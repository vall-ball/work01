package ru.vallball.work01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.work01.dao.PauseRepository;
import ru.vallball.work01.model.Pause;

@Service
@Transactional
public class PauseServiceImpl implements PauseService{
	
	@Autowired
	PauseRepository pauseRepository;

	@Override
	public void save(Pause pause) {
		pauseRepository.save(pause);
		
	}

	@Override
	public List<Pause> list() {
		return pauseRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		pauseRepository.deleteById(id);
		
	}

	@Override
	public void update(Pause pause) {
		pauseRepository.save(pause);
	}


	@Override
	public Pause findPauseById(Long id) {
		return pauseRepository.getOne(id);
	}

}
