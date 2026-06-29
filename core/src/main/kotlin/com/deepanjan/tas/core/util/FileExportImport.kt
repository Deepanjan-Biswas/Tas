package com.deepanjan.tas.core.util

import android.content.Context
import android.net.Uri
import com.deepanjan.tas.core.data.database.entity.NoteEntity
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File
import java.time.LocalDateTime

object FileExportImport {
    
    suspend fun exportNotesToJson(
        context: Context,
        notes: List<NoteEntity>,
        fileName: String = "tas_backup_${System.currentTimeMillis()}.json"
    ): Result<Uri> = try {
        val json = Json {
            prettyPrint = true
        }.encodeToString(notes)
        
        val file = File(context.filesDir, fileName)
        file.writeText(json)
        
        Result.success(Uri.fromFile(file))
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun exportNotesToCSV(
        context: Context,
        notes: List<NoteEntity>,
        fileName: String = "tas_backup_${System.currentTimeMillis()}.csv"
    ): Result<Uri> = try {
        val csvContent = buildString {
            appendLine("ID,Title,Content,Created At,Updated At,Color,Is Favorite,Category")
            notes.forEach { note ->
                appendLine(
                    "\"${note.id}\",\"${note.title}\",\"${note.content}\",\"${note.createdAt}\",\"${note.updatedAt}\",\"${note.color}\",\"${note.isFavorite}\",\"${note.category}\""
                )
            }
        }
        
        val file = File(context.filesDir, fileName)
        file.writeText(csvContent)
        
        Result.success(Uri.fromFile(file))
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun importNotesFromJson(
        context: Context,
        uri: Uri
    ): Result<List<NoteEntity>> = try {
        val inputStream = context.contentResolver.openInputStream(uri)
        val jsonString = inputStream?.bufferedReader().use { it?.readText() ?: "" }
        
        val notes = Json.decodeFromString<List<NoteEntity>>(jsonString)
        Result.success(notes)
    } catch (e: Exception) {
        Result.failure(e)
    }

    fun deleteExportedFile(file: File): Boolean {
        return file.delete()
    }
}
