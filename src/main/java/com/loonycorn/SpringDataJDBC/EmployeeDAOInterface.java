package com.loonycorn.SpringDataJDBC;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAOInterface<Table> {

    List<Table> list();

    Optional<Table> getById(int id);

    void addNewEmployee(Table table);

    void updateEmployee(Table table);
}
