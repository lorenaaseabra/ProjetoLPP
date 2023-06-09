package ProjetoLPP2023.ProjetoLPP;

public abstract class Funcionario {
        protected String nome;
        protected int idade;
        protected double salario;
    
        public Funcionario(String nome, int idade, double salario) {
            this.nome = nome;
            this.idade = idade;
            this.salario = salario;
        }
    
        public Funcionario() {
            this("", 0, 0.0);
        }
    
        public Funcionario(Funcionario outro) {
            this.nome = outro.nome;
            this.idade = outro.idade;
            this.salario = outro.salario;
        }
    
        // Métodos de acesso
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public int getIdade() {
            return idade;
        }
    
        public void setIdade(int idade) {
            this.idade = idade;
        }
    
        public double getSalario() {
            return salario;
        }
    
        public void setSalario(double salario) {
            this.salario = salario;
        }
    
        // Métodos abstratos
    
        public abstract void imprimirDados();
    
        // Métodos sobrepostos
    
        @Override
        public String toString() {
            return "Funcionário [nome=" + nome + ", idade=" + idade + ", salário=" + salario + "]";
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Funcionario other = (Funcionario) obj;
            return nome.equals(other.nome) && idade == other.idade && salario == other.salario;
        }
    
        @Override
        public Funcionario clone() {
            try {
                return (Funcionario) super.clone();
            } catch (CloneNotSupportedException e) {
                return new Funcionario(this);
            }
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
                System.out.println("Erro: " + e.getMessage());
            }
        }
    
}
