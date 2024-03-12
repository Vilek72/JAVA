package trabalho_final.kittysanddragons.Entities;
import java.util.ArrayList;
import java.util.List;


public class Equipe {
    private static List<Personagem> personagens = new ArrayList<>();

    public Equipe() {
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        personagens = personagens;
    }

    public void adicionarPersonagem(Personagem personagem) {
        this.personagens.add(personagem);
    }

    public Personagem buscarPersonagem(String nome) {
        for (Personagem personagem : this.personagens) {
            if (personagem.getNome().equals(nome)) {
                return personagem;
            }
        }
        return null;
    }

    public List<Personagem> getEquipe() {
        return this.personagens;
    }

    public void computarPontosExperiencia(Personagem pontos) {
        for (Personagem personagem : this.personagens) {
            personagem.ganharExperiencia(pontos);
        }
    }

    public Personagem proximoAtacante() {
        Personagem proximoAtacante = null;
        int maiorAtaque = -1;

        for (Personagem personagem : this.personagens) {
            if (personagem.getAtaque() > maiorAtaque) {
                maiorAtaque = personagem.getAtaque();
                proximoAtacante = personagem;
            }
        }

        return proximoAtacante;
    }

    public void atualizarTempoEspera() {
        for (Personagem personagem : this.personagens) {
            personagem.setTempoEspera(personagem.getTempoEspera() - 1);
        }
    }
}



