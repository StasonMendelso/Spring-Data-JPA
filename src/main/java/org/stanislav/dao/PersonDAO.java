package org.stanislav.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.stanislav.models.Person;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Stanislav Hlova
 */
@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);
        //1 query
//        List<Person> people = session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        //N queries
//        for (Person person : people) {
//            System.out.println("Person " + person.getName() + ", items:" + person.getItemList());
//        }
        List<Person> people = session.createQuery("SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.itemList", Person.class).getResultList();


        for (Person person : people) {
            System.out.println("Person " + person.getName() + ", items:" + person.getItemList());
        }
    }
}
