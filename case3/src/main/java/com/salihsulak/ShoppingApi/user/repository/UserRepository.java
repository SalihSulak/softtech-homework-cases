package com.salihsulak.ShoppingApi.user.repository;

import com.salihsulak.ShoppingApi.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPhoneNumber(String username, String phoneNumber);

    boolean existsByUsername(String username);

    @Query("select u.username from User u where u.id=?1")
    String findUsernameById(UUID id);
    }
