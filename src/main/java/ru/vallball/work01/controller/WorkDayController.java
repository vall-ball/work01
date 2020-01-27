package ru.vallball.work01.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.work01.model.WorkDay;
import ru.vallball.work01.model.WorkDayDTO;
import ru.vallball.work01.service.WorkDayService;

@RestController
@RequestMapping(value = "/workdays", produces = "application/json")
public class WorkDayController {
	
	//private static final Logger logger = LoggerFactory.getLogger(WorkDayController.class);
	
	
	@Autowired
	WorkDayService workDayService;
	
	@GetMapping
	@ResponseBody
	public List<WorkDayDTO> list() {
		List<WorkDayDTO> list = new ArrayList<>();
		for (WorkDay d : workDayService.list()) {
			list.add(d.convertToDto());
		}
		return list;
	}
	
	@PostMapping
	public ResponseEntity<Object> createProject(@RequestBody WorkDayDTO workDayDto) {
		System.out.println(workDayDto);
		WorkDay workDay = workDayDto.convertToWorkDay();
		workDayService.save(workDay);
		return new ResponseEntity<>("WorkDay is created successfully", HttpStatus.CREATED);
	}

}
