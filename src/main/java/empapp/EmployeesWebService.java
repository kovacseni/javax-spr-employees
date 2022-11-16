//package empapp;
//
//import empapp.dto.EmployeeWdto;
//import empapp.dto.FindEmployeeByIdWdto;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import javax.jws.WebService;
//
//// SOAP webszolgáltatások CXF-fel
//@Component
//@WebService
//@AllArgsConstructor
//public class EmployeesWebService {
//
//    private EmployeeService employeeService;
//
//    public EmployeeWdto EmployeeWdtofondEmployeeById(FindEmployeeByIdWdto findEmployee) {
//        var employee = employeeService.findEmployeeById(findEmployee.getId());
//        return new EmployeeWdto(employee.getId(), employee.getName());
//    }
//}
