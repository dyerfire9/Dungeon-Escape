module graphics {
    requires javafx.controls;
    requires  javafx.fxml;
    requires java.desktop;

    opens graphics to javafx.graphics, javafx.fxml;

    exports graphics;
    exports graphics.dialog;
    opens graphics.dialog to javafx.fxml, javafx.graphics;
    exports graphics.enums;
    opens graphics.enums to javafx.fxml, javafx.graphics;
    exports graphics.controller;
    opens graphics.controller to javafx.fxml, javafx.graphics;
}