package br.com.renanravelli.covid19dataprovider.core.ports.driven;

import br.com.renanravelli.covid19dataprovider.core.domain.CovidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author renanravelli
 */

@Repository
public interface CovidDataRepository extends JpaRepository<CovidData, Long> {
}
