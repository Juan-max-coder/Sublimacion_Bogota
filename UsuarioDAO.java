/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacion_bogota.dao;

import com.mycompany.sublimacion_bogota.conexion.Conexion;
import com.mycompany.sublimacion_bogota.modelo.Usuario;
import java.sql.*;

public class UsuarioDAO {

    public boolean insertarUsuario(Usuario u) {
        String sql = "INSERT INTO Usuario (correoUsuario, contrasenaUsuario, rolUsuario) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getCorreoUsuario());
            ps.setString(2, u.getContrasenaUsuario());
            ps.setString(3, u.getRolUsuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario consultarUsuarioPorCorreo(String correo) {
        String sql = "SELECT * FROM Usuario WHERE correoUsuario=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getLong("idUsuario"),
                    rs.getString("correoUsuario"),
                    rs.getString("contrasenaUsuario"),
                    rs.getString("rolUsuario")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizarUsuario(Usuario u) {
        String sql = "UPDATE Usuario SET correoUsuario=?, contrasenaUsuario=?, rolUsuario=? WHERE idUsuario=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getCorreoUsuario());
            ps.setString(2, u.getContrasenaUsuario());
            ps.setString(3, u.getRolUsuario());
            ps.setLong(4, u.getIdUsuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarUsuario(long id) {
        String sql = "DELETE FROM Usuario WHERE idUsuario=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}
