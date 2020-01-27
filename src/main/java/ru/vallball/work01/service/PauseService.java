package ru.vallball.work01.service;

import java.util.List;

import ru.vallball.work01.model.Pause;

public interface PauseService {

	void save(Pause pause);

	List<Pause> list();

	void delete(Long id);

	void update(Pause pause);
	
	Pause findPauseById(Long id);
}
