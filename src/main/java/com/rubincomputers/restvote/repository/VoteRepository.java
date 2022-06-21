package com.rubincomputers.restvote.repository;

import com.rubincomputers.restvote.model.Vote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface VoteRepository extends BaseRepository<Vote> {

}
