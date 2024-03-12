package trabalho_final.kittysanddragons.Application;

import trabalho_final.kittysanddragons.Entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arena {

    private static ArrayList<Personagem> herois = new ArrayList<>();

    private static List<Fase> fases = new ArrayList<>();

    public void criarHeroi(String tipoDeClasse, String nome){
        switch (tipoDeClasse) {
            case "Guerreiro":
                Guerreiro novoGuerreiro = new Guerreiro();
                Personagem novoPersonagemGuerreiro = new Personagem(nome, novoGuerreiro, 1);
                herois.add(novoPersonagemGuerreiro );
                break;
            case "Mago":
                Mago novoMago = new Mago();
                Personagem novoPersonagemMago = new Personagem(nome, novoMago, 1);
                herois.add(novoPersonagemMago);
                break;
            case "Arqueiro":
                Arqueiro novoArqueiro = new Arqueiro();
                Personagem novoPersonagemArqueiro = new Personagem(nome, novoArqueiro, 1);
                herois.add(novoPersonagemArqueiro);
                break;
            default:
                System.out.println("Classe inválida");
        }
    }

    public void debuggPrint () {
        int i = 1;
        for (Personagem personagem: herois) {
            System.out.println(personagem.getNome() + "\t" + personagem.getClasse());
            System.out.println(i);
            i+=1;
        }
    }

    public void iniciarJogo() {
        Game game = new Game();
        fases = game.lerArquivo();
        fases.remove(fases.size() - 1);
        fases.forEach(fase -> {
            System.out.println("Fase: " + fase.getDescricao());
            System.out.print("Monstros: ");
            fase.getMonstros().forEach(monstro -> {
                System.out.print(monstro.getNome() + "   ");
            });
            System.out.println();
        });
    }

    public List<Fase> getFases() {
        return fases;
    }

    public static ArrayList<Personagem> getHerois() {
        return herois;
    }
}
