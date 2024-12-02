package ch.wiibeeri.planovic;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class MyRestController  {

    @GetMapping("/hello")
    public String hello() {
        return "Guguuus";
    }


    @GetMapping("/echo")
    public String helloName(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello "+name;
    }

    public record Result(String message){}

    @GetMapping("/helloJson")
    public Result helloJson() {
        return new Result("Avocado");
    }

    public record GreetingRequest(String name){}
    public record GreetingResponse(String message, LocalDateTime date){}
    @PostMapping("/postRequest")
    public GreetingResponse postRequest(@RequestBody GreetingRequest request) {
        return new GreetingResponse("Hi "+request.name, LocalDateTime.now());
    }
}
