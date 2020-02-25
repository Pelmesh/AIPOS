package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCar;

    private String modelCar;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    private Integer authorId;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    private String vin;
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Car() {
    }

    public Car(String modelCar, String vin, String number, User user) {
        this.author = user;
        this.modelCar = modelCar;
        this.vin = vin;
        this.number = number;
    }

    public Car(Integer idCar, String vin, String number, String modelCar,User user) {
        this.idCar = idCar;
        this.modelCar = modelCar;
        this.vin = vin;
        this.number = number;
        this.author = user;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", modelCar='" + modelCar + '\'' +
                ", vin='" + vin + '\'' +
                ", number='" + number + '\'' +
                ", author=" + author +
                '}';
    }
}
