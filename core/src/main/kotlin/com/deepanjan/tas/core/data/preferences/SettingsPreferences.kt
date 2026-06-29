package com.deepanjan.tas.core.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "tas_settings")

class SettingsPreferences(private val context: Context) {
    companion object {
        private val PRIMARY_COLOR_KEY = stringPreferencesKey("primary_color")
        private val SECONDARY_COLOR_KEY = stringPreferencesKey("secondary_color")
        private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")
        private val FONT_SIZE_KEY = stringPreferencesKey("font_size")
    }

    val primaryColor: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PRIMARY_COLOR_KEY] ?: "#6750A4"
    }

    val secondaryColor: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[SECONDARY_COLOR_KEY] ?: "#625B71"
    }

    val darkMode: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[DARK_MODE_KEY] ?: false
    }

    val fontSize: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[FONT_SIZE_KEY] ?: "NORMAL"
    }

    suspend fun setPrimaryColor(color: String) {
        context.dataStore.edit { preferences ->
            preferences[PRIMARY_COLOR_KEY] = color
        }
    }

    suspend fun setSecondaryColor(color: String) {
        context.dataStore.edit { preferences ->
            preferences[SECONDARY_COLOR_KEY] = color
        }
    }

    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DARK_MODE_KEY] = enabled
        }
    }

    suspend fun setFontSize(size: String) {
        context.dataStore.edit { preferences ->
            preferences[FONT_SIZE_KEY] = size
        }
    }
}
