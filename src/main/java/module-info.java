module fr.univartois.butinfo.r304.flatcraft {
    exports fr.univartois.butinfo.r304.flatcraft;
    exports fr.univartois.butinfo.r304.flatcraft.model;
    exports fr.univartois.butinfo.r304.flatcraft.view;
    exports fr.univartois.butinfo.r304.flatcraft.controller;


    opens fr.univartois.butinfo.r304.flatcraft to javafx.fxml;
    opens fr.univartois.butinfo.r304.flatcraft.controller to javafx.fxml;

    requires javafx.fxml;
    requires javafx.graphics;
    requires transitive javafx.controls;
    requires java.desktop;
}
