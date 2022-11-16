//package empapp;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.apache.cxf.Bus;
//import org.apache.cxf.jaxws.EndpointImpl;
//
//import javax.xml.ws.Endpoint;
//
//// SOAP webszolgáltatások CXF-fel
//@Configuration
//public class CxfConfig {
//
//    @Bean
//    public Endpoint employeeEndpoint(Bus bus, EmployeesWebService employeesWebService) {
//        var endpoint = new EndpointImpl(bus, employeesWebService);
//        endpoint.publish("/employees");
//        return endpoint;
//    }
//}
