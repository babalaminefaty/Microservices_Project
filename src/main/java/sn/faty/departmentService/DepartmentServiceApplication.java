package sn.faty.departmentService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);

		System.out.println("serveur de department bien demarre");
	}

	@Bean
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}

}
