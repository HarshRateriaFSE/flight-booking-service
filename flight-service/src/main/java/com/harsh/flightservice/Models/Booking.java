package com.harsh.flightservice.Models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {
    private long pnr;
    private String fromCity;
    private String toCity;
    private Date DateAndTime;
    private String Airlines;
    private long UserID;
}
