package com.loltilel.realmdatabase.repository.local

import com.loltilel.realmdatabase.BaseApplication
import com.loltilel.realmdatabase.Constantes
import com.loltilel.realmdatabase.repository.model.Usuario
import io.realm.Realm

class RealmQuerys {

    private val realm:Realm = Realm.getInstance(BaseApplication().getConfigurationRealm())

    fun cerrar() = realm.close()

    fun agregarUsuario(nombre: String, apellido: String, adress: String): Int{
        val idUsuario: Int = BaseApplication().generarIdAutonIncremental(Constantes().ID_ESQUEMA)

        realm.beginTransaction()
        val usuario:Usuario = realm.createObject(Usuario::class.java, idUsuario)
        usuario.name = nombre
        usuario.direction = apellido
        usuario.lastName = adress
        realm.commitTransaction()

        return idUsuario
    }

}