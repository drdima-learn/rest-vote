package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.exception.NotFoundException;
import com.rubincomputers.restvote.model.Dish;
import com.rubincomputers.restvote.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class DishService extends AbstractService<Dish>{

    @Autowired
    private DishRepository repository;

}
