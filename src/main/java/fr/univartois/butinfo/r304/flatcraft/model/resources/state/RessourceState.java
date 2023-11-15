package fr.univartois.butinfo.r304.flatcraft.model.resources.state;

public interface RessourceState {
    void handle();
    RessourceState nextState();
}
