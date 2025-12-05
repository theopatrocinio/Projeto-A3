package dao;

import database.DatabaseConnection;
import model.Recurso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecursoDAO {

    public boolean cadastrarRecurso(Recurso recurso) {
        String sql = "INSERT INTO recursos (titulo, autor, categoria, usuario_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, recurso.getTitulo());
            stmt.setString(2, recurso.getAutor());
            stmt.setString(3, recurso.getCategoria());
            stmt.setInt(4, recurso.getUsuarioId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Recurso> listarRecursosPorUsuario(int usuarioId) {

        String sql = "SELECT * FROM recursos WHERE usuario_id = ?";
        List<Recurso> lista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Recurso r = new Recurso();
                r.setId(rs.getInt("id"));
                r.setTitulo(rs.getString("titulo"));
                r.setAutor(rs.getString("autor"));
                r.setCategoria(rs.getString("categoria"));
                r.setUsuarioId(rs.getInt("usuario_id"));
                r.setDataCadastro(rs.getString("data_cadastro"));

                lista.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
