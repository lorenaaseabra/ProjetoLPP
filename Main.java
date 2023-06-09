package ProjetoLPP2023.ProjetoLPP;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
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
            funcionario.imprimirDados();
        }
        // Abre o arquivo para escrita

        try (PrintWriter writer = new PrintWriter(new FileWriter("funcionarios.txt"))) {
            for (Funcionario funcionario : funcionarios) {
                // Escreve as informações do funcionário no arquivo
                writer.println(funcionario.toString());
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        // Tratamento de erros
        try {
            gerente1.aumentarSalario(-10); // Tentativa de aumento com valor negativo
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aumentar o salário do gerente1: " + e.getMessage());
        }

        try {
            dev1.atualizarLinguagem(null); // Tentativa de atualização de linguagem com valor nulo
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar a linguagem do dev1: " + e.getMessage());
        }

        try {
            estagiario1.atualizarDuracaoEstagio(-3); // Tentativa de atualização de duração do estágio com valor negativo
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar a duração do estágio do estagiario1: " + e.getMessage());
        }
    }
}

