package fis.pbcap.fundtransfer.service;

import fis.pbcap.fundtransfer.entity.ExecutionType;
import fis.pbcap.fundtransfer.entity.FundTransfer;
import fis.pbcap.fundtransfer.entity.TransactionStatus;
import fis.pbcap.fundtransfer.exception.ResourceNotFoundException;
import fis.pbcap.fundtransfer.repository.FundTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FundTransferService {
    @Autowired
    private FundTransferRepository fundTransferRepository;

    public FundTransfer createCurrentAccountTransfer(FundTransfer transfer) {
        return fundTransferRepository.save(transfer);
    }

    public FundTransfer createInternalTransfer(FundTransfer transfer) {
        return fundTransferRepository.save(transfer);
    }

    public FundTransfer createInterbankTransfer(FundTransfer transfer) {
        return fundTransferRepository.save(transfer);
    }

    public void createSalaryBatch(List<FundTransfer> transfers, String batchId) {
        transfers.forEach(transfer -> {
            transfer.setBatchId(batchId);
            transfer.setTransactionStatus("Pending"); // Wait for batch approval
            fundTransferRepository.save(transfer);
        });
    }

    // Maker creates a transaction with a status of PENDING
    public FundTransfer createPendingTransfer(FundTransfer transfer) {
        transfer.setTransactionStatus(TransactionStatus.PENDING.name());
        return fundTransferRepository.save(transfer);
    }

    // Checker reviews the transaction, and either approves or rejects it
    public FundTransfer reviewTransfer(String transactionId, boolean approve) {
        FundTransfer transfer = fundTransferRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        if (approve) {
            transfer.setTransactionStatus(TransactionStatus.APPROVED.name());
            if (Objects.equals(transfer.getExecutionMode(), ExecutionType.IMMEDIATE.name())) {
                //TODO processImmediateTransfer
            } else if (Objects.equals(transfer.getExecutionMode(), ExecutionType.SCHEDULED.name())) {
                //TODO processScheduleTransfer
            }
        } else {
            transfer.setTransactionStatus(TransactionStatus.REJECTED.name());
        }
        return fundTransferRepository.save(transfer);
    }
}

