package br.com.renanravelli.covid19dataprovider.backend.adapter.jpa.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author renanravelli
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportQuery {

    private String isoCode;
    private String date;

}
