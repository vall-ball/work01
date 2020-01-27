package ru.vallball.work01.service;

import java.util.List;

import ru.vallball.work01.model.WorkDay;

public interface WorkDayService {
	
	void save(WorkDay workDay);

	List<WorkDay> list();

	void delete(Long id);

	void update(WorkDay workDay);

	WorkDay findWorkDayById(Long id);

}
