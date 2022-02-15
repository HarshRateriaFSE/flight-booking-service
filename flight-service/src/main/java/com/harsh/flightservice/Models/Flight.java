package com.harsh.flightservice.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    private long pnr;
    private String fromCity;
    private String toCity;
    private Date DateAndTime;
    private String Airlines;
    private long UserID;
    private String password;
    private String emailAddress;
    private String contactNumber;
}
