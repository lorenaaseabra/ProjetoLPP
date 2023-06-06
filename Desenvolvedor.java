package ProjetoLPP2023.ProjetoLPP;

public class Desenvolvedor extends Funcionario {
        private String linguagem;
    
        public Desenvolvedor(String nome, int idade, double salario, String linguagem) {
            super(nome, idade, salario);
            this.linguagem = linguagem;
        }
    
        public Desenvolvedor() {
            super();
            this.linguagem = "";
        }
    
        public Desenvolvedor(Desenvolvedor outro) {
            super(outro);
            this.linguagem = outro.linguagem;
        }
    
        // Métodos de acesso
    
        public String getLinguagem() {
            return linguagem;
        }
    
        public void setLinguagem(String linguagem) {
            this.linguagem = linguagem;
        }
    
        // Métodos sobrepostos
    
        @Override
        public void imprimirDados() {
            System.out.println("Desenvolvedor: " + nome + ", " + idade + " anos, salário: " + salario + ", linguagem: " + linguagem);
        }
    }
