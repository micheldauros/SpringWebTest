package com.yy.sakila.pojo;

import lombok.Data;

@Data
public class Customer {
    private Integer customerId;
    private Integer storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer addressId;

}
