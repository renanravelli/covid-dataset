package br.com.renanravelli.covid19dataprovider.api;

import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CountryDTO;
import br.com.renanravelli.covid19dataprovider.backend.adapter.dto.CovidDataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/report")
public interface ReportController {

    @GetMapping(value = "/")
    ResponseEntity<List<CountryDTO>> findAllISOCodes(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size);

    @GetMapping(value = "/{code}/{date}")
    ResponseEntity<CovidDataDTO> findByIsoCode(@PathVariable(value = "code") String code,
                                               @PathVariable("date") String date);

}
