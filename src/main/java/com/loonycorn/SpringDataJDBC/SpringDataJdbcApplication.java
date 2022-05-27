package com.loonycorn.SpringDataJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJdbcApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmployeeDAOInterface<EmployeeDetails> empDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeDetails employee = empDAO.getById(11023395).get();
		EmployeeDetails newEmp = new EmployeeDetails(null, "Zhentian", "Wan", "Sr Staff Engineer");
		empDAO.addNewEmployee(newEmp);
		employee.setFirstName("ABC");
		empDAO.updateEmployee(employee);
		List<EmployeeDetails> employees = empDAO.list();

		for(EmployeeDetails row: employees) {
			System.out.println(row.toString());
		}

		System.out.println("**** printed employee****"+ employee);




		//printList(jdbcTemplate);

	}

	void insertData(JdbcTemplate jdbcTemplate) {
		String insertQuery = "INSERT INTO EmployeeDetails VALUES(?,?, ?, ?);";
		jdbcTemplate.update(insertQuery,  null,"James", "Powell", "Software Engineer");
		jdbcTemplate.update(insertQuery,  null,"Abby", "Jonues", "Software Engineer");
		jdbcTemplate.update(insertQuery,  null,"Kathy", "Cruz", "Senior Software Engineer");
	}

	void updateAndDelete(JdbcTemplate jdbcTemplate) {
		String updateQuery = "UPDATE EmployeeDetails SET designation = ? WHERE employeeId = ?";
		jdbcTemplate.update(updateQuery, "Staff Engineer", 11023396);

		printList(jdbcTemplate);

		String deleteQuery = "DELETE from EmployeeDetails WHERE employeeId = ?";
		jdbcTemplate.update(deleteQuery, 11023394);
	}

	void printList(JdbcTemplate jdbcTemplate) {
		String query = "SELECT * FROM EmployeeDetails";
		List employeeList = jdbcTemplate.queryForList(query);
		for (Object emp: employeeList) {
			System.out.println(emp.toString());
		}
		System.out.println("#############");
	}
}
