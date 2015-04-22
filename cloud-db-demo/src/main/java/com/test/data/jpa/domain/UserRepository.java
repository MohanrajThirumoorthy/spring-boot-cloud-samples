package com.test.data.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mohan on 4/3/15.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
