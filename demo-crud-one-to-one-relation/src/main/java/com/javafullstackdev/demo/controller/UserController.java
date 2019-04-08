package com.javafullstackdev.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackdev.demo.dto.UserDTO;
import com.javafullstackdev.demo.entity.User;
import com.javafullstackdev.demo.mapper.UserSkipPropertiesMapper;
import com.javafullstackdev.demo.repository.UserReposiotry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserReposiotry userReposiotry;

	@PostMapping
	public User create(@RequestBody User user) {
		User newUser = userReposiotry.save(user);

		return newUser;
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		return userReposiotry.findById(id).map(existingUser -> {
			existingUser.setEmail(user.getEmail());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setDateOfBirth(user.getDateOfBirth());

			User updatedUser = userReposiotry.save(existingUser);

			return ResponseEntity.ok().body(updatedUser);

		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<UserDTO> getAll() {
		List<User> users = userReposiotry.findAll();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new UserSkipPropertiesMapper());
		return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		return userReposiotry.findById(id).map(user -> {
			ModelMapper modelMapper = new ModelMapper();

			return ResponseEntity.ok().body(modelMapper.map(user, UserDTO.class));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return userReposiotry.findById(id).map(user -> {
			userReposiotry.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
