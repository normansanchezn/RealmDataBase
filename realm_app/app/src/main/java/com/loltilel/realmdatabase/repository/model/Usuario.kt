package com.loltilel.realmdatabase.repository.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required

@RealmClass
class Usuario : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    @Required
    var name: String?= null
    @Required
    var lastName: String?= null
    @Required
    var direction: String?= null
}