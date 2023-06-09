package ProjetoLPP2023.ProjetoLPP;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainGUI extends JFrame {
    private JPanel funcionariosPanel;

    public MainGUI() {
        setTitle("Lista de Funcionários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        funcionariosPanel = new JPanel();
        funcionariosPanel.setLayout(new BoxLayout(funcionariosPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(funcionariosPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        getContentPane().setBackground(Color.WHITE);
        add(scrollPane);

        exibirDadosFuncionarios();
    }

    public void exibirDadosFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        Gerente gerente1 = new Gerente("João", 35, 5000.0, "Vendas");
        Gerente gerente2 = new Gerente("Maria", 40, 5500.0, "RH");
        Desenvolvedor dev1 = new Desenvolvedor("Pedro", 25, 3000.0, "Java");
        Estagiario estagiario1 = new Estagiario("Lucas", 20, 1000.0, "Python", 6);
        Estagiario estagiario2 = new Estagiario("Luana", 21, 1500.0, "JavaScript", 12);

        funcionarios.add(gerente1);
        funcionarios.add(gerente2);
        funcionarios.add(dev1);
        funcionarios.add(estagiario1);
        funcionarios.add(estagiario2);

        for (Funcionario funcionario : funcionarios) {
            JPanel panel = new JPanel();
            Color corBorda = getRandomColor();
            panel.setBorder(new LineBorder(corBorda, 3));
            panel.setBackground(corBorda);
            panel.setLayout(new BorderLayout());

            JLabel nomeLabel = new JLabel(funcionario.getNome());
            nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
            nomeLabel.setForeground(Color.WHITE);
            nomeLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            panel.add(nomeLabel, BorderLayout.NORTH);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setFont(new Font("Courier", Font.PLAIN, 12));
            panel.add(textArea, BorderLayout.CENTER);

            nomeLabel.addMouseListener(new MouseAdapter() {
                boolean expanded = false;

                @Override
                public void mouseClicked(MouseEvent e) {
                    expanded = !expanded;
                    textArea.setText(expanded ? formatarDadosFuncionario(funcionario) : "");
                    panel.revalidate();
                    panel.repaint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    nomeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    nomeLabel.setCursor(Cursor.getDefaultCursor());
                }
            });

            funcionariosPanel.add(panel);
            funcionariosPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        getContentPane().setBackground(funcionariosPanel.getComponent(0).getBackground());
    }

    private String formatarDadosFuncionario(Funcionario funcionario) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Funcionário\n")
                .append("Nome: ").append(funcionario.getNome()).append("\n")
                .append("Idade: ").append(funcionario.getIdade()).append("\n")
                .append("Salário: ").append(funcionario.getSalario()).append("\n");

        try {
            if (funcionario instanceof Gerente) {
                Gerente gerente = (Gerente) funcionario;
                stringBuilder.append("Departamento: ").append(gerente.getDepartamento()).append("\n");
            } else if (funcionario instanceof Desenvolvedor) {
                Desenvolvedor desenvolvedor = (Desenvolvedor) funcionario;
                stringBuilder.append("Linguagem: ").append(desenvolvedor.getLinguagem()).append("\n");
            } else if (funcionario instanceof Estagiario) {
                Estagiario estagiario = (Estagiario) funcionario;
                stringBuilder.append("Duração do Estágio: ").append(estagiario.getDuracaoEstagio()).append(" meses\n");
            }
        } catch (Exception e) {
            stringBuilder.append("Erro ao formatar dados do funcionário: ").append(e.getMessage()).append("\n");
        }
    
        return stringBuilder.toString();
    }

    private Color getRandomColor() {
        float r = (float) Math.random();
        float g = (float) Math.random();
        float b = (float) Math.random();
        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao configurar o look and feel do sistema.");
            }

            try {
                MainGUI gui = new MainGUI();
                gui.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao criar a interface gráfica.");
            }
        });
    }
}

