package org.acme;

import jakarta.persistence.*;

@Entity
@Table(name = "REGISTRATIONS")
public class RegistrationEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long id;

    @Column(name = "NAME")
    public String name;
    @Column(name = "SURNAME")
    public String surname;
    @Column(name = "EMAIL")
    public String email;
    @Column
    public boolean approved;

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
    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public boolean isApproved() { return approved; }

    public void setApproved(Boolean approved) { this.approved = approved; }
}
