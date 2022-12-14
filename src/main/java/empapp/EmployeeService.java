package empapp;

import empapp.dto.CreateEmployeeCommand;
import empapp.dto.EmployeeDto;
//import empapp.dto.EmployeeHasBeenCreatedEvent;
//import empapp.dto.EmployeeHasCreatedEvent;
import empapp.dto.UpdateEmployeeCommand;
import empapp.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private EmployeeMapper employeeMapper;

    // WebSocket üzenetküldés üzleti logikából
//    private ApplicationEventPublisher publisher;

    // Ütemezett feladatok
//    private RemoteSyncService remoteSyncService;

    // JMS üzenetküldés
//    private EventStoreGateway eventStoreGateway;

    // Cache
//    @CacheEvict(value = "employee", key = "#id")
//    @CachePut(key = "#result.id", value = "employee")
    public EmployeeDto createEmployee(CreateEmployeeCommand command) {
        Employee employee = employeeMapper.toEmployee(command);

        // Ütemezett feladatok
//        log.info("EmployeeService thread: {}", Thread.currentThread().getName());
//        log.info("RemoteSyncService reference: {}", remoteSyncService.getClass().getName());
//        remoteSyncService.sync(employee); // Ütemezett feladatoknál hívjuk meg ezt a metódust
//        remoteSyncService.syncProgrammable(employee); // Ütemezett feladatoknál hívjuk meg ezt a metódust

        // Server send events
//        publisher.publishEvent(new EmployeeHasCreatedEvent(employee.getId(), employee.getName()));

        employeeRepository.save(employee);

        // JMS üzenetküldés
//        eventStoreGateway.sendMessage("Employee has been created: " + command);

        // Ütemezett feladatok
//        logNumberOfEmployees();

        // WebSocket üzenetküldés üzleti logikából
//        publisher.publishEvent(new EmployeeHasBeenCreatedEvent(employee.getId(), employee.getName()));

        return employeeMapper.toEmployeeDto(employee);
    }

    // Cache
//    @Cacheable("employees") // Map<Void, List<EmployeeDto>>
    public List<EmployeeDto> listEmployees() {
        return employeeMapper.toEmployeesDto(employeeRepository.findAllWithAddresses());
    }

    // Cache
//    @Cacheable("employee")
    public EmployeeDto findEmployeeById(long id) {
        return employeeMapper.toEmployeeDto(employeeRepository.findByIdWithAddresses(id)
                        .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id)));
    }

    @Transactional
    // Cache
//    @CacheEvict(value = "employee", key = "#id")
//    @Caching(
//            put = {
//                    @CachePut(key = "#result.id", value = "employee")
//            },
//            evict = {
//            @CacheEvict(value = "employee", key = "#id"),
//            @CacheEvict(value = "employees", allEntries = true)
//    })
    public EmployeeDto updateEmployee(long id, UpdateEmployeeCommand command) {
        Employee employeeToModify = employeeRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
        employeeToModify.setName(command.getName());
        return employeeMapper.toEmployeeDto(employeeToModify);
    }

    // Cache
//    @Caching(evict = {
//            @CacheEvict(value = "employee", key = "#id"),
//            @CacheEvict(value = "employees", allEntries = true)
//    })
    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findByIdWithAddresses(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }

    // Ütemezett feladatok
//    @Scheduled(fixedRate = 10_000)
//    public void logNumberOfEmployees() {
//        log.info("The number of employees: {}", employeeRepository.count());
//    }
}
