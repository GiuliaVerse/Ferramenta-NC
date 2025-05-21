import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlanoDeProjeto extends JFrame {

    private JComboBox<String> artefatoComboBox;
    private JPanel checklistPanel;
    private JButton calcularButton;
    private JLabel resultadoLabel;

    // Guarda os bot�es de cada item para verificar a conformidade
    private ArrayList<ButtonGroup> conformidadeGrupos = new ArrayList<>();

    public PlanoDeProjeto() {
        setTitle("Plano de Projeto");
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        artefatoComboBox = new JComboBox<>(CadastroItem.artefatos.keySet().toArray(new String[0]));
        JButton carregarButton = new JButton("Carregar Checklist");
        checklistPanel = new JPanel();
        checklistPanel.setLayout(new BoxLayout(checklistPanel, BoxLayout.Y_AXIS));
        calcularButton = new JButton("Calcular Aderencia");
        resultadoLabel = new JLabel("Porcentagem: -");

        // Layout principal
        JPanel painel = new JPanel(new BorderLayout());

        // Topo
        JPanel topo = new JPanel();
        topo.add(new JLabel("Selecione o Artefato:"));
        topo.add(artefatoComboBox);
        topo.add(carregarButton);
        painel.add(topo, BorderLayout.NORTH);

        // Centro
        //JScrollPane scroll = new JScrollPane(checklistPanel);
        //painel.add(scroll, BorderLayout.CENTER);
        
     // Envolve o checklistPanel para alinhar no topo
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(checklistPanel, BorderLayout.NORTH);

        // Coloca no JScrollPane
        JScrollPane scroll = new JScrollPane(wrapperPanel);
        painel.add(scroll, BorderLayout.CENTER);


        // Rodap�
        JPanel rodape = new JPanel();
        rodape.add(calcularButton);
        rodape.add(resultadoLabel);
        painel.add(rodape, BorderLayout.SOUTH);

        add(painel);

        // Listener para carregar o checklist
        carregarButton.addActionListener(e -> carregarChecklist());

        // Listener para calcular a ader�ncia
        calcularButton.addActionListener(e -> calcularAderencia());
    }

    private void carregarChecklist() {
        checklistPanel.removeAll();
        conformidadeGrupos.clear();

        String artefatoSelecionado = (String) artefatoComboBox.getSelectedItem();
        if (artefatoSelecionado == null) return;

        ArrayList<ItemChecklist> itens = CadastroItem.artefatos.get(artefatoSelecionado);

        for (ItemChecklist itemObj : itens) {
        	String item = itemObj.getTexto();
        	String status = itemObj.getStatus();
        	
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            //itemPanel.add(new JLabel(item));
            
            //JLabel itemLabel = new JLabel(item);
            //itemLabel.setPreferredSize(new Dimension(200, 25)); // largura fixa de 200px
            //itemPanel.add(itemLabel);
            
            // Label com quebra de linha e largura fixa
            String htmlItem = "<html><body style='width:180px'>" + item + "</body></html>";
            JLabel itemLabel = new JLabel(htmlItem);
            itemLabel.setPreferredSize(new Dimension(200, 40)); // Largura fixa com altura ajustada
            itemPanel.add(itemLabel);
            
            JRadioButton conforme = new JRadioButton("Conforme");
            JRadioButton naoConforme = new JRadioButton("Nao Conforme");
            JRadioButton naoAplicavel = new JRadioButton("Nao Aplicavel");

            conforme.setActionCommand("Conforme");
            naoConforme.setActionCommand("Nao Conforme");
            naoAplicavel.setActionCommand("Nao Aplicavel");
            
            switch (status) {
            case "Conforme": conforme.setSelected(true); break;
            case "Nao Conforme": naoConforme.setSelected(true); break;
            default: naoAplicavel.setSelected(true); break;
            }
            
            ButtonGroup grupo = new ButtonGroup();
            grupo.add(conforme);
            grupo.add(naoConforme);
            grupo.add(naoAplicavel);

            itemPanel.add(conforme);
            itemPanel.add(naoConforme);
            itemPanel.add(naoAplicavel);

            conformidadeGrupos.add(grupo);
            checklistPanel.add(itemPanel);
        }

        checklistPanel.revalidate();
        checklistPanel.repaint();
        calcularAderencia();
    }

    private void calcularAderencia() {
        int total = 0;
        int conformeCount = 0;

        String artefatoSelecionado = (String) artefatoComboBox.getSelectedItem();
        ArrayList<ItemChecklist> itens = CadastroItem.artefatos.get(artefatoSelecionado);

        for (int i = 0; i < conformidadeGrupos.size(); i++) {
            ButtonModel selecionado = conformidadeGrupos.get(i).getSelection();
            if (selecionado == null) continue;

            String status = selecionado.getActionCommand();
            itens.get(i).setStatus(status); // salva de volta
            if (status.equals("Conforme")) {
                conformeCount++;
                total++;
            } else if (status.equals("Nao Conforme")) {
                total++;
            }
        }

        /*
        for (ButtonGroup grupo : conformidadeGrupos) {
            ButtonModel selecionado = grupo.getSelection();
            if (selecionado != null && selecionado.getActionCommand().equals("Conforme")) {
                conformeCount++;
            }
        }
        */

        if (total == 0) {
            resultadoLabel.setText("Nenhum item carregado.");
        } else {
            double porcentagem = (double) conformeCount / total * 100;
            resultadoLabel.setText(String.format("Porcentagem: %.1f%%", porcentagem));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlanoDeProjeto().setVisible(true));
    }
}
