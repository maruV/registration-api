package com.sbl.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    EmpRepository empRepository;

    public Employee GetEmpById(int id)
    {
        return empRepository.findByempID(id);
    }

    public Employee GetEmpByUser(String username)
    {
        return empRepository.findByempUName(username);
    }

    public String createEmployee(Employee employee)
    {
        empRepository.save(employee);
        return employee.getEmpUName();
    }

}
