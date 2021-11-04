package ultraemojicombat;

import java.util.Random;

public class Luta {

    //Atributos da Classe Luta(Encapsulados)
    private Lutador desafiador;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    //NÃO TEM MÉTODO CONSTRUTOR
    
    //Métodos Acessores e Modificadores
    private void setRounds(int rounds) {
        this.rounds = rounds;
    }
    public int getRounds() {
        return this.rounds;
    }
    
    private void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    public boolean getAprovada() {
        return this.aprovada;
    }

    
    //Métodos da Classe Luta
    //"RPG"
    public void soco(Lutador l1, Lutador l2) { //Soco tira 10 de vida
        //l1 socou l2
        l2.setVida(l2.getVida() -70);
        System.out.println("###");
        System.out.println(l1 + " socou " + l2);
        System.out.println("###");
    }

    public void chute(Lutador l1, Lutador l2) { //Chute tira 20 de vida
        //l1 chutou l2
        l2.setVida(l2.getVida() - 80);
        System.out.println("###");
        System.out.println(l1 + " chutou " + l2);
        System.out.println("###");
    }

    public void defesaSoco(Lutador l1, Lutador l2) { //Defende metade do soco
        //l2 se defende de l1
        l2.setVida(l2.getVida() - 35);
        System.out.println("###");
        System.out.println(l2 + " defendeu o chute de " + l1);
        System.out.println("###");
    }
    
    public void defesaChute(Lutador l1, Lutador l2) { //Defende metade do chute 
        //l2 se defende de l1
        l2.setVida(l2.getVida() - 40);
        System.out.println("###");
        System.out.println(l2 + " defendeu o chute de " + l1);
        System.out.println("###");
    }

    public void contraGolpe(Lutador l1, Lutador l2) { //Defende perfeitamente e dá um golpe de 25
        //l1 ataca l2, e l2 se defende e contra-ataca
        l1.setVida(l1.getVida() - 25);
        System.out.println("###");
        System.out.println(l2 + " contra ataca " + l1);
        System.out.println("###");
    }

    
    
    //$$ ESSE MÉTODO SÓ PODE SER USADO EM CASO DE CONFIRMAÇÃO DA LUTA $$
    public void criterios(Lutador desafiador, Lutador desafiante) {

        //****** CRITÉRIO: NÚMERO DE PARTIDAS (EXPERIÊNCIA) ******
        if (desafiador.getPartidas() > desafiante.getPartidas()) {
            desafiador.setPontos(desafiador.getPontos() + 1);
        } else if (desafiante.getPartidas() > desafiador.getPartidas()) {
            desafiante.setPontos(desafiante.getPontos() + 1);
        } else { //Caso lutadores possuam mesmo número de Partidas...
            //CRITÉRIO: NÚMERO DE VITÓRIAS
            if (desafiador.getVitorias() > desafiante.getVitorias()) {
                desafiador.setPontos(desafiador.getPontos() + 1);
            } else if (desafiante.getVitorias() > desafiador.getVitorias()) {
                desafiante.setPontos(desafiante.getPontos() + 1);
            } else { // Caso lutadores possuam mesmo número de Vitórias...
                //CRITÉRIO: NÚMERO DE DERROTAS
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
            //CRITÉRIO: PESAGEM
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

            //O programa vai escolher se a Luta terá um Resultado Lógico ou Aleatório
            Random gerador = new Random();
            int escolha = gerador.nextInt(3); //0 1 2
            switch (escolha) {
                case 0: //CASO LÓGICO (PONTOS)
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
                    break;

                case 1: //CASO ALEATÓRIO (SIMULAÇÃO)
                    System.out.println("CASO ALEATÓRIO (SIMULAÇÃO)");
                    Random aleatorio = new Random();
                    int vencedor = aleatorio.nextInt(3); //0 1 2
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
                    
                case 2: //CASO RPG
                    System.out.println("CASO RPG");
                    Random RPG = new Random();
                    int casos = RPG.nextInt(10); //
                   
                    do {                                    
                    switch(casos) {
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
                    
                } while(desafiador.getVida() == 0 || desafiante.getVida() == 0);
                    if (desafiante.getVida() == 0) {
                        System.out.println("## VITÓRIA DO DESAFIADOR (" + desafiador.getNome() + ") ##");
                    } else if (desafiador.getVida() == 0) {
                        System.out.println("## VITÓRIA DO DESAFIANTE (" + desafiante.getNome() + ") ##");
                    }                   
            }

        } else { //this.getAprovada() == false;
            System.out.println("## LUTA NÃO MARCADA ##");
        }
        
    }

}
