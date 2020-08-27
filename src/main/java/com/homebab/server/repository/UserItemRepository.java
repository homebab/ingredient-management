package com.homebab.server.repository;

import com.homebab.server.domain.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserItemRepository extends JpaRepository<UserItem, Long> {

}
