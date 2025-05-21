import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Sistema de Avaliacao de Automatização");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnCadastro = new JButton("Plano de Projeto");
        JButton btnAvaliacao = new JButton("Conformidade");
        JButton btnNaoConforme = new JButton("Registro Não Conformidade");
        JButton btnComunicacaoNC = new JButton("Comunicação NC");

        btnCadastro.addActionListener(e -> {
            CadastroItem cadastroFrame = new CadastroItem();
            cadastroFrame.setVisible(true);
        });

        btnAvaliacao.addActionListener(e -> {
            PlanoDeProjeto avaliacaoFrame = new PlanoDeProjeto();
            avaliacaoFrame.setVisible(true);
        });

        btnNaoConforme.addActionListener(e -> {
            RegistroNC registroNC = new RegistroNC();
            registroNC.setVisible(true);
        });

        btnComunicacaoNC.addActionListener(e -> {
            ComunicacaoNC comunicacaoNC = new ComunicacaoNC();
            comunicacaoNC.setVisible(true);
        });

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1, 10, 10));
        painel.setBorder(new EmptyBorder(30, 30, 30, 30)); // top, left, bottom, right
        painel.add(btnCadastro);
        painel.add(btnAvaliacao);
        painel.add(btnNaoConforme);
        painel.add(btnComunicacaoNC);

        add(painel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}
