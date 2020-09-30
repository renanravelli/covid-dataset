package br.com.renanravelli.covid19dataprovider.backend.adapter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author renanravelli
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CovidDataDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CountryDTO country;
    private LocalDate date;
    private String totalCases;
    private String newCases;
    private String newCasesSmoothed;
    private String totalDeaths;
    private String newDeaths;
    private String newDeathsSmoothed;
    private String totalCasesPerMillion;
    private String newCasesPerMillion;
    private String newCasesSmoothedPerMillion;
    private String totalDeathsPerMillion;
    private String newDeathsPerMillion;
    private String newDeathsSmoothedPerMillion;
    private String newTests;
    private String totalTests;
    private String totalTestsPerThousand;
    private String newTestsPerThousand;
    private String newTestsSmoothed;
    private String newTestsSmoothedPerThousand;
    private String testsPerCase;
    private String positiveRate;
    private String testsUnits;
    private String stringencyIndex;
    private String population;
    private String populationDensity;
    private String medianAge;
    private String aged65Older;
    private String aged70Older;
    private String gdpPerCapita;
    private String extremePoverty;
    private String cardiovascDeathRate;
    private String diabetesPrevalence;
    private String femaleSmokers;
    private String maleSmokers;
    private String handwashingFacilities;
    private String hospitalBedsPerThousand;
    private String lifeExpectancy;
    private String humanDevelopmentIndex;
}
