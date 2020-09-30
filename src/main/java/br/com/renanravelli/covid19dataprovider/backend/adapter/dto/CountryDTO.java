package br.com.renanravelli.covid19dataprovider.backend.adapter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author renanravelli
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String isoCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String continent;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String location;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<CovidDataDTO> covidData = new HashSet<>();
}
