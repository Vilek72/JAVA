package trabalho_final.kittysanddragons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import trabalho_final.kittysanddragons.Application.Arena;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDescription implements Initializable {


    private boolean VisibilityNameArcher;
    private boolean VisibilityNameMage;
    private boolean VisibilityNameWarrior;

    private int quantidadePersonagens = 0;

    private String classe;

    @FXML
    private Button buttonGo;

    @FXML
    private Button buttonSave;

    @FXML
    private TextField textNameArcher;

    @FXML
    private TextField textNameMage;

    @FXML
    private TextField textNameWarrior;

    @FXML
    void buttonGoHoverIn(MouseEvent event) {
        buttonSave.setStyle("-fx-background-color:  #f7bea3; -fx-background-radius: 100; -fx-font-weight: bold");
    }

    @FXML
    void buttonGoHoverOut(MouseEvent event) {
        buttonSave.setStyle("-fx-background-color:  #f7bea3; -fx-background-radius: 100; -fx-font-weight: bold");
    }

    @FXML
    void buttonSaveHoverIn(MouseEvent event) {
        buttonSave.setStyle("-fx-background-color: #f8a8a7; -fx-background-radius: 100; -fx-font-weight: bold");
    }

    @FXML
    void buttonSaveHoverOut(MouseEvent event) {
        buttonSave.setStyle("-fx-background-color:  #f7bea3; -fx-background-radius: 100; -fx-font-weight: bold");
    }

    @FXML
    void eventGo(ActionEvent event) throws IOException {
        Arena arena = new Arena();
        arena.iniciarJogo();
        HelloApplication.changeScene("selection-view.fxml", event);
    }

    @FXML
    void eventSave(ActionEvent event) {
        if (quantidadePersonagens < 3) {
            if (quantidadePersonagens == 2){
                buttonSave.setVisible(false);
                buttonGo.setVisible(true);
            }
            Arena novaArena = new Arena();
            switch (classe){
                case "Guerreiro":
                    novaArena.criarHeroi("Guerreiro", textNameWarrior.getText());
                    break;
                case "Mago":
                    novaArena.criarHeroi("Mago", textNameMage.getText());
                    break;
                case "Arqueiro":
                    novaArena.criarHeroi("Arqueiro", textNameArcher.getText());
                    break;
                default:
            }
            quantidadePersonagens++;
            System.out.println(quantidadePersonagens);
        }
    }

    @FXML
    void imageClickOnArcher(MouseEvent event) {
        classe = "Arqueiro";
        VisibilityNameArcher = true;
        textNameArcher.setVisible(VisibilityNameArcher);
        VisibilityNameMage = false;
        textNameMage.setVisible(VisibilityNameMage);
        VisibilityNameWarrior = false;
        textNameWarrior.setVisible(VisibilityNameWarrior);
    }

    @FXML
    void imageClickOnMage(MouseEvent event) {
        classe = "Mago";
        VisibilityNameMage = true;
        textNameMage.setVisible(VisibilityNameMage);
        VisibilityNameArcher = false;
        textNameArcher.setVisible(VisibilityNameArcher);
        VisibilityNameWarrior = false;
        textNameWarrior.setVisible(VisibilityNameWarrior);
    }

    @FXML
    void imageClickOnWarrior(MouseEvent event) {
        classe = "Guerreiro";
        VisibilityNameWarrior = true;
        textNameWarrior.setVisible(VisibilityNameWarrior);
        VisibilityNameArcher = false;
        textNameArcher.setVisible(VisibilityNameArcher);
        VisibilityNameMage = false;
        textNameMage.setVisible(VisibilityNameMage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VisibilityNameArcher = false;
        textNameArcher.setVisible(VisibilityNameArcher);
        VisibilityNameMage = false;
        textNameMage.setVisible(VisibilityNameMage);
        VisibilityNameWarrior = false;
        textNameWarrior.setVisible(VisibilityNameWarrior);
        buttonGo.setVisible(false);
    }
}