package br.com.renanravelli.covid19dataprovider.backend.adapter.camel;

import br.com.renanravelli.covid19dataprovider.backend.shared.FileConfig;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;

/**
 * @author renanravelli
 */

@Component
@RequiredArgsConstructor
public class CovidDatasetProviderRoute extends RouteBuilder {

    private final FileConfig fileConfig;

    @Override
    public void configure() {
        String out = buildPathFile();
        from("cron:downloadFile?schedule=0 40 6 ? * *")
                .log("Starting file download")
                .to(fileConfig.getUrl())
                .log("Finishing download")
                .to(out)
                .log("File available for processing:  " + out)
                .log("Starting processing")
                .to("spring-batch:covidDataJob?jobLauncher=#covidDataProviderJobLaucher");
    }

    private String buildPathFile() {
        return "file://" + fileConfig.getFileDirectory() + File.separator + LocalDate.now()
                + File.separator + "?fileName=" + fileConfig.getFileName();
    }
}
