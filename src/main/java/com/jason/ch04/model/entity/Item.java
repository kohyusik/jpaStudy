package com.jason.ch04.model.entity;

import javax.persistence.*;


@Entity
public class Item {

    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ITEM_SEQ_GENERATOR")
    @TableGenerator(name="ITEM_SEQ_GENERATOR", table="SEQUENCES", pkColumnValue="ITEM_SEQ", allocationSize=2)
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
