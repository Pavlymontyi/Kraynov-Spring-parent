package com.kraynov.deps.model;

import javax.persistence.*;

@Entity
@Table(name="BANKS")
@NamedQueries(
    {
        @NamedQuery(name = "Bank.findAll", query = "select distinct b from Bank b"),
        @NamedQuery(name = "Bank.findById", query = "select distinct b from Bank b where b.id=:id"),
        @NamedQuery(name = "Bank.findByName", query = "select distinct b from Bank b where b.name=:name")
    }
)
public class Bank {
    private Long       id;
    private String     name;

    public Bank() {}

    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
