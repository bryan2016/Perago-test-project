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
		pet.setName("Cat");
		pet.setType("Lucy");

		Person original = new Person();
		original.setFirstName("First Name");
		original.setSurname("Surname");

		Person modified = new Person();
		modified.setFirstName("Modified firstName");
		modified.setSurname("modified surname");
		modified.setPet(pet);
		try {

			Diff<Person> diff = diffService.calculate(null, modified);
			System.out.println(diff);

			// Person person = diffService.apply(modified, diff);
			// System.out.println(person);
		} catch (DiffException e) {

			e.printStackTrace();
		}
	}
}
