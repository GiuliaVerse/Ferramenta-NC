import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CadastroItem extends JFrame {

    private JTextField nomeArtefatoField;
    private DefaultListModel<String> checklistModel;
    private JList<String> checklistList;
    private JTextField novoItemField;

    // Armazenamento em mem�ria: artefato -> lista de itens
    public static HashMap<String, ArrayList<ItemChecklist>> artefatos = new HashMap<>();

    public CadastroItem() {
        setTitle("Plano de Projeto");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Componentes da interface
        nomeArtefatoField = new JTextField(30);
        checklistModel = new DefaultListModel<>();
        checklistList = new JList<>(checklistModel);
        novoItemField = new JTextField(20);
        JButton adicionarItemButton = new JButton("Adicionar Item");
        JButton salvarButton = new JButton("Salvar Item");

        // Layout
        JPanel painel = new JPanel(new BorderLayout());

        // Topo: Nome do artefato
        JPanel topoPanel = new JPanel();
        topoPanel.add(new JLabel("Nome do Plano de Projeto:"));
        topoPanel.add(nomeArtefatoField);
        painel.add(topoPanel, BorderLayout.NORTH);

     // Centro: conte�do principal
        JPanel centroPanel = new JPanel();
        centroPanel.setLayout(new BoxLayout(centroPanel, BoxLayout.Y_AXIS));

        // Campo para adicionar novo item
        JPanel addItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addItemPanel.setBorder(BorderFactory.createTitledBorder("Item Avaliado"));
        addItemPanel.add(novoItemField);
        addItemPanel.add(adicionarItemButton);
        centroPanel.add(addItemPanel);

        // Lista de itens j� adicionados
        JPanel listaPanel = new JPanel(new BorderLayout());
        listaPanel.setBorder(BorderFactory.createTitledBorder("Itens do Checklist"));
        listaPanel.add(new JScrollPane(checklistList), BorderLayout.CENTER);
        centroPanel.add(listaPanel);

        // Adiciona o centroPanel ao painel principal
        painel.add(centroPanel, BorderLayout.CENTER);

        // Rodap�: bot�o de salvar
        JPanel rodape = new JPanel();
        rodape.add(salvarButton);
        painel.add(rodape, BorderLayout.SOUTH);

        // Listeners
        adicionarItemButton.addActionListener(e -> {
            String item = novoItemField.getText().trim();
            if (!item.isEmpty()) {
                checklistModel.addElement(item);
                novoItemField.setText("");
            }
        });

        salvarButton.addActionListener(e -> {
            String nomeArtefato = nomeArtefatoField.getText().trim();
            if (nomeArtefato.isEmpty() || checklistModel.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o nome e pelo menos um item do checklist.");
                return;
            }

            //ArrayList<String> checklist = new ArrayList<>();
            //for (int i = 0; i < checklistModel.size(); i++) {
            //    checklist.add(checklistModel.get(i));
            //}

            ArrayList<ItemChecklist> checklist = new ArrayList<>();
            for (int i = 0; i < checklistModel.size(); i++) {
                checklist.add(new ItemChecklist(checklistModel.get(i)));
            }
            CadastroItem.artefatos.put(nomeArtefato, checklist);
            
            artefatos.put(nomeArtefato, checklist);
            JOptionPane.showMessageDialog(this, "Item salvo com sucesso!");
            checklistModel.clear();
            nomeArtefatoField.setText("");
        });

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroItem().setVisible(true));
    }
}
