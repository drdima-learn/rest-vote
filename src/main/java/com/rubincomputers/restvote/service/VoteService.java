package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.model.Dish;
import com.rubincomputers.restvote.repository.DishRepository;
import com.rubincomputers.restvote.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService extends AbstractService<Dish>{

    @Autowired
    private VoteRepository repository;

}
