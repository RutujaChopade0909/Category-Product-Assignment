package com.assignment.product_category.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private int p_id;
    private String p_name;
    private double price;
    private double discount;

    @ManyToOne
    @JoinColumn(name = "c_id", nullable = false)
    @JsonBackReference
    private Category category;

}
