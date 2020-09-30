package br.com.renanravelli.covid19dataprovider.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author renanravelli
 */

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_COVID_DATA", schema = "sch_provider")
public class CovidData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;
    @Column(name = "date", updatable = false)
    private LocalDate date;
    @Column(name = "total_cases", updatable = false)
    private String totalCases;
    @Column(name = "new_cases", updatable = false)
    private String newCases;
    @Column(name = "new_cases_smoothed", updatable = false)
    private String newCasesSmoothed;
    @Column(name = "total_deaths", updatable = false)
    private String totalDeaths;
    @Column(name = "new_deaths", updatable = false)
    private String newDeaths;
    @Column(name = "new_deaths_smoothed", updatable = false)
    private String newDeathsSmoothed;
    @Column(name = "total_cases_per_million", updatable = false)
    private String totalCasesPerMillion;
    @Column(name = "new_cases_per_million", updatable = false)
    private String newCasesPerMillion;
    @Column(name = "new_cases_smoothed_per_million", updatable = false)
    private String newCasesSmoothedPerMillion;
    @Column(name = "total_deaths_per_million", updatable = false)
    private String totalDeathsPerMillion;
    @Column(name = "new_deaths_per_million", updatable = false)
    private String newDeathsPerMillion;
    @Column(name = "new_deaths_smoothed_per_million", updatable = false)
    private String newDeathsSmoothedPerMillion;
    @Column(name = "new_tests", updatable = false)
    private String newTests;
    @Column(name = "total_tests", updatable = false)
    private String totalTests;
    @Column(name = "total_tests_per_thousand", updatable = false)
    private String totalTestsPerThousand;
    @Column(name = "new_tests_per_thousand", updatable = false)
    private String newTestsPerThousand;
    @Column(name = "new_tests_smoothed", updatable = false)
    private String newTestsSmoothed;
    @Column(name = "new_tests_smoothed_per_thousand", updatable = false)
    private String newTestsSmoothedPerThousand;
    @Column(name = "tests_per_case", updatable = false)
    private String testsPerCase;
    @Column(name = "positive_rate", updatable = false)
    private String positiveRate;
    @Column(name = "tests_units", updatable = false)
    private String testsUnits;
    @Column(name = "stringency_index", updatable = false)
    private String stringencyIndex;
    @Column(name = "population", updatable = false)
    private String population;
    @Column(name = "population_density", updatable = false)
    private String populationDensity;
    @Column(name = "median_age", updatable = false)
    private String medianAge;
    @Column(name = "aged_65_older", updatable = false)
    private String aged65Older;
    @Column(name = "aged_70_older", updatable = false)
    private String aged70Older;
    @Column(name = "gdp_per_capita", updatable = false)
    private String gdpPerCapita;
    @Column(name = "extreme_poverty", updatable = false)
    private String extremePoverty;
    @Column(name = "cardiovasc_death_rate", updatable = false)
    private String cardiovascDeathRate;
    @Column(name = "diabetes_prevalence", updatable = false)
    private String diabetesPrevalence;
    @Column(name = "female_smokers", updatable = false)
    private String femaleSmokers;
    @Column(name = "male_smokers", updatable = false)
    private String maleSmokers;
    @Column(name = "handwashing_facilities", updatable = false)
    private String handwashingFacilities;
    @Column(name = "hospital_beds_per_thousand", updatable = false)
    private String hospitalBedsPerThousand;
    @Column(name = "life_expectancy", updatable = false)
    private String lifeExpectancy;
    @Column(name = "human_development_index", updatable = false)
    private String humanDevelopmentIndex;
}
