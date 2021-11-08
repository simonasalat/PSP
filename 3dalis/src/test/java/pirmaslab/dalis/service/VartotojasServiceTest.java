package pirmaslab.dalis.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import pirmaslab.dalis.model.Vartotojas;
import pirmaslab.dalis.repository.VartotojasRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class VartotojasServiceTest {

	@Mock
	VartotojasRepository repository;

	@Mock
	ValidationService validation;

	@InjectMocks
	VartotojasService service;


	@Test
	void saveTest() {
		Vartotojas var = new Vartotojas("Vardenis", "Pavardenis", "861111111", "emailas@gmail.com", "Adress", "Sl@ptazodis132!");
		when(repository.save(Mockito.any(Vartotojas.class))).thenReturn(var);
		when(validation.isValidVartotojas(Mockito.any(Vartotojas.class))).thenReturn(true);

		String result = service.save(var);
		assertEquals("saved",result);
	}

	@Test
	void findAllTest() {
		Vartotojas var1 = new Vartotojas("vardas", "pavarde","+37061111111","vardas@gmail.com","adresas1","@@aaA1-KopL$");
		Vartotojas var2 = new Vartotojas("vardas", "pavarde","+37061111112","vardas2.pav@gmail.com","adresas 8","@@aaA1-KopL$");
		var varList = List.of(var1, var2);
		when(repository.findAll()).thenReturn(varList);
		var users = service.findAll();
		assertEquals(2, users.size());
		assertEquals("vardas", users.get(0).getVardas());
		assertEquals("vardas", users.get(1).getVardas());
	}

	@Test
	void updateTest(){
		Vartotojas var = new Vartotojas("vardas", "pavarde","+37061111111","vardas@gmail.com","adresas1","@@aaA1-KopL$");

		when(repository.save(Mockito.any(Vartotojas.class))).thenReturn(var);
		when(validation.isValidVartotojas(Mockito.any(Vartotojas.class))).thenReturn(true);
		Vartotojas var2 = new Vartotojas("vardas2", "pavarde2","+37061111112","vardas2@gmail.com","adresas2","NaujasS21pL-@@");
		var2 = service.update(var2);
		verify(repository).save(Mockito.any(Vartotojas.class));

		assertEquals(var2.getVardas(), var.getVardas());
		assertEquals(var2.getPavarde(), var.getPavarde());
		assertEquals(var2.getTelNr(), var.getTelNr());
		assertEquals(var2.getEmail(), var.getEmail());
		assertEquals(var2.getAdresas(), var.getAdresas());
		assertEquals(var2.getSlaptazodis(), var.getSlaptazodis());
	}

	@Test
	void findByIdTest() {
		Vartotojas var = new Vartotojas("vardas2", "pavarde2","+37061111112","vardas2@gmail.com","adresas2","NaujasS21pL-@@");
		when(repository.findById(1)).thenReturn(var);
		assertEquals(var,service.findById(1));
		assertNull(service.findById(2));
	}

	@Test
	void deleteByIdTest() {
		service.deleteById(1);
		verify(repository).deleteById(Mockito.anyInt());
	}


}
