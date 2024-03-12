package trabalho_final.kittysanddragons.Entities;
import java.util.ArrayList;
import java.util.List;

public class Classe {

    private String tipoDaClasse;
    protected int forca;
    protected int agilidade;
    protected int inteligencia;
    protected List<Habilidade> habilidades = new ArrayList<>();

    public Classe(int forca, int agilidade, int inteligencia, String tipoDaClasse) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.tipoDaClasse = tipoDaClasse;
    }

    // Métodos para adicionar e remover habilidades
    public void adicionarHabilidade(Habilidade habilidade) {
        this.habilidades.add(habilidade);
    }

    public void removerHabilidade(Habilidade habilidade) {
        this.habilidades.remove(habilidade);
    }

    // Métodos getters
    public int getForca() {
        return this.forca;
    }

    public int getAgilidade() {
        return this.agilidade;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }

    public String getTipoDaClasse() {
        return tipoDaClasse;
    }

    public List<Habilidade> getHabilidades() {
        return this.habilidades;
    }
}


