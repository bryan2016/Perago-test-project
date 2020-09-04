package xyz.foobar.test;

import xyz.foobar.Diff;
import xyz.foobar.DiffException;

//import org.springframework.boot.SpringApplication;

//import org.springframework.boot.autoconfigure.SpringBootApplication;

import xyz.foobar.services.DiffEngineService;

//@SpringBootApplication
public class TechnicalTestApplication {

	public static void main(String[] args) {
		// SpringApplication.run(TechnicalTestApplication.class, args);
		System.out.println("Welcome");

		DiffEngineService diffService = new DiffEngineService();

		Pet pet = new Pet();
		pet.setName("Lucy");
		pet.setType("Cat");

		Person original = new Person();
		original.setFirstName("First Name Here");
		original.setSurname("Surname");

		Person modified = new Person();
		modified.setFirstName("Modified firstName Here ");
		modified.setSurname("modified surname Here");
		modified.setPet(pet);
		try {

			Diff<Person> diff = diffService.calculate(null, modified);
			System.out.println(diff);

			System.out.println("\n");
			diff = diffService.calculate(original, null);
			System.out.println(diff);

		} catch (DiffException e) {

			e.printStackTrace();
		}
	}
}
