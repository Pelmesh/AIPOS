package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idOwner;

    private String ownerName;
    private String year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Owner() {
    }

    public Owner(String ownerName, String year, User user) {
        this.ownerName = ownerName;
        this.year = year;
        this.author = user;
    }

    public Owner(String ownerName, String year, Integer idOwner, User user) {
        this.ownerName = ownerName;
        this.year = year;
        this.author = user;
        this.idOwner = idOwner;
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

    public Integer getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Integer idOwner) {
        this.idOwner = idOwner;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }




    @Override
    public String toString() {
        return "Owner{" +
                "idOwner=" + idOwner +
                ", ownerName='" + ownerName + '\'' +
                ", year='" + year + '\'' +
                ", author=" + author +
                '}';
    }
}
