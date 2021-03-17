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

package com.atsistemas.pokemon.main_activity.list.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atsistemas.pokemon.commons.BaseViewModel

class ListViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is list Fragment"
    }
    val text: LiveData<String> = _text
}