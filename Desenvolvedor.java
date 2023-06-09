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

        // Método com tratamento de erro

        public void aumentarSalario(double aumentoPercentual) {
            try {
                if (aumentoPercentual < 0) {
                    throw new IllegalArgumentException("O aumento percentual deve ser um valor positivo.");
                }
    
                double aumento = salario * aumentoPercentual / 100;
                salario += aumento;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao aumentar o salário: " + e.getMessage());
            }
        }
    
        public void atualizarLinguagem(String novaLinguagem) {
            try {
                if (novaLinguagem == null || novaLinguagem.isEmpty()) {
                    throw new IllegalArgumentException("A nova linguagem não pode ser nula ou vazia.");
                }
    
                this.linguagem = novaLinguagem;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao atualizar a linguagem: " + e.getMessage());
            }
        }
}
