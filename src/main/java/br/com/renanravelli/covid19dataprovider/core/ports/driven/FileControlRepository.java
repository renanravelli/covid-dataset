package br.com.renanravelli.covid19dataprovider.core.ports.driven;

import br.com.renanravelli.covid19dataprovider.core.domain.FileControl;

/**
 * @author renanravelli
 */
public interface FileControlRepository {

    FileControl newFileControl(FileControl fileControl);
}
