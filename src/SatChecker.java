package SatChecker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

/**
 * Verificatore per la teoria degli array senza estensionalità
 *
 * @version 1.0
 * @author Diego Sempreboni
 */
public class SatChecker extends JFrame {

    /**
     * Barra dei menu per il programma.
     */
    private JMenuBar menuBar = new JMenuBar();
    /**
     * Elemento Menu.
     */
    private JMenu fileMenu;
    /**
     * Elemento AboutMenu.
     */
    private JMenu aboutMenu;
    /**
     * Item per l'elemento Menu per l'apertura di un file.
     */
    private JMenuItem openFile;
    /**
     * Item per l'elemento Menu per la chiusura del programma.
     */
    private JMenuItem exit;
    /**
     * Item per l'elemento About per l'apertura della finestra about.
     */
    private JMenuItem about;
    /**
     * Variabile per la gestione del file letto.
     */
    private File file;
    /**
     * Buffer per il file.
     */
    private BufferedReader br;
    /**
     * Stringa di appoggio per il travaso delle righe del buffer.
     */
    private String strLine;
    /**
     * Area sinistra alta per la stampa dell'albero.
     */
    private JTextArea areasxtop;
    /**
     * Area sinistra bassa per la console.
     */
    private JTextArea areasxbottom;
    /**
     * Scroll destra alta.
     */
    private JScrollPane scrolldxtop;
    /**
     * Scroll destra bassa.
     */
    private JScrollPane scrolldxbottom;
    /**
     * Scroll sinistra alta.
     */
    private JScrollPane scrollsxtop;
    /**
     * Scroll sinistra bassa.
     */
    private JScrollPane scrollsxbottom;
    /**
     * Finestra che gestisce la creazione della finestra per l'apertura del
     * file.
     */
    private JFileChooser fileChooser;
    /**
     * Variabile Long per contenere il tempo di partenza del re-factoring.
     */
    private long timerFactory;
    /**
     * Variabile Long per contenere il tempo di partenza per la creazione dei
     * nodi.
     */
    private long timerNode;
    /**
     * Variabile Long per contenere il tempo di partenza per la Chiusura di
     * Congruenza.
     */
    private long timerClousure;
    /**
     * Variabile Long per contenere il tempo finale del re-factoring.
     */
    private long tiOne;
    /**
     * Variabile Long per contenere il tempo finale per la creazione dei nodi.
     */
    private long tiTwo;
    /**
     * Variabile Long per contenere il tempo finale per la Chiusura di
     * Congruenza.
     */
    private long tiThree;
    /**
     * Enumeratore per i nodi.
     */
    private int id = 0;
    /**
     * Enumeratore per le variabili fresh.
     */
    private int fresh = 0;
    /**
     * Tabella che contiene i dati sui singoli nodi.
     */
    private JTable table;
    /**
     * Tabella che contiene i dati sulle singole formule esaminate.
     */
    private JTable tableEq;
    /**
     * Modello per la prima tabella.
     */
    private DefaultTableModel model;
    /**
     * Modello per la seconda tabella.
     */
    private DefaultTableModel modelEq;
    /**
     * Array che identifica le stringhe associate alle colonne per la prima
     * tabella.
     */
    private String[] columnNames;
    /**
     * Array Multidimensionale che identifica i dati presenti dentro la prima
     * tabella.
     */
    private String[][] data;
    /**
     * Array che identifica le stringhe associate alle colonne per la seconda
     * tabella.
     */
    private String[] columnNamesEq;
    /**
     * Array Multidimensionale che identifica i dati presenti dentro la seconda
     * tabella.
     */
    private String[][] dataEq;
    /**
     * Risultato booleano della chiusura di congruenza.
     */
    private boolean sat;
    /**
     * ArrayList dei nodi definitivo.
     */
    private ArrayList<Node> nodes = new ArrayList<Node>();
    /**
     * ArrayList che contiene le uguaglianze definitive.
     */
    private ArrayList<Relation> equality = new ArrayList<Relation>();
    /**
     * ArrayList che contiene le disuguaglianze definitive.
     */
    private ArrayList<Relation> disequality = new ArrayList<Relation>();
    /**
     * ArrayList utilizzato per inserirvi le stringhe contenenti "store" per
     * elaborarle in seguito.
     */
    private ArrayList<String> toDo = new ArrayList<String>();
    /**
     * ArrayList temporaneo per i nodi, utilizzato durante la loro creazione.
     */
    private ArrayList<Node> temp = new ArrayList<Node>();
    /**
     * ArrayList utilizzato per inserire i singoli alberi creati per ogni
     * stringa del file letto.
     */
    private ArrayList<TreeChoose> forest = new ArrayList<TreeChoose>();

    /**
     * Costruttore.
     */
    public SatChecker() {
        /**
         * Proprietà della finestra.
         */
        setTitle("Verificatore");
        setSize(726, 645);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);      // gestore chiusura finestra
        getContentPane().setBackground(new Color(173, 217, 250));
        setJMenuBar(menuBar);
        /**
         * Allocazioni del menu.
         */
        openFile = new JMenuItem("Apri un file...");
        exit = new JMenuItem("Esci da Verificatore");
        fileMenu = new JMenu("File");
        aboutMenu = new JMenu("Info");
        about = new JMenuItem("Riguardo a...");
        aboutMenu.add(about);
        fileMenu.add(openFile);
        fileMenu.add(exit);
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);
        /*
         * Creazione dell'area di destra alta.
         */
        columnNames = new String[]{"ID", "FN", "FIND", "ARGS", "CCPAR"};
        data = new String[1][5];
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setEnabled(false);

        scrolldxtop = new JScrollPane(table);
        scrolldxtop.setBounds(425, 1, 300, 300);
        scrolldxtop.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrolldxtop);

        /*
         * Creazione dell'area di destra bassa.
         */
        columnNamesEq = new String[]{"F", "EQ", "DISEQ"};
        dataEq = new String[1][3];
        modelEq = new DefaultTableModel(dataEq, columnNamesEq);
        tableEq = new JTable(modelEq);
        tableEq.setEnabled(false);

        scrolldxbottom = new JScrollPane(tableEq);
        scrolldxbottom.setBounds(425, 302, 300, 298);
        scrolldxbottom.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrolldxbottom);

        /*
         * Creazione dell'area di sinistra alta.
         */
        areasxtop = new JTextArea();
        areasxtop.setEditable(false);
        areasxtop.setLineWrap(true);
        areasxtop.setWrapStyleWord(true);
        areasxtop.setMargin(new Insets(10, 10, 10, 10));
        areasxtop.setBackground(new Color(255, 255, 255));

        scrollsxtop = new JScrollPane(areasxtop);
        scrollsxtop.setBounds(1, 1, 423, 400);
        scrollsxtop.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollsxtop);

        /*
         * Creazione dell'area di sinistra bassa.
         */
        areasxbottom = new JTextArea();
        areasxbottom.setEditable(false);
        areasxbottom.setBackground(new Color(255, 255, 255));
        areasxbottom.setMargin(new Insets(10, 10, 10, 10));

        scrollsxbottom = new JScrollPane(areasxbottom);
        scrollsxbottom.setBounds(1, 402, 423, 198);
        scrollsxbottom.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollsxbottom);

        /**
         * Azione eseguita alla chiusura del programma.
         */
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                File f = new File("temp.txt");
                f.delete();
                System.exit(0);
            }
        });

        /**
         * Azione eseguita all'apertura del file.
         */
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    clearData();
                    openFile();
                } catch (IOException ex) {
                    areasxbottom.setText("Problemi nell'apertura del file");
                } catch (Exception ex) {
                    areasxbottom.setText("File di input non strutturato correttamente");
                }
            }
        });

        /**
         * Azione eseguita quando viene premuto il tasto about.
         */
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {

                JFrame re = new JFrame();
                re.setResizable(false);
                re.setLayout(new GridLayout());
                re.setLocation(600, 75);
                re.setSize(300, 125);
                aboutPanel(re);
                re.setVisible(true);
            }
        });
    }// Fine del metodo Costruttore.

    /**
     * Metodo che legge un file di testo, e che esegue tutto il programma in
     * ogni sua fase.
     *
     * @throws IOException Eccezione lanciata in caso di problemi di apertura
     * del file.
     * @throws RecognitionException Eccezione generata dalla creazione
     * dell'albero.
     */
    private void openFile() throws IOException, RecognitionException {
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            timerFactory = 0;
            timerFactory = System.nanoTime();
            try {
                br = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(file)));
                areasxbottom.setText("Ho letto il file di testo: " + fc.getSelectedFile().getName() + "\n");
            } catch (FileNotFoundException ex) {
                areasxbottom.setText("Problemi nell'individuare il file\n");
            }
        }

        if (file != null) {
            areasxbottom.append("Creazione del file di testo temporaneo...\n");
            FileOutputStream tempFile = new FileOutputStream("temp.txt");
            PrintStream scrivi = new PrintStream(tempFile);
            areasxbottom.append("Adatto il file di testo letto alla grammatica...\n");
            areasxbottom.append("\n------------------------------------------------");
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("j")) {
                    throw new RecognitionException();
                }
                areasxbottom.append("\n" + strLine + "\n");
                refactoringInput(strLine, scrivi);
            }
            areasxbottom.append("------------------------------------------------\n\n");
            tiOne = (long) ((System.nanoTime() - timerFactory) / Math.pow(10, 6));
            br.close();
            scrivi.close();
            timerNode = 0;
            timerNode = System.nanoTime();
            /*
             * Stringhe già riarrangiate nel nuovo file.
             */
            try {
                br = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream("temp.txt")));
                areasxbottom.append("Leggo il file di testo adattato...\n");
            } catch (FileNotFoundException ex) {
                areasxbottom.setText("Problemi nell'individuare il file\n");
            }
            areasxbottom.append("Analizzo le righe del file...\n");
            areasxbottom.append("\n------------------------------------------------");
            while ((strLine = br.readLine()) != null) {
                areasxbottom.append("\n" + strLine + "\n");
                processingInput(strLine);
            }
            br.close();
            areasxbottom.append("------------------------------------------------\n\n");
            /**
             * Creo un nuovo bean vuoto da passare alla radice.
             */
            BeanData beanZero = new BeanData(equality, disequality);
            /**
             * Creo l'albero.
             */
            TreeChoose root = new TreeChoose();
            /**
             * Imposto che l'albero ha il nodo padre a Root, ovvero la radice.
             */
            root.setIsRoot(true);
            /**
             * Imposto il bean vuoto all'albero.
             */
            root.setBean(beanZero);
            /**
             * Aggiungo l'albero creato alla foresta.
             */
            forest.add(root);
            /**
             * Riarrangio le stringhe che contengono degli store.
             */
            makeString();
            /**
             * Richiamo la procedura per analizzare le stringhe contenenti
             * store.
             */
            preprocessingStore();

            areasxbottom.append("Concateno i singoli alberi creati...\n");
            /**
             * Richiamo il metodo per la concatenazione dei singoli alberi della
             * foresta.
             */
            TreeChoose pronto = concatForest();
            /**
             * Fermo il conteggio per quanto riguarda la creazione dei nodi.
             */
            tiTwo = (long) ((System.nanoTime() - timerNode) / Math.pow(10, 6));
            /**
             * Stampo l'elenco dei nodi e delle uguaglianze e disuguaglianze
             * all'interno delle tabelle.
             */
            toStringNodes(root);

            timerClousure = 0;
            timerClousure = System.nanoTime();
            /**
             * Stampo l'albero nell'area in alto a sinistra.
             */
            areasxtop.setText(pronto.printString(""));
            /**
             * Per ogni nodo terminale all'interno dell'albero lancio la
             * procedura di Chiusura di Congruenza.
             */
            int count = 1;
            for (TreeChoose t : visit(pronto)) {
                if (t.isTerminal()) {
                    areasxbottom.append("Esecuzione della CC su F " + (count++));
                    ArrayList<Relation> eq = t.getBeanEqualities();
                    ArrayList<Relation> diseq = t.getBeanDisequalities();
                    ArrayList<Node> node = new ArrayList<Node>();
                    for (Node n : nodes) {
                        node.add(n.clone());
                    }
                    CCDP c = new CCDP(eq, diseq, node);
                    sat = c.execute();
                    if (sat) {
                        tiThree = (long) ((System.nanoTime() - timerClousure) / Math.pow(10, 6));
                        areasxbottom.append(" "+((sat) ? "SODDISFACIBILE" : "INSODDISFACIBILE\n"));
                        break;
                    }else{
                        areasxbottom.append(" "+((sat) ? "SODDISFACIBILE" : "INSODDISFACIBILE\n"));
                    }
                }
            }
            if (!sat) {
                tiThree = (long) ((System.nanoTime() - timerClousure) / Math.pow(10, 6));
            }

            /**
             * Apro la finestra con il resoconto della procedura.
             */
            JFrame res = new JFrame();
            res.setResizable(false);
            res.setLayout(new GridLayout());
            res.setLocation(100, 100);
            res.setSize(300, 300);
            finalPanel(res);
            res.setVisible(true);
        }
    }

    /**
     * Metodo che genera l'albero solamente delle stringhe che non contengono
     * STORE nella formula, altrimenti le mettono un ArrayList per analizzarle
     * successivamente.
     *
     * @param br Stringa letta.
     * @throws RecognitionException Eccezione generata dalla creazione
     * dell'albero.
     */
    private void processingInput(String br) throws RecognitionException {
        if (br.contains("store")) {
            //Se le stringhe contengono STORE le salvo in un ArrayList per processarle successivamente.
            toDo.add(br);
        } else {
            //Se le stringhe non contengono STORE le processo immediatamente.
            ANTLRStringStream input = new ANTLRStringStream(br);
            ArrayLexer simpleLexer = new ArrayLexer(input);
            CommonTokenStream token = new CommonTokenStream(simpleLexer);
            ArrayParser parser = new ArrayParser(token);
            CommonTree tree = (CommonTree) parser.equality().getTree();
            /**
             * Creato l'albero richiamo la procedura per processare.
             */
            preprocessing(tree, equality, disequality, nodes);
        }
    }

    /**
     * Metodo che genera l'albero solamente delle stringhe che contengono STORE
     * nella formula.
     *
     * @param br Stringa letta.
     * @param eq ArrayList delle uguaglianze.
     * @param diseq ArrayList delle disuguaglianze.
     * @param nod ArrayList dei nodi.
     * @throws RecognitionException Eccezione generata dalla creazione
     * dell'albero.
     */
    private void processingInput(String br, ArrayList<Relation> eq, ArrayList<Relation> diseq, ArrayList<Node> nod) throws RecognitionException {
        ANTLRStringStream input = new ANTLRStringStream(br);
        ArrayLexer simpleLexer = new ArrayLexer(input);
        CommonTokenStream token = new CommonTokenStream(simpleLexer);
        ArrayParser parser = new ArrayParser(token);
        CommonTree tree = (CommonTree) parser.equality().getTree();
        /**
         * Creato l'albero richiamo la procedura per processare.
         */
        preprocessing(tree, eq, diseq, nod);
    }

    /**
     * Metodo che genera l'albero solamente delle stringhe del tipo
     * SELECT(STORE(...)) da analizzare e passare ad analyzeStore.
     *
     * @throws RecognitionException Eccezione generata dalla creazione
     * dell'albero.
     */
    private void preprocessingStore() throws RecognitionException {
        CommonTree tree2;
        /**
         * Per ogni stringa da processare contenente degli store, creo l'albero
         * e lancio la procedura per processarla.
         */
        for (String s : toDo) {
            ANTLRStringStream input2 = new ANTLRStringStream(s);
            ArrayLexer simpleLexer2 = new ArrayLexer(input2);
            CommonTokenStream token2 = new CommonTokenStream(simpleLexer2);
            ArrayParser parser2 = new ArrayParser(token2);
            tree2 = (CommonTree) parser2.equality().getTree();
            TreeChoose complete = analyzeStore(tree2);
            /**
             * Processata la stringa aggiungo l'albero creato alla foresta di
             * alberi.
             */
            forest.add(complete);
        }
    }

    /**
     * Metodo che analizza le stringhe del tipo SELECT(STORE(...))=J...
     *
     * @param tree Albero da cui prendere i figli.
     * @return Albero parziale analizzato, nel caso in cui ci siano più STORE
     * annidati.
     * @throws RecognitionException Eccezione generata dalla creazione
     * dell'albero.
     */
    private TreeChoose analyzeStore(CommonTree tree2) throws RecognitionException {
        /**
         * Figlio sinistro dell'albero.
         */
        CommonTree sxson = (CommonTree) tree2.getChild(0);
        /**
         * Figlio destro dell'albero.
         */
        CommonTree dxson = (CommonTree) tree2.getChild(1);
        /**
         * Creo un padre.
         */
        TreeChoose father = new TreeChoose();

        /**
         * Analizzo prima il figlio sinistro. Se è di tipo SELECT
         */
        if (sxson.getType() == ArrayParser.SELECT) {
            /**
             * Caso in cui potrei avere lo store a sinistra. Estraggo il figlio.
             */
            CommonTree sxson2 = (CommonTree) sxson.getChild(1);
            /**
             * Genero dei nuovi ArrayList per le relazioni.
             */
            ArrayList<Relation> eqOne = new ArrayList<Relation>();
            ArrayList<Relation> diseqOne = new ArrayList<Relation>();
            ArrayList<Relation> eqTwo = new ArrayList<Relation>();
            ArrayList<Relation> diseqTwo = new ArrayList<Relation>();
            /**
             * Creo un elemento sinistro, che sarà a sua volta un albero.
             */
            TreeChoose elementsx = new TreeChoose();
            /**
             * Imposto il padre dell'elemento creato al father creato sopra.
             */
            elementsx.setFather(father);
            /**
             * Creo un elemento destro, che sarà a sua volta un albero.
             */
            TreeChoose elementdx = new TreeChoose();
            /**
             * Imposto il padre dell'elemento creato al father creato sopra.
             */
            elementdx.setFather(father);
            /**
             * Se il figlio è un elemento di tipo ARRAY, ovvero nessun figlio
             * STORE.
             */
            if (sxson2.getChild(1).getType() == ArrayParser.ARRAY) {
                String newInput = sxson2.getChild(3).getText() + "=" + sxson.getChild(3).getText();
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput, eqOne, diseqOne, nodes); //indici
                String p = dxson.toStringTree();
                if (p.contains("(")) {
                    p = p.substring(1, p.length() - 1);
                }
                String newInput2 = sxson2.getChild(5).getText() + tree2.getText() + p;
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput2, eqOne, diseqOne, nodes); //elementi

                elementsx.setBean(new BeanData(eqOne, diseqOne));
                father.setSubsx(elementsx);

                String newInput3 = sxson2.getChild(3).getText() + "!=" + sxson.getChild(3).getText();
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput3, eqTwo, diseqTwo, nodes);
                String newInput4 = "select(" + sxson2.getChild(1).getText() + "," + sxson.getChild(3).getText() + ")" + tree2.getText() + p;
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput4, eqTwo, diseqTwo, nodes); //elementi

                elementdx.setBean(new BeanData(eqTwo, diseqTwo));
                father.setSubdx(elementdx);
                /**
                 * Se il figlio è un elemento di tipo STORE, richiamo il metodo
                 * ricorsivamente, con stringhe ad hoc.
                 */
            } else {
                /**
                 * Costruisco ad hoc una stringa con l'uguaglianza.
                 */
                String newInput1 = sxson2.getChild(3).getText() + "=" + sxson.getChild(3).getText();
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput1, eqOne, diseqOne, nodes); //indici
                String p = dxson.toStringTree();
                /**
                 * Elimino parentesi superflue date dal metodo toStringTree.
                 */
                if (p.contains("(")) {
                    p = p.substring(1, p.length() - 1);
                }
                String newString2 = sxson2.getChild(5).getText() + tree2.getText() + p;
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newString2, eqOne, diseqOne, nodes); //elementi
                /**
                 * Creo il nuovo bean con l'elemento appena creato, e lo
                 * inserisco nel figlio sinistro.
                 */
                elementsx.setBean(new BeanData(eqOne, diseqOne));
                /**
                 * Imposto il figlio sinistro del padre, al figlio appena
                 * utilizzato.
                 */
                father.setSubsx(elementsx);
                /**
                 * Costruisco ad hoc una stringa con la disuguaglianza.
                 */
                String newString3 = sxson2.getChild(3).getText() + "!=" + sxson.getChild(3).getText();
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newString3, eqTwo, diseqTwo, nodes);
                sxson.setChild(1, sxson2.getChild(1));

                elementdx.setBean(new BeanData(eqTwo, diseqTwo));
                father.setSubdx(elementdx);
                /**
                 * Richiamo il metodo ricorsivamente sulla stringa creata.
                 */
                TreeChoose append = analyzeStore(tree2);
                father.getSubdx().setSubsx(append.getSubsx());
                father.getSubdx().setSubdx(append.getSubdx());
                append.getSubdx().setFather(father.getSubdx());
                append.getSubsx().setFather(father.getSubdx());
            }
            /**
             * Analizzo il figlio destro. Se è di tipo SELECT
             */
        } else if (dxson.getType() == ArrayParser.SELECT) {
            /**
             * Caso in cui potrei avere lo store a sinistra. Estraggo il figlio.
             */
            CommonTree dxson2 = (CommonTree) dxson.getChild(1);
            /**
             * Genero dei nuovi ArrayList per le relazioni.
             */
            ArrayList<Relation> eqOne = new ArrayList<Relation>();
            ArrayList<Relation> diseqOne = new ArrayList<Relation>();
            ArrayList<Relation> eqTwo = new ArrayList<Relation>();
            ArrayList<Relation> diseqTwo = new ArrayList<Relation>();
            /**
             * Creo un elemento destro, che sarà a sua volta un albero.
             */
            TreeChoose elementdx = new TreeChoose();
            /**
             * Imposto il padre dell'elemento creato al father creato sopra.
             */
            elementdx.setFather(father);
            /**
             * Creo un elemento sinistro, che sarà a sua volta un albero.
             */
            TreeChoose elementsx = new TreeChoose();
            /**
             * Imposto il padre dell'elemento creato al father creato sopra.
             */
            elementsx.setFather(father);
            /**
             * Se il figlio è un elemento di tipo ARRAY, ovvero nessun figlio
             * STORE.
             */
            if (dxson2.getChild(1).getType() == ArrayParser.ARRAY) {
                /**
                 * Costruisco ad hoc una stringa con la l'uguaglianza.
                 */
                String newInput1 = dxson2.getChild(3).getText() + "=" + dxson.getChild(3).getText();
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput1, eqOne, diseqOne, nodes); //indici
                String p = sxson.toStringTree();
                /**
                 * Elimino parentesi superflue date dal metodo toStringTree.
                 */
                if (p.contains("(")) {
                    p = p.substring(1, p.length() - 1);
                }
                String newInput2 = dxson2.getChild(5).getText() + tree2.getText() + p;
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput2, eqOne, diseqOne, nodes); //elementi

                elementdx.setBean(new BeanData(eqOne, diseqOne));
                father.setSubdx(elementdx);

                String newInput3 = dxson2.getChild(3).getText() + "!=" + dxson.getChild(3).getText();
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput3, eqTwo, diseqTwo, nodes);
                String newInput4 = "select(" + dxson2.getChild(1).getText() + "," + dxson.getChild(3).getText() + ")" + tree2.getText() + p;
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput4, eqTwo, diseqTwo, nodes); //elementi

                elementsx.setBean(new BeanData(eqTwo, diseqTwo));
                father.setSubsx(elementsx);
                father.setSubdx(elementdx);
                /**
                 * Se il figlio è un elemento di tipo STORE, richiamo il metodo
                 * ricorsivamente, con stringhe ad hoc.
                 */
            } else {
                /**
                 * Costruisco ad hoc una stringa con l'uguaglianza.
                 */
                String newInput1 = dxson2.getChild(3).getText() + "=" + dxson.getChild(3).getText();
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput1, eqOne, diseqOne, nodes); //indici
                String p = sxson.toStringTree();
                if (p.contains("(")) {
                    p = p.substring(1, p.length() - 1);
                }
                String newInput2 = dxson2.getChild(5).getText() + tree2.getText() + p;
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput2, eqOne, diseqOne, nodes); //elementi
                /**
                 * Creo il nuovo bean con l'elemento appena creato, e lo
                 * inserisco nel figlio destro.
                 */
                elementdx.setBean(new BeanData(eqOne, diseqOne));
                /**
                 * Imposto il figlio destro del padre, al figlio appena
                 * utilizzato.
                 */
                father.setSubdx(elementdx);
                /**
                 * Costruisco ad hoc una stringa con la disuguaglianza.
                 */
                String newInput3 = dxson2.getChild(3).getText() + "!=" + dxson.getChild(3).getText();
                /**
                 * Richiamo il metodo per processare la stringa semplice.
                 */
                processingInput(newInput3, eqTwo, diseqTwo, nodes);
                dxson.setChild(1, dxson2.getChild(1));

                elementsx.setBean(new BeanData(eqTwo, diseqTwo));
                father.setSubsx(elementsx);
                /**
                 * Richiamo il metodo ricorsivamente sulla stringa creata.
                 */
                TreeChoose append = analyzeStore(tree2);
                father.getSubsx().setSubsx(append.getSubsx());
                father.getSubsx().setSubdx(append.getSubdx());
                append.getSubdx().setFather(father.getSubsx());
                append.getSubsx().setFather(father.getSubsx());
            }
        }
        return father;
    }

    /**
     * Metodo principale per la lettura dell'albero e per il richiamo dei metodi
     * di creazione dei nodi.
     *
     * @param tree Albero da cui prendere i figli.
     * @param eq ArrayList delle uguaglianze.
     * @param diseq ArrayList delle disuguaglianze.
     * @param nod ArrayList dei nodi.
     */
    private void preprocessing(CommonTree tree, ArrayList<Relation> eq, ArrayList<Relation> diseq, ArrayList<Node> nod) {
        /**
         * Estraggo il figlio sinistro.
         */
        CommonTree sxson = (CommonTree) tree.getChild(0);
        /**
         * Estraggo il figlio destro.
         */
        CommonTree dxson = (CommonTree) tree.getChild(1);
        /**
         * Prendo la stringa corrispondente al nodo sinistro.
         */
        String sxstring = sxson.getText();
        /**
         * Prendo la stringa corrispondente al nodo destro.
         */
        String dxstring = dxson.getText();
        /**
         * Istanzio un nuovo nodo sinistro. Successivamente ne dovrò istanziare uno destro.
         */
        Node nodesx = new Node(id, sxstring, id, null, null);
        temp.add(nodesx);
        id++;
        /**
         * Analizzo caso per caso il tipo del nodo. Può essere VARIABILE FRESH, INDICE, ELEMENTO, SELECT, FUNZIONE
         */
        switch (sxson.getType()) {
            case ArrayParser.FRESH:
            case ArrayParser.INDEX:
            case ArrayParser.ELEMENT:
                nodesx = terminalCreation(nod, nodesx);
                break;
            case ArrayParser.SELECT:
                String name = "f" + sxson.getChild(1).getText();
                nodesx.setFn(name);
                ArrayList<Integer> ccparSon = new ArrayList();
                ccparSon.add(nodesx.getId());
                Node subnode = new Node(id, sxson.getChild(3).getText(), id, null, ccparSon);
                temp.add(subnode);
                id++;
                subnode = terminalCreation(nod, subnode);
                ArrayList<Integer> argsDad = new ArrayList();
                argsDad.add(subnode.getId());
                nodesx.setArgs(argsDad);
                nodesx = selectCreation(nod, nodesx);
                break;
            case ArrayParser.FUNCTION_NAME:
                if (countChild(sxson) == 1) {
                    nodesx.setFn(sxstring);
                    ArrayList<Integer> ccparSo = new ArrayList();
                    ccparSo.add(nodesx.getId());
                    Node subnod = new Node(id, sxson.getChild(1).getText(), id, null, ccparSo);
                    temp.add(subnod);
                    id++;
                    subnode = terminalCreation(nod, subnod);
                    ArrayList<Integer> argsDa = new ArrayList();
                    argsDa.add(subnode.getId());
                    nodesx.setArgs(argsDa);
                    nodesx = selectCreation(nod, nodesx);
                } else {
                    nodesx.setFn(sxstring);
                    ArrayList<Integer> ccparSo = new ArrayList();
                    ArrayList<Integer> argsDa = new ArrayList();
                    ccparSo.add(nodesx.getId());
                    for (int i = 0; i < countChild(sxson); i++) { //funzione con più argomenti
                        Node subnod = new Node(id, sxson.getChild(2 * i + 1).getText(), id, null, ccparSo);
                        temp.add(subnod);
                        id++;
                        subnode = terminalCreation(nod, subnod);
                        argsDa.add(subnode.getId());
                        nodesx.setArgs(argsDa);
                        nodesx = selectCreation(nod, nodesx);
                    }
                }
                break;
        }
        /**
         * Istanzio un nuovo nodo destro.
         */
        Node nodedx = new Node(id, dxstring, id, null, null);
        temp.add(nodedx);
        id++;
        switch (dxson.getType()) {
            case ArrayParser.FRESH:
            case ArrayParser.INDEX:
            case ArrayParser.ELEMENT:
                nodedx = terminalCreation(nod, nodedx);
                break;
            case ArrayParser.SELECT:
                String name = "f" + dxson.getChild(1).getText();
                nodedx.setFn(name);
                ArrayList<Integer> ccparSon = new ArrayList();
                ccparSon.add(nodedx.getId());
                Node subnode = new Node(id, dxson.getChild(3).getText(), id, null, ccparSon);
                id++;
                temp.add(subnode);
                subnode = terminalCreation(nod, subnode);
                ArrayList<Integer> argsDad = new ArrayList();
                argsDad.add(subnode.getId());
                nodedx.setArgs(argsDad);
                nodedx = selectCreation(nod, nodedx);
                break;
            case ArrayParser.FUNCTION_NAME:
                if (countChild(dxson) == 1) {
                    nodedx.setFn(dxstring);
                    ArrayList<Integer> ccparSo = new ArrayList();
                    ccparSo.add(nodedx.getId());
                    Node subnod = new Node(id, dxson.getChild(1).getText(), id, null, ccparSo);
                    temp.add(subnod);
                    id++;
                    subnode = terminalCreation(nod, subnod);
                    ArrayList<Integer> argsDa = new ArrayList();
                    argsDa.add(subnode.getId());
                    nodedx.setArgs(argsDa);
                    nodedx = selectCreation(nod, nodedx);
                } else {
                    nodedx.setFn(dxstring);
                    ArrayList<Integer> ccparSo = new ArrayList();
                    ArrayList<Integer> argsDa = new ArrayList();
                    ccparSo.add(nodedx.getId());
                    for (int i = 0; i < countChild(dxson); i++) { //funzione con più argomenti
                        Node subnod = new Node(id, dxson.getChild(2 * i + 1).getText(), id, null, ccparSo);
                        temp.add(subnod);
                        id++;
                        subnode = terminalCreation(nod, subnod);
                        argsDa.add(subnode.getId());
                        nodedx.setArgs(argsDa);
                        nodedx = selectCreation(nod, nodedx);
                    }
                }
                break;
        }
        /**
         * Aggiungo la relazione appena analizzata tra i due nodi all'ArrayList delle relazioni, in base al tipo.
         */
        Relation r = new Relation(nodesx.getId(), nodedx.getId());
        switch (tree.getType()) {
            case ArrayParser.EQ:
                eq.add(r);
                break;
            case ArrayParser.NEQ:
                diseq.add(r);
                break;
            default:
                break;
        }
    }

    /**
     * Metodo che crea una riga della tabella contenente FN FIND ARGS CCPAR.
     *
     * @param nod ArrayList su cui aggiungere il nodo.
     * @param nodex Nodo da aggiungere, se non gia presente.
     * @return Il nodo aggiunto.
     */
    private Node terminalCreation(ArrayList<Node> nod, Node nodex) {
        boolean exists = false;
        /**
         * Controllo se il nodo già esiste.
         */
        for (Node n : nod) {
            if (n.isEqualFn(nodex)) {
                /**
                 * Aggiunta dei CCPAR e degli ARGS.
                 */
                ArrayList<Integer> nccpar = n.getCcpar();
                ArrayList<Integer> nxccpar = nodex.getCcpar();
                for (int x : nxccpar) {
                    boolean toadd = true;
                    String fnx = temp.get(x).getFn();

                    for (int nc : nccpar) {
                        String fnc = temp.get(nc).getFn();

                        if (fnc.equals(fnx)) {
                            toadd = false;
                        }
                    }
                    if (toadd) {
                        n.appendCCP(x);
                    }
                }
                exists = true;
                nodex = n;
                break;
            }
        }
        if (!exists) {
            nod.add(nodex);
        }
        return nodex;
    }

    /**
     * Metodo che controlla se non esiste un nodo, ed eventualmente lo aggiunge.
     *
     * @param nod ArrayList contentente tutti i nodi.
     * @param nodex Nodo da cercare, ed eventualemente aggiungere.
     * @return Il nodo aggiunto.
     */
    private Node selectCreation(ArrayList<Node> nod, Node nodex) {
        boolean exists = false;
        for (Node n : nod) {
            if (n.isEqual(nodex)) {
                nodex = n;
                exists = true;
                break;
            }
        }
        if (!exists) {
            nod.add(nodex);
        }
        return nodex;
    }

    /**
     * Metodo che crea le nuove stringhe per quanto riguarda la forma del tipo
     * select(store(...))=select(store(...)) o
     * select(store(...))!=select(store(...));
     */
    private void makeString() {
        /**
         * Clono la toDo.
         */
        ArrayList<String> clone = (ArrayList<String>) toDo.clone();
        /**
         * Per ogni elemento da splittare, controllo che contenga il != 
         * oppure l'= e analizzo i casi creando variabili fresh.
         */
        for (String n : clone) {
            if (n.contains("!=")) {
                StringTokenizer st = new StringTokenizer(n, "!=");
                String sx = (String) st.nextElement();
                String dx = (String) st.nextElement();
                if (sx.contains("store") && dx.contains("store")) {
                    toDo.remove(n);
                    toDo.add(sx + "!=" + "j" + fresh);
                    toDo.add(dx + "=" + "j" + fresh);
                    fresh++;
                }
            } else {
                StringTokenizer st = new StringTokenizer(n, "=");
                String sx = st.nextToken();
                String dx = st.nextToken();
                if (sx.contains("store") && dx.contains("store")) {
                    toDo.remove(n);
                    toDo.add(sx + "=" + "j" + fresh);
                    toDo.add(dx + "=" + "j" + fresh);
                    fresh++;
                }
            }
        }
    }

    /**
     * Metodo che stampa tutte le uguaglianze e le disuguaglianze all'interno
     * della tabella.
     *
     * @param root Albero definitivo su cui si esegue la Clousure Congruence.
     */
    private void toStringNodes(TreeChoose root) {
        int i = 1;
        for (TreeChoose t : visit(root)) {
            if (t.isTerminal()) {
                Object[] da = new Object[3];
                int j = 0;
                if (t.getBeanEqualities().size() > t.getBeanDisequalities().size()) {
                    ArrayList<Relation> eq = t.getBeanEqualities();
                    ArrayList<Relation> diseq = t.getBeanDisequalities();
                    da[0] = "F " + i;
                    for (j = 0; j < t.getBeanDisequalities().size(); j++) {
                        da[1] = eq.get(j).getFirst() + "=" + eq.get(j).getSecond();
                        da[2] = diseq.get(j).getFirst() + "!=" + diseq.get(j).getSecond();
                        modelEq.addRow(da);
                        da[0] = "";
                    }
                    for (int k = j; k < t.getBeanEqualities().size(); k++) {
                        da[1] = eq.get(k).getFirst() + "=" + eq.get(k).getSecond();
                        da[2] = "";
                        modelEq.addRow(da);
                        da[0] = "";
                    }
                } else if (t.getBeanEqualities().size() < t.getBeanDisequalities().size()) {
                    ArrayList<Relation> eq = t.getBeanEqualities();
                    ArrayList<Relation> diseq = t.getBeanDisequalities();
                    da[0] = "F " + i;
                    for (j = 0; j < t.getBeanEqualities().size(); j++) {
                        da[1] = eq.get(j).getFirst() + "=" + eq.get(j).getSecond();
                        da[2] = diseq.get(j).getFirst() + "!=" + diseq.get(j).getSecond();
                        modelEq.addRow(da);
                        da[0] = "";
                    }
                    for (int k = j; k < t.getBeanDisequalities().size(); k++) {
                        da[1] = "";
                        da[2] = diseq.get(k).getFirst() + "!=" + diseq.get(k).getSecond();
                        modelEq.addRow(da);
                    }
                } else {
                    ArrayList<Relation> eq = t.getBeanEqualities();
                    ArrayList<Relation> diseq = t.getBeanDisequalities();
                    da[0] = "F " + i;
                    for (j = 0; j < t.getBeanEqualities().size(); j++) {
                        da[1] = eq.get(j).getFirst() + "=" + eq.get(j).getSecond();
                        da[2] = diseq.get(j).getFirst() + "!=" + diseq.get(j).getSecond();
                        modelEq.addRow(da);
                        da[0] = "";
                    }
                }
            }
            modelEq.addRow(new Object[]{"", "", ""});
            i++;
        }
        for (Node n : nodes) {
            Object[] dat = new Object[5];
            dat[0] = n.getId();
            dat[1] = n.getFn();
            dat[2] = n.getFind();
            dat[3] = n.getAllArgs();
            dat[4] = n.getAllCcpar();
            model.addRow(dat);
        }
    }

    /**
     * Metodo che conta i figli per gestire i casi di più argomenti nelle
     * funzioni.
     *
     * @param tree Sottoalbero della stringa passata in input.
     * @return Numero dei figli del sottoalbero passato
     */
    private int countChild(CommonTree tree) {
        return ((tree.getChildCount() - 1) / 2);
    }

    /**
     * Metodo che corregge un'errore dell'implementazione di ANTLR. Il metodo
     * sistema le stringhe in modo tale che il metodo toStringTree() riporti le
     * stringhe senza parentesi doppie o iniziali.
     *
     * @param s Stringa proveniente dal metodo toStringTree().
     * @return Stringa sistemata.
     */
    private String processString(String s) {
        String p = s;
        /**
         * Pulisco da "( (" e "))" e ", ("
         */
        if (p.contains("(")) {
            p = p.substring(1, p.length() - 1);
            p = p.replaceAll("[(] [(]", "(");
            p = p.replaceAll("[)][)]", ")");
            p = p.replaceAll("[,] [(]", ",");
        }
        return p;
    }

    /**
     * Metodo che sistema il file in input per adattarlo alla procedura di
     * Clousure Congruence.
     *
     * @param strLine riga del file letto.
     * @param scrivi PrintStream per scrivere sul file temporaneo.
     * @throws RecognitionException Eccezione sollevata in caso di erronea
     * creazione dell'albero con la stringa passata.
     */
    private void refactoringInput(String strLine, PrintStream scrivi) throws RecognitionException {

        ANTLRStringStream input2 = new ANTLRStringStream(strLine);
        ArrayLexer simpleLexer2 = new ArrayLexer(input2);
        CommonTokenStream token2 = new CommonTokenStream(simpleLexer2);
        ArrayParser parser2 = new ArrayParser(token2);
        CommonTree tree2 = (CommonTree) parser2.equality().getTree();
        CommonTree sx = (CommonTree) tree2.getChild(0);
        String s = processString(sx.toStringTree());
        CommonTree dx = (CommonTree) tree2.getChild(1);
        String d = processString(dx.toStringTree());
        /**
         * Se il nodo sinistro è di tipo funzione e il nodo destro è di tipo funzione.
         */
        if (sx.getType() == ArrayParser.FUNCTION_NAME && dx.getType() == ArrayParser.FUNCTION_NAME) {
            String sxs = s + tree2.getText() + "j" + fresh;
            String dxs = d + "=" + "j" + fresh;
            fresh++;
            refactoringInput(sxs, scrivi);
            refactoringInput(dxs, scrivi);
        /**
         * Se il nodo sinistro è di tipo funzione.
         */
        } else if (sx.getType() == ArrayParser.FUNCTION_NAME) {
            if (countChild(sx) == 1) {
                String sxs = sx.getText() + "(j" + fresh + ")" + tree2.getText() + d;
                scrivi.println(sxs);
                String ns = processString(sx.getChild(1).toStringTree()) + "=j" + fresh;
                fresh++;
                refactoringInput(ns, scrivi);
            } else {
                String sxs = sx.getText() + "(";
                for (int i = 0; i < countChild(sx); i++) {
                    sxs = sxs + "j" + fresh + ",";
                    String ns = processString(sx.getChild(2 * i + 1).toStringTree()) + "=j" + fresh;
                    fresh++;
                    refactoringInput(ns, scrivi);
                }
                sxs = sxs.substring(0, sxs.length() - 1);
                sxs = sxs + ")" + tree2.getText() + d;
                scrivi.println(sxs);
            }
        /**
         * Se il nodo destro è di tipo funzione.
         */
        } else if (dx.getType() == ArrayParser.FUNCTION_NAME) {
            if (countChild(dx) == 1) {
                String dxs = dx.getText() + "(j" + fresh + ")" + tree2.getText() + s;
                scrivi.println(dxs);
                String nd = processString(dx.getChild(1).toStringTree()) + "=j" + fresh;
                fresh++;
                refactoringInput(nd, scrivi);
            } else {
                String dxs = dx.getText() + "(";
                for (int i = 0; i < countChild(dx); i++) {
                    dxs = dxs + "j" + fresh + ",";
                    String nd = processString(dx.getChild(2 * i + 1).toStringTree()) + "=j" + fresh;
                    fresh++;
                    refactoringInput(nd, scrivi);
                }
                dxs = dxs.substring(0, dxs.length() - 1);
                dxs = dxs + ")" + tree2.getText() + d;
                scrivi.println(dxs);
            }
        } else if (sx.getType() == ArrayParser.SELECT && dx.getType() == ArrayParser.SELECT && sx.getChild(3).getType() == ArrayParser.FUNCTION_NAME && dx.getChild(3).getType() == ArrayParser.FUNCTION_NAME) {
            String sxs = s + tree2.getText() + "j" + fresh;
            String dxs = d + "=" + "j" + fresh;
            fresh++;
            refactoringInput(sxs, scrivi);
            refactoringInput(dxs, scrivi);
        } else if (sx.getType() == ArrayParser.SELECT && sx.getChild(3).getType() == ArrayParser.FUNCTION_NAME) {
            String q = "select(" + processString(sx.getChild(1).toStringTree()) + ",j" + fresh + ")" + tree2.getText() + d;
            scrivi.println(q);
            String r = processString(sx.getChild(3).toStringTree()) + "=j" + fresh;
            fresh++;
            refactoringInput(r, scrivi);
        } else if (dx.getType() == ArrayParser.SELECT && dx.getChild(3).getType() == ArrayParser.FUNCTION_NAME) {
            String q = "select(" + processString(dx.getChild(1).toStringTree()) + ",j" + fresh + ")" + tree2.getText() + s;
            scrivi.println(q);
            String r = processString(dx.getChild(3).toStringTree()) + "=j" + fresh;
            fresh++;
            refactoringInput(r, scrivi);
        } else {
            scrivi.println(strLine);
        }
    }

    /**
     * Metodo che visita l'albero alla ricerca di terminali.
     *
     * @param x Albero da visitare.
     * @return ArrayList di TreeChoose terminali.
     */
    private ArrayList<TreeChoose> visit(TreeChoose x) {
        ArrayList<TreeChoose> a = new ArrayList<TreeChoose>();
        /**
         * Caso Base: se l'albero x è terminale allora lo aggiungo.
         */
        if (x.isTerminal()) {
            a.add(x);
        } else {
            /**
             * Caso ricorsivo: aggiungo alla lista tutti i risultati delle 
             * chiamate ricorsive sui figli destri e sinistri di x.
             */
            a.addAll(visit(x.getSubdx()));
            a.addAll(visit(x.getSubsx()));
        }
        return a;
    }

    /**
     * Metodo che concatena i singoli alberi di formule per generare l'albero
     * finale su cui lanciare la Clousure Congruence.
     *
     * @return L'albero finale.
     */
    private TreeChoose concatForest() {
        /**
         * Caso base con la foresta di un solo albero.
         */
        if (forest.size() == 1) {
            TreeChoose last = forest.get(0);
            forest.remove(0);
            return last;
        } else {
            /**
             * Caso ricorsivo. Prendo l'albero, estraggo i terminali, 
             * lo rimuovo dalla foresta e faccio la chiamata ricorsiva. Poi per ogni
             * terminale estratto clono l'albero ritornato dalla foresta e imposto
             * il figlio destro e sinistro, inoltre che al padre.
             */
            TreeChoose primo = forest.get(0);
            ArrayList<TreeChoose> terminali = visit(primo);
            forest.remove(0);
            TreeChoose x = concatForest();
            for (TreeChoose t : terminali) {
                TreeChoose clone = x.clone();
                t.setSubdx(clone.getSubdx());
                t.setSubsx(clone.getSubsx());
                clone.getSubdx().setFather(t);
                clone.getSubsx().setFather(t);
            }
            return primo;
        }
    }

    /**
     * Creazione del pannello del resoconto finale.
     *
     * @param p JFrame su cui verrà inserito il pannello creato.
     */
    private void finalPanel(final JFrame p) {
        JPanel pa = new JPanel(new BorderLayout());
        JLabel labelTwo = new JLabel("Tempo di PREPARAZIONE file\t" + tiOne + " ms");
        labelTwo.setBounds(20, 20, 300, 30);
        JLabel labelThree = new JLabel("Tempo di CREAZIONE nodi\t" + tiTwo + " ms");
        labelThree.setBounds(20, 50, 300, 30);
        JLabel labelFour = new JLabel("Tempo di ESECUZIONE algoritmo\t" + tiThree + " ms");
        labelFour.setBounds(20, 80, 300, 30);
        JLabel labelFive = new JLabel("Risultato:\t" + ((sat) ? "SODDISFACIBILE" : "INSODDISFACIBILE"));
        labelFive.setBounds(20, 140, 300, 30);
        JButton bu = new JButton("Close");
        bu.setBounds(180, 180, 60, 30);
        /**
         * Metodo per chiudere la finestra di riepilogo.
         */
        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                p.dispose();
            }
        });
        /**
         * Aggiungo tutte le label create sopra.
         */
        pa.add(labelTwo);
        pa.add(labelThree);
        pa.add(labelFour);
        pa.add(labelFive);
        pa.add(bu);
        /**
         * Label vuota, per evitare il fluttuare dell'ultima label inserita.
         */
        pa.add(new JLabel(""));
        p.add(pa);
    }

    /**
     * Creazione del pannello about
     *
     * @param p JFrame su cui verrà inserito il pannello creato.
     */
    private void aboutPanel(final JFrame p) {
        JPanel pa = new JPanel(new BorderLayout());
        /**
         * Creo una label per la descrizione.
         */
        JLabel labelOne = new JLabel("Progetto realizzato da:");
        labelOne.setBounds(20, 20, 200, 30);
        pa.add(labelOne);
        /**
         * Creo una label per il nome e la matricola.
         */
        JLabel labelTwo = new JLabel("Diego Sempreboni VR370412");
        labelTwo.setBounds(20, 50, 200, 30);
        pa.add(labelTwo);
        /**
         * Label vuota, per evitare il fluttuare dell'ultima label inserita.
         */
        pa.add(new JLabel(""));
        p.add(pa);
    }

    /**
     * Metodo che pulisce tutte le variabili.
     */
    private void clearData() {
        tiOne = 0;
        tiTwo = 0;
        tiThree = 0;
        nodes = new ArrayList<Node>();
        equality = new ArrayList<Relation>();
        disequality = new ArrayList<Relation>();
        temp = new ArrayList<Node>();
        id = 0;
        fresh = 0;
        toDo = new ArrayList<String>();
        temp = new ArrayList<Node>();
        forest = new ArrayList<TreeChoose>();
        areasxbottom.setText("");
        areasxtop.setText("");
        model.setRowCount(0);
        modelEq.setRowCount(0);
        file = null;
    }

    /**
     * Metodo Main della classe.
     *
     * @param args Argomenti passati da riga di comando.
     */
    public static void main(String args[]) {
        SatChecker mioframe = new SatChecker();
        mioframe.setLocation(50, 50);
        mioframe.setVisible(true);
    }
}
