package SatChecker;

import java.util.ArrayList;

/**
 * Classe che rappresenta un nodo dell'albero.
 *
 * @author Diego Sempreboni
 */
public class TreeChoose {

    BeanData bean;
    TreeChoose subsx;
    TreeChoose subdx;
    TreeChoose father;
    boolean root = false;

    /**
     * Costruttore vuoto
     */
    public TreeChoose() {
    }

    /**
     * Metodo che ritorna se un nodo è il nodo padre.
     *
     * @return Vero se è padre, Falso altrimenti.
     */
    public boolean isRoot() {
        return root;
    }

    /**
     * Metodo che imposta un nodo a padre.
     *
     * @param root Valore.
     */
    public void setIsRoot(boolean root) {
        this.root = root;
    }

    /**
     * Metodo che ritorna il padre del nodo.
     *
     * @return TreeChoose padre.
     */
    public TreeChoose getFather() {
        return father;
    }

    /**
     * Metodo che imposta un padre per il nodo.
     *
     * @param father Il nodo padre.
     */
    public void setFather(TreeChoose father) {
        this.father = father;
    }

    /**
     * Metodo che ritorna un Bean, ovvero una formula.
     *
     * @return La formula.
     */
    public BeanData getBean() {
        return bean;
    }

    /**
     * Metodo che imposta un bean.
     *
     * @param bean Il bean da impostare.
     */
    public void setBean(BeanData bean) {
        this.bean = bean;
    }

    /**
     * Metodo che ritorna il figlio sinistro.
     *
     * @return Il figlio sinistro del nodo.
     */
    public TreeChoose getSubsx() {
        return subsx;
    }

    /**
     * Metodo che imposta il figlio sinistro del nodo.
     *
     * @param subsx Il nodo sinistro da impostare.
     */
    public void setSubsx(TreeChoose subsx) {
        this.subsx = subsx;
    }

    /**
     * Metodo che ritorna il figlio destro.
     *
     * @return Il figlio destro del nodo.
     */
    public TreeChoose getSubdx() {
        return subdx;
    }

    /**
     * Metodo che imposta il figlio destro del nodo.
     *
     * @param subdx Il nodo destro da impostare.
     */
    public void setSubdx(TreeChoose subdx) {
        this.subdx = subdx;
    }

    /**
     * Metodo che ritorna se un nodo è terminale, ovvero il figlio destro e
     * sinistro sono null.
     *
     * @return Vero se è terminale, falso altrimenti.
     */
    public boolean isTerminal() {
        return this.subdx == null && this.subsx == null;
    }

    /**
     * Metodo che stampa l'albero completo.
     *
     * @param s Stringa dell'albero parziale.
     * @return La stringa dell'albero completo.
     */
    public String printString(String s) {
        String rey = "";
        rey = rey + "o\n";
        if (subsx != null && subdx != null) {
            rey = rey + s + "|-> ";
            rey = rey + subsx.printString(s + "|      ");
            rey = rey + s + "|-> ";
            rey = rey + subdx.printString(s + "       ");
        } else {
        }
        return rey;
    }

    /**
     * Metodo che clona un nodo.
     *
     * @return Il nodo clonato.
     */
    public TreeChoose clone() {
        TreeChoose newElement = new TreeChoose();
        if (this.subdx != null && this.subdx != null) {
            newElement.subdx = this.subdx.clone();
            newElement.subsx = this.subsx.clone();
            newElement.subsx.father = newElement;
            newElement.subdx.father = newElement;
        }
        newElement.root = this.root;
        newElement.bean = this.bean;
        return newElement;
    }

    /**
     * Metodo che ritorna un ArrayList con tutte le uguaglianze.
     *
     * @return L'ArrayList con le uguaglianze.
     */
    public ArrayList<Relation> getBeanEqualities() {
        ArrayList<Relation> r = new ArrayList<Relation>();
        r.addAll(this.getBean().getEquality());
        if (!this.isRoot()) {
            r.addAll(this.getFather().getBeanEqualities());
        }
        return r;
    }

    /**
     * Metodo che ritorna un ArrayList con tutte le disuguaglianze.
     *
     * @return L'ArrayList con le disuguaglianze.
     */
    public ArrayList<Relation> getBeanDisequalities() {
        ArrayList<Relation> r = new ArrayList<Relation>();
        r.addAll(this.getBean().getDisequality());
        if (!this.isRoot()) {
            r.addAll(this.getFather().getBeanDisequalities());
        }
        return r;
    }
}
