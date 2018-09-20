package com.example.installcertatruntime.car

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity(name = "cars")
data class Car(
        @Id
        @Column(name = "id")
        var id: Long? = null,

        @Column(name = "license_plate")
        @NotNull
        @Size(min = 2, max = 10)
        var licensePlate: String? = null,

        @Column(name = "color")
        var color: String? = null

)
