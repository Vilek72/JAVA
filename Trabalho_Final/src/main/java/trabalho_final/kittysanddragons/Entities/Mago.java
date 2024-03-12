package trabalho_final.kittysanddragons.Entities;
import trabalho_final.kittysanddragons.Entities.Habilidade.*;
public class Mago extends Classe {

    public Mago() {
        super(10, 20, 15, "Mago"); // Inicializa força, agilidade e inteligência

        // Adicione as habilidades do Mago
        Habilidade SocarMago = new SocarMago("SocarMago", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);
        Habilidade Enfraquecer = new Enfraquecer("Enfraquecer", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);
        Habilidade CuraAmigo = new CuraAmigo("CuraAmigo", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);


        this.adicionarHabilidade(SocarMago);
        this.adicionarHabilidade(Enfraquecer);
        this.adicionarHabilidade(CuraAmigo);
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        this.habilidades.add(habilidade);
    }
    public void subirDeNivel() {
        this.setForca(this.getForca() + 1);
        this.setAgilidade(this.getAgilidade() + 2);
        this.setInteligencia(this.getInteligencia() + 3);
    }

    private void setForca(int forca) {
        this.forca = forca;
    }

    private void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    private void setInteligencia(int agilidade) {
        this.inteligencia = agilidade;
    }


}