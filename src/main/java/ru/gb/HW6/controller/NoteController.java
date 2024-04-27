package ru.gb.HW6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.HW6.model.Note;
import ru.gb.HW6.service.NoteService;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id){
        Note note;
        try {
            note = noteService.getNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id,
                                           @RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(id, note),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id){
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }



}
