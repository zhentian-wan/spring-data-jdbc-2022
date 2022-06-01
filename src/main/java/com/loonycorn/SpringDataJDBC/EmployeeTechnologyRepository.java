package com.loonycorn.SpringDataJDBC;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeTechnologyRepository extends CrudRepository<EmployeeTechnology, Long> {

    @Query("SELECT * FROM EmployeeDetails WHERE firstName =:firstName AND lastName =:lastName")
    EmployeeDetails findEmployeeByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT * FROM TechnologyDetails WHERE technologyName =:technologyName")
    TechnologyDetails findTechnologyByName(@Param("technologyName") String technologyName);
}
