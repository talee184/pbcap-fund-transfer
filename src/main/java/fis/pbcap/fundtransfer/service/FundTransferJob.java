package fis.pbcap.fundtransfer.service;

import fis.pbcap.fundtransfer.entity.ExecutionType;
import fis.pbcap.fundtransfer.entity.FundTransfer;
import fis.pbcap.fundtransfer.entity.TransactionStatus;
import fis.pbcap.fundtransfer.repository.FundTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FundTransferJob {
    @Autowired
    private FundTransferRepository fundTransferRepository;

    @Scheduled(fixedRate = 300000) // Chạy mỗi 5 phút
    public void processPendingTransfers() {
        List<FundTransfer> pendingTransfers = fundTransferRepository.findByTransactionStatusAndExecutionMode(TransactionStatus.PENDING.name(), ExecutionType.IMMEDIATE.name());

        for (FundTransfer transfer : pendingTransfers) {
            try {
                processTransfer(transfer);
                System.out.println("Processed transfer ID: " + transfer.getId());
            } catch (Exception e) {
                System.err.println("Failed to process transfer ID: " + transfer.getId());
                e.printStackTrace();
            }
        }
    }

    private void processTransfer(FundTransfer transfer) throws Exception {
        boolean success = performPaymentProcessing(transfer);

        if (success) {
            transfer.setTransactionStatus("success");
        } else {
            transfer.setTransactionStatus("failed");
        }
        transfer.setUpdatedAt(LocalDateTime.now());
        fundTransferRepository.save(transfer);
    }

    private boolean performPaymentProcessing(FundTransfer transfer) {
        // Thực hiện logic xử lý giao dịch thực tế (gọi API hoặc các dịch vụ khác)
        return true; // Giả sử giao dịch thành công
    }

}
