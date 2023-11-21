/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.r304.flatcraft.controller;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * La classe {@link FurnaceController} fournit le contrôleur permettant de gérer le
 * fourneau, dans lequel l'utilisateur peut fabriquer de nouvelles ressources à partir de
 * celles collectées dans le jeu.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class FurnaceController {

    /**
     * La partie de Flatcraft en cours.
     */
    private FlatcraftGame game;

    /**
     * Le combustible déposé dans le fourneau.
     */
    private Resource fuel;

    /**
     * La ressource déposée dans le fourneau.
     */
    private Resource resource;

    /**
     * La grille représentant le fourneau dans lequel les ressources sont déposées.
     */
    @FXML
    private GridPane furnaceGrid;

    /**
     * La vue pour le combustible déposé dans le fourneau.
     */
    @FXML
    private ImageView fuelView;

    /**
     * La vue pour la ressource déposée dans le fourneau.
     */
    @FXML
    private ImageView resourceView;

    /**
     * Le produit obtenu à l'issue de la cuisson.
     */
    private Resource product;

    /**
     * La vue représentant la ressource produite à l'issue de la cuisson.
     */
    @FXML
    private ImageView productView;

    /**
     * Le bouton permettant d'effacer les ressources déposées dans le fourneau.
     */
    @FXML
    private Button clearButton;

    /**
     * Le bouton permettant d'ajouter la ressource produite à l'inventaire du joueur.
     */
    @FXML
    private Button addButton;

    /**
     * Initialise ce contrôleur.
     */
    @FXML
    private void initialize() {
        // TODO
    }

    /**
     * Associe à ce contrôleur la partie de Flatcraft en cours.
     *
     * @param game La partie de Flatcraft en cours.
     */
    public void setGame(FlatcraftGame game) {
        this.game = game;
    }

    /**
     * Crée une nouvelle ressource à partir de celles déposées dans le fourneau.
     */
    @FXML
    private void cook() {
        // On crée la nouvelle ressource.
        product = game.cook(fuel, resource);
        productView.setImage(product.getSprite().getImage());

        // On met à jour les actions disponibles.
        addButton.setDisable(false);
        furnaceGrid.setDisable(true);
        clearButton.setDisable(true);
    }

    /**
     * Ajoute la ressource nouvellement créée à l'inventaire du joueur.
     */
    @FXML
    private void addToInventory() {
        // TODO Récupérer le joueur ou définir une méthode pour pouvoir effectuer l'ajout.
    }

    /**
     * Supprime la totalité des ressources ayant été déposées dans le fourneau.
     */
    @FXML
    private void clear() {
        // TODO Remettre les ressources non utilisée dans l'inventaire.
        fuel = null;
        fuelView.setImage(null);
        resource = null;
        resourceView.setImage(null);

        // On met à jour les actions disponibles.
        clearButton.setDisable(true);
    }

}
