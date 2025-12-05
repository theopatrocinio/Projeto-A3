package ui;

import dao.RecursoDAO;
import model.Recurso;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListarRecursosPanel extends JPanel {

    private DefaultTableModel modelo;
    private JTable tabela;
    private RecursoDAO recursoDAO = new RecursoDAO();
    private Usuario usuario;

    public ListarRecursosPanel(Usuario usuario) {
        this.usuario = usuario;

        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(
                new String[]{"Título", "Autor", "Categoria", "Data Cadastro"}, 0
        );

        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        carregar();
    }

    private void carregar() {
        modelo.setRowCount(0);

        List<Recurso> recursos = recursoDAO.listarRecursosPorUsuario(usuario.getId());

        for (Recurso r : recursos) {
            modelo.addRow(new Object[]{
                    r.getTitulo(),
                    r.getAutor(),
                    r.getCategoria(),
                    r.getDataCadastro()
            });
        }
    }
}
