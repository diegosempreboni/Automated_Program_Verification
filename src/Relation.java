package SatChecker;


/**
 * Classe che rappresenta una relazione binaria tra nodi.
 * @author Diego Sempreboni
 */
public class Relation {
    private int first;
    private int second;

    /**
     * Costruttore di Relationship
     * @param first Primo elemento della relazione binaria.
     * @param second Secondo elemento della relazione binaria.
     */
    public Relation(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * Metodo che ritorna il primo elemento della relazione.
     * @return Il primo elemento.
     */
    public int getFirst() {
        return first;
    }

    /**
     * Metodo che imposta il primo elemento della relazione.
     * @param first Parametro da impostare.
     */
    public void setFirst(int first) {
        this.first = first;
    }

    /**
     * Metodo che ritorna il secondo elemento della relazione.
     * @return Il secondo elemento.
     */
    public int getSecond() {
        return second;
    }

    /**
     * Metodo che imposta il secondo elemento della relazione.
     * @param second Parametro da impostare.
     */
    public void setSecond(int second) {
        this.second = second;
    }
    
    /**
     * Metodo che clona una relazione.
     * @return La nuova relazione.
     */
    public Relation clone(){
        return new Relation(first,second);
    }
    
}
