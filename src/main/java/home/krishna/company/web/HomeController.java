package home.krishna.company.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	

	@Value("Hi ${spring.application.name: } is UP !!!")
	private String message;
	
	@GetMapping("/")
	public String getHello() {
		return message;
	}
	
	
	@GetMapping("/health")
	public ResponseEntity<String> getHealth() {
		return ResponseEntity.ok(message);
	}

}
