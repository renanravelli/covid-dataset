package br.com.renanravelli.covid19dataprovider.core.service;

import br.com.renanravelli.covid19dataprovider.core.domain.FileControl;
import br.com.renanravelli.covid19dataprovider.core.ports.driven.FileControlRepository;
import br.com.renanravelli.covid19dataprovider.core.ports.driver.FileControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author renanravelli
 */

@Service
@RequiredArgsConstructor
public class FileControlServiceImpl implements FileControlService {

    private final FileControlRepository fileControlRepository;

    @Override
    public FileControl newFileControl(FileControl fileControl) {
        return fileControlRepository.newFileControl(fileControl);
    }
}
