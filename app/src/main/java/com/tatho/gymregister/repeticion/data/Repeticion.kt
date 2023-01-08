package com.tatho.gymregister.repeticion.data

data class Repeticion(val peso: Int, val repeticionMaxima: Int, val unidadDeMedida: String) {
    companion object {
        private const val serialVersionUID = 1L
        fun mapToRepeticion(map: Map<String, Any>): MutableList<Repeticion> {
            val repeticiones = mutableListOf<Repeticion>()
            for ((key, value) in map) {
                if (key == "series") {
                    (value as ArrayList<*>).forEach {
                        it as Map<*, *>
//                        Log.e("VALUE", it["peso"] as String)
                        val repeticion = Repeticion(
                            peso = (it["peso"] as Long).toInt(),
                            repeticionMaxima = (it["repeticionMaxima"] as Long).toInt(),
                            unidadDeMedida = it["unidadDeMedida"] as String,
                        )

                        repeticiones.add(repeticion)
                    }
                }
            }
            return repeticiones
        }
    }
}