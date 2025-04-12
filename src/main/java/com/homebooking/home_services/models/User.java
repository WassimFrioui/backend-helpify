package com.homebooking.home_services.models;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String lastname;

    @Column(nullable = true)
    private String firstname;

    @Column(nullable = true)
    private Enum<E_Role> role;

    @Column(nullable = true, unique = true)
    private String mail;

    @Column(nullable = true, unique = true)
    private String phone;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true, updatable = false)
    @CreationTimestamp
    private Date createdAt = new Date();
}
