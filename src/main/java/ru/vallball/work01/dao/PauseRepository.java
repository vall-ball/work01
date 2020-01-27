package ru.vallball.work01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.work01.model.Pause;

public interface PauseRepository extends JpaRepository<Pause, Long> {

}
