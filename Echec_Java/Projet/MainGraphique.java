import MG2D.*;
import MG2D.geometrie.*;
import myCheesLib.Plateau;
import myCheesLib.Position;
import myCheesLib.pieces.Piece;

import java.util.ArrayList;

public class MainGraphique {
    
    private static final int TAILLE = 100; // TAILLE d'une case
    private static final int ORIGINEX = -100; // position X de la première case
    private static final int ORIGINEY = 800; // position Y de la première case


    // Réalisation du damier
    static void affichageDamier (Fenetre f, char joueur, Plateau p){
        
        int i, j;
        int cptCase = 1; // attribut pour réalisation l'alternance de couleur du damier

        // --------------------- Réalisation du damier ---------------------
            
       
        for (i = 1; i <= 8; i++){
            for (j = 1; j <= 8; j++){

                if ((cptCase + i) % 2 == 0){ // reste de la div eucli de nb de case + nb colonne (pour que ce soit 1 sur 2 sur les lignes) par 2

                    // Case claire
                    Carre c = new Carre(new Couleur(242, 228, 197), new Point(ORIGINEX + (j * TAILLE), ORIGINEY - (i * TAILLE)), TAILLE, true);
                    f.ajouter(c);
                }
                else {
                    // Case foncée
                    Carre c = new Carre(new Couleur(153, 51, 0), new Point(ORIGINEX + (j * TAILLE), ORIGINEY - (i * TAILLE)), TAILLE, true);
                    f.ajouter(c);
                }
                cptCase++;
            }
        }

        // Si il y a échec
        if (p.estEchec(joueur, p) == true){
            Carre c = new Carre(Couleur.ORANGE, new Point(ORIGINEX + ((p.getRoi(joueur).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((p.getRoi(joueur).getPosition().getX() + 1) * TAILLE)), TAILLE, true);
            f.ajouter(c);
        }
    }

    // Placement pièces blanches
    static void affichagePiecesBlanches (Fenetre f, Plateau p, ArrayList<Piece> piecesBlanches){
        
        int i;
 
        // --------------------- Placement pièces blanches ---------------------

        // 1. Parcours l'ensemble de la liste des pièces blanches restantes
        // 2. Compare le type de la pièce pour lui attribuer une image
        // 3. Création d'une image avec position X = (ORIGINEX + (position Y de la pièce + 1) * TAILLE d'une case + 1 (pour qu'il soit au milieu de la case)
        // 4. Création d'une image avec position X = (ORIGINEY - (position X de la pièce + 1) * TAILLE d'une case
        for (i = 0; i < piecesBlanches.size(); i++){
            if (piecesBlanches.get(i).getType().equals("pion")){
                Texture img = new Texture("./images_eches/pion_B.png", new Point(ORIGINEX + ((piecesBlanches.get(i).getPosition().getY() + 1) * (TAILLE + 1)), ORIGINEY - ((piecesBlanches.get(i).getPosition().getX() + 1) * (TAILLE))), TAILLE - 5, TAILLE - 5);
                f.ajouter(img);
            }
            else if (piecesBlanches.get(i).getType().equals("tour")){
                Texture img2 = new Texture("./images_eches/tour_B.png", new Point(ORIGINEX + ((piecesBlanches.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesBlanches.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img2);
            }
            else if (piecesBlanches.get(i).getType().equals("fou")){
                Texture img3 = new Texture("./images_eches/fou_B.png", new Point(ORIGINEX + ((piecesBlanches.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesBlanches.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img3);
            }
            else if (piecesBlanches.get(i).getType().equals("cavalier")){
                Texture img4 = new Texture("./images_eches/cavalier_B.png", new Point(ORIGINEX + ((piecesBlanches.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesBlanches.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img4);
            }
            else if (piecesBlanches.get(i).getType().equals("dame")){
                Texture img5 = new Texture("./images_eches/reine_B.png", new Point(ORIGINEX + ((piecesBlanches.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesBlanches.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img5);
            }
            else if (piecesBlanches.get(i).getType().equals("roi")){
                Texture img6 = new Texture("./images_eches/roi_B.png", new Point(ORIGINEX + ((piecesBlanches.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesBlanches.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img6);
            }   
        }
    }

    // Placement pièces blanches
    static void affichagePiecesNoires (Fenetre f, Plateau p, ArrayList<Piece> piecesNoires){
        
        int i;
        
        // --------------------- Placement pièces noires ---------------------

        // 1. Parcours l'ensemble de la liste des pièces noires restantes
        // 2. Compare le type de la pièce pour lui attribuer une image
        // 3. Création d'une image avec position X = (ORIGINEX + (position Y de la pièce + 1) * TAILLE d'une case + 1 (pour qu'il soit au milieu de la case)
        // 4. Création d'une image avec position X = (ORIGINEY - (position X de la pièce + 1) * TAILLE d'une case
        for (i = 0; i < piecesNoires.size(); i++){
            if (piecesNoires.get(i).getType().equals("pion")){
                Texture img = new Texture("./images_eches/pion_N.png", new Point(ORIGINEX + ((piecesNoires.get(i).getPosition().getY() + 1) * (TAILLE + 1)), ORIGINEY - ((piecesNoires.get(i).getPosition().getX() + 1) * (TAILLE))), TAILLE - 5, TAILLE - 5);
                f.ajouter(img);
            }
            else if (piecesNoires.get(i).getType().equals("tour")){
                Texture img2 = new Texture("./images_eches/tour_N.png", new Point(ORIGINEX + ((piecesNoires.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesNoires.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img2);
            }
            else if (piecesNoires.get(i).getType().equals("fou")){
                Texture img3 = new Texture("./images_eches/fou_N.png", new Point(ORIGINEX + ((piecesNoires.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesNoires.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img3);
            }
            else if (piecesNoires.get(i).getType().equals("cavalier")){
                Texture img4 = new Texture("./images_eches/cavalier_N.png", new Point(ORIGINEX + ((piecesNoires.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesNoires.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img4);
            }
            else if (piecesNoires.get(i).getType().equals("dame")){
                Texture img5 = new Texture("./images_eches/reine_N.png", new Point(ORIGINEX + ((piecesNoires.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesNoires.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img5);
            }
            else if (piecesNoires.get(i).getType().equals("roi")){
                Texture img6 = new Texture("./images_eches/roi_N.png", new Point(ORIGINEX + ((piecesNoires.get(i).getPosition().getY() + 1) * TAILLE), ORIGINEY - ((piecesNoires.get(i).getPosition().getX() + 1) * TAILLE)), TAILLE - 5, TAILLE - 5);
                f.ajouter(img6);
            }            
        }  
    }

    // Affichage des déplacements d'un pion
    static void affichageDeplacement (Fenetre f, ArrayList<Position> posPossible){
        
        int i, j;

        // Permet d'afficher l'ensemble des possibilités
        for (i = 0; i < posPossible.size(); i++){

            // Permet de faire des cercles plus gros
            for (j = 0; j < 5; j++){
                
                Cercle c = new Cercle(Couleur.ROUGE, new Point(posPossible.get(i).getY()* 100 + 50, (((posPossible.get(i).getX() - 8) *(-1) + 1) * 100 - 150)), TAILLE/2 - j, false);
                f.ajouter(c);
            }   
        }
    }

    // Déplace le pion 
    static void Deplacement (Plateau plateau, Position from, Position to){
    
        int i;
        // -------------- Déplace pion --------------
        
        // Si case To est vide --> deplacer
        if (plateau.getCase(to) == null){
            plateau.getCase(from).setPosition(to);
        }

        // Si pas vide --> alors virer la piece sur To + deplacer 
        else{
            
            for (i = 0; i < plateau.plateau.size(); i++){

                if (plateau.plateau.get(i).getPosition().equals(to) == true){
                    plateau.plateau.remove(i); 
                    plateau.getCase(from).setPosition(to); 
                    break;
                }
            }
        }
    }

    // Pour alterner le tour des joueurs 
    static char changementJoueur(char c){
        if (c == 'B'){
            return 'N';
        }
        else {
            return 'B';
        }
    }


    public static void main(String[] args){
        
        Plateau p = new Plateau(); // Création et instanciation d'un échiquier

        Fenetre f = new Fenetre("Echec", 800, 800); // Création de la fenêtre d'interface

        char joueur = 'N'; // variable pour alterner le tour des joueurs

        boolean jeuFini = false;
        

        // Boucle qui fait tourner le jeu et qui s'arrête dès que l'un des joueurs gagnes ou match nul
        while (jeuFini != true){
            
            joueur = changementJoueur(joueur); // alterner le tour des joueurs

            // listes des pièces restantes de chaque couleur
            ArrayList<Piece> piecesBlanches = p.getPiecesBlanches(); 
            ArrayList<Piece> piecesNoires = p.getPiecesNoires();

            affichageDamier(f, joueur, p);
            affichagePiecesBlanches(f, p, piecesBlanches);
            affichagePiecesNoires(f, p, piecesNoires);
            
            f.rafraichir();

            Souris souris = f.getSouris(); // Nécessaire pour récup coordonée d'un clic   
        
            Position from = new Position(); // Position qui sera modifiée selon le clic de l'user
            Position to = new Position(); // Position qui sera modifiée selon le clic de l'user

            
            boolean deplacement = false;
            
            out: // Point de sortir si user dé-selectionne une pièce

            // Boucle qui s'arrête lorsque le déplacement est validé
            while (deplacement != true){
                
                // Boucle from correspond à une piece 
                boolean fromValide = false;
                
                while (fromValide == false){
                    
                    // Boucle pour attendre un clic gauche de l'user
                    while ( !souris.getClicGauche()){
                        try{
                            Thread.sleep(1);
                        }
                        catch (Exception e){}
                    }
                    
                    // Récup coordonnée du clic 
                    int xFrom = souris.getPosition().getX()/100; 
                    int yFrom = souris.getPosition().getY()/100;
                    
                    int rowFrom = (yFrom - 8) * (-1) - 1;
                    int columnFrom = xFrom;
                    
                    from = new Position(rowFrom, columnFrom); // vrai instanciation

                    try {
                        
                        // Pour éviter un bug (case A1 choisi par défaut lorsque l'on clique sans bouger la souris)
                        if ((souris.getPosition().getX() == -1) && (souris.getPosition().getY() == -1)){

                        }
                        // Si pièce ne peut pas bouger 
                        else if (p.getCase(from).getDeplacementPossible(p).size() == 0){
                            System.out.println("\n Aucune déplacement possible pour cette pièce \n");
                        }

                        else if (p.getCase(from).getCouleur() != joueur){
                            System.out.println("\n Pas touche ! Ce n'est pas ton pion ! \n");
                        }
                
                        // Vérifie s'il y a une pièce sur la case que l'user à sélectionnée
                        else{
                            fromValide = true;
                        }
                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println("\n Aucune pièce choisie\n");
                    }
                }
                
                ArrayList<Position> posPossible = p.getCase(from).getDeplacementPossible(p); // Récupération de la liste des poss
                                
                affichageDeplacement(f, posPossible); // Affichage des possibilités de déplacement
                
                f.rafraichir();

                // Boucle qui vérif si déplacement autorisé 
                boolean toValide = false;
                
                while (toValide != true){
                    
                    // Boucle pour attendre un clic gauche de l'user
                    while ( !souris.getClicGauche()){
                        try{
                            Thread.sleep(1);
                        }
                        catch (Exception e){}
                    }

                    // Récup coordonnée du clic 
                    int xTo = souris.getPosition().getX()/100; 
                    int yTo = souris.getPosition().getY()/100;
                    int rowTo = (yTo - 8) * (-1) - 1;
                    int columnTo = xTo;
                    to = new Position(rowTo, columnTo);
                    
                    // Si il y a échec
                    if ((p.estEchec(joueur, p) == true) && (p.deplacer(from, to) == true)){
                        Plateau cloneP = new Plateau(p);
                        Deplacement(cloneP, from, to);

                        if (cloneP.estEchec(joueur, cloneP) == false){
                            toValide = true;
                            deplacement = true;
                        }
                        else {
                            System.out.println("Vous êtes toujours en échec, choisissez une autre case.");
                        }

                    }

                    // Si déplacement possible --> changement de la variable deplacement
                    else if (p.deplacer(from, to) == true){
                        
                        Plateau cloneP = new Plateau(p);
                        Deplacement(cloneP, from, to);

                        // Vérif qu'une fois pièce déplacer il n'y a pas échec
                        if (cloneP.estEchec(joueur, cloneP) == false){
                            toValide = true;
                            deplacement = true;
                        }
                        else {
                            System.out.println("Vous ne pouvez pas bouger, vous serez en échec.");
                        }
                    }

                    // Si user déselectionne la pièce choisie --> retourne au début du programme
                    else{
                        f.effacer();
                        affichageDamier(f, joueur, p);
                        affichagePiecesBlanches(f, p, piecesBlanches);
                        affichagePiecesNoires(f, p, piecesNoires);
                        f.rafraichir();
                        continue out;
                    }
                }
            }

            Deplacement(p, from, to);
            
            f.effacer();
        }                
    }
}
