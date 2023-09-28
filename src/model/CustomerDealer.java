package model;

import constant.CustomerDealerEnum;
import java.sql.Date;
import java.time.LocalDate;

public class CustomerDealer {

    private int customerDealerId;
    private String customerDealerName;
    private CustomerDealerEnum customerDealerEnum;
    private String email;
    private String phoneNumber;
    private String address;
    private Date createDate;
    private Date modifiedDate;
    private String createdBy;
    private String updatedBy;
    private int active;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public CustomerDealerEnum getCustomerDealerEnum() {
        return customerDealerEnum;
    }

    public void setCustomerDealerEnum(CustomerDealerEnum customerDealerEnum) {
        this.customerDealerEnum = customerDealerEnum;
    }

}
