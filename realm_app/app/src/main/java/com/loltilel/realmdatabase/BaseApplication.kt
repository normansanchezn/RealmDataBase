package com.loltilel.realmdatabase

import android.app.Application
import com.loltilel.realmdatabase.repository.model.Usuario
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmModel

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        Realm.setDefaultConfiguration(getConfigurationRealm())
        // Realm.getInstance(getConfigurationRealm())
    }

    fun getConfigurationRealm(): RealmConfiguration {
        return RealmConfiguration.Builder()
            .name("BDExample")
            .schemaVersion(0)
            .deleteRealmIfMigrationNeeded()
            .build()
    }

    private fun <E: RealmModel> recuperarIdMaximo(realm: Realm, clase: Class<E>, campoId: String): Int {
        val id: Number?= realm.where(clase).max(campoId)

        val idRecuperado: Int
        idRecuperado = if (id==null) 0
        else id.toInt() +1

        return idRecuperado

    }

    fun generarIdAutonIncremental(id: Int): Int {
        val realm:Realm = Realm.getInstance(getConfigurationRealm())
        val idAutoIncremental: Int = when (id){
            Constantes().ID_ESQUEMA -> recuperarIdMaximo(realm, Usuario::class.java, "id")
            else -> -1
        }

        realm.close()
        return idAutoIncremental
    }


}