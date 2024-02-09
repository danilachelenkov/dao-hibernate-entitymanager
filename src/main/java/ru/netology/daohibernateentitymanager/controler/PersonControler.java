package ru.netology.daohibernateentitymanager.controler;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernateentitymanager.model.Person;
import ru.netology.daohibernateentitymanager.repository.PersonJpaRepository;

import java.util.Optional;


@RestController
public class PersonControler {
    private PersonJpaRepository personJpaRepository;

    public PersonControler(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping("/persons/by-city")
    public ResponseEntity<?> getPersonsByCity(@RequestParam String city) {

        return new ResponseEntity<>(personJpaRepository.findByCityOfLiving(city), HttpStatus.OK);
    }

    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-less-than-age")
    public ResponseEntity<?> getPersonsByLessAgeAndOrderAsc(@RequestParam Integer age) {
        return new ResponseEntity<>(personJpaRepository.findByAgeLessThanOrderByAgeAsc(age), HttpStatus.OK);
    }

    @RolesAllowed({"ROLE_READ", "ROLE_WRITE"})
    @GetMapping("/persons/by-name-and-surname")
    public ResponseEntity<?> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {

        Optional<Person> person = personJpaRepository.findFirstByNameAndSurname(name, surname);
        if (!person.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person.get(), HttpStatus.OK);
    }

    @GetMapping("/user")
    @PreAuthorize("#username == authentication.principal.username")
    private String getUserName(String username) {
       return "Hellow user: " + username;
    }
}
