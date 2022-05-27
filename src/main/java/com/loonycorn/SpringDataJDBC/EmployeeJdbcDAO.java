package com.loonycorn.SpringDataJDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// instance should be created
// dependencies should be injected
@Component
public class EmployeeJdbcDAO implements EmployeeDAOInterface<EmployeeDetails>{
    private JdbcTemplate jdbcTemplate;

    RowMapper<EmployeeDetails> rowMap = (row, num) -> {
        EmployeeDetails employees = new EmployeeDetails();

        employees.setEmployeeId(row.getInt("employeeId"));
        employees.setFirstName(row.getString("firstName"));
        employees.setLastName(row.getString("lastName"));
        employees.setDesignation(row.getString("designation"));

        return employees;
    };

    public EmployeeJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeeDetails> list() {
        String query = "SELECT * from EmployeeDetails";

        return jdbcTemplate.query(query, rowMap);
    }

    @Override
    public Optional<EmployeeDetails> getById(int id) {
        String query = "SELECT * FROM EmployeeDetails WHERE employeeId = ?";
        EmployeeDetails employee = null;
        try {
            employee = jdbcTemplate.queryForObject(query, rowMap, id);
        } catch(DataAccessException dataAccessException) {
            System.out.println(dataAccessException);
         }

        return Optional.ofNullable(employee);
    }

    @Override
    public void addNewEmployee(final EmployeeDetails employeeDetails) {
        String query = "INSERT INTO EmployeeDetails (firstName, lastName, designation) " + "VALUES (?, ?, ?)";
        jdbcTemplate.update(query, employeeDetails.getFirstName(), employeeDetails.getLastName(), employeeDetails.getDesignation());
    }

    @Override
    public void updateEmployee(final EmployeeDetails employeeDetails) {
        String query = "UPDATE EmployeeDetails SET firstName = ?, lastName = ?, designation = ? WHERE employeeId = ?";
        jdbcTemplate.update(query, employeeDetails.getFirstName(), employeeDetails.getLastName(), employeeDetails.getDesignation(), employeeDetails.getEmployeeId());

    }
}
