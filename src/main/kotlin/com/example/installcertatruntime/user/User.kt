package com.example.installcertatruntime.user

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "users")
data class User(

        @Id
        @GeneratedValue
        var id: UUID? = null,

        var displayName: String? = null,

        var password: String? = null

)