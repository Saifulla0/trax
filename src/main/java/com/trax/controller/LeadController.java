package com.trax.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entities.Lead;
import com.trax.services.LeadService;
import com.trax.utility.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;

	@RequestMapping("viewCreateLead")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping(value="/saveLead", method = RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		try {
			leadService.saveLeadInfo(lead);
			model.addAttribute("lead", lead);
			return "lead_info";
		} catch (Exception e) {
			model.addAttribute("emailerror", "this email already exists!!");
			return "create_lead";
		}
		
		
	}
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam ("email") String email,ModelMap model) {
		model.addAttribute("email", email);
		return "compose_email";
		
	}
	
	@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("to") String to,@RequestParam("sub") String sub,@RequestParam("body") String body,ModelMap model) {
		emailService.sendSimpleMessage(to, sub, body);
		model.addAttribute("msg", "email sent successfuly!");
		return "lead_info";
	}
	
	@RequestMapping("/listall")
	public String listAll(ModelMap model) {
		List<Lead> leads = leadService.getAllLead();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id,ModelMap model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
		
	}
}
