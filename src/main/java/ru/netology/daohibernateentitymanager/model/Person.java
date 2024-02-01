package ru.netology.daohibernateentitymanager.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @EmbeddedId
    private PersonId personId;

    /*@Id
    @Column(nullable = false, length = 100)
    private String name;

    @Id
    @Column(nullable = false, length = 100)
    private String surname;

    @Id
    @Column(nullable = false)
    private Integer age;*/

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Gender gender;

    @Column(length = 50,
            name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false,
            length = 120,
            name = "city_of_living")
    private String cityOfLiving;
}
