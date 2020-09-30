package br.com.renanravelli.covid19dataprovider.backend.adapter.rest;

import br.com.renanravelli.covid19dataprovider.api.ReportController;
import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CountryDTO;
import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CovidDataDTO;
import br.com.renanravelli.covid19dataprovider.backend.adapter.jpa.criteria.ReportQuery;
import br.com.renanravelli.covid19dataprovider.backend.adapter.mapper.CountryMapper;
import br.com.renanravelli.covid19dataprovider.backend.adapter.mapper.CovidDataMapper;
import br.com.renanravelli.covid19dataprovider.core.domain.Country;
import br.com.renanravelli.covid19dataprovider.core.domain.CovidData;
import br.com.renanravelli.covid19dataprovider.core.ports.driver.CountryService;
import br.com.renanravelli.covid19dataprovider.core.ports.driver.CovidDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author renanravelli
 */

@Service
@RequiredArgsConstructor
public class ReportRestService implements ReportController {

    private final CountryMapper countryMapper;
    private final CovidDataMapper covidDataMapper;
    private final CountryService countryService;
    private final CovidDataService covidDataService;

    @Override
    public ResponseEntity<List<CountryDTO>> findAllISOCodes(int page, int size) {
        Page<Country> countries = countryService.findAllCountry(page, size);
        List<CountryDTO> countryDTOS = countryMapper.toDTO(countries.getContent());
        return ResponseEntity.ok(countryDTOS);
    }

    @Override
    public ResponseEntity<CovidDataDTO> findByIsoCode(String code, String date) {
        var reportQuery = ReportQuery.builder()
                .isoCode(code)
                .date(date)
                .build();
        CovidData covidData = covidDataService.find(reportQuery);
        CovidDataDTO covidDataDTO = covidDataMapper.toDTO(covidData);
        return ResponseEntity.ok(covidDataDTO);
    }
}
