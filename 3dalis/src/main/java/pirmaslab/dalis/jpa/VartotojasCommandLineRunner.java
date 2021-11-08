package pirmaslab.dalis.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pirmaslab.dalis.model.Vartotojas;
import pirmaslab.dalis.repository.VartotojasRepository;

@Component
public class VartotojasCommandLineRunner implements CommandLineRunner {

    @Autowired
    private VartotojasRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Vartotojas("vardas", "pavarde","+37061111111","vardas@gmail.com","adresas1","@@aaA1-KopL$"));
        repository.save(new Vartotojas("vardas", "pavarde","+37061111112","vardas2.pav@gmail.com","adresas 8","@@aaA1-KopL$"));
        repository.save(new Vartotojas("vardas", "pavarde","+37061111113","vardas.1pav@gmail.com","adresass st.","@@aaA1-KopL$"));
        repository.save(new Vartotojas("vardas", "pavarde","+37061111114","vardas.paaav@gmail.com","adresas","@@aaA1-KopL$"));
        repository.save(new Vartotojas("vardas", "pavarde","+37061111115","vardas.pavhh@gmail.com","adresas 1","@@aaA1-KopL$"));
        repository.save(new Vartotojas("vardas", "pavarde","+37061111116","vardaspaav@gmail.com","adresas g. 11","@@aaA1-KopL$"));
    }
}




