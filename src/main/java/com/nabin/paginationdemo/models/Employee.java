package com.nabin.paginationdemo.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-17
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
    private String designation;
}
