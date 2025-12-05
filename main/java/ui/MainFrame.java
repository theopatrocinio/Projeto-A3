package ui;

import model.Usuario;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(Usuario usuario) {

        setTitle("Bem-vindo, " + usuario.getNome());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();

        if (usuario.getTipo().equalsIgnoreCase("Administrador")) {
            abas.add("Gerenciar Usuários", new GerenciarUsuariosPanel());
        }

        abas.add("Cadastrar Recurso", new CadastrarRecursoPanel(usuario));
        abas.add("Meus Recursos", new ListarRecursosPanel(usuario));

        add(abas);
    }
}
