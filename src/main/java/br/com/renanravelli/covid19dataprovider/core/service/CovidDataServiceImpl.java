package br.com.renanravelli.covid19dataprovider.core.service;

import br.com.renanravelli.covid19dataprovider.backend.adapter.jpa.criteria.ReportQuery;
import br.com.renanravelli.covid19dataprovider.core.domain.CovidData;
import br.com.renanravelli.covid19dataprovider.core.ports.driven.CovidDataRepository;
import br.com.renanravelli.covid19dataprovider.core.ports.driver.CovidDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author renanravelli
 */
@Service
@RequiredArgsConstructor
public class CovidDataServiceImpl implements CovidDataService {

    private final EntityManager entityManager;
    private final CovidDataRepository covidDataRepository;

    @Override
    @Transactional
    public CovidData save(CovidData covidData) {
        return covidDataRepository.save(covidData);
    }

    @Override
    public CovidData find(ReportQuery reportQuery) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CovidData> query = builder.createQuery(CovidData.class);
        Root<CovidData> covidData = query.from(CovidData.class);

        List<Predicate> predicates = new ArrayList<>();
        Predicate isoCodePredicate = builder.equal(covidData.get("country").get("isoCode"), reportQuery.getIsoCode());
        predicates.add(isoCodePredicate);
        if (Objects.nonNull(reportQuery.getDate())) {
            Predicate datePredicate = builder.equal(covidData.get("date"), LocalDate.parse(reportQuery.getDate()));
            predicates.add(datePredicate);
        }

        Predicate or = builder.or((Predicate[]) predicates.toArray());

        query.where(or);
        TypedQuery<CovidData> queryResult = entityManager.createQuery(query);
        return queryResult.getResultList().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found"));
    }
}
