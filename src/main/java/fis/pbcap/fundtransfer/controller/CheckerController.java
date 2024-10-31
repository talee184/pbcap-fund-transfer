package fis.pbcap.fundtransfer.controller;

import fis.pbcap.fundtransfer.entity.FundTransfer;
import fis.pbcap.fundtransfer.entity.TransactionStatus;
import fis.pbcap.fundtransfer.repository.FundTransferRepository;
import fis.pbcap.fundtransfer.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checker")
public class CheckerController {
    @Autowired
    private FundTransferService fundTransferService;
    @Autowired
    private FundTransferRepository fundTransferRepository;

    @GetMapping("/pending")
    public ResponseEntity<List<FundTransfer>> getPendingTransactions() {
        List<FundTransfer> pendingTransfers = fundTransferRepository.findByTransactionStatus(TransactionStatus.PENDING.name());
        return ResponseEntity.ok(pendingTransfers);
    }

    @PostMapping("/review/{transactionId}")
    public ResponseEntity<FundTransfer> reviewTransaction(@PathVariable String transactionId, @RequestParam boolean approve) {
        FundTransfer reviewedTransfer = fundTransferService.reviewTransfer(transactionId, approve);
        return ResponseEntity.ok(reviewedTransfer);
    }
}
