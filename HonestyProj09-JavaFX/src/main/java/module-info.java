module com.example.honestyproj09javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.honestyproj09javafx to javafx.fxml;
    exports com.example.honestyproj09javafx;
}