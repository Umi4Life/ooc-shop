package io.ooc.project.shop.repository;

import io.ooc.project.shop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository("ItemRepository")
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemByItemID(long itemID);
}
