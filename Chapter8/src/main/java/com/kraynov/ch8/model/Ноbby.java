package com.kraynov.ch8.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class Ноbby implements Serializable {

    private String hobbyId;
    private Set<Contact> contacts = new HashSet<>();
    public Ноbby() {}

    public Ноbby(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Id
    @Column(name="id")
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @ManyToMany
    @JoinTable(name = "CONTACT_HOBBY_DETAIL",
            joinColumns = @JoinColumn(name = "HOBBY_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Ноbby{" +
                "hobbyId='" + hobbyId + '\'' +
                '}';
    }
}
