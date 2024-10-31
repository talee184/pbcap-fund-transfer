package fis.pbcap.fundtransfer.repository;

import fis.pbcap.fundtransfer.entity.FundTransfer;
import fis.pbcap.fundtransfer.entity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, String> {
    List<FundTransfer> findByTransactionStatus(String transactionStatus);

    List<FundTransfer> findByTransactionStatusAndExecutionMode(String status, String executionMode);

    List<FundTransfer> findByBatchId(Long batchId);
}
