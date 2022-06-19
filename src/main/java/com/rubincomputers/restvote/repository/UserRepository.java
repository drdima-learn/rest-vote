package com.rubincomputers.restvote.repository;

import com.rubincomputers.restvote.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    //@Modifying
    User save(User user);
}
