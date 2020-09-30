package br.com.renanravelli.covid19dataprovider.core.ports.driver;

import br.com.renanravelli.covid19dataprovider.core.domain.Country;
import org.springframework.data.domain.Page;

/**
 * @author renanravelli
 */
public interface CountryService {

    Country find(Country country);

    Page<Country> findAllCountry(int page, int size);
}
