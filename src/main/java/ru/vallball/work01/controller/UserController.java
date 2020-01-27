package ru.vallball.work01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.work01.model.User;
import ru.vallball.work01.model.UserDTO;
import ru.vallball.work01.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	@ResponseBody
	public List<UserDTO> list() {
		List<UserDTO> list = new ArrayList<>();
		for (User user : userService.list()) {
			list.add(user.convertToDto());
		}
		return list;
	}

	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody UserDTO userDto) {
		User user = userDto.convertToUser();
		userService.save(user.toUser(passwordEncoder));
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{name}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "name") String name, @RequestBody UserDTO userDto) {
		if (!name.equals(userDto.getName())) {
			userService.delete(name);
			User user = userDto.convertToUser();
			userService.save(user.toUser(passwordEncoder));

		} else {
			User user = userDto.convertToUser();
			try {
				User userForUpdate = userService.findUserByName(name);
				userForUpdate.setName(user.getName());
				userForUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
				userService.save(userForUpdate);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>("User is updated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{name}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "name") String name) {
		try {
			userService.delete(name);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("User is deleted successfully", HttpStatus.ACCEPTED);
	}

}
