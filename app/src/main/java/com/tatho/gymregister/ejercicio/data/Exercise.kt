package com.tatho.gymregister.ejercicio.data

import android.util.Log
import com.tatho.gymregister.repeticion.data.Repeticion
import com.tatho.gymregister.repeticion.data.Repeticion.Companion.mapToRepeticion

data class Exercise(
    //TODO(esto puede ser un obteto de tipo exercise por ahora solo el nombre)
    val nameExercise: String,
    val series: MutableList<Repeticion>
) {
    companion object {
        private const val serialVersionUID = 1L
        fun mapToExercise(map: Map<String, Any>): MutableList<Exercise> {
            val exercises = mutableListOf<Exercise>()
            for ((key, value) in map) {
                if (key == "exercises") {
                    (value as ArrayList<*>).forEach {
                        it as Map<*, *>
                        Log.e("VALUE", it["nameExercise"] as String)
                        val exercise = Exercise(
                            nameExercise = it["nameExercise"] as String,
                            series = mapToRepeticion(it as Map<String, Any>)
                        )
                        exercises.add(exercise)
                    }
                }
            }
            return exercises
        }
    }
}