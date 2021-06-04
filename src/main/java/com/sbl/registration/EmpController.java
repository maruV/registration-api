package com.sbl.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000/")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * search functionality using id and username
     * returns employee object based on the parameter
     */

    @GetMapping("/withid/{id}")
    public @ResponseBody Employee getEmployeeById(@PathVariable int id)
    {
        return empService.GetEmpById(id);
    }

    @GetMapping("/withusername/{username}")
    public @ResponseBody Employee getEmployeeByUname(@PathVariable String username)
    {
        return empService.GetEmpByUser(username);
    }

    /**
     * takes employee json fron request body
     * saves into repo using the service method
     */
    @PostMapping
    public @ResponseBody String registerEmployee(@RequestBody Employee employee)
    {
        return empService.createEmployee(employee);
    }
}
