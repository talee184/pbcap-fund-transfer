package fis.pbcap.fundtransfer.controller;

import fis.pbcap.fundtransfer.entity.FundTransfer;
import fis.pbcap.fundtransfer.entity.TransferType;
import fis.pbcap.fundtransfer.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer")
public class FundTransferController {

    @Autowired
    private FundTransferService fundTransferService;

    @PostMapping("/current-account")
    public ResponseEntity<FundTransfer> createCurrentAccountTransfer(@RequestBody FundTransfer transfer) {
        transfer.setTypeTran(TransferType.CURRENT_ACCOUNT.name());
        FundTransfer createdTransfer = fundTransferService.createCurrentAccountTransfer(transfer);
        return new ResponseEntity<>(createdTransfer, HttpStatus.CREATED);
    }

    @PostMapping("/internal")
    public ResponseEntity<FundTransfer> createInternalTransfer(@RequestBody FundTransfer transfer) {
        transfer.setTypeTran(TransferType.INTERNAL_TRANSFER.name());
        FundTransfer createdTransfer = fundTransferService.createInternalTransfer(transfer);
        return new ResponseEntity<>(createdTransfer, HttpStatus.CREATED);
    }

    @PostMapping("/interbank")
    public ResponseEntity<FundTransfer> createInterbankTransfer(@RequestBody FundTransfer transfer) {
        transfer.setTypeTran(TransferType.INTERBANK_TRANSFER.name());
        FundTransfer createdTransfer = fundTransferService.createInterbankTransfer(transfer);
        return new ResponseEntity<>(createdTransfer, HttpStatus.CREATED);
    }

    @PostMapping("/salary-bath")
    public ResponseEntity<String> createSalaryBatch(@RequestBody List<FundTransfer> transfers, @RequestParam String batchId) {
        fundTransferService.createSalaryBatch(transfers, batchId);
        return ResponseEntity.ok("Batch import created successfully");
    }
}
