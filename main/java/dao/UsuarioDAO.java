package dao;

import database.DatabaseConnection;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean autenticar(String login, String senha) {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ? AND ativo = TRUE";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario obterUsuarioPorLogin(String login) {
        String sql = "SELECT * FROM usuarios WHERE login = ?";
        Usuario usuario = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("tipo"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> lista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("tipo"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo")
                );

                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
