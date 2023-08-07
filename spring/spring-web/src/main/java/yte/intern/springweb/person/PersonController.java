package yte.intern.springweb.person;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {


    @PostMapping("")
    public List<Person> updateAges(@RequestBody List<Person> persons) {
//        List<Person> updatedPersons = persons.stream()
//                .map(person -> {
//                    person.setAge(person.getAge() + 1);
//                    return person;
//                })
//                .collect(Collectors.toList());

        return persons.stream()
                .map(person -> new Person(person.name(), person.surname(), person.age() + 1))
                .toList();
    }
}
