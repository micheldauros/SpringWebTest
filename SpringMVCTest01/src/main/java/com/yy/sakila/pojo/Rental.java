package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Rental {
    private Integer rentalId;
    private LocalDateTime rentalDate;
    private Integer inventoryId;
    private Integer customerId;
    private LocalDateTime returnDate;
    private Integer staffId;
    private LocalDateTime lastUpdate;
}
