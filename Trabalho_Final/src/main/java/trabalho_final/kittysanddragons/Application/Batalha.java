package trabalho_final.kittysanddragons.Application;

import trabalho_final.kittysanddragons.ControllerDescription;
import trabalho_final.kittysanddragons.ControllerSelection;
import trabalho_final.kittysanddragons.Entities.Equipe;
import trabalho_final.kittysanddragons.Entities.Personagem;
import trabalho_final.kittysanddragons.Entities.Habilidade;
import trabalho_final.kittysanddragons.HelloApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Batalha {
    public void iniciarBatalha(){
        Arena arena = new Arena();
        Equipe time1 = new Equipe();
        time1.setPersonagens(arena.getFases().get(ControllerSelection.getIndiceFase()).getMonstros());
        Equipe time2 = new Equipe();
        time2.setPersonagens(Arena.getHerois());

        separarHeroisEMonstros(time1, time2);
        System.out.println("Informações do Time 1:");

        System.out.println("Informações do Time 2:");


        // Definir tempo de espera inicial como zero para todos os personagens
        definirTempoEsperaInicial(time1);
        definirTempoEsperaInicial(time2);

        // Sortear qual personagem ataca primeiro
        Personagem primeiroPersonagem = sortearPersonagem(time1, time2);
        System.out.println("O personagem " + primeiroPersonagem.getNome() + " ataca primeiro!");

        // Iniciar batalha
        boolean batalhaEmAndamento = true;

        while (batalhaEmAndamento) {
            // Verificar se algum personagem pode atacar
            boolean algumPersonagemPodeAtacar = false;
            for (Personagem personagem : time1.getPersonagens()) {
                if (personagem.getTempoEspera() == 0) {
                    algumPersonagemPodeAtacar = true;
                    break;
                }
            }
            for (Personagem personagem : time2.getPersonagens()) {
                if (personagem.getTempoEspera() == 0) {
                    algumPersonagemPodeAtacar = true;
                    break;
                }
            }

            if (algumPersonagemPodeAtacar) {
                // Ordenar personagens por tempo de espera
                List<Personagem> personagensOrdenados = new ArrayList<>();
                personagensOrdenados.addAll(time1.getPersonagens());
                personagensOrdenados.addAll(time2.getPersonagens());
                personagensOrdenados.sort(Comparator.comparingInt(Personagem::getTempoEspera));

                // Selecionar primeiro personagem que pode atacar
                Personagem personagemAtacante = null;
                for (Personagem personagem : personagensOrdenados) {
                    if (personagem.getTempoEspera() == 0) {
                        personagemAtacante = personagem;
                        break;
                    }
                }

                // Exibir informações do personagem atacante
                System.out.println("Personagem atacante: " + personagemAtacante.getNome());
                System.out.println("Habilidades:");
                for (Habilidade habilidade : personagemAtacante.getHabilidades()) {
                    System.out.println("Nome: " + habilidade.getNome());
                    System.out.println("PM necessário: " + habilidade.getPMNecessario());
                    System.out.println("Dano causado: " + habilidade.getDanoCausado());
                    System.out.println("Tempo de espera: " + habilidade.getTempoEspera());
                    System.out.println("Afeta: " + habilidade.getAfeta());
                    System.out.println("------------------------");
                }

                // Selecionar habilidade a ser usada
                Habilidade habilidadeSelecionada = null;
                // Implementar lógica para selecionar habilidade
                Scanner scanner = new Scanner(System.in);
                System.out.println("Selecione a habilidade a ser usada:");
                int habilidadeIndex = scanner.nextInt();

                // Verificar se o índice da habilidade é válido
                if (habilidadeIndex >= 0 && habilidadeIndex < personagemAtacante.getHabilidades().length) {
                    habilidadeSelecionada = personagemAtacante.getHabilidades()[habilidadeIndex];
                } else {
                    System.out.println("Índice de habilidade inválido. Tente novamente.");
                    continue;
                }
                scanner.close();
                // Atualizar tempo de espera do personagem atacante
                personagemAtacante.setTempoEspera(habilidadeSelecionada.getTempoEspera());

                // Realizar ataque
                // Selecionar personagem alvo
                Personagem personagemAlvo = null;
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Selecione o personagem alvo:");
                int personagemAlvoIndex = scanner2.nextInt();

                // Verificar se o índice do personagem alvo é válido
                if (personagemAlvoIndex >= 0 && personagemAlvoIndex < personagensOrdenados.size()) {
                    personagemAlvo = personagensOrdenados.get(personagemAlvoIndex);
                } else {
                    System.out.println("Índice de personagem alvo inválido. Tente novamente.");
                    continue;
                }
                scanner2.close();

                // Realizar ataque
                personagemAtacante.atacar(personagemAlvo);

                // Verificar se a batalha terminou
                boolean time1Venceu = true;
                boolean time2Venceu = true;
                for (Personagem personagem : time1.getPersonagens()) {
                    if (personagem.getPV() > 0) {
                        time2Venceu = false;
                        break;
                    }
                }
                for (Personagem personagem : time2.getPersonagens()) {
                    if (personagem.getPV() > 0) {
                        time1Venceu = false;
                        break;
                    }
                }
                if (time1Venceu || time2Venceu) {
                    batalhaEmAndamento = false;
                    ControllerSelection.proximaFase();
                }

                // Calcular pontos de experiência para cada personagem do time vencedor
                if (time1Venceu) {
                    for (Personagem personagem : time1.getPersonagens()) {
                        if (personagem.getPV() > 0) {
                            double nivel = personagem.getNivel();
                            int pontosExperiencia = (int) nivel * 5;
                            personagem.setPE(personagem.getPE() + pontosExperiencia);
                        }
                    }
                } else if (time2Venceu) {
                    for (Personagem personagem : time2.getPersonagens()) {
                        if (personagem.getPV() > 0) {
                            double nivel = personagem.getNivel();
                            int pontosExperiencia = (int) nivel * 5;
                            personagem.setPE(personagem.getPE() + pontosExperiencia);
                        }
                    }
                }
            } else {
                // Reduzir tempo de espera de todos os personagens
                for (Personagem personagem : time1.getPersonagens()) {
                    personagem.setTempoEspera(personagem.getTempoEspera() - 1);
                }
                for (Personagem personagem : time2.getPersonagens()) {
                    personagem.setTempoEspera(personagem.getTempoEspera() - 1);
                }
            }
        }
    }

    private void separarHeroisEMonstros(Equipe time1, Equipe time2) {
        List<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(time1.getPersonagens());
        todosPersonagens.addAll(time2.getPersonagens());

        List<Personagem> herois = new ArrayList<>();
        List<Personagem> monstros = new ArrayList<>();

        for (Personagem personagem : todosPersonagens) {
            if (personagem.getClasse().equals("heroi")) {
                herois.add(personagem);
            } else if (personagem.getClasse().equals("monstro")) {
                monstros.add(personagem);
            }
        }

        time1.setPersonagens(herois);
        time2.setPersonagens(monstros);
    }


    private void exibirInformacoesTime(Equipe time) {
        for (Personagem personagem : time.getPersonagens()) {
            System.out.println("ID: " + personagem.getID());
            System.out.println("Nome: " + personagem.getNome());
            System.out.println("Classe: " + personagem.getClasse());
            System.out.println("PV: " + personagem.getPV());
            System.out.println("PM: " + personagem.getPM());
            System.out.println("Nível: " + personagem.getNivel());
            System.out.println("Tempo de Espera: " + personagem.getTempoEspera());
            System.out.println("------------------------");
        }
    }
    private void definirTempoEsperaInicial(Equipe time) {
        for (Personagem personagem : time.getPersonagens()) {
            personagem.setTempoEspera(0);
        }
    }
    private Personagem sortearPersonagem(Equipe time1, Equipe time2) {
        List<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(time1.getPersonagens());
        todosPersonagens.addAll(time2.getPersonagens());

        todosPersonagens.sort(Comparator.comparingInt(Personagem::getTempoEspera));

        return todosPersonagens.get(0);
    }
}