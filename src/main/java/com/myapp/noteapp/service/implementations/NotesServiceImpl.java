package com.myapp.noteapp.service.implementations;

import com.myapp.noteapp.entities.Notes;
import com.myapp.noteapp.entities.User;
import com.myapp.noteapp.payload.NotesDto;
import com.myapp.noteapp.repositories.NotesRepository;
import com.myapp.noteapp.repositories.UserRepository;
import com.myapp.noteapp.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE
    @Override
    public NotesDto createNote(NotesDto notesDto, String userId) {
        Integer parsedUserId = Integer.parseInt(userId);
        User user = userRepository.findById(parsedUserId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Notes notes = dtoToNotes(notesDto);
        notes.setUser(user);

        Notes savedNote = notesRepository.save(notes);
        return notesToDto(savedNote);

    }

    // Update
    @Override
    public NotesDto updateNote(NotesDto notesDto, Integer notesId) {
        Notes notes = notesRepository.findById(notesId).orElseThrow(() -> new RuntimeException("Note not found with id: " + notesId));

        notes.setTitle(notesDto.getTitle());
        notes.setDescription(notesDto.getDescription());
        notes.setDate(notesDto.getDate());

        Notes updatedNote = notesRepository.save(notes);
        return notesToDto(updatedNote);
    }

    // delete
    @Override
    public void deleteNote(Integer notesId) {
        Notes notes = notesRepository.findById(notesId).orElseThrow(()-> new RuntimeException("Note not found with id: " + notesId));
        this.notesRepository.delete(notes);
    }

    // get
    @Override
    public NotesDto getNote(Integer notesId) {
        Notes notes = notesRepository.findById(notesId).orElseThrow(()-> new RuntimeException("Note not found with id: " + notesId));
        return this.notesToDto(notes);
    }

    // getAll
    @Override
    public List<NotesDto> getAllNote() {
        List<Notes> notes = this.notesRepository.findAll();
        List<NotesDto> allNotes = notes.stream().map((note)->this.notesToDto(note)).collect(Collectors.toList());
        return allNotes;
    }

    @Override
    public List<NotesDto> getNoteByUserId(String userId) {
        Integer parsedUserId = Integer.parseInt(userId);
        User user = userRepository.findById(parsedUserId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        List<Notes> notesList = notesRepository.findByUser(user);
        return notesList.stream()
                .map(this::notesToDto)
                .toList();
    }

    // DTO → Entity dönüşüm
    private Notes dtoToNotes(NotesDto dto) {
        Notes notes = new Notes();
        notes.setTitle(dto.getTitle());
        notes.setDescription(dto.getDescription());
        notes.setDate(dto.getDate());
        return notes;
    }

    // Entity → DTO dönüşüm
    private NotesDto notesToDto(Notes notes) {
        NotesDto dto = new NotesDto();
        dto.setID(notes.getId());
        dto.setTitle(notes.getTitle());
        dto.setDescription(notes.getDescription());
        dto.setDate(notes.getDate());
        return dto;
    }


}
