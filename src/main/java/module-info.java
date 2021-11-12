module graphics {
    requires javafx.controls;

    opens graphics to javafx.graphics, javafx.fxml;

    exports graphics;
}