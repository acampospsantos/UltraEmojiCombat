package UltraEmojiCombat_RPG;

import java.util.Random;

public class Luta { // Classe da Luta - envolvendo os métodos essenciais para que a Luta ocorra

    // Atributos da Classe Luta(Encapsulados)
    private Lutador desafiador;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    //MÉTODO CONSTRUTOR
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

    // "RPG" - Métodos
    public void soco(Lutador l1, Lutador l2) { // Soco tira 20 de vida
        // l1 socou l2
        l2.setVida(l2.getVida() - 20);
        System.out.println("### " + l1.getNome() + " socou " + l2.getNome() + " ###");        
        System.out.println("");
    }

    public void chute(Lutador l1, Lutador l2) { // Chute tira 30 de vida
        // l1 chutou l2
        l2.setVida(l2.getVida() - 30);
        System.out.println("### " + l1.getNome() + " chutou " + l2.getNome() + " ###");        
        System.out.println("");
    }

    public void defesaSoco(Lutador l1, Lutador l2) { // Defende metade do soco
        // l2 se defende de l1
        l2.setVida(l2.getVida() - 10);
        System.out.println("### " + l2.getNome() + " defendeu o chute de " + l1.getNome() + " ###");        
        System.out.println("");
    }

    public void defesaChute(Lutador l1, Lutador l2) { // Defende metade do chute
        // l2 se defende de l1
        l2.setVida(l2.getVida() - 15);
        System.out.println("### " + l2.getNome() + " defendeu o chute de " + l1.getNome() + " ###");        
        System.out.println("");
    }

    public void contraGolpe(Lutador l1, Lutador l2) { // Defende perfeitamente e dá um golpe de 25
        // l1 ataca l2, e l2 se defende e contra-ataca
        l1.setVida(l1.getVida() - 20);
        System.out.println("### " + l2.getNome() + " contra ataca " + l1.getNome() + " ###");        
        System.out.println("");
    }


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

            System.out.println("CASO RPG");
            System.out.println("");
            Random RPG = new Random();            

            do {
                int casos = RPG.nextInt(10);
                switch (casos) {
                    case 0:
                        soco(desafiador, desafiante);
                        break;
                    case 1:
                        soco(desafiante, desafiador);
                        break;
                    case 2:
                        chute(desafiador, desafiante);
                        break;
                    case 3:
                        chute(desafiante, desafiador);
                        break;
                    case 4:
                        defesaSoco(desafiador, desafiante);
                        break;
                    case 5:
                        defesaSoco(desafiante, desafiador);
                        break;
                    case 6:
                        defesaChute(desafiador, desafiante);
                        break;
                    case 7:
                        defesaChute(desafiante, desafiador);
                        break;
                    case 8:
                        contraGolpe(desafiador, desafiante);
                        break;
                    case 9:
                        contraGolpe(desafiante, desafiador);
                        break;
                }

            } while (desafiador.getVida() > 0 && desafiante.getVida() > 0);

            System.out.println("");
            if (desafiante.getVida() <= 0) {
                System.out.println("## VITÓRIA DO DESAFIADOR (" + desafiador.getNome() + ") ##");
                desafiador.ganharLuta();
                desafiante.perderLuta();
                System.out.println("");
            } else if (desafiador.getVida() <= 0) {
                System.out.println("## VITÓRIA DO DESAFIANTE (" + desafiante.getNome() + ") ##");
                desafiador.ganharLuta();
                desafiante.perderLuta();
                System.out.println("");
            }

            System.out.println("VIDA FINAL: " + desafiador.getNome() + " " + desafiador.getVida() + "  X  " + desafiante.getVida() + " " + desafiante.getNome());

        } else { // this.getAprovada() == false;
            System.out.println("## LUTA NÃO MARCADA ##");
        }

    }

}
