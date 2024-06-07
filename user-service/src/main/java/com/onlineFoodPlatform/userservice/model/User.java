package com.onlineFoodPlatform.userservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;

    @Column(name = "email" ,nullable = false, unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cart> cartList;
}
