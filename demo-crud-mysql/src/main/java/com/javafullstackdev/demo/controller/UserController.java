package com.javafullstackdev.demo.controller;

import java.util.List;

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

import com.javafullstackdev.demo.entity.User;
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
	public List<User> getAll() {
		List<User> users = userReposiotry.findAll();

		return users;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return userReposiotry.findById(id).map(user -> ResponseEntity.ok().body(user))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return userReposiotry.findById(id).map(user -> {
			userReposiotry.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
