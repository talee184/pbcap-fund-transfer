package fis.pbcap.fundtransfer.controller;

import fis.pbcap.fundtransfer.entity.BatchImport;
import fis.pbcap.fundtransfer.entity.BatchStatus;
import fis.pbcap.fundtransfer.service.BatchImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/batch")
public class BatchImportController {
    @Autowired
    private BatchImportService batchImportService;

    @GetMapping("/status/{status}")
    public ResponseEntity<List<BatchImport>> getBatchesByStatus(@PathVariable BatchStatus status) {
        return ResponseEntity.ok(batchImportService.getBatchesByStatus(status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchImport> getBatchDetails(@PathVariable Long id) {
        return batchImportService.getBatchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
