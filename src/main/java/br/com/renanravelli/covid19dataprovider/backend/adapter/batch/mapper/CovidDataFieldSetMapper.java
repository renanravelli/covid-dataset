package br.com.renanravelli.covid19dataprovider.backend.adapter.batch.mapper;

import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CountryDTO;
import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CovidDataDTO;
import br.com.renanravelli.covid19dataprovider.core.domain.Country;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import java.time.LocalDate;
import java.util.Properties;

/**
 * @author renanravelli
 */
public class CovidDataFieldSetMapper implements FieldSetMapper<CovidDataDTO> {

    @Override
    public CovidDataDTO mapFieldSet(FieldSet fieldSet) {
        Properties properties = fieldSet.getProperties();
        return CovidDataDTO.builder()
                .country(CountryDTO.builder()
                        .isoCode(properties.getProperty("iso_code"))
                        .continent(properties.getProperty("continent"))
                        .location(properties.getProperty("location"))
                        .build())
                .date(LocalDate.parse(properties.getProperty("date")))
                .totalCases(properties.getProperty("total_cases"))
                .newCases(properties.getProperty("new_cases"))
                .newCasesSmoothed(properties.getProperty("new_cases_smoothed"))
                .totalDeaths(properties.getProperty("total_deaths"))
                .newDeaths(properties.getProperty("new_deaths"))
                .newDeathsSmoothed(properties.getProperty("new_deaths_smoothed"))
                .totalCasesPerMillion(properties.getProperty("total_cases_per_million"))
                .newCasesPerMillion(properties.getProperty("new_cases_per_million"))
                .newCasesSmoothedPerMillion(properties.getProperty("new_cases_smoothed_per_million"))
                .totalDeathsPerMillion(properties.getProperty("total_deaths_per_million"))
                .newDeathsPerMillion(properties.getProperty("new_deaths_per_million"))
                .newDeathsSmoothedPerMillion(properties.getProperty("new_deaths_smoothed_per_million"))
                .newTests(properties.getProperty("new_tests"))
                .totalTests(properties.getProperty("total_tests"))
                .totalTestsPerThousand(properties.getProperty("total_tests_per_thousand"))
                .newTestsPerThousand(properties.getProperty("new_tests_per_thousand"))
                .newTestsSmoothed(properties.getProperty("new_tests_smoothed"))
                .newTestsSmoothedPerThousand(properties.getProperty("new_tests_smoothed_per_thousand"))
                .testsPerCase(properties.getProperty("tests_per_case"))
                .positiveRate(properties.getProperty("positive_rate"))
                .testsUnits(properties.getProperty("tests_units"))
                .stringencyIndex(properties.getProperty("stringency_index"))
                .population(properties.getProperty("population"))
                .populationDensity(properties.getProperty("population_density"))
                .medianAge(properties.getProperty("median_age"))
                .aged65Older(properties.getProperty("aged_65_older"))
                .aged70Older(properties.getProperty("aged_70_older"))
                .gdpPerCapita(properties.getProperty("gdp_per_capita"))
                .extremePoverty(properties.getProperty("extreme_poverty"))
                .cardiovascDeathRate(properties.getProperty("cardiovasc_death_rate"))
                .diabetesPrevalence(properties.getProperty("diabetes_prevalence"))
                .femaleSmokers(properties.getProperty("female_smokers"))
                .maleSmokers(properties.getProperty("male_smokers"))
                .handwashingFacilities(properties.getProperty("handwashing_facilities"))
                .hospitalBedsPerThousand(properties.getProperty("hospital_beds_per_thousand"))
                .lifeExpectancy(properties.getProperty("life_expectancy"))
                .humanDevelopmentIndex(properties.getProperty("human_development_index"))
                .build();
    }
}
