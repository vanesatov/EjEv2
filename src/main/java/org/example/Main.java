package org.example;


import org.example.dao.PeliculaDAO;
import org.example.model.Pelicula;

public class Main {
    public static void main(String[] args) {

        //new PeliculaDAO(JdbcUtil.getConnection()).save(new Pelicula(7, "Konan", 2017, "Acción"));
        new PeliculaDAO(JdbcUtil.getConnection()).filtrarPorgenero("drama").forEach(System.out::println);

    }
}