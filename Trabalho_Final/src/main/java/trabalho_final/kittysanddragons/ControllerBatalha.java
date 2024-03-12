package trabalho_final.kittysanddragons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import trabalho_final.kittysanddragons.Application.Arena;
import trabalho_final.kittysanddragons.Application.Batalha;
import trabalho_final.kittysanddragons.Entities.Fase;
import trabalho_final.kittysanddragons.Entities.Monstro;
import trabalho_final.kittysanddragons.Entities.Personagem;

import java.net.URL;
import java.util.*;

public class ControllerBatalha implements Initializable {

    private int indiceDaOrdemDeAtaque = 1;
    private static List<Personagem> herois = new ArrayList<>();
    private List<Personagem> monstros = new ArrayList<>();
    private List<Image> imagesHerois = new ArrayList<>();

    private List<Image> imagesMonstros = new ArrayList<>();

    @FXML
    private Button buttonNextFase;

    @FXML
    private ImageView heroiTres;

    @FXML
    private ImageView heroiDois;

    @FXML
    private ImageView heroiUm;

    @FXML
    private ImageView monstroDois;

    @FXML
    private ImageView monstroTres;

    @FXML
    private ImageView monstroUm;

    @FXML
    private Label infoHeroiDois;

    @FXML
    private Label infoHeroiTres;

    @FXML
    private Label infoHeroiUm;

    @FXML
    private Label infoMonstroDois;

    @FXML
    private Label infoMonstroTres;

    @FXML
    private Label infoMonstroUm;


    @FXML
    void buttonNextFaseHoverIn(MouseEvent event) {

    }

    @FXML
    void buttonNextFaseHoverOut(MouseEvent event) {

    }

    @FXML
    void eventNextFase(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonNextFase.setVisible(false);
        herois = Arena.getHerois();
        herois.forEach(heroi -> {
            switch (heroi.getClasse().getTipoDaClasse()) {
                case "Guerreiro":
                    imagesHerois.add(new Image(getClass().getResourceAsStream("/files/images/Guerreiro.PNG")));
                    break;
                case "Arqueiro":
                    imagesHerois.add(new Image(getClass().getResourceAsStream("/files/images/Arqueiro.PNG")));
                    break;
                case "Mago":
                    imagesHerois.add(new Image(getClass().getResourceAsStream("/files/images/Mago.PNG")));
                    break;
            }
        });
        heroiUm.setImage(imagesHerois.get(0));
        heroiDois.setImage(imagesHerois.get(1));
        heroiTres.setImage(imagesHerois.get(2));
        Arena arena = new Arena();
        arena.getFases().get(ControllerSelection.getIndiceFase()).getMonstros().forEach(monstro -> {
            switch (monstro.getNome()) {
                case "MonstroTucana":
                    imagesMonstros.add(new Image(getClass().getResourceAsStream("/files/images/MonstroTucana.PNG")));
                    break;
                case "MonstroCalvo":
                    imagesMonstros.add(new Image(getClass().getResourceAsStream("/files/images/MonstroCalvo.PNG")));
                    break;
                case "MonstroVilek":
                    imagesMonstros.add(new Image(getClass().getResourceAsStream("/files/images/MonstroVilek.PNG")));
                    break;
                case "MonstroSnape":
                    imagesMonstros.add(new Image(getClass().getResourceAsStream("/files/images/MonstroSnape.PNG")));
                    break;
            }
        });
        System.out.println(imagesMonstros.size());
        switch (imagesMonstros.size()) {
            case 1:
                monstroUm.setImage(imagesMonstros.get(0));
                break;
            case 2:
                monstroUm.setImage(imagesMonstros.get(0));
                monstroDois.setImage(imagesMonstros.get(0));

                break;
            case 3:
                monstroUm.setImage(imagesMonstros.get(0));
                monstroDois.setImage(imagesMonstros.get(0));
                monstroTres.setImage(imagesMonstros.get(0));
                break;
        }
        mostrarDadosHerois();
        mostrarDadosMonstros();
        //sortearOrdemDeAtaque();
        //Batalha batalha = new Batalha();
        //batalha.iniciarBatalha();
    }

    public void mostrarDadosHerois() {
        Personagem heroi = herois.get(0);
        infoHeroiUm.setText("Nome: " + heroi.getNome() + "  Classe: " + heroi.getClasse().getTipoDaClasse() + "   Vida: " + heroi.getPV() + "   Magia: " + heroi.getPM() + "   Nvl: " + heroi.getNivel() + "   TE: " + heroi.getTempoEspera());
        heroi = herois.get(1);
        infoHeroiDois.setText("Nome: " + heroi.getNome() + "  Classe: " + heroi.getClasse().getTipoDaClasse() + "   Vida: " + heroi.getPV() + "   Magia: " + heroi.getPM() + "   Nvl: " + heroi.getNivel() + "   TE: " + heroi.getTempoEspera());
        heroi = herois.get(2);
        infoHeroiTres.setText("Nome: " + heroi.getNome() + "  Classe: " + heroi.getClasse().getTipoDaClasse() + "   Vida: " + heroi.getPV() + "   Magia: " + heroi.getPM() + "   Nvl: " + heroi.getNivel() + "   TE: " + heroi.getTempoEspera());
    }

    public void mostrarDadosMonstros() {
        int indiceFaseAtual = ControllerSelection.getIndiceFase();
        Arena arena = new Arena();
        List<Fase> fases = arena.getFases();
        monstros = fases.get(indiceFaseAtual).getMonstros();
        System.out.println(monstros.size());
        switch (monstros.size()) {
            case 1:
                infoMonstroUm.setText("Nome: " + monstros.get(0).getNome() + "  Classe: " + monstros.get(0).getClasse().getTipoDaClasse() + "   Vida: " + monstros.get(0).getPV() + "   Magia: " + monstros.get(0).getPM() + "   Nvl: " + monstros.get(0).getNivel() + "   TE: " + monstros.get(0).getTempoEspera());
                break;
            case 2:
                infoMonstroDois.setText("Nome: " + monstros.get(1).getNome() + "  Classe: " + monstros.get(1).getClasse().getTipoDaClasse() + "   Vida: " + monstros.get(1).getPV() + "   Magia: " + monstros.get(1).getPM() + "   Nvl: " + monstros.get(1).getNivel() + "   TE: " + monstros.get(1).getTempoEspera());
                break;
            case 3:
                infoMonstroTres.setText("Nome: " + monstros.get(2).getNome() + "  Classe: " + monstros.get(2).getClasse().getTipoDaClasse() + "   Vida: " + monstros.get(2).getPV() + "   Magia: " + monstros.get(2).getPM() + "   Nvl: " + monstros.get(2).getNivel() + "   TE: " + monstros.get(2).getTempoEspera());
                break;
        }
    }

    /*public void sortearOrdemDeAtaque() {

        Random random = new Random();

        // Gera uma lista de números aleatórios sem repetição
        ArrayList<Integer> numerosSorteados = gerarNumerosAleatorios(monstros.size() + herois.size());

        // Itera pelos ArrayLists e adiciona a ordem de ataque
        int indiceNumero = 0;
        for (Personagem personagem1 : herois) {
            personagem1.setOrdemDeAtaque(numerosSorteados.get(indiceNumero++));
        }
        for (Personagem personagem2 : monstros) {
            personagem2.setOrdemDeAtaque(numerosSorteados.get(indiceNumero++));
        }
    }

    private static ArrayList<Integer> gerarNumerosAleatorios(int quantidade) {
        ArrayList<Integer> numerosSorteados = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            numerosSorteados.add(i + 1);
        }
        Collections.shuffle(numerosSorteados);
        return numerosSorteados;
    }

    public void começarBatalha() {
        while(verificaVidaDosMonstros() && verificaVidaDosHerois()) {
            verificaQuemAtaca();
        }
    }

    public Personagem verificaQuemAtaca() {
        int quantidadeDePersonagens = monstros.size() + herois.size();
        for (Personagem heroi: herois) {
            if (heroi.getOrdemDeAtaque() == indiceDaOrdemDeAtaque) {
                heroi.setOrdemDeAtaque(heroi.getOrdemDeAtaque() + (quantidadeDePersonagens));
                return heroi;
            }
        }
        for (Personagem monstro: monstros) {
            if (monstro.getOrdemDeAtaque() == indiceDaOrdemDeAtaque) {
                monstro.setOrdemDeAtaque(monstro.getOrdemDeAtaque() + (quantidadeDePersonagens));
                return monstro;
            }
        }
        indiceDaOrdemDeAtaque++;
        return null;
    }
    public void Atacar() {}

    public boolean verificaVidaDosMonstros() {
        int monstrosSemVida = 0;
        for (Personagem monstro: monstros) {
            if (monstro.getPV() == 0) {
                monstrosSemVida += 1;
            }
        }
        if (monstrosSemVida == monstros.size()){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean verificaVidaDosHerois() {
        int heroisSemVida = 0;
        for (Personagem heroi: herois) {
            if (heroi.getPV() == 0) {
                heroisSemVida += 1;
            }
        }
        if (heroisSemVida == herois.size()){
            return false;
        }
        else{
            return true;
        }
    }*/
}
