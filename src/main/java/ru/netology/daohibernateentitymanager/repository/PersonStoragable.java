package ru.netology.daohibernateentitymanager.repository;

import ru.netology.daohibernateentitymanager.model.Person;

import java.util.List;

public interface PersonStoragable {
    List<Person> getPersonsByCity(String city);
    public void checkAndFillForTest();
}
