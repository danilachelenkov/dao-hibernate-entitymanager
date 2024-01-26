package ru.netology.daohibernateentitymanager.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernateentitymanager.repository.PersonRepository;


@RestController
public class PersonControler {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    public ResponseEntity<?> getPersonsByCity(@RequestParam String city) {
        return new ResponseEntity<>(personRepository.getPersonsByCity(city), HttpStatus.OK);
    }


}
