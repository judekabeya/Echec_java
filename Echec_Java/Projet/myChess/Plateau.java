package myCheesLib;
import java.util.ArrayList;

import myCheesLib.pieces.Cavalier;
import myCheesLib.pieces.Dame;
import myCheesLib.pieces.Fou;
import myCheesLib.pieces.Piece;
import myCheesLib.pieces.Roi;
import myCheesLib.pieces.Tour;
import myCheesLib.pieces.pion.PionBlanc;
import myCheesLib.pieces.pion.PionNoir;

/**
 * Cette classe se caracterise par les informations suivantes :
 * 
 * <br><br><u> <b>Attributs : </b> </u><br>  
 * 
 * <ul>
 * <li>ArrayList Piece plateau : Tableau dynamique des pieces d'un echiquier</li>
 * </ul>
 * 
 * <br><u> <b>Description des principales fonctionnalites de la classe : </b> </u><br><br> 
 * 
 * Cette classe peut construire un objet Plateau et permet entre autre de verifier si une deplacement est possible ou encore si un roi est en echec
 * 
 * 
 * @author KABEYA JUDE
 * @version V1
 */
public class Plateau {
    
    /** Tableau dynamique des pieces d'un echiquier */    
    public ArrayList<Piece> plateau = new ArrayList<Piece>();

    /** 
     * Initialise le plateau tel un debut de jeu (meme piece, position)
    */
    public Plateau(){

        // Creation pièces maitresses blanches
        plateau.add(new Tour (new Position(7, 0), 'B'));
        plateau.add(new Cavalier(new Position(7, 1), 'B'));
        plateau.add(new Fou(new Position(7, 2),'B'));
        plateau.add(new Dame(new Position(7, 3),'B'));
        plateau.add(new Roi( new Position(7, 4),'B'));
        plateau.add(new Fou(new Position(7, 5), 'B'));
        plateau.add(new Cavalier(new Position(7, 6), 'B'));
        plateau.add(new Tour(new Position(7, 7), 'B'));

        // Création pions blancs
        plateau.add(new PionBlanc(new Position(6, 0)));
        plateau.add(new PionBlanc(new Position(6, 1)));
        plateau.add(new PionBlanc(new Position(6, 2)));
        plateau.add(new PionBlanc(new Position(6, 3)));
        plateau.add(new PionBlanc(new Position(6, 4)));
        plateau.add(new PionBlanc(new Position(6, 5)));
        plateau.add(new PionBlanc(new Position(6, 6)));        
        plateau.add(new PionBlanc(new Position(6, 7)));

        // Création pions noirs
        plateau.add(new PionNoir(new Position(1, 0)));
        plateau.add(new PionNoir(new Position(1, 1)));
        plateau.add(new PionNoir(new Position(1, 2)));
        plateau.add(new PionNoir(new Position(1, 3)));
        plateau.add(new PionNoir(new Position(1, 4)));
        plateau.add(new PionNoir(new Position(1, 5)));
        plateau.add(new PionNoir(new Position(1, 6)));
        plateau.add(new PionNoir(new Position(1, 7)));

        // Création pièces maitresses noires
        plateau.add(new Tour (new Position(0, 0), 'N'));
        plateau.add(new Cavalier(new Position(0, 1), 'N'));
        plateau.add(new Fou(new Position(0, 2),'N'));
        plateau.add(new Dame(new Position(0, 3),'N'));
        plateau.add(new Roi( new Position(0, 4),'N'));
        plateau.add(new Fou(new Position(0, 5), 'N'));
        plateau.add(new Cavalier(new Position(0, 6), 'N'));
        plateau.add(new Tour(new Position(0, 7), 'N'));
    }

    /** 
     * Constructeur par copie
     * @param thatPlateau Plateau : Plateau à recopier
    */
    public Plateau (Plateau thatPlateau){
        int i;
        for (i = 0; i < thatPlateau.plateau.size(); i++){
            
            if ((thatPlateau.plateau.get(i).getType() == "pion") && (thatPlateau.plateau.get(i).getCouleur() == 'N')){
                this.plateau.add(new PionNoir(thatPlateau.plateau.get(i).getPosition()));
            }

            else if ((thatPlateau.plateau.get(i).getType() == "pion") && (thatPlateau.plateau.get(i).getCouleur() == 'B')){
                this.plateau.add(new PionBlanc(thatPlateau.plateau.get(i).getPosition()));
            }
            
            else if (thatPlateau.plateau.get(i).getType() == "cavalier"){
                this.plateau.add(new Cavalier(thatPlateau.plateau.get(i).getPosition(), thatPlateau.plateau.get(i).getCouleur()));
            }

            else if (thatPlateau.plateau.get(i).getType() == "fou"){
                this.plateau.add(new Fou(thatPlateau.plateau.get(i).getPosition(), thatPlateau.plateau.get(i).getCouleur()));
            }
            
            else if (thatPlateau.plateau.get(i).getType() == "tour"){
                this.plateau.add(new Tour(thatPlateau.plateau.get(i).getPosition(), thatPlateau.plateau.get(i).getCouleur()));
            }
            
            else if (thatPlateau.plateau.get(i).getType() == "dame"){
                this.plateau.add(new Dame(thatPlateau.plateau.get(i).getPosition(), thatPlateau.plateau.get(i).getCouleur()));
            }
            
            else if (thatPlateau.plateau.get(i).getType() == "roi"){
                this.plateau.add(new Roi(thatPlateau.plateau.get(i).getPosition(), thatPlateau.plateau.get(i).getCouleur()));
            }
        }
    }

    /**
     * Methode qui sert a obtenir la piece d'un plateau selon sa position
     * @param x int : Coordonnee x de la piece recherchee
     * @param y int : Coordonnee y de la piece recherchee
     * @return Piece | null : Retourne la piece s'il y en a bidn une sur la position recherchee. Sinon retourne null.
     */
    public Piece getCase(int x, int y){
        int i;
        for (i = 0; i < this.plateau.size(); i++){
            if ((this.plateau.get(i).getPosition().getX() == x) && (this.plateau.get(i).getPosition().getY() == y)){
                return this.plateau.get(i);
            }
        }
        return null;
    }

    /**
     * Methode qui sert a obtenir la piece d'un plateau selon sa position
     * @param p Position : Position de la piece recherchee
     * @return Piece | null : Retourne la piece s'il y en a bien une sur la position recherchee. Sinon retourne null.
     */
    public Piece getCase(Position p){
        int i;
        for (i = 0; i < this.plateau.size(); i++){
            if ((this.plateau.get(i).getPosition().getX() == p.getX()) && (this.plateau.get(i).getPosition().getY() == p.getY())){
                return this.plateau.get(i);
            }
        }
        return null;
    }

    /**
     * Methode qui sert a obtenir la piece d'un plateau selon sa position
     * @param p String : Position en chaine de caractere de la piece recherchee
     * @return Piece | null : Retourne la piece s'il y en a bien une sur la position recherchee. Sinon retourne null.
     */
    public Piece getCase(String p){
        int i;
        Position nvPos = new Position(p);

        for (i = 0; i < this.plateau.size(); i++){
            if ((this.plateau.get(i).getPosition().getX() == nvPos.getX()) && (this.plateau.get(i).getPosition().getY() == nvPos.getY())){
                return this.plateau.get(i);
            }
        }
        return null;
    }

    
    // Fonction affichant le plateau
    /**
     * Methode qui sert a afficher l'echiquier dans un terminal
     * @return String : Retourne le plateau en chaine de caractere
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        int i, j, n, cptLettre;
        int cptChiffre = 8;
        String affichageFinal = "";

        // affichage premiere colonne de presentation
        affichageFinal = affichageFinal + "\n |";
        for (n = 0; n <= 7; n++){
            affichageFinal = affichageFinal + "---|";
        }
        affichageFinal = affichageFinal + "\n";
        
        for (i = 0; i <= 7; i++){
            
            affichageFinal = affichageFinal + cptChiffre + '|';

            for (j = 0; j <= 7; j++){
                if (getCase(i, j) != null){
                    // Car avec partie 2 ça ne fonctionne plus + plus besoin

                    affichageFinal = affichageFinal + getCase(i, j) + '|';
                }
                else {
                    affichageFinal = affichageFinal + "   |";
                }
            }
            affichageFinal = affichageFinal + "\n |";
            for (n = 0; n <= 7; n++){
                affichageFinal = affichageFinal + "---|";
            }
            affichageFinal = affichageFinal + "\n";
            cptChiffre--;
        }

        for (cptLettre = 65; cptLettre <= 72; cptLettre++){
                affichageFinal = affichageFinal + "   " + (char)cptLettre;
            }

        return affichageFinal;
    }

    /**
     * Methode qui recuperer l'ensemble des pieces blanches du plateau
     * @return ArrayList Piece : Retourne l'ensemble des pieces blanches presentes encore sur le plateau
     */
    public ArrayList<Piece> getPiecesBlanches(){
        int i;
        ArrayList<Piece> nvTab = new ArrayList<Piece>();

        for (i = 0; i < this.plateau.size(); i++){
            if (this.plateau.get(i).getCouleur() == 'B'){
                nvTab.add(this.plateau.get(i));
            }
        }
        return nvTab;   
    }

    /**
     * Methode qui recuperer l'ensemble des pieces noires du plateau
     * @return ArrayList Piece : Retourne l'ensemble des pieces noires presentes encore sur le plateau
     */
    public ArrayList<Piece> getPiecesNoires(){
        int i;
        ArrayList<Piece> nvTab = new ArrayList<Piece>(); 

        for (i = 0; i < this.plateau.size(); i++){
            if (this.plateau.get(i).getCouleur() == 'N'){
                nvTab.add(this.plateau.get(i));
            }
        }
        return nvTab;   
    }

    /**
     * Methode qui verifie si un deplacement est possible
     * @param from Position : Position de depart de la piece a deplacer
     * @param to Position : Position d'arrivee de la piece a deplacer
     * @return boolean : Retourne si la piece peut etre deplacee ou non
     */
    public boolean deplacer (Position from, Position to){

        if (getCase(from.getX(), from.getY()) != null){
            
            ArrayList<Position> poss = getCase(from).getDeplacementPossible(this);
            
            int i;

            for (i=0; i < poss.size(); i++){
                if (poss.get(i).equals(to)){
                    return true;
                }
            }
        }
        return false;
    }

     
    /**
     * Methode servant a recuperer un roi selon sa couleur
     * @param color char : Precise la couleur du roi souhaite
     * @return Piece : Retourne la piece du roi recherche
     */
    public Piece getRoi(char color){
        int i;

        for (i=0; i < this.plateau.size(); i++){
           if ((this.plateau.get(i).getType().equals("roi")) && (this.plateau.get(i).getCouleur() == color)){
               return this.plateau.get(i);
           }
        }
        return null;
    }

    
    
    // Retourne si un roi est en echec
    /**
     * Methode servant a recuperer un roi selon sa couleur
     * @param color char : Necessite la couleur du roi souhaite
     * @param p Plateau : Necessite le plateau pour controler s'il y a echec
     * @return boolean : Retourne si le roi est en echec ou non
     */
    public boolean estEchec (char color, Plateau p){
        
        int i,j;
        Piece roi = new Roi(getRoi(color).getPosition(), color);

        if (color == 'B'){
            ArrayList<Piece> piecesNoires = p.getPiecesNoires();
            for (i=0; i < piecesNoires.size(); i++){
                ArrayList<Position> deplacementPossNoires = piecesNoires.get(i).getDeplacementPossible(p);
                for (j=0; j < deplacementPossNoires.size(); j++){
                    if (deplacementPossNoires.get(j).equals(roi.getPosition())){
                        return true;
                    }
                }   
            }
        }
        else {
            ArrayList<Piece> piecesBlanches = p.getPiecesBlanches();
            for (i=0; i < piecesBlanches.size(); i++){
                ArrayList<Position> deplacementPossBlanches = piecesBlanches.get(i).getDeplacementPossible(p);
                for (j=0; j < deplacementPossBlanches.size(); j++){
                    if (deplacementPossBlanches.get(j).equals(roi.getPosition())){
                        return true;
                    }
                }   
            }
        }
        return false;
    }
}
