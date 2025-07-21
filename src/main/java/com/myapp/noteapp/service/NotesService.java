package com.myapp.noteapp.service;

import com.myapp.noteapp.entities.Notes;
import com.myapp.noteapp.payload.NotesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {
    // simple crud implementations

    // create
    NotesDto createNote(NotesDto notesDto, String userId);

    // update
    NotesDto updateNote(NotesDto notesDto, Integer notesId);

    // delete
    void deleteNote(Integer notesId);

    // get
    NotesDto getNote(Integer notesId);

    // getAll
    List<NotesDto> getAllNote();

    // getByUser
    List<NotesDto> getNoteByUserId(String userId);

}
