package uptc.frw.el_periodico.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.el_periodico.jpa.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Integer  > {

}
