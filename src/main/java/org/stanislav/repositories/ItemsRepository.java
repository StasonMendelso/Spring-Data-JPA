package org.stanislav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stanislav.models.Item;
import org.stanislav.models.Person;

import java.util.List;

/**
 * @author Stanislav Hlova
 */
@Repository
public interface ItemsRepository extends JpaRepository<Item,Integer>{
    List<Item> findByOwner(Person owner);
    List<Item> findByName(String name);

}
