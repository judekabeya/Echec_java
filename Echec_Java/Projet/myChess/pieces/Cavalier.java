package myCheesLib.pieces;
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
 * Cette classe depend de la classe Piece. Elle peut construire un objet cavalier et defini les deplacements possibles.
 * 
 * 
 * @author Kabeya jude
 * @version V1
 */
public class Cavalier extends Piece{

    /** 
     * Cree une Cavalier blanc en position B1
    */
    public Cavalier(){
        super('B', "B1");
    }

    /**
     * Instanciation de l'etat de l'objet avec une position (Position) et une couleur (char)
     * @param pos Position : Position de l'objet
     * @param color Char : Couleur de l'objet
     */
    public Cavalier(Position pos, char color){
        super(color, pos);
    }

    /**
     * Getteur de type

     * @return String : Type de l'objet  
     */
    public String getType(){
        return "cavalier";
    }

    /**
     * Methode qui definie les deplacements possible de l'objet 
     * @param p Plateau : Sert a connaitre l'etat du plateau afin de definir les deplacements possibles 
     * @return ArrayList Position : Retourne une liste des deplacements possibles
     */ 
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        ArrayList<Position> tab = new ArrayList<Position>();


        Position posPiece = getPosition();
        char couleurPiece = getCouleur();

        // ---------- vérif en haut à gauche ---------- //

        if ((((posPiece.getX() - 2) >= 0) && (posPiece.getX() - 2) <= 7) && (((posPiece.getY() - 1) >= 0) && (posPiece.getY() - 1) <= 7)){
            
            if (p.getCase(posPiece.getX() - 2, posPiece.getY() - 1) == null){
                tab.add(new Position(posPiece.getX() - 2, posPiece.getY() - 1));
            }

            else if (p.getCase(posPiece.getX() - 2, posPiece.getY() - 1).getCouleur() != couleurPiece){
    
                tab.add(new Position(posPiece.getX() - 2, posPiece.getY() - 1));
            }
        }
        
        if ((((posPiece.getX() - 1) >= 0) && (posPiece.getX() - 1) <= 7) && (((posPiece.getY() - 2) >= 0) && (posPiece.getY() - 2) <= 7)){

            if (p.getCase(posPiece.getX() - 1, posPiece.getY() - 2) == null){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() - 2));
            }

            else if (p.getCase(posPiece.getX() - 1, posPiece.getY() - 2).getCouleur() != couleurPiece){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() - 2));
            }
        }


        // ---------- vérif en haut à droite ---------- //

        if ((((posPiece.getX() - 2) >= 0) && (posPiece.getX() - 2) <= 7) && (((posPiece.getY() + 1) >= 0) && (posPiece.getY() + 1) <= 7)){

            if (p.getCase(posPiece.getX() - 2, posPiece.getY() + 1) == null){
                tab.add(new Position(posPiece.getX() - 2, posPiece.getY() + 1));
            }

            else if (p.getCase(posPiece.getX() - 2, posPiece.getY() + 1).getCouleur() != couleurPiece){
                tab.add(new Position(posPiece.getX() - 2, posPiece.getY() + 1));
            }
        }

        if ((((posPiece.getX() - 1) >= 0) && (posPiece.getX() - 1) <= 7) && (((posPiece.getY() + 2) >= 0) && (posPiece.getY() + 2) <= 7)){

            if (p.getCase(posPiece.getX() - 1, posPiece.getY() + 2) == null){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() + 2));
            }

            else if (p.getCase(posPiece.getX() - 1, posPiece.getY() + 2).getCouleur() != couleurPiece){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() + 2));
            }
        }


        // ---------- vérif en bas à droite ---------- //

        if ((((posPiece.getX() + 2) >= 0) && (posPiece.getX() + 2) <= 7) && (((posPiece.getY() - 1) >= 0) && (posPiece.getY() - 1) <= 7)){

            if (p.getCase(posPiece.getX() + 2, posPiece.getY() + 1) == null){
                tab.add(new Position(posPiece.getX() + 2, posPiece.getY() + 1));
            }
            
            else if (p.getCase(posPiece.getX() + 2, posPiece.getY() + 1).getCouleur() != couleurPiece){
                tab.add(new Position(posPiece.getX() + 2, posPiece.getY() + 1));
            }
        }

        if ((((posPiece.getX() + 1) >= 0) && (posPiece.getX() - 1) <= 7) && (((posPiece.getY() + 2) >= 0) && (posPiece.getY() + 2) <= 7)){

            if (p.getCase(posPiece.getX() + 1, posPiece.getY() + 2) == null){
                tab.add(new Position(posPiece.getX() + 1, posPiece.getY() + 2));
            }

            else if (p.getCase(posPiece.getX() + 1, posPiece.getY() + 2).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() + 1, posPiece.getY() + 2));
            }
        }


        // ---------- vérif en bas à gauche ---------- //

        if ((((posPiece.getX() + 2) >= 0) && (posPiece.getX() + 2) <= 7) && (((posPiece.getY() - 1) >= 0) && (posPiece.getY() - 1) <= 7)){

            if (p.getCase(posPiece.getX() + 2, posPiece.getY() - 1) == null){
                tab.add(new Position(posPiece.getX() + 2, posPiece.getY() - 1));
            }

            else if (p.getCase(posPiece.getX() + 2, posPiece.getY() - 1).getCouleur() != couleurPiece){
                tab.add(new Position(posPiece.getX() + 2, posPiece.getY() - 1));
            }
        }

        if ((((posPiece.getX() + 1) >= 0) && (posPiece.getX() + 1) <= 7) && (((posPiece.getY() - 2) >= 0) && (posPiece.getY() - 2) <= 7)){

            if (p.getCase(posPiece.getX() + 1, posPiece.getY() - 2) == null){
                tab.add(new Position(posPiece.getX() + 1, posPiece.getY() - 2));
            }

            else if (p.getCase(posPiece.getX() + 1, posPiece.getY() - 2).getCouleur() != couleurPiece){
                tab.add(new Position(posPiece.getX() + 1, posPiece.getY() - 2));
            }
        }

        return tab;
    }
}