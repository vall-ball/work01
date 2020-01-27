package ru.vallball.work01.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ru.vallball.work01.model.User;

public interface UserService extends UserDetailsService {
	void save(User user);

	List<User> list();

	void delete(String name);

	void update(User user);

	User findUserByName(String name);

}
