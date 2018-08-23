package com.example.installcertatruntime.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "cars")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="license_plate")
    @NotNull
    @Size(min = 2, max = 10)
    private String licensePlate;


    @Column(name="color")
    private String color;




}
