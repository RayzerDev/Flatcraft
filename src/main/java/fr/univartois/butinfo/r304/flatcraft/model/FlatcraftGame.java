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

package fr.univartois.butinfo.r304.flatcraft.model;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import fr.univartois.butinfo.r304.flatcraft.model.craft.RuleParser;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.map.IFabricMap;
import fr.univartois.butinfo.r304.flatcraft.model.map.MyGenarateMap;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.PassiveMob;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement.IntelligentMobMovement;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement.LinearMobMovement;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement.RandomMobMovement;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * La classe {@link FlatcraftGame} permet de gérer une partie du jeu Flatcraft.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class FlatcraftGame {

    /**
     * La largeur de la carte du jeu affichée (en pixels).
     */
    private final int width;

    /**
     * La hauteur de la carte du jeu affichée (en pixels).
     */
    private final int height;

    /**
     * Le contrôleur de l'application.
     */
    private IFlatcraftController controller;

    /**
     * L'instance e {@link ISpriteStore} utilisée pour créer les sprites du jeu.
     */
    private ISpriteStore spriteStore;

    /**
     * L'instance de {@link CellFactory} utilisée pour créer les cellules du jeu.
     */
    private CellFactory cellFactory;

    /**
     * La carte du jeu, sur laquelle le joueur évolue.
     */
    private GameMap map;

    /**
     * Le temps écoulé depuis le début de la partie.
     */
    private IntegerProperty time = new SimpleIntegerProperty(12);

    /**
     * Le niveau actuel de la partie.
     */
    private IntegerProperty level = new SimpleIntegerProperty(1);

    /**
     * La représentation du joueur.
     */
    private Player player;

    /**
     * La liste des objets mobiles du jeu.
     */
    private List<IMovable> movableObjects = new CopyOnWriteArrayList<>();

    /**
     * L'animation simulant le temps qui passe dans le jeu.
     */
    private FlatcraftAnimation animation = new FlatcraftAnimation(this, movableObjects);

    /**
     * Crée une nouvelle instance de FlatcraftGame.
     *
     * @param width La largeur de la carte du jeu (en pixels).
     * @param height La hauteur de la carte du jeu (en pixels).
     * @param spriteStore L'instance de {@link ISpriteStore} permettant de créer les
     *        {@link Sprite} du jeu.
     * @param factory La fabrique permettant de créer les cellules du jeux.
     */
    public FlatcraftGame(int width, int height, ISpriteStore spriteStore, CellFactory factory) {
        this.width = width;
        this.height = height;
        this.spriteStore = spriteStore;
        this.cellFactory = factory;
        this.cellFactory.setSpriteStore(spriteStore);
    }

    /**
     * Donne la largeur de la carte du jeu affichée (en pixels).
     *
     * @return La largeur de la carte du jeu affichée (en pixels).
     */
    public int getWidth() {
        return width;
    }

    /**
     * Donne la hauteur de la carte du jeu affichée (en pixels).
     *
     * @return La hauteur de la carte du jeu affichée (en pixels).
     */
    public int getHeight() {
        return height;
    }

    /**
     * Associe à cette partie le contrôleur gérant l'affichage du jeu.
     *
     * @param controller Le contrôleur gérant l'affichage.
     */
    public void setController(IFlatcraftController controller) {
        this.controller = controller;
    }

    /**
     * Prépare la partie de Flatcraft avant qu'elle ne démarre.
     */
    public void prepare() {
        // On crée la carte du jeu.
        map = createMap();
        controller.prepare(map);

        // TODO On crée le joueur, qui se trouve sur le sol à gauche de la carte.
        player = new Player(this, 0., (map.getSoilHeight() - 1.) * spriteStore.getSpriteSize(),
                spriteStore.getSprite("tool_steelpick"));
        controller.addMovable(player);
        movableObjects.add(player);

        // On créé 3 mobs passifs
        PassiveMob mobLin = new PassiveMob(this, map.getWidth()/2 * spriteStore.getSpriteSize(),
                (map.getSoilHeight() - 1.) * spriteStore.getSpriteSize(),spriteStore.getSprite("nc_front"),
                new LinearMobMovement());
        controller.addMovable(mobLin);
        movableObjects.add(mobLin);

        PassiveMob mobRan = new PassiveMob(this, map.getWidth()/3 * spriteStore.getSpriteSize(),
                (map.getSoilHeight() - 1.) * spriteStore.getSpriteSize(),spriteStore.getSprite("nc_front"),
                new RandomMobMovement());
        controller.addMovable(mobRan);
        movableObjects.add(mobRan);

        PassiveMob mobInt = new PassiveMob(this, map.getWidth()/4 * spriteStore.getSpriteSize(),
                (map.getSoilHeight() - 1.) * spriteStore.getSpriteSize(),spriteStore.getSprite("nc_front"),
                new IntelligentMobMovement(player));
        controller.addMovable(mobInt);
        movableObjects.add(mobInt);

        // TODO On fait le lien entre les différentes propriétés et leur affichage.
        controller.bindTime(time);
        controller.bindLevel(level);
        controller.bindXP( player.getXpProperty());
        controller.bindHealth( player.getHealthProperty());
        controller.bindInventory(player.getInventory());

        RuleParser ruleParser = new RuleParser("craftrules.txt");
        try {
            ruleParser.parse();
        }
        catch (IOException e){
            System.err.println("Erreur lors du parsse du craft");
        }
        // On démarre l'animation du jeu.
        animation.start();
    }

    /**
     * Crée la carte du jeu.
     *
     * @return La carte du jeu créée.
     */
    private GameMap createMap() {
        int spriteSize = spriteStore.getSpriteSize();
        int cellHeigth = height/spriteSize;
        int cellWidth = width/spriteSize;
        IFabricMap fabricMap = new MyGenarateMap(cellHeigth, cellWidth, cellFactory);
        fabricMap.setSpriteStore(spriteStore);
        map = fabricMap.createMapA();
        return map;
    }

    /**
     * Indique à cette partie de Flatcraft qu'une nouvelle heure s'est écoulée
     * (dans le jeu).
     */
    void oneHour() {
        time.set((time.get() + 1) % 24);
    }

    /**
     * Fait se déplacer le joueur vers le haut.
     */
    public void moveUp() {
        player.setVerticalSpeed(-100);
        move(player);
    }

    /**
     * Fait se déplacer le joueur vers le bas.
     */
    public void moveDown() {
        Cell currentCell = getCellOf(player);
        if(currentCell.getRow() < map.getHeight()-1 && map.getAt(currentCell.getRow()+1, currentCell.getColumn()).move(player)) {
            move(player);
        }
    }

    /**
     * Fait se déplacer le joueur vers la gauche.
     */
    public void moveLeft() {
        Cell currentCell = getCellOf(player);
        if(currentCell.getColumn()!=0 && map.getAt(currentCell.getRow(), currentCell.getColumn()-1).move(player)) {
            move(player);
        }
    }

    /**
     * Fait se déplacer le joueur vers la droite.
     */
    public void moveRight() {
        Cell currentCell = getCellOf(player);
        if(currentCell.getColumn() < map.getWidth()-1 && map.getAt(currentCell.getRow(), currentCell.getColumn()+1).move(player)){
            move(player);
        }
    }

    /**
     * Déplace un objet mobile en tenant compte de la gravité.
     *
     * @param movable L'objet à déplacer.
     */
    private void move(IMovable movable) {
        Cell currentCell = getCellOf(movable);
        for (int row = currentCell.getRow() + 1; row < map.getHeight(); row++) {
            Cell below = map.getAt(row, currentCell.getColumn());
            if (!below.move(movable)) {
                break;
            }
        }
    }

    /**
     * Interrompt le déplacement du joueur.
     */
    public void stopMoving() {
        player.setHorizontalSpeed(0);
        player.setVerticalSpeed(0);
    }

    /**
     * Fait sauter le joueur.
     */
    public void jump() {
        // TODO Cette méthode vous sera fournie ultérieurement.
    }

    /**
     * Fait creuser le joueur vers le haut.
     */
    public void digUp() {
        Cell cellNow = getCellOf(player);
        if (cellNow.getRow()>1){
            dig(map.getAt(cellNow.getRow()-1, cellNow.getColumn()));
            move(player);
        }
    }

    /**
     * Fait creuser le joueur vers le bas.
     */
    public void digDown() {
        Cell cellNow = getCellOf(player);
        if (cellNow.getRow()< map.getHeight()-1){
            dig(map.getAt(cellNow.getRow()+1, cellNow.getColumn()));
            move(player);
        }
    }

    /**
     * Fait creuser le joueur vers la gauche.
     */
    public void digLeft() {
        Cell cellNow = getCellOf(player);
        if (cellNow.getColumn()>1){
            dig(map.getAt(cellNow.getRow(), cellNow.getColumn()-1));
        }
    }

    /**
     * Fait creuser le joueur vers la droite.
     */
    public void digRight() {
        Cell cellNow = getCellOf(player);
        if (cellNow.getColumn()< map.getWidth()-1){
            dig(map.getAt(cellNow.getRow(), cellNow.getColumn()+1));
        }
    }

    /**
     * Creuse la cellule donnée pour en extraire une ressource.
     *
     * @param toDig La cellule sur laquelle creuser.
     */
    private void dig(Cell toDig) {
        if (toDig.dig(player)) {
            toDig.replaceBy(cellFactory.createSky());
        }
    }

    /**
     * Récupére la cellule correspondant à la position d'un objet mobile.
     * Il s'agit de la cellule sur laquelle l'objet en question occupe le plus de place.
     *
     * @param movable L'objet mobile dont la cellule doit être récupérée.
     *
     * @return La cellule occupée par l'objet mobile.
     */
    private Cell getCellOf(IMovable movable) {
        // On commence par récupérer la position du centre de l'objet.
        int midX = movable.getX() + (movable.getWidth() / 2);
        int midY = movable.getY() + (movable.getHeight() / 2);

        // On traduit cette position en position dans la carte.
        int row = midY / spriteStore.getSpriteSize();
        int column = midX / spriteStore.getSpriteSize();

        // On récupère enfin la cellule à cette position dans la carte.
        return map.getAt(row, column);
    }

    /**
     * Crée une nouvelle ressource à l'aide d'un ensemble de ressources, en suivant les
     * règles de la table de craft.
     *
     * @param inputResources Les ressources déposées sur la table de craft.
     *
     * @return La ressource produite.
     */
    public Resource craft(Resource[][] inputResources) {
        // TODO Vous devez compléter cette méthode.
        throw new UnsupportedOperationException("Pas encore implémentée !");
    }

    /**
     * Crée une nouvelle ressource à l'aide d'un combustible et d'une ressource, en suivant les
     * règles du fourneau.
     *
     * @param fuel Le matériau combustible utilisé dans le fourneau.
     * @param resource La ressource à transformer.
     *
     * @return La ressource produite.
     */
    public Resource cook(Resource fuel, Resource resource) {
        // TODO Vous devez compléter cette méthode.
        throw new UnsupportedOperationException("Pas encore implémentée !");
    }

    public Player getPlayer() {
        return player;
    }
}
