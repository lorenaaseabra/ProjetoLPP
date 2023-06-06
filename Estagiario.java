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
}

