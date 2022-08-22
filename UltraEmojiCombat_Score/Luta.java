package UltraEmojiCombat_Score;

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
    
    public void criterios(Lutador desafiador, Lutador desafiante) {
        desafiador.setPontos(0);
        desafiante.setPontos(0);

        //****** CRITÉRIO: NÚMERO DE PARTIDAS (EXPERIÊNCIA) ******
        if (desafiador.getPartidas() > desafiante.getPartidas()) {
            desafiador.setPontos(desafiador.getPontos() + 1);
        } else if (desafiante.getPartidas() > desafiador.getPartidas()) {
            desafiante.setPontos(desafiante.getPontos() + 1);
        } else { //Caso lutadores possuam mesmo número de Partidas...
            //CRITÉRIO DESEMPATE: NÚMERO DE VITÓRIAS
            if (desafiador.getVitorias() > desafiante.getVitorias()) {
                desafiador.setPontos(desafiador.getPontos() + 1);
            } else if (desafiante.getVitorias() > desafiador.getVitorias()) {
                desafiante.setPontos(desafiante.getPontos() + 1);
            } else { // Caso lutadores possuam mesmo número de Vitórias...
                //CRITÉRIO DESEMPATE: NÚMERO DE DERROTAS
                if (desafiador.getDerrotas() > desafiante.getDerrotas()) {
                    desafiador.setPontos(desafiador.getPontos() - 1);
                } else if (desafiante.getDerrotas() > desafiador.getDerrotas()) {
                    desafiante.setPontos(desafiante.getPontos() - 1);
                } else {
                    //Ambos NÃO PONTUAM
                }
            }
        }
        //****** CRITÉRIO: ALTURA ******
        if (desafiador.getAltura() > desafiante.getAltura()) {
            desafiador.setPontos(desafiador.getPontos() + 1);
        } else if (desafiante.getAltura() > desafiador.getAltura()) {
            desafiante.setPontos(desafiante.getPontos() + 1);
        } else { //Caso lutadores possuam mesma altura...
            //CRITÉRIO DESEMPATE: PESAGEM
            if (desafiador.getPeso() > desafiante.getPeso()) {
                desafiador.setPontos(desafiador.getPontos() + 1);
            } else if (desafiante.getPeso() > desafiador.getPeso()) {
                desafiante.setPontos(desafiante.getPontos() + 1);
            } else {
                //Ambos NÃO PONTUAM
            }
        }
        //****** CRITÉRIO: IDADE ******
        if (desafiador.getIdade() > 30 && desafiador.getIdade() < 40) {
            desafiador.setPontos(desafiador.getPontos() + 1);
        }
        if (desafiante.getIdade() > 30 && desafiante.getIdade() < 40) {
            desafiante.setPontos(desafiante.getPontos() + 1);
        }
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

            // CASO LÓGICO (PONTOS)
            System.out.println("CASO LÓGICO (PONTOS)");
            criterios(desafiador, desafiante);
            if (desafiador.getPontos() > desafiante.getPontos()) {
                System.out.println("## VITÓRIA DO DESAFIADOR (" + desafiador.getNome() + ") ##");                
                desafiador.ganharLuta();
                desafiante.perderLuta();
            } else if (desafiante.getPontos() > desafiador.getPontos()) {
                System.out.println("## VITÓRIA DO DESAFIANTE (" + desafiante.getNome() + ") ##");                
                desafiador.perderLuta();
                desafiante.ganharLuta();
            } else {
                System.out.println("## EMPATE ##");
                desafiador.empatarLuta();
                desafiante.empatarLuta();
            }
            System.out.println("PONTUAÇÃO: " + desafiador.getNome() + " " + desafiador.getPontos() + "  X  " + desafiante.getPontos() + " " + desafiante.getNome());

        } else { // this.getAprovada() == false;
            System.out.println("## LUTA NÃO MARCADA ##");
        }

    }
}
