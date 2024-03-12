package trabalho_final.kittysanddragons.Entities;
import trabalho_final.kittysanddragons.Entities.Habilidade.*;
public class Guerreiro extends Classe {

    public Guerreiro() {
        super(10, 5, 5, "Guerreiro"); // Inicializa força, agilidade e inteligência

        // Adicione as habilidades do Guerreiro
        Habilidade SocarGuerreiro = new SocarGuerreiro("SocarGuerreiro", new PesosDeAtributos(), new PesosDeAtributos(), 4, false, false);
        Habilidade GolpeDeEspada = new GolpeDeEspada("GolpeDeEspada", new PesosDeAtributos(), new PesosDeAtributos(), 5, false, false);
        Habilidade EspadaFlamejante = new EspadaFlamejante("EspadaFlamejante", new PesosDeAtributos(), new PesosDeAtributos(), 7, false, false);

        this.adicionarHabilidade(SocarGuerreiro);
        this.adicionarHabilidade(GolpeDeEspada);
        this.adicionarHabilidade(EspadaFlamejante);
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        this.habilidades.add(habilidade);
    }

    public void subirDeNivel() {
        this.setForca(this.getForca() + 4);
        this.setAgilidade(this.getAgilidade() + 1);
        this.setInteligencia(this.getInteligencia() + 1);
    }

    private void setForca(int forca) {
        this.forca = forca;
    }

    private void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    private void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
}

