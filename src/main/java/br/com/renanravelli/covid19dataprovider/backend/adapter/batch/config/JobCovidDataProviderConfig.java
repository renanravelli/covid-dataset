package br.com.renanravelli.covid19dataprovider.backend.adapter.batch.config;

import br.com.renanravelli.covid19dataprovider.backend.adapter.batch.mapper.CovidDataFieldSetMapper;
import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CovidDataDTO;
import br.com.renanravelli.covid19dataprovider.core.domain.CovidData;
import br.com.renanravelli.covid19dataprovider.core.domain.FileControl;
import br.com.renanravelli.covid19dataprovider.core.ports.driver.FileControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;

import javax.persistence.EntityManagerFactory;
import java.nio.file.Path;
import java.time.LocalDateTime;

/**
 * @author renanravelli
 */

@Configuration
@RequiredArgsConstructor
public class JobCovidDataProviderConfig extends JobExecutionListenerSupport {

    private final JobRepository jobRepository;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final FileControlService fileControlService;
    private final EntityManagerFactory entityManagerFactory;

    private static final Integer CHUNK = 500;
    private static final String COVID_DATA = "COVID_DATA";
    private static final String COVID_DATA_JOB = COVID_DATA + "_JOB";
    private static final String COVID_DATA_STEP = COVID_DATA + "_STEP";

    @Override
    public void beforeJob(JobExecution jobExecution) {
        super.beforeJob(jobExecution);
        String file = jobExecution.getJobParameters().getString("file");
        Path path = Path.of(file);
        FileControl fileControl = FileControl.builder()
                .name(path.getFileName().toString())
                .dtProcessing(LocalDateTime.now())
                .build();
        fileControlService.newFileControl(fileControl);
    }

    @Bean
    @StepScope
    public ItemReader<CovidDataDTO> covidDataItemReader(@Value("#{jobParameters['file']}") String file) {
        var reader = new FlatFileItemReaderBuilder<CovidDataDTO>()
                .name("covidDataItemReader")
                .resource(new FileSystemResource(file))
                .delimited()
                .delimiter(",")
                .names(getTokens())
                .fieldSetMapper(new CovidDataFieldSetMapper())
                .linesToSkip(1)
                .build();
        reader.open(new ExecutionContext());
        return reader;
    }

    @Bean
    @StepScope
    public ItemWriter<CovidData> covidDataItemWriter() {
        return new JpaItemWriterBuilder<CovidData>()
                .entityManagerFactory(this.entityManagerFactory)
                .build();
    }

    @Bean
    public Step coviDataStep(@Qualifier("covidDataItemReader")
                                     ItemReader<CovidDataDTO> reader,
                             @Qualifier("covidDataProviderProcessor")
                                     ItemProcessor<CovidDataDTO, CovidData> processor,
                             @Qualifier("covidDataItemWriter")
                                     ItemWriter<CovidData> writer) {
        return this.stepBuilderFactory.get(COVID_DATA_STEP)
                .<CovidDataDTO, CovidData>chunk(CHUNK)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job covidDataJob(@Qualifier("coviDataStep")
                                    Step covid) {
        return this.jobBuilderFactory.get(COVID_DATA_JOB)
                .incrementer(new RunIdIncrementer())
                .listener(this)
                .repository(jobRepository)
                .start(covid)
                .preventRestart()
                .build();
    }

    private String[] getTokens() {
        return new String[]{"iso_code",
                "continent",
                "location",
                "date",
                "total_cases",
                "new_cases",
                "new_cases_smoothed",
                "total_deaths",
                "new_deaths",
                "new_deaths_smoothed",
                "total_cases_per_million",
                "new_cases_per_million",
                "new_cases_smoothed_per_million",
                "total_deaths_per_million",
                "new_deaths_per_million",
                "new_deaths_smoothed_per_million",
                "new_tests",
                "total_tests",
                "total_tests_per_thousand",
                "new_tests_per_thousand",
                "new_tests_smoothed",
                "new_tests_smoothed_per_thousand",
                "tests_per_case",
                "positive_rate",
                "tests_units",
                "stringency_index",
                "population",
                "population_density",
                "median_age",
                "aged_65_older",
                "aged_70_older",
                "gdp_per_capita",
                "extreme_poverty",
                "cardiovasc_death_rate",
                "diabetes_prevalence",
                "female_smokers",
                "male_smokers",
                "handwashing_facilities",
                "hospital_beds_per_thousand",
                "life_expectancy",
                "human_development_inde"};
    }
}
