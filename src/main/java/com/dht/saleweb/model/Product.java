/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.model;

import com.dht.saleweb.validator.ProductName;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author duonghuuthanh
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 2L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    @Size(min = 10, max = 50, message = "{product.name.error.sizeMsg}")
    @ProductName(message = "{product.name.error.productNameMsg}")
    private String name;
    
    @Column(name = "description")
    @Size(max = 255, message = "{product.description.error.sizeMsg}") 
    private String description;
    
    @Column(name = "price")
    @NotNull(message = "{product.price.error.notNullMsg}")
    @Min(value = 100000, message = "{product.price.error.minMsg}")
    @Max(value = 1000000000, message = "{product.price.error.maxMsg}")
    private BigDecimal price;
    
    @Column(name = "manufacturer")
    @Size(max = 50, message = "{product.manufacturer.error.sizeMsg}")
    private String manufacturer;
    
    @Column(name = "image")
    private String image;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;
    
    @Column(name = "active")
    private boolean active;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "{product.category.error.notNullMsg}")
    private Category category;
    
    @Transient
    private MultipartFile imgFile;
    
    { 
        createdDate = new Date();
        active = true;
    }
    
    public Product() {
        
    }
    
    public Product(String name, BigDecimal price, String manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the imgFile
     */
    public MultipartFile getImgFile() {
        return imgFile;
    }

    /**
     * @param imgFile the imgFile to set
     */
    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
    
}
