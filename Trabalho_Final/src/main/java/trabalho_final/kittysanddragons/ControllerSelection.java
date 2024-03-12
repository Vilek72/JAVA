package trabalho_final.kittysanddragons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import trabalho_final.kittysanddragons.Application.Arena;
import trabalho_final.kittysanddragons.Entities.Fase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerSelection implements Initializable {

    private static int indiceFase = 0;
    private List<Fase> fases = new ArrayList<>();

    @FXML
    private Label labelFaseBatalha;

    @FXML
    void buttonBackHoverIn(MouseEvent event) {

    }

    @FXML
    void buttonBackOut(MouseEvent event) {

    }

    @FXML
    void buttonGoHoverOut(MouseEvent event) {

    }

    @FXML
    void buttonGoHoverin(MouseEvent event) {

    }

    @FXML
    void eventBack(ActionEvent event) {

    }

    @FXML
    void eventGo(ActionEvent event) throws IOException {
        HelloApplication.changeScene("batalha-view.fxml", event);
    }

    public static int getIndiceFase() {
        return indiceFase;
    }

    public static void proximaFase() {
        indiceFase += 1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Arena arena = new Arena();
        fases = arena.getFases();
        labelFaseBatalha.setText(arena.getFases().get(indiceFase).getDescricao());
    }

}

