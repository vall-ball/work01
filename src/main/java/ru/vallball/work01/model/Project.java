package ru.vallball.work01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotNull
	@Column(unique = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public ProjectDTO convertToDto() {
		ProjectDTO projectDto = new ProjectDTO();
		projectDto.setId(this.getId());
		projectDto.setName(this.getName());
		return projectDto;
	}
	
	
}
