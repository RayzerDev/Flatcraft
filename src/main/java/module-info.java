module fr.univartois.butinfo.r304.flatcraft {
    exports fr.univartois.butinfo.r304.flatcraft;
    exports fr.univartois.butinfo.r304.flatcraft.model;
    exports fr.univartois.butinfo.r304.flatcraft.view;
    exports fr.univartois.butinfo.r304.flatcraft.controller;
    exports fr.univartois.butinfo.r304.flatcraft.model.map.cell.factory;
    exports fr.univartois.butinfo.r304.flatcraft.model.resources;
    exports fr.univartois.butinfo.r304.flatcraft.model.movables;


    opens fr.univartois.butinfo.r304.flatcraft to javafx.fxml;
    opens fr.univartois.butinfo.r304.flatcraft.controller to javafx.fxml;

    requires javafx.fxml;
    requires javafx.graphics;
    requires transitive javafx.controls;
    requires java.desktop;
    requires java.logging;
}
