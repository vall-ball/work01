package ru.vallball.work01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.work01.dao.ProjectRepository;
import ru.vallball.work01.model.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public void save(Project project) {
		projectRepository.save(project);
		
	}

	@Override
	public List<Project> list() {
		return projectRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		projectRepository.deleteById(id);		
	}

	@Override
	public void update(Project project) {
		projectRepository.save(project);
		
	}

	@Override
	public Project findProjectByName(String name) {
		return projectRepository.findProjectByName(name);
	}

	@Override
	public Project findProjectById(Long id) {
		return projectRepository.findById(id).get();
	}
	
	

}
