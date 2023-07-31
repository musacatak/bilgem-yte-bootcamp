package org.example.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name="staffs")
public class Staff {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;

    @ElementCollection
    @CollectionTable(name = "phone_numbers")
    private Set<String> phoneNumbers = new HashSet<String>();

    public void addPhoneNumber(String phoneNumber){
        this.phoneNumbers.add(phoneNumber);
    }
    public Staff(String name, String surname, Set<String> phoneNumbers) {
        this.name = name;
        this.surname = surname;
        this.phoneNumbers = phoneNumbers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
