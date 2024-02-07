package com.diego.northwindproyect.proyect.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shippers")
public class Shippers {
    @Column(name = "shipper_id")
    @Id
    private long shipperId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="phone")
    private String phone;


    public Shippers(){
        
    }
    public Shippers(int i, String companyName, String phone) {
    }


    public long getShipperId() {
        return shipperId;
    }


    public void setShipperId(long shipperId) {
        this.shipperId = shipperId;
    }


    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
