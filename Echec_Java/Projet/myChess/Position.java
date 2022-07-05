package myCheesLib;

/**
 * Cette classe se caracterise par les informations suivantes :
 * 
 * <br><br><u> <b>Attributs : </b> </u><br>  
 * 
 * <ul>
 * <li> int x : Coordonnee x d'une position (attention ordonnee)</li>
 * <li> int y : Coordonnee y d'une position (attention abscisse)</li>
 * </ul>
 * 
 * <br><u> <b>Description des principales fonctionnalites de la classe : </b> </u><br><br> 
 * 
 * Cette classe peut construire une position. Afin de pouvoir placer et deplacer les pieces, chacune d'entre elles possedent une position 
 * 
 * 
 * @author Kabeya Jude
 * @version V1
 */
public class Position {

    /**  Attributs de coordonnee */
    private int x, y;
    
    /** 
     * Initialise une position à (0,0)
    */
    public Position(){
        this.x = 0;
        this.y = 0;
    }

    /** 
     * Constructeur par copie
     * @param p Position : Position à recopier
    */
    public Position(Position p){
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * Instanciation de l'etat de l'objet avec 2 int pour abscisse et l'ordonnee
     * @param thatX int : Coordonnee x
     * @param thatY int : Coordonnee y
     */
    public Position(int thatX, int thatY){
        if ((thatX >= 0 && thatX <= 7) && (thatY >= 0 && thatX <= 7)){
            this.x = thatX;
            this.y = thatY;
        }
    }

    // Constructeur prenant 1 string par args (1 lettre en maj + 1 chiffre)
    /**
     * Instanciation de l'etat de l'objet avec 1 string pour une lecture des cases classique (ex: A1)
     * @param pos String : Coordonee en lecture classique (ex : A1, B1...)
     */
    public Position(String pos){ 
        char yChar = pos.charAt(0); 
        char xChar = pos.charAt(1); 

        int thatY = yChar - 'A'; // Soustraction par 'A' (code ascii) pour récup position
        int thatX = (xChar - '8') * (-1); // Soustraction par '8' (code ascii) puis multiplication par -1 pour récup position

        if (thatX >= 0 && thatX <= 7 && thatY >= 0 && thatX <= 7){
            this.x = thatX; 
            this.y = thatY;
        }
    }

    /**
     * Getteur de x (ordonnee)

     * @return int : Retourne x (ordonnee)
     */
    public int getX(){
        return this.x;
    }

    /**
     * Getteur de y (abscisse)

     * @return int : Retourne y (abscisse)
     */
    public int getY(){
        return this.y;
    }


    /**
     * Setteur de x (ordonnee)
     * @param thatX int : Modification de l'ordonnee d'une piece
     */
    public void setX(int thatX){
        if (thatX >= 0 && thatX <= 7){
            this.x = thatX;
        }
    }

    /**
     * Setteur de y (abscisse)
     * @param thatY int : Modification de l'abscisse d'une piece
     */
    public void setY(int thatY){
        if (thatY >= 0 && thatY <= 7){
            this.y = thatY;
        }
    }

    /** Methode equals permettant de savoir si deux objets position sont identiques
     * @param obj Object : Objet de comparaison
     * @return boolean : Retourne si l'egalite entre deux positions est vraie ou fausse
     */
    public boolean equals(Object obj){
        if (obj instanceof Position == false){
            return false;
        }
    
        Position that = (Position)obj;
        
        if (this.x != that.getX() || this.y != that.getY()){
            return false;
        }
        else{
            return true;
        }
    }

    
    @Override
    /** Methode permettant d'afficher une position correctement
     * @return String : Retourne la position en format string
    */
    public String toString() {
        // TODO Auto-generated method stub

        int xInt = '8' - (char)this.x;
        int yInt = (char)this.y + 'A';
        

        char xChar = (char)xInt;
        char yChar = (char)yInt;

        String posFinale = Character.toString(yChar) + Character.toString(xChar);
        return posFinale;
    }
}