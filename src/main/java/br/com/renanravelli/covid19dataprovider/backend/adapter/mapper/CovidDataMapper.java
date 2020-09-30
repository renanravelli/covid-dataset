package br.com.renanravelli.covid19dataprovider.backend.adapter.mapper;

import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CountryDTO;
import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CovidDataDTO;
import br.com.renanravelli.covid19dataprovider.core.domain.CovidData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CountryDTO.class)
public interface CovidDataMapper {

    CovidData fromDTO(CovidDataDTO dto);

    @Mapping(target = "country.covidData", ignore = true)
    CovidDataDTO toDTO(CovidData covidData);
}
