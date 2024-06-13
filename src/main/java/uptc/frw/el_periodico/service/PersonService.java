package uptc.frw.el_periodico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.graphqlgrupo2.jpa.entity.Person;
import uptc.frw.graphqlgrupo2.jpa.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person createPerson(Person person) {
        if (person.getBirthday()!= null) {
            if (DateValidator.isValidDate(person.getBirthday())) {
                return personRepository.save(person);
            }
        }
            person.setBirthday(null);
            return personRepository.save(person);


    }

    public Person updatePerson(Person person) {
        Person personPre = findById(person.getId());
        if (personPre != null ) {
            if (person.getName() != null) {
                personPre.setName(person.getName());
            }
            if (person.getAddres() != null) {
                personPre.setAddres(person.getAddres());
            }
            if (person.getPhone() != null) {
                personPre.setPhone(person.getPhone());
            }
            if (person.getBirthday() != null) {
                if (DateValidator.isValidDate(person.getBirthday())) {
                    personPre.setBirthday(person.getBirthday());
                }
            }
            return personRepository.save(personPre);
        }
        return null;
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

}
