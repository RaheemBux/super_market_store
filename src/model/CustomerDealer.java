package model;

import constant.CustomerDealerEnum;
import java.sql.Date;
import java.time.LocalDate;

public class CustomerDealer extends AuditableEntity {

    private int customerDealerId;
    private String customerDealerName;
    private CustomerDealerEnum customerDealerEnum;
    private String email;
    private String phoneNumber;
    private String address;
   

    public int getCustomerDealerId() {
        return customerDealerId;
    }

    public void setCustomerDealerId(int customerDealerId) {
        this.customerDealerId = customerDealerId;
    }

    public String getCustomerDealerName() {
        return customerDealerName;
    }

    public void setCustomerDealerName(String customerDealerName) {
        this.customerDealerName = customerDealerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public CustomerDealerEnum getCustomerDealerEnum() {
        return customerDealerEnum;
    }

    public void setCustomerDealerEnum(CustomerDealerEnum customerDealerEnum) {
        this.customerDealerEnum = customerDealerEnum;
    }

}
