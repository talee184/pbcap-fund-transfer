package fis.pbcap.fundtransfer.repository;

import fis.pbcap.fundtransfer.entity.BatchImport;
import fis.pbcap.fundtransfer.entity.BatchStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchImportRepository extends JpaRepository<BatchImport, Long> {
    List<BatchImport> findByStatus(BatchStatus status);
}
