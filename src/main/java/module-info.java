module voxylware.voxylsnake {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens voxylware.voxylsnake to javafx.fxml;
    exports voxylware.voxylsnake;
}