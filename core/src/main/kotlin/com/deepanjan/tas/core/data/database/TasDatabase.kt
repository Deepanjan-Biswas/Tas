package com.deepanjan.tas.core.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deepanjan.tas.core.data.database.converter.LocalDateTimeConverter
import com.deepanjan.tas.core.data.database.dao.NoteDao
import com.deepanjan.tas.core.data.database.entity.NoteEntity
import net.zetetic.database.sqlcipher.SQLiteDatabase
import net.zetetic.database.sqlcipher.SupportOpenHelper

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class TasDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var instance: TasDatabase? = null

        fun getInstance(context: Context): TasDatabase {
            return instance ?: synchronized(this) {
                val dbInstance = Room.databaseBuilder(
                    context.applicationContext,
                    TasDatabase::class.java,
                    "tas_database"
                )
                    .openHelperFactory { context, name, callback ->
                        SupportOpenHelper(
                            context,
                            name,
                            null,
                            callback,
                            false
                        )
                    }
                    .fallbackToDestructiveMigration()
                    .build()
                instance = dbInstance
                dbInstance
            }
        }
    }
}
