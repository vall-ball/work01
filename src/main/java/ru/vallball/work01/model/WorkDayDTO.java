package ru.vallball.work01.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkDayDTO {

	private Long id;

	private LocalDateTime begin;

	private LocalDateTime end;

	private UserDTO userDto;

	private List<PauseDTO> pauses;

	private ProjectDTO projectDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getBegin() {
		return begin;
	}

	public void setBegin(LocalDateTime begin) {
		this.begin = begin;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	public List<PauseDTO> getPauses() {
		return pauses;
	}

	public void setPauses(List<PauseDTO> pauses) {
		this.pauses = pauses;
	}

	public ProjectDTO getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectDTO project) {
		this.projectDto = project;
	}
	
	public WorkDay convertToWorkDay() {
		WorkDay workDay = new WorkDay();
		workDay.setBegin(this.begin);
		workDay.setEnd(this.getEnd());
		List<Pause> pauseEntities = new ArrayList<>();
		for (PauseDTO p : this.getPauses()) {
			pauseEntities.add(p.convertToPause());
		}
		workDay.setPauses(pauseEntities);
		workDay.setProject(this.getProjectDto().convertToProject());
		workDay.setUser(this.getUserDto().convertToUser());
		return workDay;
	}

	@Override
	public String toString() {
		return "WorkDayDTO [id=" + id + ", begin=" + begin + ", end=" + end + ", userDto=" + userDto + ", pauses="
				+ pauses + ", projectDto=" + projectDto + "]";
	}
	
	

}
