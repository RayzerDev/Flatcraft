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
 * La classe {@link CraftTableController} fournit le contrôleur permettant de gérer la
 * table de craft, sur laquelle l'utilisateur peut fabriquer de nouvelles ressources à
 * partir de celles collectées dans le jeu.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class CraftTableController {

    /**
     * La partie de Flatcraft en cours.
     */
    private FlatcraftGame game;

    /**
     * Les ressources déposées sur la table de craft.
     */
    private Resource[][] resources;

    /**
     * La grille représentant la table sur laquelle les ressources sont déposées.
     */
    @FXML
    private GridPane craftGrid;

    /**
     * Les vues représentant les ressources déposées sur la table de craft.
     */
    private ImageView[][] resourceViews;

    /**
     * Le produit obtenu à l'issue du craft.
     */
    private Resource product;

    /**
     * La vue représentant la ressource produite à l'issue du craft.
     */
    @FXML
    private ImageView productView;

    /**
     * Le bouton permettant d'effacer les ressources ajoutées à la table de craft.
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
        // On initialise le tableau des ressources, qui est initialement vide.
        this.resources = new Resource[craftGrid.getRowCount()][craftGrid.getColumnCount()];

        // On initialise ensuite les vues pour ces ressources.
        this.resourceViews = new ImageView[craftGrid.getRowCount()][craftGrid.getColumnCount()];
        for (int i = 0; i < resourceViews.length; i++) {
            for (int j = 0; j < resourceViews[i].length; j++) {
                resourceViews[i][j] = new ImageView();

                // On configure la taille appropriée pour la vue.
                resourceViews[i][j].minWidth(16);
                resourceViews[i][j].maxWidth(16);
                resourceViews[i][j].minHeight(16);
                resourceViews[i][j].maxHeight(16);

                // On ajoute la vue à la grille.
                craftGrid.add(resourceViews[i][j], j, i);
            }
        }
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
     * Crée une nouvelle ressource à partir de celles déposées sur la table de craft.
     */
    @FXML
    private void craft() {
        // On crée la nouvelle ressource.
        product = game.craft(resources);
        productView.setImage(product.getSprite().getImage());

        // On met à jour les actions disponibles.
        addButton.setDisable(false);
        craftGrid.setDisable(true);
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
     * Supprime la totalité des ressources ayant été déposées sur la table de craft.
     */
    @FXML
    private void clear() {
        // On retire toutes les ressources déposées sur la table de craft.
        for (int i = 0; i < resources.length; i++) {
            for (int j = 0; j < resources[i].length; j++) {
                // TODO Remettre les ressources non utilisée dans l'inventaire.
                resources[i][j] = null;
                resourceViews[i][j].setImage(null);
            }
        }

        // On met à jour les actions disponibles.
        clearButton.setDisable(true);
    }

}
