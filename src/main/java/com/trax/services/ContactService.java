package com.trax.services;

import java.util.List;

import com.trax.entities.Contact;

public interface ContactService {

	public void saveContactLead(Contact contact);
	public List<Contact> getContacts();
	public void deleteConvertByEmail(long id);
	public Contact findById(long id);
}
