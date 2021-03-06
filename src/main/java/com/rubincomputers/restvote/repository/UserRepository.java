package com.rubincomputers.restvote.repository;

import com.rubincomputers.restvote.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> getByEmail(String email);
}
