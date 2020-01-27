package ru.vallball.work01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.work01.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findUserByName(String username);

	void deleteByName(String name);
}
