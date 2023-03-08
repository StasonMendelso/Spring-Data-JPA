package org.stanislav.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.stanislav.models.Item;
import org.stanislav.models.Person;
import org.stanislav.repositories.ItemsRepository;

import java.util.List;

/**
 * @author Stanislav Hlova
 */
@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByOwner(Person person) {
        return itemsRepository.findByOwner(person);
    }

    public List<Item> findByItemName(String name) {
        return itemsRepository.findByName(name);
    }


}
