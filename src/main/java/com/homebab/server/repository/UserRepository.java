package com.homebab.server.repository;

import com.homebab.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>  {

}
