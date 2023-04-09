package net.javaguide.springbootrestfulwebservices.repository;

import net.javaguide.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
