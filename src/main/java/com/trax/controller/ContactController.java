package com.trax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entities.Contact;
import com.trax.entities.Lead;
import com.trax.services.ContactService;
import com.trax.services.LeadService;

@Controller
public class ContactController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/convertLead")
	public String contactLead(@RequestParam("id") long id,ModelMap model) {
		try {
		Lead lead = leadService.findLeadById(id);
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setLeadSource(lead.getLeadSource());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contactService.saveContactLead(contact);
		leadService.deleteLeadById(id);
		
		List<Contact> contacts = contactService.getContacts();
		model.addAttribute("contacts", contacts);
		return "contact_search_result";
		}catch (Exception e) {
			contactService.deleteConvertByEmail(id);
			model.addAttribute("emailerror", "emialexists!!");
			return "lead_info";
		}
	}
		@RequestMapping("/contactInfo")
		public String getContactById(@RequestParam("id") long id,ModelMap model) {
			Contact contact = contactService.findById(id);
			model.addAttribute("contact", contact);
			return "contact_info";
	}
		@RequestMapping("/listallcontacts")
		public String listAll(ModelMap model) {
			List<Contact> contacts = contactService.getContacts();
			model.addAttribute("contacts", contacts);
			return "contact_search_result";
		}
		
	
}
