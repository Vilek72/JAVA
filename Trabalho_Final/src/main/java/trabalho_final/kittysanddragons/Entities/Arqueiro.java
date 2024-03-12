package trabalho_final.kittysanddragons.Entities;

import java.util.List;
import trabalho_final.kittysanddragons.Entities.Habilidade.*;
public class Arqueiro extends Classe {

    public Arqueiro() {
        super(10, 20, 15, "Arqueiro"); // Inicializa força, agilidade e inteligência

        // Adicione as habilidades do Arqueiro
        Habilidade SocarArqueiro = new SocarArqueiro("SocarArqueiro", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);
        Habilidade AtirarFlecha = new AtirarFlecha("AtirarFlecha", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);
        Habilidade FlechaEncantada = new FlechaEncantada("FlechaEncantada", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);


        this.adicionarHabilidade(SocarArqueiro);
        this.adicionarHabilidade(AtirarFlecha);
        this.adicionarHabilidade(FlechaEncantada);
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        this.habilidades.add(habilidade);
    }
    public void subirDeNivel() {
        this.setForca(this.getForca() + 1);
        this.setAgilidade(this.getAgilidade() + 3);
        this.setInteligencia(this.getInteligencia() + 2);
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




