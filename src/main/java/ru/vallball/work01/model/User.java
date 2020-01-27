package ru.vallball.work01.model;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User implements UserDetails {

	@Id
	@Size(min = 3, max = 30)
	private String name;

	@NotNull
	@Size(min = 3, max = 300)
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO convertToDto() {
		UserDTO dto = new UserDTO();
		dto.setName(this.getUsername());
		dto.setPassword(this.getPassword());
		return dto;
	}

	public User toUser(PasswordEncoder passwordEncoder) {
		this.setPassword(passwordEncoder.encode(password));
		return this;
	}
}
