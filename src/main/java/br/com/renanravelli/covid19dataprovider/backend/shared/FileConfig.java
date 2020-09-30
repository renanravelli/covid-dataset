package br.com.renanravelli.covid19dataprovider.backend.shared;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author renanravelli
 */

@Getter
@Component
public class FileConfig {

    @Value("${covid.dataset.url}")
    private String url;
    @Value("${covid.file.directory}")
    private String fileDirectory;
    @Value("${covid.file.name}")
    private String fileName;

}
