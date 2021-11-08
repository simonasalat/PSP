package pirmaslab.dalis.service;

import org.springframework.stereotype.Service;

import lt.vu.mif.ood.EmailValidator;
import lt.vu.mif.ood.PasswordChecker;
import lt.vu.mif.ood.PhoneValidator;
import lt.vu.mif.ood.exceptions.*;
import pirmaslab.dalis.model.Vartotojas;

@Service
public class ValidationService {

    private PhoneValidator phoneValidator = new PhoneValidator();
    private PasswordChecker passwordChecker = new PasswordChecker();
    private EmailValidator emailValidator = new EmailValidator();

   /* public ValidationService(PhoneValidator phoneVal, PasswordChecker passCheck, EmailValidator emailVal){
        phoneValidator = phoneVal;
        passwordChecker = passCheck;
        emailValidator = emailVal;
    }*/

    public ValidationService(){}

    public String getError(Vartotojas var){
    	
    	String error = "";
    	
    	if(!isValidPhone(var.getTelNr())) {
    		
    	   error = "Blogai ivestas telefono numeris. ";
    	}
    		
    	if(!isValidEmail(var.getEmail())) {
    	
    		error = error + "Blogai ivestas emailas. ";
    	}
    	
    	if(!isValidPassword(var.getSlaptazodis()))
    	{
    		error = error + "Per silpnas slaptazodis. ";
    			
        }
    		
        return error;

    }

    public boolean isValidVartotojas(Vartotojas var) {
    
    	return isValidPhone(var.getTelNr()) && isValidEmail(var.getEmail()) && isValidPassword(var.getSlaptazodis());

    }
    
    
    public boolean isValidPhone(String telNr) {
        try{
            phoneValidator.validate(telNr);
            return true;
        } 
         catch (ValidationException e) {
           return false;
        }
    }
    
    public boolean isValidEmail(String email) {
        try{
            emailValidator.validate(email);
            return true;
        } 
        catch (ValidationException e) {
            return false;
        }
    }
    
    public boolean isValidPassword(String password) {
        try {
            passwordChecker.validate(password);
            return true;
        } 
        catch (ValidationException e) {
            return false;
        }
    }
}
