package fis.pbcap.fundtransfer.service;

import fis.pbcap.fundtransfer.entity.BatchImport;
import fis.pbcap.fundtransfer.entity.BatchStatus;
import fis.pbcap.fundtransfer.repository.BatchImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BatchImportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BatchImportRepository batchImportRepository;

    public List<BatchImport> getBatchesByStatus(BatchStatus status) {
        return batchImportRepository.findByStatus(status);
    }

    public Optional<BatchImport> getBatchById(Long id) {
        return batchImportRepository.findById(id);
    }

    // Generate batch_id in the format SAL_YYMMDD_XXXX
    public String generateBatchId() {
        // 1. Get the current date formatted as YYMMDD
        String datePrefix = new SimpleDateFormat("yyMMdd").format(new Date());

        // 2. Get the next value from the sequence
        Long nextSeq = jdbcTemplate.queryForObject("SELECT nextval('daily_batch_seq')", Long.class);

        // 3. Format the sequence as a 4-digit number, padding with zeros if needed
        String formattedSeq = String.format("%04d", nextSeq);

        // 4. Combine datePrefix and formattedSeq to get the batch_id
        return "SAL_" + datePrefix + "_" + formattedSeq;
    }

}
