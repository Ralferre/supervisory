package com.example.supervisory.api.repository.user;

import com.example.supervisory.api.model.user.NewUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface NewUserRepository extends JpaRepository<NewUser, Integer> {
    Page<NewUser> findAll(Pageable pageable);
    Page<NewUser> findByUserNameOrNameOrEmailOrCreatedOn(
            String userName,
            String name,
            String email,
            String createdOn,
            Pageable pageable
    );
}
