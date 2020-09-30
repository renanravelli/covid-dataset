package br.com.renanravelli.covid19dataprovider.backend.adapter.jpa;

import br.com.renanravelli.covid19dataprovider.core.domain.FileControl;
import br.com.renanravelli.covid19dataprovider.core.ports.driven.FileControlRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author renanravelli
 */

@Repository
public interface FileControlRepositoryJPA extends JpaRepository<FileControl, Long>, FileControlRepository {

    @Override
    default FileControl newFileControl(FileControl fileControl){
        return save(fileControl);
    }
}
