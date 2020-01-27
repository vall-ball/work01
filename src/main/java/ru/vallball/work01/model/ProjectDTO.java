package ru.vallball.work01.model;

public class ProjectDTO {
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Project convertToProject() {
		Project project = new Project();
		project.setName(this.getName());
		project.id = this.getId();
		return project;
	}
	@Override
	public String toString() {
		return "ProjectDTO [id=" + id + ", name=" + name + "]";
	}
	
	
}
