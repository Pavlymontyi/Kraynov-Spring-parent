package com.kraynov.ch8.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="contact")
@NamedQueries(
    {
        @NamedQuery(name = "Contact.findAllWithDetail",
                query = "select distinct c from Contact c left join fetch c.contactTelDetails t " +
                        "left join fetch c.hobbies h"),
        @NamedQuery(name = "Contact.findById",
                query = "select distinct c from Contact c left join fetch c.contactTelDetails t " +
                        "left join fetch c.hobbies h where c.id=:id")
    }
)
public class Contact implements Serializable{

    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Set<ContactTelDetail> contactTelDetails = new HashSet<>();
    private Set<Ноbby> hobbies = new HashSet<>();

    public Contact(){}
    public Contact(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    @Version
    @Column(name="version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }

    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    public void addContactDetail(ContactTelDetail telDetail){
        telDetail.setContact(this);
        this.contactTelDetails.add(telDetail);
    }

    public void removeContactDetail(ContactTelDetail telDetail){
        telDetail.setContact(null);
        this.contactTelDetails.remove(telDetail);
    }

    @ManyToMany
    @JoinTable(name = "CONTACT_HOBBY_DETAIL",
            joinColumns = @JoinColumn(name = "CONTACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
    public Set<Ноbby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Ноbby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ",\n  contactTelDetails=" + contactTelDetails +
                ",\n  hobbies=" + hobbies +
                "\n}\n";
    }
}
