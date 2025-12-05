package ui;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public LoginFrame() {
        setTitle("Login - Sistema de Curadoria");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);

        add(new JLabel("Login:"));
        txtLogin = new JTextField();
        add(txtLogin);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        JButton btnEntrar = new JButton("Entrar");
        add(btnEntrar);

        btnEntrar.addActionListener(e -> realizarLogin());
    }

    private void realizarLogin() {

        String login = txtLogin.getText();
        String senha = new String(txtSenha.getPassword());

        if (usuarioDAO.autenticar(login, senha)) {
            Usuario usuario = usuarioDAO.obterUsuarioPorLogin(login);
            new MainFrame(usuario).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Login inválido!");
        }
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}
