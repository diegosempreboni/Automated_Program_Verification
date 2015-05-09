package SatChecker;


import java.util.ArrayList;

/**
 * Classe che rappresenta il contenuto di un nodo della procedura.
 * @author Diego Sempreboni
 */
public class Node {

    private int id;
    private String fn;
    private int find;
    private ArrayList<Integer> args;
    private ArrayList<Integer> ccpar;

    /**
     * Costruttore di Node.
     * @param id Identificativo del nodo.
     * @param fn Nome testuale.
     * @param find Find del nodo.
     * @param args Argomenti del nodo.
     * @param ccpar Padri del nodo.
     */
    public Node(int id, String fn, int find, ArrayList<Integer> args, ArrayList<Integer> ccpar) {
        this.id = id;
        this.fn = fn;
        this.find = find;
        if (args != null) {
            this.args = args;
        } else {
            this.args = new ArrayList<Integer>();
        }
        if (ccpar != null) {
            this.ccpar = ccpar;
        } else {
            this.ccpar = new ArrayList<Integer>();
        }        
    }
    
    /**
     * Metodo che ritorna l'identificativo del nodo.
     * @return Identificativo.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo che imposta l'identificativo del nodo.
     * @param id Id da impostare.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo che ritorna il nome testuale del nodo.
     * @return Il nome testuale.
     */
    public String getFn() {        
        return fn;
    }

    /**
     * Metodo che imposta il nome testuale del nodo.
     * @param fn Il nome da impostare.
     */
    public void setFn(String fn) {
        this.fn = fn;
    }

    /**
     * Metodo che ritorna il find del nodo.
     * @return Il find del nodo.
     */
    public int getFind() {
        return this.find;
    }

    /**
     * Metodo che ritorna l'intero nodo.
     * @return Il nodo.
     */
    public Node getNode() {
        return this;
    }

    /**
     * Metodo che setta il find del nodo.
     * @param find Il valore del find da settare.
     */
    public void setFind(int find) {
        this.find = find;
    }

    /**
     * Metodo che ritorna l'ArrayList di ARGS.
     * @return L'ArrayList di ARGS.
     */
    public ArrayList<Integer> getArgs() {
        return args;
    }
    
    /**
     * Metodo che ritorna una stringa contenente tutti i ARGS.
     * @return La stringa degli ARGS.
     */
    public String getAllArgs(){
        return args.toString();
    }
    
    /**
     * Metodo che ritorna una stringa contenente tutti i CCPAR.
     * @return La stringa dei CCPAR.
     */
    public String getAllCcpar(){
        return ccpar.toString();
    }

    /**
     * Metodo che ritorna la lista di CCPAR.
     * @return La lista di CCPAR.
     */
    public ArrayList<Integer> getCcpar() {
        return ccpar;
    }

    /**
     * Metodo che imposta un'intera lista di ARGS.
     * @param arg La nuova lista
     */
    public void setArgs(ArrayList<Integer> arg) {
        this.args = arg;
    }

    /**
     * Metodo che imposta un'intera lista di CCPAR.
     * @param ccp La nuova lista.
     */
    public void setCcpar(ArrayList<Integer> ccp) {
        this.ccpar = ccp;
    }

    /**
     * Metodo che aggiunge più CCPAR all'ArrayList di argomenti.
     * @param ccpar La lista di CCPAR da aggiungere.
     */
    public void appendCcpar(ArrayList<Integer> ccpar) {
        for (int element : ccpar) {
            if (!this.ccpar.contains(element)) {
                this.ccpar.add(element);
            }
        }
    }

    /**
     * Metodo che aggiunge un'CCPAR all'ArrayList di argomenti.
     * @param ccp Argomento da aggiungere.
     */
    public void appendCCP(int ccp) {
        if (!this.ccpar.contains(ccp)) {
            this.ccpar.add(ccp);
        }
    }

    /**
     * Metodo che aggiunge più ARG all'ArrayList di argomenti.
     * @param args La lista di ARGS da aggiungere.
     */
    public void appendArgs(ArrayList<Integer> args) {
        for (int element : args) {
            if (!this.args.contains(element)) {
                this.args.add(element);
            }
        }
    }

    /**
     * Metodo che aggiunge un'ARG all'ArrayList di argomenti.
     * @param arg Argomento da aggiungere.
     */
    public void appendArg(int arg) {
        if (!this.args.contains(arg)) {
            this.args.add(arg);
        }
    }

    /**
     * Metodo che elimina tutti i CCPAR del nodo.
     */
    public void clearCcpar() {
        this.ccpar.clear();
    }

    /**
     * Metodo che controlla se due nodi hanno uguale nome testuale.
     * @param n Il nodo di confronto.
     * @return Vero se hanno nome uguale, falso altrimenti.
     */
    public boolean isEqualFn(Node n) {
        return n.getFn().equals(this.getFn());
    }

    /**
     * Metodo che confronta due nodi.
     * @param n Il nodo di confronto.
     * @return Vero se sono uguali, falso altrimenti.
     */
    public boolean isEqual(Node n) {
        return n.getFn().equals(this.getFn()) && n.getCcpar().containsAll(this.getCcpar()) && n.getArgs().containsAll(this.getArgs());
    }

    /**
     * Metodo che crea una stringa con i dati del nodo.
     * @return La stringa con tutti i dati del nodo.
     */
    public String toString() {
        return "NODE\n\tid:" + this.id + "\n\tfn:" + this.fn + "\n\tfind:"
                + this.find + "\n\targs:" + this.args.toString()
                + "\n\tccpar:" + this.ccpar.toString();
    }
    
    /**
     * Metodo che clona un nodo.
     * @return Il nuovo nodo clonato.
     */
    public Node clone(){
        return new Node(id,fn,find,(ArrayList<Integer>)args.clone(),(ArrayList<Integer>)ccpar.clone());
    }
}
