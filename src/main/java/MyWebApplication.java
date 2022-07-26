import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyWebApplication {

    @RequestMapping("/welcome")
    String hello() {
        return "Hello World, Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyWebApplication.class, args);
    }

}
