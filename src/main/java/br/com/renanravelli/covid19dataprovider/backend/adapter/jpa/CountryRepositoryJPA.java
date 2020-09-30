package br.com.renanravelli.covid19dataprovider.backend.adapter.jpa;

import br.com.renanravelli.covid19dataprovider.core.domain.Country;
import br.com.renanravelli.covid19dataprovider.core.ports.driven.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import java.util.Optional;

@Repository
public interface CountryRepositoryJPA extends JpaRepository<Country, Long>, CountryRepository {

    @Override
    default Optional<Country> find(Country country) {
        return findByIsoCodeAndContinentAndLocation(country.getIsoCode(),
                country.getContinent(),
                country.getLocation());
    }

    @Override
    default Page<Country> findAllCountry(Pageable pageable) {
        return findAll(pageable);
    }

    @Override
    @Query("SELECT a FROM Country a WHERE a.isoCode = :code ")
    Optional<Country> findIsoCode(String code);

    @Override
    default Country newCountry(Country country) {
        return save(country);
    }

    Optional<Country> findByIsoCodeAndContinentAndLocation(String isoCode, String continent, String location);
}
