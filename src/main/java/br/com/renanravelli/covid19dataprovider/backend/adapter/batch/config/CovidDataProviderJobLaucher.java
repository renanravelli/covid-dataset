package br.com.renanravelli.covid19dataprovider.backend.adapter.batch.config;

import br.com.renanravelli.covid19dataprovider.backend.shared.FileConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;

/**
 * @author renanravelli
 */
@Component
@RequiredArgsConstructor
public class CovidDataProviderJobLaucher implements JobLauncher {

    private final FileConfig fileConfig;
    private final JobRepository jobRepository;

    @Override
    @SneakyThrows
    public JobExecution run(Job job, JobParameters jobParameters) {
        String diretorio = fileConfig.getFileDirectory() + File.separator + LocalDate.now() +
                File.separator + fileConfig.getFileName();
        JobParametersBuilder parameters = new JobParametersBuilder();
        parameters.addString("file", diretorio);
        JobExecution jobExecution = this.jobRepository.createJobExecution(job.getName(), parameters.toJobParameters());
        job.execute(jobExecution);
        return jobExecution;
    }
}
