package com.gerald.accounts.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accounts", schema = "banking")
public class Accounts extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "account_number", nullable = false, length = 100)
    private String accountNumber;

    @Size(max = 100)
    @NotNull
    @Column(name = "account_type", nullable = false, length = 100)
    private String accountType;

    @Size(max = 200)
    @NotNull
    @Column(name = "branch_address", nullable = false, length = 200)
    private String branchAddress;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
   // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "customer_id", nullable = false,referencedColumnName = "customer_id")
    private Customers customers;

}