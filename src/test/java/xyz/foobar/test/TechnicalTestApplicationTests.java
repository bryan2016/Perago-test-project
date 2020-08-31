package xyz.foobar.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xyz.foobar.DiffException;
import xyz.foobar.services.DiffEngineService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TechnicalTestApplicationTests {

	Person person = new Person("F N", "L N");

	Pet pet = new Pet("Cat", "Lucy");

	DiffEngineService diffService = new DiffEngineService();

	{
		person.setPet(pet);

	

	}

	@Test
	void contextLoads() {

	}

	@Test
	public void initObject() {
		try {
			diffService.calculate(person, pet);

		} catch (DiffException e) {
			e.printStackTrace();
		}
		person.setFirstName("F Name");
		person.setSurname("Surname");
		System.out.println("\n Welocme!!!!!!!! 1 = " + person.getFirstName());

		try {
			System.out.println("Diff=" + diffService.calculate(null, person));
		} catch (DiffException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void createNewObject() {

		System.out.println("\n Welocme!!!!!!!! 2 = " + person.getSurname());
	}

	@Test
	public void updateObject() {

		System.out.println("\n Welocme!!!!!!!! 3 = " + person);
	}

}
