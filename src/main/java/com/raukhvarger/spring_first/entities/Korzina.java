package com.raukhvarger.spring_first.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Mavra on 05.06.2018.
 */
@Entity
public class Korzina implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idtov;
    private long idpolz;

    public long getId() {
        return id;
    }

    public Korzina( long idtov,long idpolz){
        this.idpolz = idpolz;
        this.idtov = idtov;
    }

    public void setIdpolz(long idpolz) {
        this.idpolz = idpolz;
    }

    public long getIdpolz() {
        return idpolz;
    }

    public void setIdtov(long idtov) {
        this.idtov = idtov;
    }

    public long getIdtov() {
        return idtov;
    }
}
