package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Contact;

public interface ContactService {

	boolean saveContact(Contact contact);
	List<Contact> getAllContacts();
	Contact getContactById(Integer cid);
	boolean deleteContactById(Integer cid);
}
