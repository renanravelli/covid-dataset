package br.com.renanravelli.covid19dataprovider.core.service;

import br.com.renanravelli.covid19dataprovider.core.domain.Country;
import br.com.renanravelli.covid19dataprovider.core.ports.driven.CountryRepository;
import br.com.renanravelli.covid19dataprovider.core.ports.driver.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author renanravelli
 */

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private static final String ISO_CODE_NOT_FOUND = "ISO CODE NOT FOUND";

    @Override
    @Transactional
    public Country find(Country country) {
        return countryRepository.find(country)
                .orElseGet(() -> this.countryRepository.newCountry(country));
    }

    @Override
    public Page<Country> findAllCountry(int page, int size) {
        PageRequest request = PageRequest.of(page, size, Sort.by(Sort.Order.asc("isoCode")));
        return countryRepository.findAllCountry(request);
    }
}
