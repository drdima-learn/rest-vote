package com.rubincomputers.restvote.repository;

import com.rubincomputers.restvote.model.Dish;
import com.rubincomputers.restvote.model.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface DishRepository extends BaseRepository<Dish> {

}
