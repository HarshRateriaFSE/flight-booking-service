package com.harsh.userservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private long UserID;
    private String password;
    private String emailAddress;
    private String contactNumber;
}
