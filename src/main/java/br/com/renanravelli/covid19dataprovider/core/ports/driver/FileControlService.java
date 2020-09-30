package br.com.renanravelli.covid19dataprovider.core.ports.driver;

import br.com.renanravelli.covid19dataprovider.core.domain.FileControl;

/**
 * @author renanravelli
 */
public interface FileControlService {

    FileControl newFileControl(FileControl fileControl);
}
