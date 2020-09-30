package br.com.renanravelli.covid19dataprovider.backend.adapter.mapper;

import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CountryDTO;
import br.com.renanravelli.covid19dataprovider.core.domain.Country;
import org.mapstruct.Mapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author renanravelli
 */

@Mapper(componentModel = "spring", uses = CovidDataMapper.class)
public interface CountryMapper {

    default List<CountryDTO> toDTO(List<Country> countries) {
        return countries.stream()
                .map(country -> CountryDTO.builder()
                        .isoCode(country.getIsoCode())
                        .location(country.getLocation())
                        .continent(country.getContinent())
                        .build())
                .sorted(Comparator.comparing(CountryDTO::getIsoCode))
                .collect(Collectors.toList());
    }

    CountryDTO toDTO(Country country);
}
