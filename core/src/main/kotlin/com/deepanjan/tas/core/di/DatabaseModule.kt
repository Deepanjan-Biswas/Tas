package com.deepanjan.tas.core.di

import android.content.Context
import com.deepanjan.tas.core.data.database.TasDatabase
import com.deepanjan.tas.core.data.database.dao.NoteDao
import com.deepanjan.tas.core.data.preferences.SettingsPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TasDatabase {
        return TasDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideNoteDao(database: TasDatabase): NoteDao {
        return database.noteDao()
    }

    @Singleton
    @Provides
    fun provideSettingsPreferences(
        @ApplicationContext context: Context
    ): SettingsPreferences {
        return SettingsPreferences(context)
    }
}
