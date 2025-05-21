import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ComunicacaoNC extends JFrame {

    private JComboBox<String> artefatoComboBox;
    private JPanel checklistPanel;
    private JButton calcularButton;

    // Guarda os bot�es de cada item para verificar a conformidade
    private ArrayList<ButtonGroup> conformidadeGrupos = new ArrayList<>();

    public ComunicacaoNC() {
        setTitle("Comunicação da NC");
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        artefatoComboBox = new JComboBox<>(CadastroItem.artefatos.keySet().toArray(new String[0]));
        JButton carregarButton = new JButton("Carregar NC");
        checklistPanel = new JPanel();
        checklistPanel.setLayout(new BoxLayout(checklistPanel, BoxLayout.Y_AXIS));
        calcularButton = new JButton("Enviar Comunicação NC");

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

            if( status == "Nao Conforme") {
        	
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
                
            // Ação corretiva
            JComboBox<String> acaoStatusCombo = new JComboBox<>(new String[]{"Simples", "Médio", "Alto"});



            // Data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataRes = LocalDate.now().format(formatter);
            JTextField dataField = new JTextField(dataRes);
            dataField.setColumns(10);

            // data resolução
            dataRes = LocalDate.now().plusDays(3).format(formatter);
            JTextField dataResolucao = new JTextField(dataRes);
            dataResolucao.setColumns(10);

            // Situação
            JComboBox<String> situacaoCombo = new JComboBox<>(new String[]{"0", "1", "2", "3"});
            
            JComboBox<String> responsavel = new JComboBox<>(new String[]{"Giulia", "Paulo"});

            acaoStatusCombo.addActionListener(e -> {
                String selecionado = (String) acaoStatusCombo.getSelectedItem();

                int dias = switch (selecionado) {
                case "Simples" -> 3;
                case "Médio" -> 2; 
                case "Alto" -> 1;
                default -> 0;
                };
                dataResolucao.setText(LocalDate.now().plusDays(dias).format(formatter));
            });

            JPanel coluna2 = new JPanel(new GridLayout(2, 1, 5, 5));
            

            JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

            linha1.add(new JLabel("Classificação:"));
            linha1.add(acaoStatusCombo);
            linha1.add(new JLabel("Data Solicitação:"));
            linha1.add(dataField);
            linha1.add(new JLabel("Data Resolução:"));
            linha1.add(dataResolucao);
            linha1.add(new JLabel("Nº Escalonamentos"));
            linha1.add(situacaoCombo);
            linha1.add(new JLabel("Responsável"));
            linha1.add(responsavel);
            coluna2.add(linha1);

            JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            linha2.add(new JLabel("Descrição:"));
            JTextArea textoArea = new JTextArea(5, 30);
            textoArea.setLineWrap(true);
            textoArea.setWrapStyleWord(true);
            textoArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));
            linha2.add(textoArea);
            coluna2.add(linha2);

            itemPanel.add(coluna2);

                checklistPanel.add(itemPanel);
            }
        }

        checklistPanel.revalidate();
        checklistPanel.repaint();
    }

    private void calcularAderencia() {
        JOptionPane.showMessageDialog(this, "Comunicação NC enviada com sucesso!");
        System.exit(ABORT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlanoDeProjeto().setVisible(true));
    }
}

