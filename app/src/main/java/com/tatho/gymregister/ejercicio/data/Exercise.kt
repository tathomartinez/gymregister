package com.tatho.gymregister.ejercicio.data

import com.tatho.gymregister.repeticion.data.Repeticion

data class Exercise(
    //TODO(esto puede ser un obteto de tipo exercise por ahora solo el nombre)
    val nameExercise: String,
    val series: MutableList<Repeticion>
)