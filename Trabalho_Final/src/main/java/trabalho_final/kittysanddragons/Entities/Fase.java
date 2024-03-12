package trabalho_final.kittysanddragons.Entities;

import java.util.ArrayList;
import java.util.List;

public class Fase {
    private String descricao;
    private List<Personagem> monstros = new ArrayList<>();
    public Fase(String descricao, List<Personagem> monstros) {
        this.descricao = descricao;
        this.monstros = monstros;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Personagem> getMonstros() {
        return monstros;
    }
}
