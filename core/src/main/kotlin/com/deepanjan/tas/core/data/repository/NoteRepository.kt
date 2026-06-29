package com.deepanjan.tas.core.data.repository

import com.deepanjan.tas.core.data.database.dao.NoteDao
import com.deepanjan.tas.core.data.database.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    fun getAllNotes(): Flow<List<NoteEntity>> = noteDao.getAllNotes()

    fun getFavoriteNotes(): Flow<List<NoteEntity>> = noteDao.getFavoriteNotes()

    fun getNoteById(id: Long): Flow<NoteEntity?> = noteDao.getNoteById(id)

    fun getNotesByCategory(category: String): Flow<List<NoteEntity>> =
        noteDao.getNotesByCategory(category)

    fun searchNotes(query: String): Flow<List<NoteEntity>> = noteDao.searchNotes(query)

    suspend fun insertNote(note: NoteEntity): Long = noteDao.insertNote(note)

    suspend fun updateNote(note: NoteEntity) = noteDao.updateNote(note)

    suspend fun deleteNote(note: NoteEntity) = noteDao.deleteNote(note)

    suspend fun deleteNoteById(id: Long) = noteDao.deleteNoteById(id)

    // Auto-save with debounce to avoid excessive database writes
    fun autoSaveNote(note: NoteEntity, debounceMs: Long = 1000L) =
        noteDao.getAllNotes().debounce(debounceMs)

    suspend fun exportNotesToJson(notes: List<NoteEntity>): String {
        return kotlinx.serialization.json.Json.encodeToString(notes)
    }

    suspend fun importNotesFromJson(json: String): List<NoteEntity> {
        return kotlinx.serialization.json.Json.decodeFromString(json)
    }

    suspend fun replaceAllNotes(notes: List<NoteEntity>) {
        noteDao.replaceAllNotes(notes)
    }
}
