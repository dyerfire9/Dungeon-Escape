module graphics {
    requires javafx.controls;
    requires  javafx.fxml;
    requires java.desktop;

    opens graphics to javafx.graphics, javafx.fxml;
    opens graphics.controller to javafx.fxml;
    exports graphics.dialog;
    opens graphics.dialog to javafx.fxml, javafx.graphics;
}