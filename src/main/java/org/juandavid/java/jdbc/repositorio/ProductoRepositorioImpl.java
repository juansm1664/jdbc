package org.juandavid.java.jdbc.repositorio;

import org.juandavid.java.jdbc.modelo.Producto;
import org.juandavid.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnetion() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try(Statement stmt = getConnetion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos")){
            while (rs.next()){
                Producto p = new Producto();
                p.setId(rs.getLong("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setFechaRegistro(rs.getDate("fecha_registro"));
                productos.add(p);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(long id) {

    }
}