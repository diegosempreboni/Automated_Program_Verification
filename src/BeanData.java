package SatChecker;

import java.util.ArrayList;

/**
 * Classe che rappresenta una formula.
 *
 * @author Diego Sempreboni
 */
public class BeanData {

    private ArrayList<Relation> equality;
    private ArrayList<Relation> disequality;

    /**
     * Costruttore di BeanData.
     *
     * @param eq ArrayList di Relazioni binarie di sole uguaglianze.
     * @param diseq ArrayList di Relazioni binarie di sole disuguaglianze.
     */
    public BeanData(ArrayList<Relation> eq, ArrayList<Relation> diseq) {

        equality = new ArrayList<Relation>();
        for (Relation e : eq) {
            this.equality.add(e.clone());
        }
        disequality = new ArrayList<Relation>();
        for (Relation e : diseq) {
            this.disequality.add(e.clone());
        }
    }

    /**
     * Metodo che ritorna le uguaglianze del bean.
     *
     * @return ArrayList di uguaglianze.
     */
    public ArrayList<Relation> getEquality() {
        return equality;
    }

    /**
     * Metodo che setta le uguaglianze del bean.
     *
     * @param equality Il nuovo ArrayList di uguaglianze.
     */
    public void setEquality(ArrayList<Relation> equality) {
        this.equality = equality;
    }

    /**
     * Metodo che ritorna le disuguaglianze del bean.
     *
     * @return ArrayList di disuguaglianze.
     */
    public ArrayList<Relation> getDisequality() {
        return disequality;
    }

    /**
     * Metodo che setta le disuguaglianze del bean.
     *
     * @param disequality Il nuovo ArrayList di disuguaglianze.
     */
    public void setDisequality(ArrayList<Relation> disequality) {
        this.disequality = disequality;
    }
}
