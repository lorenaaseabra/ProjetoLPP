package ProjetoLPP2023.ProjetoLPP;

public class Estagiario extends Desenvolvedor {
    private int duracaoEstagio;

    public Estagiario(String nome, int idade, double salario, String linguagem, int duracaoEstagio) {
        super(nome, idade, salario, linguagem);
        this.duracaoEstagio = duracaoEstagio;
    }

    public Estagiario() {
        super();
        this.duracaoEstagio = 0;
    }

    public Estagiario(Estagiario outro) {
        super(outro);
        this.duracaoEstagio = outro.duracaoEstagio;
    }

    // Métodos de acesso

    public int getDuracaoEstagio() {
        return duracaoEstagio;
    }

    public void setDuracaoEstagio(int duracaoEstagio) {
        this.duracaoEstagio = duracaoEstagio;
    }

    // Métodos sobrepostos

    @Override
    public void imprimirDados() {
        System.out.println("Estagiário: " + nome + ", " + idade + " anos, salário: " + salario + ", linguagem: " + getLinguagem() + ", duração do estágio: " + duracaoEstagio + " meses");
    }

    // Métodos com tratamento de erros

    public void atualizarDuracaoEstagio(int novaDuracao) {
        try {
            if (novaDuracao < 0) {
                throw new IllegalArgumentException("A duração do estágio deve ser um valor não negativo.");
            }

            this.duracaoEstagio = novaDuracao;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar a duração do estágio: " + e.getMessage());
        }
    }
}

