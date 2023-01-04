package com.tatho.gymregister.repeticion.data.servicio

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tatho.gymregister.ejercicio.data.SessionExercise

class FireBaseService {

    val db = Firebase.firestore
    fun addExercise(sessionExercise: SessionExercise) {
        db.collection("exercise")
            .add(sessionExercise)
            .addOnSuccessListener { documentReference -> Log.d("firebasedb", documentReference.toString()) }
            .addOnFailureListener { e -> Log.e("DB", e.stackTraceToString()) }
    }
}