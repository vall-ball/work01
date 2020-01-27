package ru.vallball.work01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.work01.model.WorkDay;

public interface WorkDayRepository extends JpaRepository<WorkDay, Long>{

}
