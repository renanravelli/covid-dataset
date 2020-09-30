package br.com.renanravelli.covid19dataprovider.backend.adapter.batch.config;

import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CovidDataDTO;
import br.com.renanravelli.covid19dataprovider.backend.adapter.mapper.CovidDataMapper;
import br.com.renanravelli.covid19dataprovider.core.domain.Country;
import br.com.renanravelli.covid19dataprovider.core.domain.CovidData;
import br.com.renanravelli.covid19dataprovider.core.ports.driver.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author renanravelli
 */
@Component
@RequiredArgsConstructor
public class CovidDataProviderProcessor implements ItemProcessor<CovidDataDTO, CovidData> {

    private final CovidDataMapper mapper;
    private final CountryService countryService;

    @Override
    public CovidData process(@NonNull CovidDataDTO dto) {
        CovidData covidData = mapper.fromDTO(dto);
        Country country = this.countryService.find(covidData.getCountry());
        covidData.setCountry(country);
        return covidData;
    }
}
