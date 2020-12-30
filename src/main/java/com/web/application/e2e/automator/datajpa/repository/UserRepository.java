package com.web.application.e2e.automator.datajpa.repository;

import com.web.application.e2e.automator.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}