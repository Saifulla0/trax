package com.trax.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entities.Bill;
import com.trax.entities.Contact;
import com.trax.services.BillingService;
import com.trax.services.ContactService;
import com.trax.utility.PdfService;

@Controller
public class BillingController {

	@Autowired
	private PdfService pdfService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;

	@RequestMapping(value="/createBill", method = RequestMethod.GET)
	public String createBill(@RequestParam long id,ModelMap model) {
		String filePath = "C:\\sts_code8\\trax\\tickets\\tickets.pdf";

		Contact contact = contactService.findById(id);
		model.addAttribute("contact", contact);
		pdfService.writeUsingIText(filePath);

		return "create_bill";
	}
	
	@RequestMapping("/saveBill")
	public String billing(@ModelAttribute Bill bill) {
		billingService.saveBill(bill);
		return "create_bill";
	}
}
