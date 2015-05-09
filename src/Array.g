grammar Array;

options {
language=Java;
output=AST;
ASTLabelType=CommonTree;
rewrite=true;
backtrack=true;
}

tokens { 
	SELECT 	= 'select';
	STORE 	= 'store';
	LPAR 	= '(';
	RPAR 	= ')';
	C 	= ',';
	EQ 	= '=';
	NEQ 	= '!=';
}

@rulecatch {
    // ANTLR does not generate its normal rule try/catch
    catch(RecognitionException e) {
        throw e;
    }
}

@parser::members {
    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        throw new RuntimeException(hdr + ":" + msg);
    }
}

@lexer::members {
    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        throw new RuntimeException(hdr + ":" + msg);
    }
}

/*-------------------------------------------------
 * PARSER RULES
 *------------------------------------------------*/
equality
	:	read^ (EQ^ | NEQ^) read
	| 	INDEX^ (EQ^ | NEQ^) (INDEX | FRESH)
	;

read
	:	SELECT^ LPAR write C (INDEX | fun | FRESH) RPAR 
	|	ELEMENT^ 
	|	fun^
	|	FRESH^
	;

fun
	:	FUNCTION_NAME^ LPAR functionarg (C functionarg)* RPAR
	;

functionarg
	:	read^
	|	INDEX^ 	
	;

write
	:	STORE^ LPAR write C INDEX C ELEMENT RPAR
	|	ARRAY^
	;

/*-------------------------------------------------
 * LEXER RULES
 *------------------------------------------------*/

ELEMENT:'v'(DIGIT)+;

INDEX:	'i'(DIGIT)+;

FRESH: 'j'(DIGIT)+;

ARRAY: 	'A'(DIGIT)+;

FUNCTION_NAME: 'f'ARRAY | 'a'..'e' | 'g'..'h' | 'k'..'u' | 'w'..'z';

fragment DIGIT: '0'..'9';

WS: ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;