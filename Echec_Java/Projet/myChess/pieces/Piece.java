package myCheesLib.pieces;
import java.util.ArrayList;

import myCheesLib.Plateau;
import myCheesLib.Position;

/**
 * Cette classe se caracterise par les informations suivantes :
 * 
 * <br><br><u> <b>Attributs : </b> </u><br> <br> 
 * 
 * <ul>
 * <li>char couleur : Caractère qui defini la couleur d'une piece</li>
 * <li>Position position : Position qui defini l'endroit où se situe une piece</li>
 * </ul>
 * 
 * <u> <b>Description des principales fonctionnalites de la classe : </b> </u><br><br> 
 * 
 * Cette classe abstract peut construire un objet Piece mais ne peut ni definir son type ni ses deplacements possibles. Pour ce faire, elle a besoin d'une classe differente par type de piece.
 * 
 * 
 * @author Kabeya Jude
 * @version V1 
 * 
 */
public abstract class Piece {

    /**  Caractère qui defini la couleur d'une piece (ex : 'B' -> pièce blanche ; 'N' -> pièce noire) */
    private char couleur;
    /**  Position qui defini l'endroit où se situe une piece */
    private Position position;

    /** 
     * Cree un piece blanche en position A2
    */  
    public Piece(){
        this.couleur = 'B';
        this.position = new Position("A1");
    }

    /**
     * Constructeur par copie
     * @param thatP Piece : Piece à recopier
     */
    public Piece(Piece thatP){
        this.couleur = thatP.getCouleur();
        this.position = new Position(thatP.getPosition().getX(), thatP.getPosition().getY());
    }

    /**
     * Instanciation de l'etat de l'objet avec une couleur (char), une ordonne (int) et un abscisse (int)
     * @param c char : Couleur de la piece
     * @param x int : Ordonnee de la piece
     * @param y int : Abscisse de la piece
     */
    public Piece(char c, int x, int y){
        if (c == 'B' || c == 'N'){
            this.couleur = c;
            this.position = new Position(x, y);
        }
    }

    /**
     * Instanciation de l'etat de l'objet avec une couleur (char), une position (position)
     * @param c char : Couleur de la piece
     * @param p Position : Position de la piece
     */
    public Piece(char c, Position p){
        if (c == 'B' || c == 'N'){
            this.couleur = c;
            this.position = p;
        }
    }

    /**
     * Instanciation de l'etat de l'objet avec une couleur (char), une position (string)
     * @param c char : Couleur de la piece
     * @param p String : Position de la piece
     */
    public Piece(char c, String p){
        if (c == 'B' || c == 'N'){
            this.couleur = c;
            this.position = new Position(p);
        }
    }

    /**
     * Getteur de type

     * @return String : Type de l'objet
     */
    public abstract String getType();

    /**
     * Getteur de couleur

     * @return char : Retourne la couleur de la piece
     */
    public char getCouleur(){
        return this.couleur;
    }

    /**
     * Getteur de position

     * @return Position : Retourne la position de la piece
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Methode abstract qui oblige ses classes filles à définir les deplacements possible de l'objet 
     * @param p Plateau : Servira a connaitre l'etat du plateau afin de definir les deplacements possibles 
     * @return ArrayList Position : Retournera une liste des deplacements possibles
     */ 
    public abstract ArrayList<Position> getDeplacementPossible(Plateau p);

    
    /**
     * Setteur de couleur
     * @param couleur char : Modification de la couleur d'une piece
     */
    public void setCouleur(char couleur) {
        if (couleur == 'B' || couleur == 'N'){
            this.couleur = couleur;
        }
    }

    /**
     * Setteur de couleur
     * @param position Position : Modification de la position d'une piece
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /** Methode equals permettant de savoir si deux objets pieces sont identiques
     * @param obj Object : Objet de comparaison
     * @return boolean : Retourne si l'egalite entre deux pieces est vraie ou fausse
     */
    public boolean equals (Object obj){
        if ((obj instanceof Piece) == false){
            return false;
        }

        Piece that = (Piece)obj;

        if ((this.couleur != that.couleur) && (this.position.equals(that.position)  == false)){
            return false;
        }
        else {
            return true;
        }
    }


    @Override
    /** Methode permettant d'afficher une piece correctement
     * @return String : Retourne la piece en format string
    */
    public String toString() {
        // TODO Auto-generated method stub
        String color;

        if (this.couleur == 'B'){
            color = "blanc";
            }
        else{
            color = "noir";
            }
        return (color + " en " + this.position);
    }

}

