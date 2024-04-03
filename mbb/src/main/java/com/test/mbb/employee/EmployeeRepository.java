package com.test.mbb.employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	@Query("Select e From Employee e Where e.email=?1")
	Optional<Employee> findEmployeeByEmail(String email);
}
