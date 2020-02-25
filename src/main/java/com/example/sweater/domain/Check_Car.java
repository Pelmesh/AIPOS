package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Check_Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_check;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String vin;
    private String ownerName;
    private String result;

    public Check_Car(){

    }

    public Check_Car(String ownerName, String engineNumber, String result, User user) {
        this.author = user;
        this.vin = engineNumber;
        this.ownerName = ownerName;
        this.result = result;
    }

    public Integer getId_check() {
        return id_check;
    }

    public void setId_check(Integer id_check) {
        this.id_check = id_check;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
