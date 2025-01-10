/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swingmaven.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 *
 * @author admin
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "student")
public class Student {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(columnDefinition = "varchar(60)", nullable = false)
    String name;
    @Column(columnDefinition = "varchar(70)", nullable = false)
    String className;
    @Column(columnDefinition = "varchar(15)", nullable = false, unique = true)
    String email;
    @Column(columnDefinition = "varchar(15)", nullable = false, unique = true)
    String phoneNumber;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    String birthday;
}
