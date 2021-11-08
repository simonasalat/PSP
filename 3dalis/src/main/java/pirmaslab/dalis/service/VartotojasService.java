package pirmaslab.dalis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pirmaslab.dalis.model.Vartotojas;
import pirmaslab.dalis.repository.VartotojasRepository;

import java.util.List;

@Service
public class VartotojasService {

    @Autowired
    private VartotojasRepository repository;
    
    @Autowired
    ValidationService validationService;
    

  public String save(Vartotojas vartotojas){
    	
    	if(validationService.isValidVartotojas(vartotojas))
    	{
           repository.save(vartotojas);
           return "saved";
    	}
    	return validationService.getError(vartotojas);
    	
    }


    public List<Vartotojas> findAll() {
        return (List<Vartotojas>)repository.findAll();
    }

    public Vartotojas findById(int id) {
        return repository.findById(id);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void delete(Vartotojas vartotojas){
        repository.delete(vartotojas);
    }

    public Vartotojas update(Vartotojas vartotojas){
    	
    	if(validationService.isValidVartotojas(vartotojas))
    	{
           return repository.save(vartotojas);
    	}
    	
    	return null;
    	
    }

    


}

