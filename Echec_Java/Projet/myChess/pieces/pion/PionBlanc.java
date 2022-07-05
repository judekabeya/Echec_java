package myCheesLib.pieces.pion;

import java.util.ArrayList;

import myCheesLib.Plateau;
import myCheesLib.Position;

/**
 * Cette classe se caracterise par les informations suivantes :
 * 
 * <br><br><u> <b>Attributs : </b> </u><br> <br> 
 * 
 * 
 * 
 * <u> <b>Description des principales fonctionnalites de la classe : </b> </u><br><br> 
 * 
 * Cette classe depend de la classe Piece. Elle peut construire un objet pion blanc et defini les deplacements possibles.
 * 
 * 
 * @author Kabeya Jude
 * @version V1
 */
public class PionBlanc extends Pion{
    
    /** 
     * Cree un pion blanc en position A2
    */
    public PionBlanc(){
        super();
    }

    /**
     * Instanciation de l'etat de l'objet avec une position (Position) et une couleur (char)
     * @param pos Position : Position de l'objet
     */
    public PionBlanc(Position pos){
        super(pos, 'B');
    }

    /**
     * Getteur de type

     * @return String : Type de l'objet  
     */
    public String getType(){
        return "pion";
    }

    /**
     * Methode qui definie les deplacements possible de l'objet 
     * @param p Plateau : Sert a connaitre l'etat du plateau afin de definir les deplacements possibles 
     * @return ArrayList Position : Retourne une liste des deplacements possibles
     */ 
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        ArrayList<Position> tab = new ArrayList<Position>();
        
        Position posPiece = getPosition();
        
        if (posPiece.getX() == 0){
            return tab;
        }

        // ------------------ MOUVEMENT ------------------ //

        else{
            if (posPiece.getX() == 6){

                if ((p.getCase(posPiece.getX() - 1, posPiece.getY()) == null)){
                    tab.add(new Position(posPiece.getX() - 1, posPiece.getY()));
                
                    if (p.getCase(posPiece.getX() - 2, posPiece.getY()) == null){
                        tab.add(new Position(posPiece.getX() - 2, posPiece.getY()));
                    }
                }
                }

            else{

                if ((p.getCase(posPiece.getX() - 1, posPiece.getY()) == null)){
                    tab.add(new Position(posPiece.getX() - 1, posPiece.getY()));
                }

            }
        }

        // ------------------ GRAILLE ------------------ //

        if ((p.getCase(posPiece.getX() - 1, posPiece.getY() - 1) != null)){

            if (p.getCase(posPiece.getX() - 1, posPiece.getY() - 1).getCouleur() == 'N'){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() - 1));
            }
        }

        if ((p.getCase(posPiece.getX() - 1, posPiece.getY() + 1) != null)){

            if (p.getCase(posPiece.getX() - 1, posPiece.getY() + 1).getCouleur() == 'N'){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() + 1));
            }
        }
        return tab;
    }
}
