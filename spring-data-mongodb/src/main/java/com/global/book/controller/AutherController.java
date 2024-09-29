package com.global.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Author;
import com.global.book.service.AuthorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

@RestController
@Validated
@RequestMapping("/auther")
public class AutherController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {

		return ResponseEntity.ok(authorService.findById(id));
	}

	@GetMapping("/All")
	public ResponseEntity<?> findAll() {

		return ResponseEntity.ok(authorService.findAll());
	}

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody @Valid Author entity) {

		return ResponseEntity.ok(authorService.insert(entity));
	}

	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody @Valid Author entity) {

		return ResponseEntity.ok(authorService.update(entity));
	}
	
	@PutMapping("/custom")
	public ResponseEntity<?> updateEmail(@RequestParam @Email String email,@RequestParam String name ,@RequestParam String phone) {
		authorService.updateEmail(email, name, phone) ;
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/customId")
	public ResponseEntity<?> updateEmail(@RequestParam String id, @RequestParam @Email String email,
										@RequestParam String name ,@RequestParam String phone) {
		authorService.updateId(id,email, name, phone) ;
		return ResponseEntity.ok(null);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) {
		authorService.deleteById(id);
		return ResponseEntity.ok(null);
	}

	@GetMapping("/find-by-email/{email}")
	public ResponseEntity<?> findAuthorByEmail(@PathVariable @Email String email) {
		return ResponseEntity.ok(authorService.findAuthorByEmail(email));
	}

}
