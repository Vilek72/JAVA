package trabalho_final.kittysanddragons.Entities;

public class PesosDeAtributos {
    private float pesoForca;
    private float pesoAgilidade;
    private float pesoInteligencia;

    public PesosDeAtributos(float pesoForca, float pesoAgilidade, float pesoInteligencia) {
        this.pesoForca = pesoForca;
        this.pesoAgilidade = pesoAgilidade;
        this.pesoInteligencia = pesoInteligencia;
    }

    PesosDeAtributos() {
        this.pesoForca = 0.0f;
        this.pesoAgilidade = 0.0f;
        this.pesoInteligencia = 0.0f;
    }

    // Métodos getters
    public float getPesoForca() {
        return this.pesoForca;
    }

    public float getPesoAgilidade() {
        return this.pesoAgilidade;
    }

    public float getPesoInteligencia() {
        return this.pesoInteligencia;
    }

}
