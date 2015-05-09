package SatChecker;

import java.util.ArrayList;

/**
 * Classe che contiene l'algoritmo di ClosureCongruence.
 *
 * @author Diego Sempreboni
 */
public class CCDP {

    private ArrayList<Relation> equality;
    private ArrayList<Relation> disequality;
    private ArrayList<Node> nodes;

    /**
     * Metodo costruttore di ClosureCongruence.
     *
     * @param equality ArrayList di uguaglianze.
     * @param disequality ArrayList di disuguaglianze.
     * @param nodes ArrayList di nodi.
     */
    public CCDP(ArrayList<Relation> equality, ArrayList<Relation> disequality, ArrayList<Node> nodes) {
        this.equality = equality;
        this.disequality = disequality;
        this.nodes = nodes;
    }

    /**
     * Metodo che ritorna un nodo, se esiste, altrimenti ritorna null.
     *
     * @param id Identificativo del nodo da cercare.
     * @return Il nodo.
     */
    public Node node(int id) {
        for (Node n : nodes) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    /**
     * Metodo Find dell'algoritmo di ClosureCongruence
     *
     * @param id Find del nodo da ricercare.
     * @return Id Find.
     */
    public int find(int id) {
        Node n = node(id);
        if (n.getFind() == id) {
            return id;

        } else {
            return find(n.getFind());
        }
    }

    /**
     * Metodo che ritorna i CCPAR di un FIND passato.
     *
     * @param id Find passato.
     * @return ArrayList di CCPAR.
     */
    public ArrayList<Integer> ccpar(int id) {
        return (node(find(id)).getCcpar());
    }

    /**
     * Metodo Union dell'algoritmo di ClosureCongruence
     *
     * @param i1 ID del nodo da unire.
     * @param i2 ID del nodo da unire.
     */
    public void union(int i1, int i2) {
        Node n1 = node(find(i1));
        Node n2 = node(find(i2));

        n2.appendCcpar(ccpar(i1));
        n1.setFind(find(i2));
        n1.clearCcpar();
    }

    /**
     * Metodo Merge dell'algoritmo di ClosureCongruence
     *
     * @param i1 ID del nodo su cui chiamare merge.
     * @param i2 ID del nodo su cui chiamare merge.
     */
    public void merge(int i1, int i2) {
        if (find(i1) != find(i2)) {
            ArrayList<Integer> Pi1 = (ArrayList<Integer>) ccpar(i1).clone();
            ArrayList<Integer> Pi2 = (ArrayList<Integer>) ccpar(i2).clone();

            union(i1, i2);

            for (int element1 : Pi1) {
                for (int element2 : Pi2) {
                    if (find(element1) != find(element2) && congruent(element1, element2)) {
                        merge(element1, element2);
                    }
                }
            }
        }
    }

    /**
     * Metodo che verifica la congruenza tra due nodi.
     *
     * @param i1 ID del nodo.
     * @param i2 ID del nodo.
     * @return Vero, se sono congruenti, falso altrimenti.
     */
    public boolean congruent(int i1, int i2) {
        Node n1 = node(i1);
        Node n2 = node(i2);
        boolean k = n1.getFn().equalsIgnoreCase(n2.getFn()) && n1.getArgs().size() == n2.getArgs().size();
        if (!k) {
            return k;
        } else {
            for (int i = 0; i < n2.getArgs().size(); i++) {
                k = k && find(n1.getArgs().get(i)) == find(n2.getArgs().get(i));
            }
            return k;
        }
    }

    /**
     * Metodo che esegue l'algoritmo.
     *
     * @return Vero se l'insieme di formule è soddisfacibile, falso altrimenti.
     */
    public boolean execute() {
        for (Relation rel : equality) {
            merge(rel.getFirst(), rel.getSecond());
        }
        for (Relation rel : disequality) {
            if (find(rel.getFirst()) == find(rel.getSecond())) {
                return false;
            }
        }
        return true;
    }
}
