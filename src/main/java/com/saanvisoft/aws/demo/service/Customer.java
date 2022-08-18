package com.saanvisoft.aws.demo.service;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Table
@Entity(name = "T_CUSTOMER_DETAILS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
	private int customerID;
    private String custFirstName;	
    private String custLastName	;
    private long custPhone;
    private String deliveryAddress;
    private String billingAddress;
    private int custZipCode	; 
    
    @Column(name = "created_on", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdOn	;
    @Column(name = "created_by",columnDefinition = "varchar(15) default 'System'")
    private String createdBy;
    
    @Column(name = "modified_On", nullable = false, updatable = false)
    @CreationTimestamp
    private Date modifiedOn	;
    @Column(name = "modifed_by",columnDefinition = "varchar(15) default 'System'")
    private String modifedBy ;
    private String username;
    private String password;
    
    @OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
    @JoinColumn(name="cp_pk", referencedColumnName = "customerID" )
    private List<Order> orders;
    
}