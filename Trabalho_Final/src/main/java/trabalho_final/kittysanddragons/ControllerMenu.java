package trabalho_final.kittysanddragons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ControllerMenu {

    @FXML
    private Button buttonPlay;

    @FXML
    void buttonPlayHoverIn(MouseEvent event) {
        buttonPlay.setStyle("-fx-background-color: #f8a8a7; -fx-background-radius: 100; -fx-font-weight: bold");
    }

    @FXML
    void buttonPlayHoverOut(MouseEvent event) {
        buttonPlay.setStyle("-fx-background-color:  #f7bea3; -fx-background-radius: 100; -fx-font-weight: bold");
    }

    @FXML
    void eventPlay(ActionEvent event) throws IOException {
        HelloApplication.changeScene("description-view.fxml", event);
    }

}
