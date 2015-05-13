=============================
DESCRIPTION OF IMPLEMENTATION
=============================

- Run the Jar file SatChecker.jar
  inside the jar folder

- From Menù, select File -> Load File…

- Select a text file (*.txt)

================================================================

- The grammar used for the input file, is as following:

ELEMENTS:’v’(DIGIT)+;

INDEX:	'i'(DIGIT)+;

VARIABLES FRESH: 'j'(DIGIT)+;

ARRAY: 	'A'(DIGIT)+;

FUNCTIONS: 'f'ARRAY | 'a'..'e' | 'g'..'h' | 'k'..'u' | 'w'..'z';

===============================================================

- To launch Javadoc, consult index.html file inside the Javadoc folder.