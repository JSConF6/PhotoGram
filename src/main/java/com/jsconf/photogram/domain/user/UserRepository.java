package com.jsconf.photogram.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository 없어도 JpaRepository를 상속하면 IoC 등록이 자동으로 된다.
public interface UserRepository extends JpaRepository<User, Integer> {
    // JPA query method
    User findByUsername(String username);
}
