module com.mpcamargo.emuladornes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.mpcamargo.emuladornes.tela to javafx.fxml;

    exports com.mpcamargo.emuladornes.core;
    exports com.mpcamargo.emuladornes.tela;
    exports com.mpcamargo.emuladornes.core.CPU;
}