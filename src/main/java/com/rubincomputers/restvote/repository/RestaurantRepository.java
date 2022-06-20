package com.rubincomputers.restvote.repository;

import com.rubincomputers.restvote.model.Restaurant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface RestaurantRepository extends BaseRepository<Restaurant> {

}
