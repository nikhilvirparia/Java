package com.nikhil.fullcrudpokebook.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity // Connects to MySQl
@Table(name="expenses") // Send it to the expenses table
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull // If this is null we don't except it
    @Size(min = 5, max = 200, message = "Name must not be blank") // Min 5 and max 200 has to be between this values
    private String expenseName;

    @NotNull
    @Size(min = 5, max = 200, message = "Vendor must between 5 and 200 character")
    private String vendor;

    @NotNull
    private Double amount;

    @NotNull
    @Size(min = 5, max = 200, message = "Description must not be blank")
    private String description;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false) // Column does not get updated
    @DateTimeFormat(pattern="yyyy-MM-dd") // Year month and day
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // Empty Constructor
    public Expense() {}

    // Create a Constructor using the fields
    public Expense(String expenseName, String vendor, Double amount, String description) {
        this.expenseName = expenseName;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }

    //Getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    // Pre Persist on create, and update
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
