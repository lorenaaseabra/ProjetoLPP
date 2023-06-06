package ProjetoLPP2023.ProjetoLPP;

public class Gerente extends Funcionario {
        private String departamento;
    
        public Gerente(String nome, int idade, double salario, String departamento) {
            super(nome, idade, salario);
            this.departamento = departamento;
        }
    
        public Gerente() {
            super();
            this.departamento = "";
        }
    
        public Gerente(Gerente outro) {
            super(outro);
            this.departamento = outro.departamento;
        }
    
        // Métodos de acesso
    
        public String getDepartamento() {
            return departamento;
        }
    
        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }
    
        // Métodos sobrepostos
    
        @Override
        public void imprimirDados() {
            System.out.println("Gerente: " + nome + ", " + idade + " anos, salário: " + salario + ", departamento: " + departamento);
        }
    }
