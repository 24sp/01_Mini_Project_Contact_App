package in.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.constants.ObjectConstant;
import in.ashokit.entity.Contact;
import in.ashokit.props.AppProps;
import in.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private AppProps appProps;
	
	@Autowired
	private ContactService contactService;
	/**
	 * This method is used to load Contact Info page
	 * @param model
	 * @return String	
	 */
	@GetMapping("/contact")
	public String loadContacForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute(ObjectConstant.CONTACT, contactObj);
		return ObjectConstant.CONTACT_INFO;
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact,Model model)
	{
		boolean isSave = contactService.saveContact(contact);
		
		Map<String, String> messages = appProps.getMessages();
 		
		if(isSave)
		{
			model.addAttribute(ObjectConstant.SUCCESS, messages.get("saveSuccess"));
		}else {
			model.addAttribute(ObjectConstant.ERROR, messages.get("saveFail"));
		}
		return ObjectConstant.CONTACT_INFO;
	}
	
	@GetMapping("/viewAllContact")
	public String viewContacts (Model model)
	{
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute(ObjectConstant.CONTACTS, allContacts);
		return ObjectConstant.CONTACTS;
	}
	
}
