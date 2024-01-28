package ru.netology.daohibernateentitymanager.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernateentitymanager.repository.PersonStoragable;

@RestController
public class PersonControler {

    private PersonStoragable personRepository;

    public PersonControler(PersonStoragable personStoragable) {
        this.personRepository = personStoragable;
    }


    @GetMapping("/persons/by-city")
    public ResponseEntity<?> getPersonsByCity(@RequestParam String city) {
        personRepository.checkAndFillForTest();
        return new ResponseEntity<>(personRepository.getPersonsByCity(city), HttpStatus.OK);
    }
}
