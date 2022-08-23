package UltraEmojiCombat_RPG;

public class UltraEmojiCombat { //Classe Principal

    public static void main(String[] args) {       

        // Instância da Classe Luta
        Luta fight = new Luta();

        // Instância da Classe Lutador - Array de 6 Objetos (6 Lutadores)
        // Lutador(nome, Nacionalidade, Idade, Altura, Peso, Vitorias, Derrotas,
        // Empates)
        Lutador[] l = new Lutador[6];

        l[0] = new Lutador("Chief Altair", "França", 31, 1.75, 68.9, 11, 2, 1);

        l[1] = new Lutador("Jack", "Brasil", 29, 1.68, 57.8, 14, 2, 3);

        l[2] = new Lutador("Logan", "EUA", 35, 1.65, 80.9, 12, 2, 1);

        l[3] = new Lutador("Michael", "Austrália", 28, 1.93, 81.6, 13, 0, 2);

        l[4] = new Lutador("Vision", "Brasil", 37, 1.70, 119.3, 5, 4, 3);

        l[5] = new Lutador("Wando", "EUA", 30, 1.81, 105.7, 12, 2, 4);

        fight.marcarLuta(l[0], l[1]);
        fight.lutar(l[0], l[1]);
        //l[0].status();
        //l[0].status();
       
    }
    
}
