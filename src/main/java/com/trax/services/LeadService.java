package com.trax.services;

import java.util.List;

import com.trax.entities.Lead;

public interface LeadService {

	void saveLeadInfo(Lead lead);

	Lead findLeadById(long id);

	void deleteLeadById(long id);
	
	public List<Lead> getAllLead();


}
