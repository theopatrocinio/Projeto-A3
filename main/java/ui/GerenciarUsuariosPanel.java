package ui;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GerenciarUsuariosPanel extends JPanel {

    private JTable tabela;
    private DefaultTableModel modelo;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public GerenciarUsuariosPanel() {

        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new String[]{
                "ID", "Nome", "Idade", "Tipo", "Login", "Ativo"
        }, 0);

        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        carregarUsuarios();
    }

    private void carregarUsuarios() {
        modelo.setRowCount(0);
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();

        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{
                    u.getId(),
                    u.getNome(),
                    u.getIdade(),
                    u.getTipo(),
                    u.getLogin(),
                    u.isAtivo() ? "Sim" : "Não"
            });
        }
    }
}
