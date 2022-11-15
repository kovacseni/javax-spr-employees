//package empapp;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.async.DeferredResult;
//
//// Aszinkron hívás (Servlet)
//@RestController
//@RequestMapping("/api/calculator")
//@Slf4j
//@AllArgsConstructor
//public class CalculatorController {
//
//    private CalculatorService calculatorService;
//
//    @GetMapping
//    public DeferredResult<Integer> calculate() {
//        log.info("calculate start");
//        var result = new DeferredResult<Integer>();
//        calculatorService.calculate(result); // ez indít egy új szálat
//        log.info("calculate end");
//        return result;
//        // itt a HTTP kiszolgáló szál felszabadul
//        // de a HttpRequest ugyanúgy aktív marad
//    }
//}
