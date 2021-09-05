package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.constants.ObjectConstant;
import in.ashokit.entity.Contact;
import in.ashokit.service.ContactService;

@Controller
public class ViewContactController {

	@Autowired
	private ContactService service;
	
	@GetMapping("/edit")
	public String editCon(@RequestParam ("cid") Integer conInteger,Model model){
		Contact contact = service.getContactById(conInteger);
		model.addAttribute(ObjectConstant.CONTACT, contact);
		return ObjectConstant.CONTACT_INFO;
	}
	
	@GetMapping("/delete")
	public String deleteCon(@RequestParam ("cid") Integer conInteger,Model model){
		service.deleteContactById(conInteger);
		return ObjectConstant.REDIRECT_VIEW_ALL_CONTACT;
	}
}
