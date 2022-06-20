package com.rubincomputers.restvote.repository;

import com.rubincomputers.restvote.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //@Transactional
    //@Modifying
    //User save(User user);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int deleteById(@Param("id") int id);

    Optional<User> getByEmail(String email);
}
