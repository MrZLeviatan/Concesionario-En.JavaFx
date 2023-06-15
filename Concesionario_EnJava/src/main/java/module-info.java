module view {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javax.jms.api;
    requires mail;
    requires java.desktop;
    requires javafx.graphics;



    opens view to javafx.fxml;
    exports view;
}
