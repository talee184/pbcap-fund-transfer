package fis.pbcap.fundtransfer.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Table(name = "fund_transfer")
@Entity
public class FundTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fund_transfer_seq_generator")
    @SequenceGenerator(name = "fund_transfer_seq_generator", sequenceName = "fund_transfer_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, length = 16, updatable = false)
    private String id;

    @Column(name = "batch_id", nullable = false, length = 32)
    private String batchId;

    @Column(name = "sender_bank_code", length = 32)
    private String senderBankCode;

    @Column(name = "sender_account_no", length = 32)
    private String senderAccountNo;

    @Column(name = "sender_account_name", length = 32)
    private String senderAccountName;

    @Column(name = "receiver_bank_code", length = 32)
    private String receiverBankCode;

    @Column(name = "receiver_account_no", length = 32)
    private String receiverAccountNo;

    @Column(name = "receiver_account_name", length = 32)
    private String receiverAccountName;

    @Column(name = "value_date", length = 32)
    private String valueDate;

    @Column(name = "nostro", length = 32)
    private String nostro;

    @Column(name = "receiver_bank_name", length = 255)
    private String receiverBankName;

    @Column(name = "beneficiary_customer_account_number", length = 64)
    private String beneficiaryCustomerAccountNumber;

    @Column(name = "beneficiary_customer_name", length = 255)
    private String beneficiaryCustomerName;

    @Column(name = "beneficiary_customer_address", length = 255)
    private String beneficiaryCustomerAddress;

    @Column(name = "beneficiary_country", length = 255)
    private String beneficiaryCountry;

    @Column(name = "intermediary_bank_swift", length = 255)
    private String intermediaryBankSwift;

    @Column(name = "aba_bsb", length = 64)
    private String abaBsb;

    @Column(name = "beneficiary_bank_name_and_address", length = 255)
    private String beneficiaryBankNameAndAddress;

    @Column(name = "currency", length = 32)
    private String currency;

    @Column(name = "foreign_amount")
    private BigDecimal foreignAmount;

    @Column(name = "local_amount")
    private BigDecimal localAmount;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;

    @Column(name = "channel", length = 64)
    private String channel;

    @Column(name = "direction", length = 32)
    private String direction;

    @Column(name = "fee_code", length = 32)
    private String feeCode;

    @Column(name = "mt_code", length = 32)
    private String mtCode;

    @Column(name = "transaction_status", length = 32)
    private String transactionStatus;

    @Column(name = "posting_status", length = 32)
    private String postingStatus;

    @Column(name = "execution_mode", length = 32)
    private String executionMode;

    @Column(name = "type_tran", length = 32)
    private String typeTran;

    @Column(name = "ref_no", length = 32)
    private String refNo;

    @Column(name = "created_by", length = 32)
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 32)
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getSenderBankCode() {
        return senderBankCode;
    }

    public void setSenderBankCode(String senderBankCode) {
        this.senderBankCode = senderBankCode;
    }

    public String getSenderAccountNo() {
        return senderAccountNo;
    }

    public void setSenderAccountNo(String senderAccountNo) {
        this.senderAccountNo = senderAccountNo;
    }

    public String getSenderAccountName() {
        return senderAccountName;
    }

    public void setSenderAccountName(String senderAccountName) {
        this.senderAccountName = senderAccountName;
    }

    public String getReceiverBankCode() {
        return receiverBankCode;
    }

    public void setReceiverBankCode(String receiverBankCode) {
        this.receiverBankCode = receiverBankCode;
    }

    public String getReceiverAccountNo() {
        return receiverAccountNo;
    }

    public void setReceiverAccountNo(String receiverAccountNo) {
        this.receiverAccountNo = receiverAccountNo;
    }

    public String getReceiverAccountName() {
        return receiverAccountName;
    }

    public void setReceiverAccountName(String receiverAccountName) {
        this.receiverAccountName = receiverAccountName;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getNostro() {
        return nostro;
    }

    public void setNostro(String nostro) {
        this.nostro = nostro;
    }

    public String getReceiverBankName() {
        return receiverBankName;
    }

    public void setReceiverBankName(String receiverBankName) {
        this.receiverBankName = receiverBankName;
    }

    public String getBeneficiaryCustomerAccountNumber() {
        return beneficiaryCustomerAccountNumber;
    }

    public void setBeneficiaryCustomerAccountNumber(String number) {
        this.beneficiaryCustomerAccountNumber = number;
    }

    public String getBeneficiaryCustomerName() {
        return beneficiaryCustomerName;
    }

    public void setBeneficiaryCustomerName(String name) {
        this.beneficiaryCustomerName = name;
    }

    public String getBeneficiaryCustomerAddress() {
        return beneficiaryCustomerAddress;
    }

    public void setBeneficiaryCustomerAddress(String address) {
        this.beneficiaryCustomerAddress = address;
    }

    public String getBeneficiaryCountry() {
        return beneficiaryCountry;
    }

    public void setBeneficiaryCountry(String country) {
        this.beneficiaryCountry = country;
    }

    public String getIntermediaryBankSwift() {
        return intermediaryBankSwift;
    }

    public void setIntermediaryBankSwift(String swift) {
        this.intermediaryBankSwift = swift;
    }

    public String getAbaBsb() {
        return abaBsb;
    }

    public void setAbaBsb(String abaBsb) {
        this.abaBsb = abaBsb;
    }

    public String getBeneficiaryBankNameAndAddress() {
        return beneficiaryBankNameAndAddress;
    }

    public void setBeneficiaryBankNameAndAddress(String address) {
        this.beneficiaryBankNameAndAddress = address;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getForeignAmount() {
        return foreignAmount;
    }

    public void setForeignAmount(BigDecimal amount) {
        this.foreignAmount = amount;
    }

    public BigDecimal getLocalAmount() {
        return localAmount;
    }

    public void setLocalAmount(BigDecimal amount) {
        this.localAmount = amount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal rate) {
        this.exchangeRate = rate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getMtCode() {
        return mtCode;
    }

    public void setMtCode(String mtCode) {
        this.mtCode = mtCode;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String status) {
        this.transactionStatus = status;
    }

    public String getPostingStatus() {
        return postingStatus;
    }

    public void setPostingStatus(String status) {
        this.postingStatus = status;
    }

    public String getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(String mode) {
        this.executionMode = mode;
    }

    public String getTypeTran() {
        return typeTran;
    }

    public void setTypeTran(String type) {
        this.typeTran = type;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
