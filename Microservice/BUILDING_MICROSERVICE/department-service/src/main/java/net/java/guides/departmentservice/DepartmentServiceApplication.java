package net.java.guides.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jdk.jfr.Description;
import org.hibernate.annotations.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Department Service Resst Api Documentation",
				description = "Department Service Rest Api Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sanchi",
						email =  "b.sanchi@samsung.com",
						url = "https://www.javaguides.net"
				),

				license = @License(
						name = "Apace",
						url = "www.google.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department Service",
				url = "https://www.javaguides.net"
)

)
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
