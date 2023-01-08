package com.tatho.gymregister.rutina.model

import android.util.Log
import com.tatho.gymregister.ejercicio.data.Exercise
import com.tatho.gymregister.ejercicio.data.Exercise.Companion.mapToExercise
import com.tatho.gymregister.repeticion.data.Repeticion
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RuntimeExercise(
    var exercises: MutableList<Exercise>? = null,
    var userId: Long? = 0,
    var date: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
        val date: String = SimpleDateFormat("ddMMyy", Locale.getDefault()).format(
            Calendar.getInstance().time
        )
        var userId: Long = 0L
        val exercises: MutableList<Exercise> = mutableListOf()
        fun getCurrent(): RuntimeExercise {
            val rutina = RuntimeExercise()
            rutina.date = this.date
            rutina.userId = this.userId
            rutina.exercises = this.exercises
            return rutina
        }

        fun mapToRuntimeExercise(map: Map<String, Any>): RuntimeExercise {
            return RuntimeExercise(
                date = map["date"] as String,
                userId = map["userId"] as Long,
                exercises = mapToExercise(map)
            )
        }
    }
}
