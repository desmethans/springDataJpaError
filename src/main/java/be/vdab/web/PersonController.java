package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Person;

@Controller
@RequestMapping(value = "/")
public class PersonController {
	private static final String TOEVOEGEN_VIEW = "/WEB-INF/JSP/index.jsp";


	@RequestMapping(method=RequestMethod.GET)
	ModelAndView get() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Person());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	String post(@ModelAttribute Person person) {
	  if (person == null) {
		  throw new IllegalArgumentException("person IS NULL");
	  }
	  return "redirect:/";
	}



}
