package com.myapp.noteapp.controllers;

import com.myapp.noteapp.entities.Notes;
import com.myapp.noteapp.payload.ApiResponse;
import com.myapp.noteapp.payload.NotesDto;
import com.myapp.noteapp.service.NotesService;
import com.myapp.noteapp.service.implementations.NotesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;
    private NotesDto updateNote;

    // create
    @PostMapping("/{userId}")
    public ResponseEntity<NotesDto> createNote(@RequestBody NotesDto notes, @PathVariable String userId) {
        NotesDto notesDto = this.notesService.createNote(notes,userId);
        return new ResponseEntity<NotesDto>(updateNote, HttpStatus.CREATED);
    }

    // update
    @PutMapping("/{notesId}")
    public ResponseEntity<NotesDto> updateNote(@RequestBody NotesDto notes, @PathVariable Integer notesId) {
        NotesDto notesDto = this.notesService.updateNote(notes,notesId);
        return new ResponseEntity<NotesDto>(updateNote,HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteNote(@PathVariable Integer notesId) {
        this.notesService.deleteNote(notesId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Note deleted!",true),HttpStatus.OK);
    }

    // get by usr
    @GetMapping("/{userId}")
    public ResponseEntity<List<NotesDto>> getNotesByUser(@PathVariable String userId) {
        List<NotesDto> Note = this.notesService.getNoteByUserId(userId);
        return new ResponseEntity<List<NotesDto>>(Note,HttpStatus.OK);
    }

    // get all
    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<NotesDto>> getNotes() {
        List<NotesDto> Note = this.notesService.getAllNote();
        return new ResponseEntity<List<NotesDto>>(Note,HttpStatus.OK);
    }
}









