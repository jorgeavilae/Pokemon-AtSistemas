/*
 *    Copyright 2021 Jorge Ávila Estévez
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.atsistemas.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.atsistemas.data.commons.Constants
import com.atsistemas.data.commons.catchPreferencesException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class ProfilePreferencesWrapper(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.DATASTORE_NAME)

    // Name
    val preferencesName: Flow<String> = context.dataStore.data
        .catch {
            catchPreferencesException(it)
        }.map { preferences ->
            val nameKey = stringPreferencesKey(Constants.PREFERENCES_NAME_KEY)
            preferences[nameKey] ?: ""
        }

    suspend fun getName(): String = preferencesName.first()
    suspend fun setName(name: String) {
        context.dataStore.edit { preferences ->
            val nameKey = stringPreferencesKey(Constants.PREFERENCES_NAME_KEY)
            preferences[nameKey] = name
        }
    }

    // Badges
    val preferencesBadges: Flow<Int> = context.dataStore.data
        .catch {
            catchPreferencesException(it)
        }.map { preferences ->
            val badgesKey = intPreferencesKey(Constants.PREFERENCES_BADGES_KEY)
            preferences[badgesKey] ?: 0
        }

    suspend fun getBadges(): Int = preferencesBadges.first()
    suspend fun setBadges(badges: Int) {
        context.dataStore.edit { preferences ->
            val badgesKey = intPreferencesKey(Constants.PREFERENCES_BADGES_KEY)
            preferences[badgesKey] = badges
        }
    }

    // Pokedex
    val preferencesPokedex: Flow<Int> = context.dataStore.data
        .catch {
            catchPreferencesException(it)
        }.map { preferences ->
            val pokedexKey = intPreferencesKey(Constants.PREFERENCES_POKEDEX_KEY)
            preferences[pokedexKey] ?: 0
        }

    suspend fun getPokedex(): Int = preferencesPokedex.first()
    suspend fun setPokedex(pokedex: Int) {
        context.dataStore.edit { preferences ->
            val pokedexKey = intPreferencesKey(Constants.PREFERENCES_POKEDEX_KEY)
            preferences[pokedexKey] = pokedex
        }
    }

    // Time
    val preferencesTime: Flow<String> = context.dataStore.data
        .catch {
            catchPreferencesException(it)
        }.map { preferences ->
            val timeKey = stringPreferencesKey(Constants.PREFERENCES_TIME_KEY)
            preferences[timeKey] ?: ""
        }

    suspend fun getTime(): String = preferencesTime.first()
    suspend fun setTime(time: String) {
        context.dataStore.edit { preferences ->
            val timeKey = stringPreferencesKey(Constants.PREFERENCES_TIME_KEY)
            preferences[timeKey] = time
        }
    }
}
