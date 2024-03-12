module trabalho_final.kittysanddragons {
    requires javafx.controls;
    requires javafx.fxml;


    opens trabalho_final.kittysanddragons to javafx.fxml;
    exports trabalho_final.kittysanddragons;
}