package ru.vallball.work01.model;

import java.time.LocalTime;

public class PauseDTO {

	private Long id;

	private LocalTime begin;

	private LocalTime end;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public Pause convertToPause() {
		Pause pause = new Pause();
		pause.setBegin(this.getBegin());
		pause.setEnd(this.getEnd());
		return pause;
	}

}
