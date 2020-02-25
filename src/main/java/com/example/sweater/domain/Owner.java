package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_owner;

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

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getId_owner() {
        return id_owner;
    }

    public void setId_owner(Integer id_owner) {
        this.id_owner = id_owner;
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

}
