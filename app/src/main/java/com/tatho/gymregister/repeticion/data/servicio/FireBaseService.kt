package com.tatho.gymregister.repeticion.data.servicio

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tatho.gymregister.ejercicio.data.Exercise
import com.tatho.gymregister.repeticion.data.Repeticion
import com.tatho.gymregister.rutina.model.RuntimeExercise

class FireBaseService {

    private val db = Firebase.firestore
//    fun addExercise(sessionExercise: Exercise) {
//        db.collection("exercise")
//            .add(sessionExercise)
//            .addOnSuccessListener { documentReference ->
//                Log.d(
//                    "firebasedb",
//                    documentReference.toString()
//                )
//            }
//            .addOnFailureListener { e -> Log.e("DB", e.stackTraceToString()) }
//    }

    fun addRuntime(runtime: RuntimeExercise) {
        db.collection("runtime")
            .add(runtime)
            .addOnSuccessListener {
                Log.d("firebasedb", it.toString())
            }
            .addOnFailureListener { e -> Log.e("DB", e.stackTraceToString()) }
    }

    fun getCollectionRuntimes(
        collectionPath: String,
        callback: (List<RuntimeExercise>) -> Unit
    ){
        val runtimeList = mutableListOf<RuntimeExercise>()
        db.collection(collectionPath)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    try {
                        val data = document.data
                        runtimeList.add(RuntimeExercise.mapToRuntimeExercise(data))
                    } catch (e: FirebaseFirestoreException) {
                        Log.e("DB", e.stackTraceToString())
                    }
                }
                callback(runtimeList)
            }
            .addOnFailureListener { exception ->
                Log.w("DB", "Error getting documents.", exception)
            }

     }

    fun getCollection(collectionPath: String): MutableList<Exercise> {
        val exerciseList = mutableListOf<Exercise>()
        val ref = db.collection(collectionPath)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    try {
                        val data = document.data
                        exerciseList.add(mapToSessionExercise(data))
                    } catch (e: FirebaseFirestoreException) {
                        Log.e("DB", e.stackTraceToString())
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.w("DB", "Error getting documents.", exception)
            }
        return exerciseList
    }

    fun mapToSessionExercise(map: Map<String, Any>): Exercise {
        return Exercise(
            map["nameExercise"] as String,
            map["series"] as MutableList<Repeticion>,
        )
    }


}