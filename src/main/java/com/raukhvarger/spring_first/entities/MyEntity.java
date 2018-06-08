package com.raukhvarger.spring_first.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String picture;

    private Double Summa;

    public MyEntity() {
    }

    public MyEntity(String name, String picture , Double sum) {
        this.name = name;
        this.picture = picture;
        this.Summa = sum;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String last) {
        this.picture = picture;
    }

    public Double getSum(){ return Summa;}

    public void setSum(Double sum) { this.Summa = sum;}

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", first='" + name + '\'' +
                ", last='" + Summa + '\'' +
                '}';
    }
}
