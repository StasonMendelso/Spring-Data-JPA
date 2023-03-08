package org.stanislav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stanislav.models.Person;

import java.util.List;

/**
 * @author Stanislav Hlova
 */
@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);
    List<Person> findByNameOrderByAge(String name);
    List<Person> findByEmail(String email);
    List<Person> findByNameStartingWith(String startingWith);
    List<Person> findByNameOrEmail(String name, String email);
}
