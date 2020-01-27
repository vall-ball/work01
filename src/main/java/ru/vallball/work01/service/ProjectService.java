package ru.vallball.work01.service;

import java.util.List;

import ru.vallball.work01.model.Project;

public interface ProjectService {
	
	void save(Project project);

	List<Project> list();

	void delete(Long id);

	void update(Project project);

	Project findProjectByName(String name);
	
	Project findProjectById(Long id);
}
