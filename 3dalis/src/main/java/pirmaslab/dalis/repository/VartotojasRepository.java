package pirmaslab.dalis.repository;

import org.springframework.data.repository.CrudRepository;
import pirmaslab.dalis.model.Vartotojas;

public interface VartotojasRepository extends CrudRepository<Vartotojas, Integer> {

    public Vartotojas findById(int id);
    
    public void deleteById(int id);
}
