package fis.pbcap.fundtransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BatchImportJob {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Schedule to reset the sequence at midnight every day
    @Scheduled(cron = "0 0 0 * * *") // Runs at midnight daily
    public void resetDailyBatchSeq() {
        jdbcTemplate.execute("ALTER SEQUENCE daily_batch_seq RESTART WITH 1");
    }
}
