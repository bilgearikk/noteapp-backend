package com.myapp.noteapp.repositories;
import com.myapp.noteapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepository extends JpaRepository<User, Integer>{
       User findByEmailAndPassword(String email, String password);
       User findByEmail(String email);
}
