package fis.pbcap.fundtransfer.controller;

import fis.pbcap.fundtransfer.entity.FundTransfer;
import fis.pbcap.fundtransfer.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maker")
public class MakerController {
    @Autowired
    private FundTransferService fundTransferService;

    @PostMapping("/create")
    public ResponseEntity<FundTransfer> createTransaction(@RequestBody FundTransfer transfer) {
        FundTransfer createdTransfer = fundTransferService.createPendingTransfer(transfer);
        return new ResponseEntity<>(createdTransfer, HttpStatus.CREATED);
    }
}
