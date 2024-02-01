package ru.netology.daohibernateentitymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.daohibernateentitymanager.model.Person;
import ru.netology.daohibernateentitymanager.model.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, PersonId> {

    @Query(value = "select p from Person p where p.cityOfLiving=:city")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query(value = "select p from Person p where p.personId.age<=?1 order by p.personId.age asc")
    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    @Query(value = "select p.* from netology_db.person p where p.name=?1 and p.surname=?2 limit 1",
            nativeQuery = true
    )
    Optional<Person> findFirstByNameAndSurname(String name, String surname);
}
