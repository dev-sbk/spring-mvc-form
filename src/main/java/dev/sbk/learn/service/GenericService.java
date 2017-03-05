package dev.sbk.learn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.sbk.learn.repository.IGenericRepository;

@Service
@Transactional
public class GenericService<T> implements IGenericService<T> {
	@Autowired
	private IGenericRepository<T> repository;

	@Override
	public void save(T temp) {
		repository.save(temp);
	}

	@Override
	public void update(T temp) {
		repository.update(temp);
	}

	@Override
	public void remove(Class<T> temp, Long id) {
		repository.remove(temp, id);
	}

	@Override
	public T findOneById(Class<T> temp, Long id) {

		return repository.findOneById(temp, id);
	}

	@Override
	public List<T> findAll(Class<T> temp) {
		// TODO Auto-generated method stub
		return repository.findAll(temp);
	}

	public IGenericRepository<T> getRepository() {
		return repository;
	}

	public void setRepository(IGenericRepository<T> repository) {
		this.repository = repository;
	}

}
