package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw('Y');
		Contact saveCon = contactRepository.save(contact);
		if (saveCon != null && saveCon.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		
		List<Contact> findAll = contactRepository.findAll();
		return findAll.stream()
									   .filter(contact -> contact.getActiveSw() == 'Y')
									   .collect(Collectors.toList()); 
		/**return collect;*/
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<Contact> findById = contactRepository.findById(cid);
		if (findById.isPresent()) {
			/**Contact contact = findById.get();*/
			return findById.get();
			/**return contact;*/
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		/**
		 * boolean status = contactRepository.existsById(cid); if(status) {
		 * contactRepository.deleteById(cid); return true; }
		 */
		Optional<Contact> optional = contactRepository.findById(cid);
		if(optional.isPresent())
		{
			Contact contact = optional.get();
			contact.setActiveSw('N');
			contactRepository.save(contact);
			return true;
		}
		return false;
	}
}
