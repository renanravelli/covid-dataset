package br.com.renanravelli.covid19dataprovider.core.ports.driver;

import br.com.renanravelli.covid19dataprovider.backend.adapter.jpa.criteria.ReportQuery;
import br.com.renanravelli.covid19dataprovider.core.domain.CovidData;

/**
 * @author renanravelli
 */
public interface CovidDataService {

    CovidData save(CovidData covidData);

    CovidData find(ReportQuery reportQuery);
}
