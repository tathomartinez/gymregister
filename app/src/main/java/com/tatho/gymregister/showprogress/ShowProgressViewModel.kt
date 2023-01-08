package com.tatho.gymregister.showprogress

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tatho.gymregister.repeticion.data.servicio.FireBaseService
import com.tatho.gymregister.rutina.model.RuntimeExercise
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowProgressViewModel : ViewModel() {

    private val fireBaseService = FireBaseService()

    private var runtimesMutableLiveData = MutableLiveData<MutableList<RuntimeExercise>>()
    val observerRuntimesMutableLiveData: MutableLiveData<MutableList<RuntimeExercise>> =
        runtimesMutableLiveData

    fun getRuntime() {
        viewModelScope.launch(Dispatchers.IO) {
            fireBaseService.getCollectionRuntimes("runtime"){
                runtimesMutableLiveData.postValue(it.toMutableList())
            }
        }
    }
}