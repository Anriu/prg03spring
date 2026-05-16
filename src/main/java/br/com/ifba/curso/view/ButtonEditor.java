package br.com.ifba.curso.view;

import br.com.ifba.curso.controller.CursoIController;
import br.com.ifba.curso.entity.Curso;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anriu
 */
public class ButtonEditor extends DefaultCellEditor {

    // Controller recebido da tela CursoListar
    private final CursoIController cursoController;

    // Botão usado dentro da célula da tabela
    protected JButton button;

    // Guarda a coluna clicada
    private int col;

    // Guarda a linha clicada
    private int row;

    // Guarda a tabela onde o botão foi clicado
    private JTable table;

    // Guarda o valor da célula
    private Object valor;

    public ButtonEditor(JCheckBox checkBox, CursoIController cursoController) {
        super(checkBox);

        // Recebe o controller gerenciado pelo Spring
        this.cursoController = cursoController;

        // Cria o botão
        button = new JButton();

        // Deixa o botão com aparência transparente
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        // Executa a ação ao clicar no botão
        button.addActionListener(e -> {

            // Executa a ação da coluna clicada
            executarAcao();

            // Finaliza a edição da célula
            fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {

        // Guarda os dados da célula clicada
        this.table = table;
        this.row = row;
        this.col = column;
        this.valor = value;

        return button;
    }

    /**
     * Executa a ação da coluna clicada.
     */
    private void executarAcao() {

        // Pega o model da tabela
        DefaultTableModel model =
                (DefaultTableModel) table.getModel();

        // Converte a linha visual para a linha real do model
        int linhaModel =
                table.convertRowIndexToModel(row);

        // Pega o ID do curso na tabela
        Long id = Long.valueOf(
                model.getValueAt(linhaModel, 0).toString()
        );

        // Verifica se a coluna clicada é a de remover
        if (col == 3) {

            int resposta = JOptionPane.showConfirmDialog(
                    button,
                    "Deseja realmente excluir o curso?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            // Se o usuário confirmar, remove o curso
            if (resposta == JOptionPane.YES_OPTION) {

                // Busca o curso pelo ID
                Curso curso = cursoController.findById(id);

                // Remove o curso do banco
                cursoController.delete(curso);

                // Remove a linha da tabela
                model.removeRow(linhaModel);
            }

        // Verifica se a coluna clicada é a de editar
        } else if (col == 4) {

            // Busca o curso pelo ID
            Curso curso = cursoController.findById(id);

            // Abre a tela de edição do curso
            DadosCurso tela = new DadosCurso(curso, cursoController);

            // Exibe a tela
            tela.setVisible(true);
        }
    }

    @Override
    public Object getCellEditorValue() {

        // Retorna o valor da célula
        return valor;
    }
}