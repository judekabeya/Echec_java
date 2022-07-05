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
 * Cette classe depend de la classe Piece. Elle peut construire un objet Dame et defini les deplacements possibles.
 * 
 * 
 * @author Kabeya Jude
 * @version V1
 */
public class Dame extends Piece{
    
    /** 
     * Cree une Dame blanche en position D1
    */
    public Dame(){
        super ('B', "D1");
    }

    /**
     * Instanciation de l'etat de l'objet avec une position (Position) et une couleur (char)
     * @param pos Position : Position de l'objet
     * @param color Char : Couleur de l'objet
     */
    public Dame(Position pos, char color){
        super(color, pos);
    }

    /**
     * Getteur de type

     * @return String : Type de l'objet  
     */
    public String getType(){
        return "dame";
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

        int i = 1;


        // ---------- ↑ vérif de bas en haut ↑ ---------- //
        
        while ((posPiece.getX() - i) >= 0){
            
            if (p.getCase(posPiece.getX() - i, posPiece.getY()) == null){

                tab.add(new Position(posPiece.getX() - i, posPiece.getY()));
            }

            else if (p.getCase(posPiece.getX() - i, posPiece.getY()).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() - i, posPiece.getY()));
                break;
            }

            else {
                break;
            }
            i ++;
        }  

        i = 1;


        // ---------- ↓ vérif de haut en bas ↓ ---------- //
        
        while ((posPiece.getX() + i) <= 7){
            
            if (p.getCase(posPiece.getX() + i, posPiece.getY()) == null){

                tab.add(new Position(posPiece.getX() + i, posPiece.getY()));
            }

            else if (p.getCase(posPiece.getX() + i, posPiece.getY()).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() + i, posPiece.getY()));
                break;
            }

            else {
                break;
            }
            i ++;
        }

        i = 1;


        // ----------  vérif de gauche à droite  ---------- //
        
        while ((posPiece.getY() + i) <= 7){
            
            if (p.getCase(posPiece.getX(), posPiece.getY() + i) == null){

                tab.add(new Position(posPiece.getX(), posPiece.getY() + i));
            }

            else if (p.getCase(posPiece.getX(), posPiece.getY()+ i).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX(), posPiece.getY() + i));
                break;
            }

            else {
                break;
            }
            i ++;
        }


        i = 1;


        // ----------  vérif de droite à gauche  ---------- //
        
        while ((posPiece.getY() - i) >= 0){
            
            if (p.getCase(posPiece.getX(), posPiece.getY()- i) == null){

                tab.add(new Position(posPiece.getX(), posPiece.getY() - i));
            }

            else if (p.getCase(posPiece.getX(), posPiece.getY()- i).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX(), posPiece.getY()- i));
                break;
            }

            else {
                break;
            }
            i ++;
        }  

        i = 1;

        // ---------- vérif vers en haut à gauche ---------- //

        while (((posPiece.getX() - i) >= 0) && ((posPiece.getY() - i) >= 0)){

            if (p.getCase(posPiece.getX() - i, posPiece.getY() - i) == null){

                tab.add(new Position(posPiece.getX() - i, posPiece.getY() - i));
            }

            else if (p.getCase(posPiece.getX() - i, posPiece.getY() - i).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() - i, posPiece.getY() - i));
                break;
            }

            else {
                break;
            }
            i ++;
        }  

        i = 1;


        // ---------- vérif vers en haut à droite ---------- //

        while (((posPiece.getX() - i) >= 0) && ((posPiece.getY() + i) <= 7)){

            if (p.getCase(posPiece.getX() - i, posPiece.getY() + i) == null){

                tab.add(new Position(posPiece.getX() - i, posPiece.getY() + i));
            }

            else if (p.getCase(posPiece.getX() - i, posPiece.getY() + i).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() - i, posPiece.getY() + i));
                break;
            }

            else {
                break;
            }
            i ++;
        }  

        i = 1;


        // ---------- vérif vers en bas à gauche ---------- //

        while (((posPiece.getX() + i) <= 7) && ((posPiece.getY() - i) >= 0)){

            if (p.getCase(posPiece.getX() + i, posPiece.getY() - i) == null){

                tab.add(new Position(posPiece.getX() + i, posPiece.getY() - i));
            }

            else if (p.getCase(posPiece.getX() + i, posPiece.getY() - i).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() + i, posPiece.getY() - i));
                break;
            }

            else {
                break;
            }
            i ++;
        }  

        i = 1;


        // ---------- vérif vers en bas à droite ---------- //

        while (((posPiece.getX() + i) <= 7) && ((posPiece.getY() + i) <= 7)){

            if (p.getCase(posPiece.getX() + i, posPiece.getY() + i) == null){

                tab.add(new Position(posPiece.getX() + i, posPiece.getY() + i));
            }

            else if (p.getCase(posPiece.getX() + i, posPiece.getY() + i).getCouleur() != couleurPiece){

                tab.add(new Position(posPiece.getX() + i, posPiece.getY() + i));
                break;
            }

            else {
                break;
            }
            i ++;
        }  

        return tab;
    }
}