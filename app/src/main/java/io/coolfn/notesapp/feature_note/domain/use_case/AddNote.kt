package io.coolfn.notesapp.feature_note.domain.use_case

import io.coolfn.notesapp.feature_note.domain.model.InvalidNoteException
import io.coolfn.notesapp.feature_note.domain.model.Note
import io.coolfn.notesapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Note's title should not be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Note's content should not be empty")
        }
        repository.insertNote(note)
    }
}