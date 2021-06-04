package com.sbl.registration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

    Employee findByempUName(String username);

    Employee findByempID(int id);
}
