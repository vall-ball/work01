package ru.vallball.work01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.work01.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

	Project findProjectByName(String name);
}
