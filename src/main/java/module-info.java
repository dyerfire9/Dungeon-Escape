module graphics {
    requires javafx.controls;
    requires  javafx.fxml;

    opens graphics to javafx.graphics, javafx.fxml;

    exports graphics;
}