package com.assignment.product_category.model;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;
    private String c_name;
    private String c_description;
    @OneToMany(mappedBy = "category")
    private List<Product> products= new ArrayList<>();


}
