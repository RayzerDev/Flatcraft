/**
 * Ce logiciel est distribué à des fins éducatives.
 * <p>
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 * <p>
 * (c) 2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.r304.flatcraft.view;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import java.net.URL;

/**
 * La classe {@link Sprite} représente un élément graphique du jeu.
 * Il s'agit d'un objet encapsulant une image sans état interne, et qui peut être placé à
 * un endroit donné de la fenêtre.
 * De cette manière, il est possible d'utiliser la même instance de {@link Sprite} pour
 * représenter plusieurs éléments similaires en même temps.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class Sprite {

    /**
     * L'image associée à cette instance de {@link Sprite}.
     */
    private final Image image;

    private String name;

    /**
     * Crée une nouvelle instance de {@link Sprite}.
     *
     * @param image L'image associée à l'instance de {@link Sprite}.
     */
    public Sprite(String name, Image image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    /**
     * Donne la largeur de l'image associée, mesurée en nombre de pixels.
     *
     * @return La largeur de l'image associée.
     */
    public int getWidth() {
        return (int) image.getWidth();
    }

    /**
     * Donne la hauteur de l'image associée, mesurée en nombre de pixels.
     *
     * @return La hauteur de l'image associée.
     */
    public int getHeight() {
        return (int) image.getHeight();
    }

    /**
     * Donne l'image associée à cette instance de {@link Sprite}.
     *
     * @return L'image associée à cette instance de {@link Sprite}.
     */
    public Image getImage() {
        return image;
    }


    public Sprite changeDurety(int lvl){
        if(lvl<1 || lvl>6){
            return this;
        }
        URL urlImage = getClass().getResource("images/crack_anylength.png");
        assert urlImage != null;
        Image imageDurety = new Image(urlImage.toExternalForm(), 16, 80, true, true);
        WritableImage img = new WritableImage(getWidth(), getHeight());
        for (int i=0;i < getWidth();i++) {
            for (int j=0; j < getHeight(); j++) {
                if(imageDurety.getPixelReader().getArgb(i,j + 16 * (5-lvl)) != 0){
                    img.getPixelWriter().setArgb(i, j,imageDurety.getPixelReader().getArgb(i,j + 16 * (5-lvl)));
                }
                else{
                    img.getPixelWriter().setArgb(i, j,image.getPixelReader().getArgb(i,j));
                }
            }
        }
        return new Sprite(name, new ImageView(img).getImage());
    }
    /**
     * Fusionne 2 sprites, considérant que possède vient compléter le fond vide du sprite en instance.
     *
     * @return Un nouveau Sprite avec 2 images fusionnées
     */
    public Sprite mergeSprite(Sprite other){
        WritableImage img = new WritableImage(getWidth(), getHeight());
        for (int i=0;i < getWidth();i++) {
            for (int j=0; j < getHeight(); j++) {
                if(image.getPixelReader().getArgb(i,j) == 0){
                    img.getPixelWriter().setArgb(i, j,other.getImage().getPixelReader().getArgb(i,j));
                }
                else{
                    img.getPixelWriter().setArgb(i, j,image.getPixelReader().getArgb(i,j));
                }
            }
        }
        return new Sprite(name, new ImageView(img).getImage());
    }
}
