package org.stanislav.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.stanislav.models.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author Stanislav Hlova
 */
public class PersonDAO implements org.stanislav.dao.PersonDAO {
    private final SessionFactory sessionFactory;

    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        criteriaQuery.from(Person.class);

        return session.createQuery(criteriaQuery).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }

    @Transactional
    @Override
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    @Override
    public void update(int id, Person updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        updatedPerson.setId(id);
        session.update(updatedPerson);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Person.class, id));
    }
}
