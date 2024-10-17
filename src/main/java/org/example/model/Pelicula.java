package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class Pelicula implements Serializable {

    private Integer id;
    private String titulo;
    private Integer año;
    private String genero;

}
