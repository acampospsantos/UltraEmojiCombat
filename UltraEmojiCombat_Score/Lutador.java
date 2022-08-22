package UltraEmojiCombat_Score;

public class Lutador { //Classe do Lutador - Atributos e Métodos próprios de cada lutador
    
    //Atributos (Encapsulados)
    private String nome; 
    private String nacionalidade; 
    private int idade;
    private double altura; 
    private double peso; 
    private String categoria; 
    private int vitorias; 
    private int derrotas; 
    private int empates; 
    private int partidas; 
    private boolean apto; 
    private int pontos;    
    
    
    //Método Construtor
    public Lutador(String nome, String nacionalidade, int idade, double altura, double peso, int vitorias, int derrotas, int empates) {
        this.setNome(nome);
        this.setNacionalidade(nacionalidade);
        this.setIdade(idade);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setCategoria(this.getPeso());
        this.setVitorias(vitorias);
        this.setDerrotas(derrotas);
        this.setEmpates(empates);
        //
        this.setPartidas(vitorias, derrotas, empates);        
        this.setApto(true);
        this.setPontos(0);  
    }

    //Métodos Acessores e Modificadores
    private void setNome(String nome) {
        if (nome != null && nome != "") { //(!nome.equals(null) && !nome.equals(""));
            this.nome = nome;
        } else {
            this.setApto(false);
        }
    }
    public String getNome() {
        return this.nome;
    }
    
    private void setNacionalidade(String nacionalidade) {
        if (nome != null && nome != "") {
            this.nacionalidade = nacionalidade;
        } else {
            this.setApto(false);
        }
    }
    public String getNacionalidade() {
        return this.nacionalidade;
    }
    
    private void setIdade(int idade) {
        if (idade > 20 && idade < 60) {
            this.idade = idade;
        } else {
            this.setApto(false);
        }
    }
    public int getIdade() {
        return this.idade;
    }

    //Unidade: metros(m)
    private void setAltura(double altura) {
        if (altura > 1 && altura < 3) {
            this.altura = altura;
        } else {
            this.setApto(false);
        }           
    }
    public double getAltura() {
        return this.altura;
    }
    
    private void setPeso(double peso) {
        this.peso = peso;
        this.setCategoria(peso);
    }
    public double getPeso() {
        return this.peso;
    }
    
    private void setCategoria(double peso) {
        if (peso < 52.2) {
            this.categoria = "Inválido";
            this.setApto(false);
        } else if (peso <= 70.3) {
            this.categoria = "Leve";
        } else if (peso <= 83.9) {
            this.categoria = "Médio";
        } else if (peso <= 120.2) {
            this.categoria = "Pesado";
        } else {
            this.categoria = "Inválido";
            this.setApto(false);
        }
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    private void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }
    public int getVitorias() {
        return this.vitorias;
    }
    
    private void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
    public int getDerrotas() {
        return this.derrotas;
    }
    
    private void setEmpates(int empates) {
        this.empates = empates;
    }
    public int getEmpates() {
        return this.empates;
    }
    
    private void setPartidas(int vitorias, int derrotas, int empates) {
        this.partidas = vitorias + derrotas + empates;
    }
    public int getPartidas() {
        return this.partidas;
    }
        
    private void setApto(boolean apto) {
        this.apto = apto;
    }
    public boolean getApto() {
        return this.apto;
    }    

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }    
    public int getPontos(){
        return this.pontos;
    }
    

    
    
    //Métodos da Classe
    public void apresentar() {
        if (this.getApto() == true) {
            System.out.println("");
            System.out.println("----- APRESENTAÇÃO -----");
            System.out.println("Nome do Lutador: " + this.getNome());
            System.out.println("Nacionalidade: " + this.getNacionalidade());
            System.out.println("Idade: " + this.getIdade());
            System.out.println("Altura: " + this.getAltura() + "m");
            System.out.println("Categoria: " + this.getCategoria());
            System.out.println("Ganhou: " + this.getVitorias() + " partidas");
            System.out.println("Perdeu: " + this.getDerrotas() + " partidas");
            System.out.println("Empatou: " + this.getEmpates() + " partidas");
            System.out.println("TOTAL: " + this.getPartidas() + " partidas");
            System.out.println("----------------------");
            System.out.println("");
        } else {
            System.out.println("null");
        }
    }

    public void status() {
        if (this.getApto() == true) {
            System.out.println("");
            System.out.println("----- STATUS -----");
            System.out.println("Nome do Lutador: " + this.getNome());
            System.out.println("Categoria: " + this.getCategoria());
            System.out.println("Ganhou: " + this.getVitorias() + " partidas");
            System.out.println("Perdeu: " + this.getDerrotas() + " partidas");
            System.out.println("Empatou: " + this.getEmpates() + " partidas");
            System.out.println("TOTAL: " + this.getPartidas() + " partidas");
            System.out.println("---------------");
            System.out.println("");
        } else {
            System.out.println("null");
        }
    }

    public void ganharLuta() {
        this.setVitorias(this.getVitorias() + 1);
        this.partidas = this.partidas + 1;
    }

    public void perderLuta() {
        this.setDerrotas(this.getDerrotas() + 1);
        this.partidas = this.partidas + 1;
    }

    public void empatarLuta() {
        this.setEmpates(this.getEmpates() + 1);
        this.partidas = this.partidas + 1;
    }
}
