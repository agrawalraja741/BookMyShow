package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Payment extends BaseEntity{

    private String paymentId;
    private LocalDateTime transactionDateTime;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;



}
