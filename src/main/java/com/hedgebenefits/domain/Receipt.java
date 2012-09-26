package com.hedgebenefits.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name="receipt")
public class Receipt {

    private Long id;
    private String receiptName;
    private Admin admin;


    @Column(name = "receipt_name")
    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    @ManyToOne
    @JoinColumn(name = "admin_fk")
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Receipt)) {
            return false;
        }
        Receipt otherAdmin  = (Receipt) o;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(getReceiptName(), otherAdmin.getReceiptName());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getReceiptName());
        return builder.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("receiptName:")
                .append(receiptName)
                .toString();
    }
}
