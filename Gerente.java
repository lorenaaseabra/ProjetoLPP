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

        // Métodos com tratamento de erros adicionais

        public void aumentarSalario(double aumentoPercentual) {
            try {
                if (aumentoPercentual < 0) {
                    throw new IllegalArgumentException("O aumento percentual deve ser um valor positivo.");
                }

                double aumento = salario * aumentoPercentual / 100;
                salario += aumento;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao aumentar o salário do gerente: " + e.getMessage());
            }
        }

        public void atualizarDepartamento(String novoDepartamento) {
            try {
                if (novoDepartamento == null || novoDepartamento.isEmpty()) {
                    throw new IllegalArgumentException("O novo departamento não pode ser nulo ou vazio.");
                }

                this.departamento = novoDepartamento;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao atualizar o departamento do gerente: " + e.getMessage());
            }
        }
    }
