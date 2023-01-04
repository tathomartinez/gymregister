package com.tatho.gymregister.ejercicio.data

import com.tatho.gymregister.repeticion.data.Repeticion

data class SessionExercise(val name: String, val series: MutableList<Repeticion>)