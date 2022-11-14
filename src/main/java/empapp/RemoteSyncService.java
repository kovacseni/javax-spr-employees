//package empapp;
//
//import empapp.entity.Employee;
//import lombok.AllArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//// Ütemezett feladatok
//@Service
//@Slf4j
//@AllArgsConstructor
//public class RemoteSyncService {
//
//    // programozott
//    private TaskExecutor taskExecutor;
//
//    // deklaratív
//    @SneakyThrows
//    @Async
//    public void sync(Employee employee) {
//        log.info("RemoteSyncService thread: {}", Thread.currentThread().getName());
//        Thread.sleep(10_000);
//        log.info("Employee has been synchronized: {}", employee.getName());
//    }
//
//    // programozott
//    public void syncProgrammable(Employee employee) {
//        log.info("RemoteSyncService thread: {}", Thread.currentThread().getName());
//
//        taskExecutor.execute(() -> {
//            try {
//                Thread.sleep(10_000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException();
//            }
//        });
//    }
//}
