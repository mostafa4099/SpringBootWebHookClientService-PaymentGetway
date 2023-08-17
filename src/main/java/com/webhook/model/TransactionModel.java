package com.webhook.model;

import java.time.LocalDateTime;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.webhook.model.TransactionModel.java: SpringBootWebHookClientService-PaymentGetway
 * @CreationDate 8/17/2023 2:49 PM
 */
public class TransactionModel {
    private String merchantNumber;
    private String transactionId;
    private String transactionNumber;
    private double amount;
    private String transactionDateTime;
    private String comment;

    public TransactionModel() {
    }

    public TransactionModel(String merchantNumber, String transactionId, String transactionNumber, double amount, String transactionDateTime, String comment) {
        this.merchantNumber = merchantNumber;
        this.transactionId = transactionId;
        this.transactionNumber = transactionNumber;
        this.amount = amount;
        this.transactionDateTime = transactionDateTime;
        this.comment = comment;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
