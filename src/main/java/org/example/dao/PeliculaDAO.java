package org.example.dao;

import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements DAO {

    private Connection connection;

    public PeliculaDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List findAll() {
        return List.of();
    }

    @Override
    public Object findById(Integer id) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    public void save(Pelicula pelicula) {
        System.out.println("Guardando la pelicula: "+pelicula.getTitulo());
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO pelicula (titulo, año, genero) VALUES (?,?,?)")){
            ps.setString(1,pelicula.getTitulo());
            ps.setInt(2,pelicula.getAño());
            ps.setString(3,pelicula.getGenero());
            ps.executeUpdate();
            System.out.println("Pelicula guardada exitosamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pelicula> filtrarPorgenero(String genero){
        var list = new ArrayList<Pelicula>();
        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM pelicula WHERE genero=?")){
            ps.setString(1,genero);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                list.add(new Pelicula(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}





