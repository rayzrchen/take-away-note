package com.example.installcertatruntime.car

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Car(
        @Id
        @GeneratedValue
        var id: UUID = UUID(0, 0),

        var licensePlate: String = "",

        var color: String = ""

)
