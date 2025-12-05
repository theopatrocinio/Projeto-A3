package ui;

import dao.RecursoDAO;
import model.Recurso;
import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class CadastrarRecursoPanel extends JPanel {

    private JTextField txtTitulo, txtAutor;
    private JComboBox<String> cmbCategoria;
    private RecursoDAO recursoDAO = new RecursoDAO();
    private Usuario usuario;

    public CadastrarRecursoPanel(Usuario usuario) {
        this.usuario = usuario;

        setLayout(new GridLayout(4, 2));

        add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        add(txtAutor);

        add(new JLabel("Categoria:"));
        cmbCategoria = new JComboBox<>(new String[]{
                "IA Responsável", "Cibersegurança", "Privacidade & Ética Digital"
        });
        add(cmbCategoria);

        JButton btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> salvar());
    }

    private void salvar() {
        Recurso r = new Recurso(
                txtTitulo.getText(),
                txtAutor.getText(),
                cmbCategoria.getSelectedItem().toString(),
                usuario.getId()
        );

        if (recursoDAO.cadastrarRecurso(r)) {
            JOptionPane.showMessageDialog(this, "Recurso cadastrado!");
            txtTitulo.setText("");
            txtAutor.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar!");
        }
    }
}
