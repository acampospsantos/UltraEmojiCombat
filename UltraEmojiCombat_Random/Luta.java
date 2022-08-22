package UltraEmojiCombat_Random;

import java.util.Random;

public class Luta { // Classe da Luta - envolvendo os métodos essenciais para que a Luta ocorra

    // Atributos da Classe Luta(Encapsulados)
    private Lutador desafiador;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    // MÉTODO CONSTRUTOR
    public Luta() {
        this.setAprovada(false);
    }

    
    // Métodos Acessores e Modificadores(get's e set's)
    public int getRounds() {
        return this.rounds;
    }

    private void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    public boolean getAprovada() {
        return this.aprovada;
    }


    // Métodos da Classe Luta
    public void marcarLuta(Lutador desafiador, Lutador desafiante) {
        if (desafiador.getApto() == true && desafiante.getApto() == true) {
            if (desafiador.getCategoria().equals(desafiante.getCategoria())) {
                if (desafiador != desafiante) {
                    this.setAprovada(true);
                    System.out.println("----------");
                    System.out.println("## LUTA APROVADA ##");
                    System.out.println("----------");
                } else {
                    this.setAprovada(false);
                    System.out.println("----------");
                    System.out.println("## LUTA NÃO APROVADA ##");
                    System.out.println("## Desafiante e Desafiador são a mesma pessoa ##");
                    System.out.println("----------");
                }
            } else {
                this.setAprovada(false);
                System.out.println("----------");
                System.out.println("## LUTA NÃO APROVADA ##");
                System.out.println("## LUTADORES DE DIFERENTES CATEGORIAS ##");
                System.out.println("----------");
            }
        } else {
            this.setAprovada(false);
            System.out.println("----------");
            System.out.println(" ## LUTA NAO AUTORIZADA ##");
            System.out.println("----------");
        }
    }

    public void lutar(Lutador desafiador, Lutador desafiante) {
        if (this.getAprovada() == true) {
            System.out.println("");
            System.out.println("----- LUTA -----");
            System.out.println(desafiador.getNome() + " x " + desafiante.getNome());
            desafiador.apresentar();
            desafiante.apresentar();

            // CASO ALEATÓRIO (SIMULAÇÃO)
            System.out.println("CASO ALEATÓRIO (SIMULAÇÃO)");
            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3); // 0 1 2
            switch (vencedor) {
                case 0:
                    System.out.println("## EMPATE ##");
                    desafiador.empatarLuta();
                    desafiante.empatarLuta();
                    break;
                case 1:
                    System.out.println("## VITÓRIA DO DESAFIADOR (" + desafiador.getNome() + ") ##");
                    desafiador.ganharLuta();
                    desafiante.perderLuta();
                    break;
                case 2:
                    System.out.println("## VITÓRIA DO DESAFIANTE (" + desafiante.getNome() + ") ##");
                    desafiador.perderLuta();
                    desafiante.ganharLuta();
                    break;
            }

        } else { // this.getAprovada() == false;
            System.out.println("## LUTA NÃO MARCADA ##");
        }

    }

}