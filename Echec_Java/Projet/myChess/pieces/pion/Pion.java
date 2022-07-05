package myCheesLib.pieces.pion;
import java.util.ArrayList;

import myCheesLib.Plateau;
import myCheesLib.Position;
import myCheesLib.pieces.Piece;

/**
 * Cette classe se caracterise par les informations suivantes :
 * 
 * <br><br><u> <b>Attributs : </b> </u><br> <br> 
 * 
 * 
 * 
 * <u> <b>Description des principales fonctionnalites de la classe : </b> </u><br><br> 
 * 
 * Cette classe abstract depend de la classe Piece. Elle peut construire un objet pion mais ne peut definir les deplacements possibles. Pour ce faire, elle a besoin de classe pionBlanc et pionNoir.
 * 
 * 
 * @author Kabeya Jude
 * @version V1
 */
public abstract class Pion extends Piece{

    /** 
     * Cree un pion blanc en position A2
    */    
    public Pion(){
        super('B', "A2"); // Référence au constructeur de la classe mère
    }

    /**
     * Instanciation de l'etat de l'objet avec une position (Position) et une couleur (char)
     * @param pos Position : Position de l'objet
     * @param color Char : Couleur de l'objet
     */
    public Pion(Position pos, char color){
        super(color, pos);
    }

    /**
     * Getteur de type

     * @return String : Type de l'objet  
     */
    public String getType(){
        return "pion";
    }

    /**
     * Methode abstract qui oblige ses classes filles à définir les deplacements possible de l'objet 
     * @param p Plateau : Servira a connaitre l'etat du plateau afin de definir les deplacements possibles 
     * @return ArrayList Position : Retournera une liste des deplacements possibles
     */ 
    public abstract ArrayList<Position> getDeplacementPossible(Plateau p);
}