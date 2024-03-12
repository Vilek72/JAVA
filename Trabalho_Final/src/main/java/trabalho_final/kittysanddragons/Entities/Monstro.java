package trabalho_final.kittysanddragons.Entities;
import trabalho_final.kittysanddragons.Entities.Habilidade.*;
public class Monstro extends Classe {

    public Monstro() {
        super(10, 20, 10, "Monstro"); // Inicializa força, agilidade e inteligência

        // Adicione as habilidades do Monstro
        Habilidade SocarMonstro = new SocarMonstro("SocarMonstro", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);
        Habilidade Chutar = new Chutar("Chutar", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);
        Habilidade GritoAtordoante = new GritoAtordoante("GritoAtordoante", new PesosDeAtributos(), new PesosDeAtributos(), 0, false, false);


        this.adicionarHabilidade(SocarMonstro);
        this.adicionarHabilidade(Chutar);
        this.adicionarHabilidade(GritoAtordoante);
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        this.habilidades.add(habilidade);
    }
    public void subirDeNivel() {
        this.setForca(this.getForca() + 4);
        this.setAgilidade(this.getAgilidade() + 1);

    }

    private void setForca(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setAgilidade(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
