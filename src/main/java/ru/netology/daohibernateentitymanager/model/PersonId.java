package ru.netology.daohibernateentitymanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}
