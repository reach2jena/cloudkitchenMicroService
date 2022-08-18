package com.saanvisoft.aws.demo.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

	private int customerID;
    private String custFirstName;	
    private String custLastName	;
    private long custPhone;
    private String deliveryAddress;
    private String billingAddress;
    private int custZipCode	;     
    private Date createdOn	;
    private String createdBy;
    private Date modifiedOn	;
    private String modifedBy  ;
    private String username;
    private String password;
}
