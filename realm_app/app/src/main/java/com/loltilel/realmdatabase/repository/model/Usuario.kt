package com.loltilel.realmdatabase.repository.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
class Usuario : RealmObject() {

    @PrimaryKey
    var id: Int = 0

    var name: String?= null
    var lastName: String?= null
    var direction: String?= null

}