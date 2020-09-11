package com.omtm.server.repository;

import com.omtm.server.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM items i WHERE i.name = :name", nativeQuery = true)
    Optional<Item> findByName(String name);
}
