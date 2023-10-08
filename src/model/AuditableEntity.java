/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class AuditableEntity {
    private Date createddate;
    private Date modifieddate;
    private String createdby;
    private String updatedby;
    private Boolean status;
    
    public Date getCreatedDate() {
        return createddate;
    }

    public void setCreatedDate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getModifiedDate() {
        return modifieddate;
    }

    public void setModifiedDate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getCreatedBy() {
        return createdby;
    }

    public void setCreatedBy(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedBy() {
        return updatedby;
    }

    public void setUpdatedBy(String updatedby) {
        this.updatedby = updatedby;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
