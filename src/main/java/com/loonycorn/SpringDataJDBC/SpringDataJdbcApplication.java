package com.loonycorn.SpringDataJDBC;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);
	}

	@Bean
	ApplicationRunner designationRunner(DesignationDetailsRepository designationDetailsRepository) {
		return args -> {
			DesignationDetails desg1 = DesignationDetails.addDesignation(null, "Associate Software Egineer");
			DesignationDetails desg2 = DesignationDetails.addDesignation(null, "Software Engineer");
			designationDetailsRepository.save(desg1);
			designationDetailsRepository.save(desg2);

			System.out.println(designationDetailsRepository.findAll());
			System.out.println(designationDetailsRepository.findById(2L));
		};
	}

	@Bean
	ApplicationRunner technologyRunner(TechnoloygDetailsRepository technoloygDetailsRepository) {
		return args -> {
			TechnologyDetails techJava = TechnologyDetails.addTech(null, "Java");
			technoloygDetailsRepository.save(techJava);
			TechnologyDetails techPython = TechnologyDetails.addTech(null, "Python");
			technoloygDetailsRepository.save(techPython);
			TechnologyDetails techAzure = TechnologyDetails.addTech(null, "Azure");
			technoloygDetailsRepository.save(techAzure);
		};
	}
	@Bean
	ApplicationRunner applicationRunner(EmployeeDetailsRepository employeeDetailsRepository) {
		return args -> {


			EmployeeDetails employee1 = EmployeeDetails.create(null, "Rachel", "Black", 1);
			EmployeeDetails employee2 = EmployeeDetails.create(null, "Naomi", "Sears", 2);

			System.out.println(employeeDetailsRepository.save(employee1));
			System.out.println(employeeDetailsRepository.save(employee2));
		};
	}





	@Bean
	ApplicationRunner empTechRunner(EmployeeTechnologyRepository employeeTechnologyRepository) {
		return args -> {
			Long technologyId = employeeTechnologyRepository.findTechnologyByName("Java").getTechnologyId();
			Integer employeeId = employeeTechnologyRepository.findEmployeeByName("Naomi", "Sears").getEmployeeId();

			EmployeeTechnology empTech = new EmployeeTechnology();
			empTech.setEmployeeId(employeeId);
			empTech.setTechnologyId(technologyId);

			employeeTechnologyRepository.save(empTech);

		};
	}

}
