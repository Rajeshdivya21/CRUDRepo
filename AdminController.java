package com.capstone.FeedbackManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import com.capstone.FeedbackManagementSystem.Admin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AdminController {

	@Autowired
	AdminRepository adminRepo;

	@GetMapping(value = "/adminDetails")
	public Flux<Admin> getAdminDetails() {
		System.out.println(adminRepo.findAll());
		return adminRepo.findAll();
	}

	@PostMapping(value = "/SaveAdmin")
	public Mono<Admin> saveAdmin(@RequestBody Admin admin) {

		return adminRepo.save(admin);
	}

	@DeleteMapping(value = "/delete/{id}")
	public Mono<Void> delete(@PathVariable Long id) {
		return adminRepo.deleteById(id);
	}

	@PatchMapping(value = "/update/{id}")
	public Mono<Object> update(@PathVariable Long id) {
		Mono<Admin> admin = adminRepo.findById(id);

		return admin.flatMap(s -> {
			s.setEmail("test");
			return adminRepo.save(s);
		});
	}
}
