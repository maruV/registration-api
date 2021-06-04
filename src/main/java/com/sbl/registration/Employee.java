package com.sbl.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employee")
public class Employee
{
    /**
     * id is auto generated
     * username, employee id, and email are kept unique
     */

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private int empID;
    @Column(unique = true)
    private String empUName;
    private String empFName;
    private String empLName;
    @Column(unique = true)
    private String empEmail;
}
