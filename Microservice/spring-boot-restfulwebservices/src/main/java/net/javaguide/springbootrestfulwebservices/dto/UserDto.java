package net.javaguide.springbootrestfulwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    //user first name should not be null or empty
    @NotEmpty(message = "Your first name should not be null or empty :)")
    private String firstName;
    //hould not be null or empty
    @NotEmpty(message = "Your last name should not be null or empty :)")
    private String lastName;
    //should not be null or empty
    //valis email
    @NotEmpty(message = "Your first name should not be null or empty :)")
    @Email(message = "Invalid email address :(")
    private String email;
}
