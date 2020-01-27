package ru.vallball.work01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.work01.model.Project;
import ru.vallball.work01.model.ProjectDTO;
import ru.vallball.work01.service.ProjectService;

@RestController
@RequestMapping(value = "/projects", produces = "application/json")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@GetMapping
	@ResponseBody
	public List<ProjectDTO> list() {
		List<ProjectDTO> list = new ArrayList<>();
		for (Project p : projectService.list()) {
			list.add(p.convertToDto());
		}
		return list;
	}

	@PostMapping
	public ResponseEntity<Object> createProject(@RequestBody ProjectDTO projectDto) {
		Project project = projectDto.convertToProject();
		projectService.save(project);
		return new ResponseEntity<>("Project is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProject(@PathVariable(value = "id") Long id,
			@RequestBody ProjectDTO projectDto) {
		Project project = projectDto.convertToProject();
		try {
			Project projectForUpdate = projectService.findProjectById(id);
			projectForUpdate.setName(project.getName());
			projectService.save(projectForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Project not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Project is updated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProject(@PathVariable(value = "id") Long id) {
		try {
			projectService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Project not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Project is deleted successfully", HttpStatus.ACCEPTED);
	}
}
