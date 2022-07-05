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
 * Cette classe depend de la classe Piece. Elle peut construire un objet tour et defini les deplacements possibles.
 * 
 * 
 * @author Kabeya Jude
 * @version V1
 */
public class Roi extends Piece{
    
    /** 
     * Cree un Roi blanc en position E1
    */
    public Roi(){
        super ('B', "E1");
    }

    /**
     * Instanciation de l'etat de l'objet avec une position (Position) et une couleur (char)
     * @param pos Position : Position de l'objet
     * @param color Char : Couleur de l'objet
     */
    public Roi(Position pos, char color){
        super(color, pos);
    }

    /**
     * Getteur de type

     * @return String : Type de l'objet  
     */
    public String getType(){
        return "roi";
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
        if ((((posPiece.getX() - 1) >= 0) && (posPiece.getX() - 1) <= 7) && (((posPiece.getY() - 1) >= 0) && (posPiece.getY() - 1) <= 7)){
            if (p.getCase(posPiece.getX() - 1, posPiece.getY() - 1) == null){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() - 1));
            }
            else if (p.getCase(posPiece.getX() - 1, posPiece.getY() - 1).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() - 1));
            }
        }


        // ---------- vérif en haut ---------- //

        if ((((posPiece.getX() - 1) >= 0) && (posPiece.getX() - 1) <= 7)){
            if (p.getCase(posPiece.getX() - 1, posPiece.getY()) == null){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY()));
            }
            else if (p.getCase(posPiece.getX() - 1, posPiece.getY()).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() - 1, posPiece.getY()));
            }
        }


        // ---------- vérif en haut à droite ---------- //

        if ((((posPiece.getX() - 1) >= 0) && (posPiece.getX() - 1) <= 7) && (((posPiece.getY() + 1) >= 0) && (posPiece.getY() + 1) <= 7)){
            if (p.getCase(posPiece.getX() - 1, posPiece.getY() + 1) == null){
                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() + 1));
            }
            else if (p.getCase(posPiece.getX() - 1, posPiece.getY() + 1).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() - 1, posPiece.getY() + 1));
            }
        }


        // ---------- vérif à droite ---------- //

        if ((((posPiece.getY() + 1) >= 0) && (posPiece.getY() + 1) <= 7)){
            if (p.getCase(posPiece.getX(), posPiece.getY() + 1) == null){
                tab.add(new Position(posPiece.getX(), posPiece.getY() + 1));
            }
            else if (p.getCase(posPiece.getX(), posPiece.getY() + 1).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX(), posPiece.getY() + 1));
            }
        }


        // ---------- vérif en bas à droite ---------- //

        if ((((posPiece.getX() + 1) >= 0) && (posPiece.getX() + 1) <= 7) && (((posPiece.getY() + 1) >= 0) && (posPiece.getY() + 1) <= 7)){
            if (p.getCase(posPiece.getX() + 1, posPiece.getY() + 1) == null){
                tab.add(new Position(posPiece.getX() + 1, posPiece.getY() + 1));
            }
            else if (p.getCase(posPiece.getX() + 1, posPiece.getY() + 1).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() + 1, posPiece.getY() + 1));
            }
        }


        // ---------- vérif en bas ---------- //

        if ((((posPiece.getX() + 1) >= 0) && (posPiece.getX() + 1) <= 7)){
            if (p.getCase(posPiece.getX() + 1, posPiece.getY()) == null){
                tab.add(new Position(posPiece.getX() + 1, posPiece.getY()));
            }
            else if (p.getCase(posPiece.getX() + 1, posPiece.getY()).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() + 1, posPiece.getY()));
            }
        }

        // ---------- vérif en bas à gauche ---------- //

        if ((((posPiece.getX() + 1) >= 0) && (posPiece.getX() + 1) <= 7) && (((posPiece.getY() - 1) >= 0) && (posPiece.getY() - 1) <= 7)){
            if (p.getCase(posPiece.getX() + 1, posPiece.getY() - 1) == null){
                tab.add(new Position(posPiece.getX() + 1, posPiece.getY() - 1));
            }
            else if (p.getCase(posPiece.getX() + 1, posPiece.getY() - 1).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() + 1, posPiece.getY() - 1));
            }
        }


        // ---------- vérif à droite ---------- //

        if ((((posPiece.getY() - 1) >= 0) && (posPiece.getY() - 1) <= 7)){
            if (p.getCase(posPiece.getX(), posPiece.getY() - 1) == null){
                tab.add(new Position(posPiece.getX(), posPiece.getY() - 1));
            }
            else if (p.getCase(posPiece.getX(), posPiece.getY() - 1).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX(), posPiece.getY() - 1));
            }
        }
        return tab;
    }
}