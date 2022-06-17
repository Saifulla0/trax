package com.trax.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trax.entities.Lead;
import com.trax.repository.LeadRepository;

@RestController
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	

	@GetMapping("/getid/{id}")
	public Lead getOneLead(@PathVariable long id) {
		try {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
