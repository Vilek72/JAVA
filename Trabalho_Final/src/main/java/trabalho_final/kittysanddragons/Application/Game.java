package trabalho_final.kittysanddragons.Application;

import trabalho_final.kittysanddragons.Entities.Fase;
import trabalho_final.kittysanddragons.Entities.Monstro;
import trabalho_final.kittysanddragons.Entities.Personagem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Fase> lerArquivo() {
        List<Fase> fases = new ArrayList<>();
        List<Personagem> monstros = new ArrayList<>();
        String descricaoFase = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/game/game.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] palavras = linha.split("\\s+");
                if (palavras.length > 0 && palavras[0].equals("fase")) {
                    descricaoFase = linha.substring(5).trim();
                    if (!monstros.isEmpty()) {
                        Fase fase = new Fase(descricaoFase, new ArrayList<>(monstros));
                        fases.add(fase);
                        monstros.clear();
                    }
                    monstros = new ArrayList<>();
                } else {
                    Personagem monstro = new Personagem(palavras[0], new Monstro(), Integer.parseInt(palavras[2]));
                    monstros.add(monstro);
                }
            }

            // Adiciona a última fase, se houver monstros
            if (monstros != null) {
                Fase fase = new Fase(descricaoFase, new ArrayList<>(monstros));
                fases.add(fase);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fases;
    }
}