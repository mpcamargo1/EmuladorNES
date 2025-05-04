module com.mpcamargo.emuladornes {
    requires com.dlsc.formsfx;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    exports com.mpcamargo.emuladornes.core;
    exports com.mpcamargo.emuladornes.gui.app;

    opens com.mpcamargo.emuladornes.gui.app to javafx.fxml;
}