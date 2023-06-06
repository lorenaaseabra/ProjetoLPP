package ProjetoLPP2023.ProjetoLPP;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        Gerente gerente1 = new Gerente("João", 35, 5000.0, "Vendas");
        Gerente gerente2 = new Gerente("Maria", 40, 5500.0, "RH");
        Desenvolvedor dev1 = new Desenvolvedor("Pedro", 25, 3000.0, "Java");
        Estagiario estagiario1 = new Estagiario("Lucas", 20, 1000.0, "Python", 6);

        funcionarios.add(gerente1);
        funcionarios.add(gerente2);
        funcionarios.add(dev1);
        funcionarios.add(estagiario1);

        for (Funcionario funcionario : funcionarios) {
            funcionario.imprimirDados();
        }
    }
}

