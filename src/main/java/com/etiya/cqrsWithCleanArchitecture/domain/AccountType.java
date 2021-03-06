package com.etiya.cqrsWithCleanArchitecture.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="accountTypes")
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {
    @Id
    @Column(name="id")
    private String accountTypeId;

    @Column(name="accountName")
    private String accountName;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;
}
