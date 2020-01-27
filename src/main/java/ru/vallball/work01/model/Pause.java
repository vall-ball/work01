package ru.vallball.work01.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pauses")
public class Pause {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private LocalTime begin;
	
	@NotNull
	private LocalTime end;

	public LocalTime getBegin() {
		return begin;
	}

	public void setBegin(LocalTime begin) {
		this.begin = begin;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}

	public Long getId() {
		return id;
	}
	
	public PauseDTO convertToDto() {
		PauseDTO dto = new PauseDTO();
		dto.setBegin(this.getBegin());
		dto.setEnd(this.getEnd());
		dto.setId(this.getId());
		return dto;
	}

}
