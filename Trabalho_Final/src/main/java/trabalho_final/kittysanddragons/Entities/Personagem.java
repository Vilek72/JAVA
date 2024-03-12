package trabalho_final.kittysanddragons.Entities;
import trabalho_final.kittysanddragons.Entities.Habilidade.*;

import java.util.ArrayList;
import java.util.List;


public class Personagem {
    public String nome;
    public int nivel, PE;
    public float PV, PM;
    public int tempoEspera;
    public Classe classe;
    public static int contador = 0;
    public int ID;
    public Habilidade habilidade;
    public int ataque;
    private int ordemDeAtaque = 0;

    public Personagem(String nome, Classe classe, int nivel) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.PE = 0;
        this.PV = 10;
        this.PM = 10;
        this.tempoEspera = 0;
        this.ID = contador++;
        this.ataque = 0;
        this.habilidade = null;
    }


    public void ganharExperiencia(int pontos, Personagem inimigo) {
        //PE += nível do adversário derrotado * 5
        this.PE += inimigo.getNivel() * pontos;
        if (this.PE >= this.nivel * 25) {
            subirDeNivel();
            this.PE = 0;
        }
    }

    public void atacar(Personagem inimigo) {
        // Seu código aqui. Por exemplo:
        int dano = this.getAtaque();
        inimigo.setPV(inimigo.getPV() - dano);
    }


    public void curarAmigo(Personagem alvo) {
        if (habilidade != null && habilidade instanceof CuraAmigo) {
            // Cura o alvo escolhido
            ((CuraAmigo) habilidade).calcularDano(alvo);
        } else {
            System.out.println("Este personagem não tem a habilidade de curar amigo.");
        }
    }

    public void registrarDano(float dano) {
        this.PV -= dano;
    }
    public float calcularPVMax() {
        //PVmax = nível * força + (nível * agilidade/2)

        return this.nivel * this.classe.getForca() + (this.nivel * this.classe.getAgilidade() / 2);
    }

    public void ganharExperiencia(Personagem adversario) {
        this.PE += adversario.getNivel() * 5;
        if (this.PE >= this.nivel * 25) {
            this.subirDeNivel();
        }
    }
    public float calcularPMMax() {
        //PMmax = nível * inteligência + (nível * agilidade/3)
        return this.nivel * this.classe.getInteligencia() + (this.nivel * this.classe.getAgilidade() / 3);
    }


    public void subirDeNivel() {
        this.nivel++;
        this.PE = 0;
    }

    public double getNivel() {
        return this.nivel;
    }

    public double getAgilidade() {
        return this.classe.getAgilidade();
    }

    public double getForca() {
        return this.classe.getForca();
    }

    public int getTempoEspera(){
        return this.tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public float getPM() {
        return (float) this.PM;
    }

    public void setOrdemDeAtaque(int ordemDeAtaque) {
        this.ordemDeAtaque = ordemDeAtaque;
    }

    public void setPM(float PM) {
        this.PM = PM;
    }

    public double getInteligencia() {
        return this.classe.getInteligencia();
    }

    public String getNome() {
        return this.nome;
    }

    public int getOrdemDeAtaque() {
        return ordemDeAtaque;
    }

    public float getPV() {
        return this.PV;
    }
    public void setPV(float PV) {
        this.PV = PV;
    }
    public void setPE(int PE) {
        this.PE = PE;
    }
    public int getPE() {
        return this.PE;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getAtaque() {
        return this.ataque;
    }
    public Classe getClasse() {
        return this.classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Habilidade getHabilidade() {
        return this.habilidade;
    }
    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void getNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void reduzEspera() {
        this.tempoEspera = 0;
    }



  /*  public double curarAmigo() {
        if (habilidade != null && habilidade instanceof CuraAmigo) {
            double dano = ((CuraAmigo) habilidade).calcularDano(this);
           // double pontosDeMagia = ((CuraAmigo) habilidade).calcularPontosDeMagia(this);
            // Aqui você pode usar os valores de dano e pontosDeMagia como desejar
            // Por exemplo, você pode retornar o dano
            return dano;
        } else {
            System.out.println("Este personagem não tem a habilidade de curar amigo.");
            return 0;
        }
    }*/

    public static class Heroi extends Personagem {
        public int experiencia;

        public Heroi(String nome, Classe classe, int nivel) {
            super(nome, classe, nivel);
            this.experiencia = 0;
        }

        public void ganharExperiencia(int pontos, Personagem inimigo) {
            super.ganharExperiencia(pontos, inimigo);
            this.experiencia += pontos;
        }

        public int getExperiencia() {
            return this.experiencia;
        }
    }

    public static class Inimigo extends Personagem {

        public Inimigo(String nome,Classe classe, int nivel) {
            super(nome, classe, nivel);
            this.nome = nome;
            this.classe = classe; // Supondo que Monstro é uma subclasse de Classe
            this.nivel = nivel;
        }

        public int enemyLevel;

        public int getEnemyLevel() {
            return this.enemyLevel;
        }

        public void setEnemyLevel(int enemyLevel) {
            this.enemyLevel = enemyLevel;
        }


    }

    public Habilidade[] getHabilidades() {
        List<Habilidade> habilidades = new ArrayList<>();
        return habilidades.toArray(new Habilidade[0]);
    }

}