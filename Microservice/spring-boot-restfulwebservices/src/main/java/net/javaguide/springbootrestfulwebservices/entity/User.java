package net.javaguide.springbootrestfulwebservices.entity;
import jakarta.persistence.*;
import lombok.*;
//import jakarta.persistence.entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email_name", nullable = false, unique = true)
    private String email;

}
