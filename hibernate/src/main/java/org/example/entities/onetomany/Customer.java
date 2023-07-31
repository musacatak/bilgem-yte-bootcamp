package org.example.entities.onetomany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "customers")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer")
    //@OneToMany(cascade = CascadeType.REMOVE)
    //@JoinColumn(name = "customer_id")
    private Set<Order> orders = new HashSet<>();

    public Customer(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public void AddOrder(Order order){
        this.orders.add(order);
    }
}
