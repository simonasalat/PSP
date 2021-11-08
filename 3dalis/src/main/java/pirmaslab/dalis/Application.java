package pirmaslab.dalis;

import lt.vu.mif.ood.EmailValidator;
import lt.vu.mif.ood.PasswordChecker;
import lt.vu.mif.ood.PhoneValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pirmaslab.dalis.model.Vartotojas;
import pirmaslab.dalis.service.ValidationService;
import pirmaslab.dalis.service.VartotojasService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

@SpringBootApplication
public class Application {

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	PhoneValidator phoneValidator = new PhoneValidator();
	PasswordChecker passwordChecker = new PasswordChecker();
	EmailValidator emailValidator = new EmailValidator();
	VartotojasService vartotojasService = new VartotojasService();
	//ValidationService validationService = new ValidationService(phoneValidator, passwordChecker, emailValidator);


	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		//runApp();
	}

	public static Vartotojas runApp() throws IOException {
		Scanner s = new Scanner(System.in);
		int choice;
		while (true) {
			System.out.println("1 - Sukurti nauja vartotoja\n2 - Redaguoti esama vartotoja\n3 - Istrinti esama vartotoja\n");
			try {
				choice = s.nextInt();
				switch (choice) {
					case 1: {
						//Vartotojas vartotojas = createNewVartotojas();
					}
					break;
					case 2:
						System.out.println("Tuesday");
						break;
					case 3:
						System.out.println("Tuesday");
						break;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Iveskite skaiciu nuo 1 iki 3");
				s.next();
				s.reset();
			}
		}
	 }
//		public static Vartotojas createNewVartotojas() throws IOException {
//
//			System.out.println("iveskite varda:");
//			String vardas = br.readLine();
//			System.out.println("iveskite pavarde:");
//			String pavarde = br.readLine();
//			System.out.println("iveskite telefono numeri:");
//			String telNr = br.readLine();
//			System.out.println("iveskite emaila:");
//			String email = br.readLine();
//			System.out.println("iveskite adresa:");
//			String adresas = br.readLine();
//			System.out.println("iveskite slaptazodi:");
//			String slaptazodis = br.readLine();
//
//			return new Vartotojas(vardas, pavarde, telNr, email, adresas, slaptazodis);
//		}

}

