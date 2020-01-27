package ru.vallball.work01.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "work_days")
public class WorkDay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private LocalDateTime begin;

	@NotNull
	private LocalDateTime end;

	@NotNull
	@ManyToOne
	@JoinColumn(name="user_name")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "work_day_pauses", joinColumns = {
			@JoinColumn(name = "work_day_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "pause_id", referencedColumnName = "id") })
	private List<Pause> pauses;

	@NotNull
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Pause> getPauses() {
		return pauses;
	}

	public void setPauses(List<Pause> pauses) {
		this.pauses = pauses;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public WorkDayDTO convertToDto() {
		WorkDayDTO dto = new WorkDayDTO();
		dto.setBegin(this.getBegin());
		dto.setEnd(this.getEnd());
		dto.setId(this.getId());
		List<PauseDTO> pausesDto = new ArrayList<>();
		for (Pause p : this.getPauses()) {
			pausesDto.add(p.convertToDto());
		}
		dto.setPauses(pausesDto);
		dto.setProjectDto(this.getProject().convertToDto());
		dto.setUserDto(this.getUser().convertToDto());
		return dto;
	}

}
