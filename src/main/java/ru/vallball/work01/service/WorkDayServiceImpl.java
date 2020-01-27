package ru.vallball.work01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.work01.dao.WorkDayRepository;
import ru.vallball.work01.model.WorkDay;

@Service
@Transactional
public class WorkDayServiceImpl implements WorkDayService{

	@Autowired
	WorkDayRepository workDayRepository;
	
	@Override
	public void save(WorkDay workDay) {
		workDayRepository.save(workDay);
	}

	@Override
	public List<WorkDay> list() {
		return workDayRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		workDayRepository.deleteById(id);
		
	}

	@Override
	public void update(WorkDay workDay) {
		workDayRepository.save(workDay);
	}

	@Override
	public WorkDay findWorkDayById(Long id) {
		return workDayRepository.getOne(id);
	}

}
