package ru.vallball.work01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.work01.dao.UserRepository;
import ru.vallball.work01.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByName(username);
		if (user != null)
			return user;
		throw new UsernameNotFoundException("Пользователь " + username + " не найден");
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	public List<User> list() {
		return userRepository.findAll();
	}

	@Override
	public void delete(String name) {
		userRepository.deleteByName(name);
		
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User findUserByName(String name) {
		return userRepository.findById(name).get();
				//findUserByName(name);
	}
	
	

}
