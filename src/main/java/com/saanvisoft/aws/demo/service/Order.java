package com.saanvisoft.aws.demo.service;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Table
@Entity(name = "T_ORDER_DETAILS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
	private int orderID;    
    private int customerID;
    private int paymentID;
    private String orderStatus;    
    private Date createdOn;
    private String createdBy;
    private Date modifiedOn	;
    private String modifedBy ;
}