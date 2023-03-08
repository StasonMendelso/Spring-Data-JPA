package org.stanislav.dao;

import org.stanislav.models.Person;

import java.util.List;

/**
 * @author Stanislav Hlova
 */
public interface PersonDAO {
    List<Person> index();

    Person show(int id);

    void save(Person person);

    void update(int id, Person updatedPerson);

    void delete(int id);
}
