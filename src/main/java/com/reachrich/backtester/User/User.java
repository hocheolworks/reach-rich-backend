package com.reachrich.backtester.User;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "\"User\"")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}
