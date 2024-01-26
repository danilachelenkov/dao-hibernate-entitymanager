package ru.netology.daohibernateentitymanager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.netology.daohibernateentitymanager.model.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {

        String query = String.format("from Person where cityOfLiving='%s'",city);
        List<Person> personList = entityManager.createQuery(query, Person.class).getResultList();

        return personList;
    }
}
