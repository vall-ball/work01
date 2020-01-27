package ru.vallball.work01.model;

public class UserDTO {
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User convertToUser() {
		User user = new User();
		user.setName(this.getName());
		user.setPassword(this.getPassword());
		return user;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + "]";
	}
	
	
}
