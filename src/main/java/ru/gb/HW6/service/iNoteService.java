package ru.gb.HW6.service;

import ru.gb.HW6.model.Note;

import java.util.List;

/**
 *  * 1. Добавление заметки. (Подсказка @PostMapping )
 *  * 2. Просмотр всех заметок.(Подсказка @GetMapping )
 *  * 3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
 *  * 4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
 *  * 5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
 */
public interface iNoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note createNote(Note note);
    Note updateNote(Long id, Note note);
    void deleteNoteById(Long id);
}
