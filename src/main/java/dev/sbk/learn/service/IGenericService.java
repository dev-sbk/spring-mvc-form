package dev.sbk.learn.service;

import java.util.List;

public interface IGenericService<T> {
    public void save(T temp);
    public void update(T temp);
    public void remove(Class<T> temp,Long id);
    public T findOneById(Class<T> temp,Long id);
    public List<T> findAll(Class<T> temp);
}
