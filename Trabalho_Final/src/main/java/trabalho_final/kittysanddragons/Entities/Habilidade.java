package trabalho_final.kittysanddragons.Entities;

import java.util.List;


public class Habilidade {

    static boolean contains(String habilidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String nome;
    private PesosDeAtributos pesosDano, pesosMana;
    private int tempo;
    public boolean afetaTodos;
    public boolean afetaAmigos;
    private static int contador = 0;
    private int ID;
    public int tempoEspera;
    public int danoCausado;
    public int PMNecessario;

    public Habilidade(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
        this.nome = nome;
        this.pesosDano = pesosDano;
        this.pesosMana = pesosMana;
        this.tempo = tempo;
        this.afetaTodos = afetaTodos;
        this.afetaAmigos = afetaAmigos;
        this.ID = contador++;
    }

    // Métodos getters
    public String getNome() {
        return this.nome;
    }

    public PesosDeAtributos getPesosDano() {
        return this.pesosDano;
    }

    public PesosDeAtributos getPesosMana() {
        return this.pesosMana;
    }

    public int getTempo() {
        return this.tempo;
    }

    public boolean isAfetaTodos() {
        return this.afetaTodos;
    }

    public boolean isAfetaAmigos() {
        return this.afetaAmigos;
    }

    public int getID() {
        return this.ID;
    }

    public int getPMNecessario() {
        return this.PMNecessario;
    }

    public void setPMNecessario(int PMNecessario) {
        this.PMNecessario = PMNecessario;

    }
    public void setAfetaTodos(boolean afetaTodos) {
        this.afetaTodos = afetaTodos;
    }
    public String getAfeta() {
        if (this.afetaTodos) {
            return "Todos";
        } else if (this.afetaAmigos) {
            return "Amigos";
        } else {
            return "Inimigos";
        }
    }
    public void setDanoCausado(int danoCausado) {
        this.danoCausado = danoCausado;

    }
    public int getDanoCausado() {
        return this.danoCausado;
    }
    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }
    public int getTempoEspera() {
        return this.tempoEspera;
    }

    public static class AtirarFlecha extends Habilidade {

        public AtirarFlecha(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getForca() * 0.3 + atacante.getAgilidade() * 0.5));
            alvo.registrarDano(dano);
            atacante.setTempoEspera(4);
        }
    }

    public static class SocarArqueiro extends Habilidade {

        public SocarArqueiro(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.1 + atacante.getForca() * 0.3));
            alvo.registrarDano(dano);
            atacante.setTempoEspera(3);
        }
    }

    public static class FlechaEncantada extends Habilidade {
        public FlechaEncantada(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getForca() * 0.3 + atacante.getAgilidade() * 0.5 + atacante.getInteligencia() * 0.4));
            int mana = (int) Math.ceil(atacante.getNivel() * (atacante.getInteligencia() + atacante.getAgilidade() * 0.2));

            if (atacante.getPM() >= mana) {
                alvo.registrarDano(dano);
                atacante.setPM(atacante.getPM() - mana);
                atacante.setTempoEspera(7);
            } else {
                System.out.println("Mana insuficiente para usar Flecha Encantada.");
            }
        }
    }

    public static class SocarGuerreiro extends Habilidade {

        public SocarGuerreiro(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.1 + atacante.getForca() * 0.3));
            alvo.registrarDano(dano);
            atacante.setTempoEspera(4);
        }
    }

    public static class GolpeDeEspada extends Habilidade {

        public GolpeDeEspada(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.3 + atacante.getForca() * 0.7));
            alvo.registrarDano(dano);
            atacante.setTempoEspera(5);
        }
    }

    public static class EspadaFlamejante extends Habilidade {

        public EspadaFlamejante(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getForca() * 0.3 + atacante.getAgilidade() * 0.5 + atacante.getInteligencia() * 0.4));
            int mana = (int) Math.ceil(atacante.getNivel() * (atacante.getInteligencia() + atacante.getForca() * 0.2));

            if (atacante.getPM() >= mana) {
                alvo.registrarDano(dano);
                atacante.setPM(atacante.getPM() - mana);
                atacante.setTempoEspera(7);
            } else {
                System.out.println("Mana insuficiente para usar Espada Flamejante.");
            }
        }
    }

    public static class SocarMago extends Habilidade {
        public SocarMago(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.1 + atacante.getForca() * 0.1));
            alvo.registrarDano(dano);
            atacante.setTempoEspera(2);
        }
    }

    public static class Enfraquecer extends Habilidade {
        public Enfraquecer(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.2 + atacante.getForca() * 0.3 + atacante.getInteligencia() * 0.5));
            int mana = (int) Math.ceil(atacante.getNivel() * atacante.getInteligencia() * 0.5);

            if (atacante.getPM() >= mana) {
                alvo.registrarDano(dano);
                atacante.setPM(atacante.getPM() - mana);
                atacante.setTempoEspera(5);
            } else {
                System.out.println("Pontos de magia insuficientes para usar Enfraquecer.");
            }
        }
    }

    public static class CuraAmigo extends Habilidade {

        public CuraAmigo(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public double calcularDano(Personagem atacante) {
            double dano = Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.5 + atacante.getForca() * 0.3 + atacante.getInteligencia()));
            return dano;
        }

        public double calcularPontosDeMagia(Personagem atacante) {
            double pontosDeMagia = atacante.getNivel() * Math.ceil(atacante.getInteligencia() * 0.7);
            return pontosDeMagia;
        }

    }

    public static class SocarMonstro extends Habilidade {
        public SocarMonstro(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.4 + atacante.getForca() * 0.8));
            alvo.registrarDano(dano);
            atacante.setTempoEspera(5);
        }
    }

    public static class Chutar extends Habilidade {
        public Chutar(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, Personagem alvo) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.5 + atacante.getForca() * 1.0));
            alvo.registrarDano(dano);
            atacante.setTempoEspera(8);
        }
    }

    public static class GritoAtordoante extends Habilidade {
        public GritoAtordoante(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana, int tempo, boolean afetaTodos, boolean afetaAmigos) {
            super(nome, pesosDano, pesosMana, tempo, afetaTodos, afetaAmigos);
        }

        public void usar(Personagem atacante, List<Personagem> alvos) {
            int dano = (int) Math.ceil(atacante.getNivel() * (atacante.getAgilidade() * 0.2 + atacante.getForca() * 0.4));
            for (Personagem alvo : alvos) {
                alvo.registrarDano(dano);
            }
            atacante.setTempoEspera(6);
        }

    }
}
