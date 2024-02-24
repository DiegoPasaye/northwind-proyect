package com.diego.northwindproyect.proyect.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "oder_details")
public class Order_details {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products productId;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orderId;

    @Column(name = "product_id")
    private Long productid;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "discount")
    private Double discount;

    
    public Orders getOrderid() {
        return orderId;
    }
    public void setOrderid(Orders orderid) {
        this.orderId = orderid;
    }
    public Long getProductid() {
        return productid;
    }
    public void setProductid(Long productid) {
        this.productid = productid;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    

}
