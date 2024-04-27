package ru.gb.HW6.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.HW6.model.Note;
import ru.gb.HW6.repository.NoteRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService implements iNoteService{
    @Autowired
    final private NoteRepo noteRepo;
    @Override
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }
    @Override
    public Note getNoteById(Long id) {
        return noteRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }
    @Override
    public Note createNote(Note note) {
        return noteRepo.save(note);
    }
    @Override
    public Note updateNote(Long id, Note note) {
        Note note1 = getNoteById(id);
        note1.setTitle(note.getTitle());
        note1.setContent(note.getContent());
        note1.setDataOfCreation(note.getDataOfCreation());
        return noteRepo.save(note1);
    }
    @Override
    public void deleteNoteById(Long id) {
        noteRepo.deleteById(id);
    }
}
