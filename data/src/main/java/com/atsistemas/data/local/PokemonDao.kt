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

package com.atsistemas.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atsistemas.data.commons.Constants.TABLE_POKEMON
import com.atsistemas.data.models.PokemonDTO

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(pokemon: PokemonDTO)

    @Query("SELECT * FROM $TABLE_POKEMON ORDER BY `order` ASC")
    fun load(): LiveData<List<PokemonDTO>>

    /* Devolver LiveData no funciona */
    @Query("SELECT * FROM $TABLE_POKEMON WHERE `name` LIKE :search ORDER BY `order` ASC")
    fun search(search: String): List<PokemonDTO>

    @Query("SELECT COUNT(`id`) FROM $TABLE_POKEMON")
    fun getPokemonCount(): LiveData<Int>

    @Query("DELETE FROM $TABLE_POKEMON")
    suspend fun deleteAll()

    @Query("SELECT * FROM  $TABLE_POKEMON WHERE `id` = :pokemonId")
    suspend fun getPokemonById(pokemonId: Int): PokemonDTO?
}