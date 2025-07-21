package com.myapp.noteapp.repositories;
import com.myapp.noteapp.entities.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myapp.noteapp.entities.User;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
    List<Notes> findByUser(User user);
}
