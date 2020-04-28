package ua.yurii.zhurakovskyi.spring.data.jpa.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.yurii.zhurakovskyi.spring.data.jpa.springdatajpa.model.University;
import ua.yurii.zhurakovskyi.spring.data.jpa.springdatajpa.service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UniversityService universityService = ctx.getBean(UniversityService.class);

		University university = new University();
		university.setName("Lviv Polytechnic National University");
		university.setAddress("Ukraine, 79000, Lviv, Stepana Bandera st., 12");
		university.setLevel(4);
		university.setNumberOfInstitutes(18);
		university.setNumberOfStudents(35000);
		System.out.println("Creating...\n");
		universityService.save(university);

		System.out.println("Reading...\n");
		System.out.println(universityService.findById(1L));
		universityService.findByLevel(4).stream().forEach(System.out::println);
		universityService.findByName("Lviv Polytechnic National University");
		System.out.println();

		System.out.println("Updating...\n");
		University updateUniversity = universityService.findById(1L);
		updateUniversity.setNumberOfInstitutes(19);
		universityService.update(updateUniversity);
		universityService.getAll().stream().forEach(System.out::println);

		System.out.println("\nDeleting... \n");
		universityService.deleteById(1L);
		universityService.getAll().stream().forEach(System.out::println);
	}

}
