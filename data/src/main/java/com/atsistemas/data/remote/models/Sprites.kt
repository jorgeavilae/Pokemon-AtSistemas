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

package com.atsistemas.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/*
* Las diferentes imágenes de un pokemon se guardan como URLs bajo la etiqueta "sprites"
*
  "sprites":{
    "back_default":"URL_completa",
    "back_female":null,
    "back_shiny":"URL_completa",
    "back_shiny_female":null,
    "front_default":"URL_completa",
    "front_female":null,
    "front_shiny":"URL_completa",
    "front_shiny_female":null,
    "other":{
      "dream_world":{
        "front_default":"URL_completa",
        "front_female":null
      },
      "official-artwork":{
        "front_default":"URL_completa"
      }
    },
    "versions":{
      "generation-i":{
        "red-blue":{
          "back_default":"URL_completa",
          "back_gray":"URL_completa",
          "front_default":"URL_completa",
          "front_gray":"URL_completa"
        },
        ...
      },
      ...
    }
  },
*
* */
@JsonClass(generateAdapter = true)
data class Sprites(
    @Json(name = "front_default") val front: String?,
    @Json(name = "back_default") val back: String?,
    val other: OtherSprites
)

@JsonClass(generateAdapter = true)
data class OtherSprites(
    @Json(name = "dream_world") val dream: FrontImageUrl,
    @Json(name = "official-artwork") val official: FrontImageUrl
)

@JsonClass(generateAdapter = true)
data class FrontImageUrl(
    @Json(name = "front_default") val url: String?
)