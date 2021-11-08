package pirmaslab.dalis.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pirmaslab.dalis.model.Vartotojas;
import pirmaslab.dalis.service.ValidationService;
import pirmaslab.dalis.service.VartotojasService;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Controller
public class VartotojasController {

    @Autowired
    VartotojasService service;
    
    @Autowired
    ValidationService validationService;


    @GetMapping("/")
    public String showAll(ModelMap model) {
        model.put("vartotojai", service.findAll());
        return "welcome";
    }
    
    @GetMapping("/list-vartotojai")
    public String showVartotojai(ModelMap model) {
        model.put("vartotojai", service.findAll());
        return "list-vartotojai";
    }
    
    
    @GetMapping("/add-vartotojas")
	public String showAddPage(ModelMap model) {
		model.addAttribute("vartotojas", new Vartotojas("","","","","",""));
		return "vartotojas";
	}

    @PostMapping("/add-vartotojas")
	public String add(ModelMap model, @ModelAttribute("vartotojas") Vartotojas var, BindingResult result) {

       String resul = service.save(var);
		
		if(resul == "saved") {
			return "redirect:/list-vartotojai";
		}
		
	    model.put("error", resul);
	    model.addAttribute("vartotojas", var);
	    return "vartotojas";
	}
   
    
    @GetMapping("/update-vartotojas/{id}")
	public String showUpdatePage(ModelMap model, @PathVariable int id) {
		model.addAttribute("vartotojas", service.findById(id));
		return "vartotojas";
	}

	@PostMapping("/update-vartotojas/{id}")
	public String update(ModelMap model, @ModelAttribute("vartotojas") Vartotojas var, BindingResult result) {
		
		String resul = service.save(var);
		
		if(resul == "saved") {
			return "redirect:/list-vartotojai";
		}
		
	    model.put("error", resul);
	    model.addAttribute("vartotojas", var);
	    return "vartotojas";
	}
	
	@GetMapping("/delete-vartotojas/{id}")
	public String delete(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/list-vartotojai";
	}

}
