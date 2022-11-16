package empapp;

import empapp.dto.CreateEmployeeCommand;
import empapp.dto.EmployeeDto;
//import empapp.dto.EmployeeHasCreatedEvent;
import empapp.dto.UpdateEmployeeCommand;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    private List<SseEmitter> emitters;

    @GetMapping
    public List<EmployeeDto> employees() {
        return employeeService.listEmployees();
    }

    // Server send events
//    @GetMapping("/messages")
//    public SseEmitter messages() {
//        var emitter = new SseEmitter();
//        emitters.add(emitter);
//        return emitter;
//    }

    // Server send events
//    @EventListener
//    public void handleEvent(EmployeeHasCreatedEvent event) {
//        var closedEmitters = new ArrayList<SseEmitter>();
//        for (var emitter: emitters) {
//            try {
//                var builder = SseEmitter.event()
//                        .id(UUID.randomUUID().toString())
//                        .comment("Employees message")
//                        .name("message")
//                        .reconnectTime(5_000)
//                        .data(event);
//
//                emitter.send(builder);
//            } catch (Exception e) {
//                closedEmitters.add(emitter);
//            }
//        }
//        emitters.removeAll(closedEmitters);
//    }

    @GetMapping("/{id}")
    public EmployeeDto findEmployeeById(@PathVariable("id") long id) {
        return employeeService.findEmployeeById(id);

        // HTTP cache
//    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable("id") long id) {
//        var employee = employeeService.findEmployeeById(id);
//        return ResponseEntity
//                .ok()
//                .header("Request-Id", UUID.randomUUID().toString()) // ezt nem használjuk semmire, csak demo céllal van itt
//                .cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS))
////                .eTag(Integer.toString(employee.hashCode()))
//                .eTag(Integer.toString(employee.getVersion()))
//                .body(employee);
    }

    @PostMapping // nem idempotens
    @Operation(description = "creates an employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody CreateEmployeeCommand command) {
        EmployeeDto employeeDto = employeeService.createEmployee(command);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employeeDto.getId()).toUri()).body(employeeDto);
    }

    @PutMapping("/{id}") // idempotens
    public EmployeeDto updateEmployee(@PathVariable("id") long id, @RequestBody UpdateEmployeeCommand command) {
        return employeeService.updateEmployee(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
    }

}
