package br.com.renanravelli.covid19dataprovider.core.ports.driven;

import br.com.renanravelli.covid19dataprovider.core.domain.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CountryRepository {

    Optional<Country> find(Country country);

    Page<Country> findAllCountry(Pageable pageable);

    Optional<Country> findIsoCode(String code);

    Country newCountry(Country country);

}
