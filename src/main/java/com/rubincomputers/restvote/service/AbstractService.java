package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.exception.NotFoundException;
import com.rubincomputers.restvote.model.AbstractBaseEntity;
import com.rubincomputers.restvote.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractService<T extends AbstractBaseEntity> {

    @Autowired
    protected BaseRepository<T> repository;

    protected String entity = getGenericName();

    public T create(T t) {
        Assert.notNull(t, entity + " must not be null");
        Assert.isTrue(t.isNew(), entity + " id must be null");
        return repository.save(t);
    }

    @Transactional
    public void update(T t) {
        Assert.notNull(t, entity = " must not be null");
        Assert.isTrue(!t.isNew(), entity + " id must not be null");
        T updated = null;
        try {
            updated = repository.save(t);
        } catch (ConstraintViolationException e) {
            throw new NotFoundException(entity + " with wrong id");
        }
        if (updated.id() != t.id()) {
            throw new NotFoundException(entity + " with wrong id");
        }
    }

    public T get(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(entity + " not found with id: " + id));
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public List<T> getAll(Sort sort) {
        return repository.findAll(sort);
    }


    public void delete(int id) {
        if (repository.delete(id) == 0) {
            throw new NotFoundException(entity + " not found id=" + id);
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    protected String getGenericName() {
        return ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }
}
