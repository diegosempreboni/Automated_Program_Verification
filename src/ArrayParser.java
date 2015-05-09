package SatChecker;

// $ANTLR 3.2 debian-7ubuntu3 Array.g 2013-07-01 10:44:10

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/**
 * Classe generata automaticamente compilando la grammatica con il tool ANTLR.
 * @author Diego Sempreboni
 */
public class ArrayParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SELECT", "STORE", "LPAR", "RPAR", "C", "EQ", "NEQ", "INDEX", "FRESH", "ELEMENT", "FUNCTION_NAME", "ARRAY", "DIGIT", "WS"
    };
    public static final int INDEX=11;
    public static final int WS=17;
    public static final int NEQ=10;
    public static final int LPAR=6;
    public static final int C=8;
    public static final int ELEMENT=13;
    public static final int RPAR=7;
    public static final int FRESH=12;
    public static final int DIGIT=16;
    public static final int FUNCTION_NAME=14;
    public static final int EQ=9;
    public static final int EOF=-1;
    public static final int SELECT=4;
    public static final int ARRAY=15;
    public static final int STORE=5;

    // delegates
    // delegators


        public ArrayParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ArrayParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ArrayParser.tokenNames; }
    public String getGrammarFileName() { return "Array.g"; }


        @Override
        public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            throw new RuntimeException(hdr + ":" + msg);
        }


    public static class equality_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equality"
    // Array.g:49:1: equality : ( read ( EQ | NEQ ) read | INDEX ( EQ | NEQ ) ( INDEX | FRESH ) );
    public final ArrayParser.equality_return equality() throws RecognitionException {
        ArrayParser.equality_return retval = new ArrayParser.equality_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ2=null;
        Token NEQ3=null;
        Token INDEX5=null;
        Token EQ6=null;
        Token NEQ7=null;
        Token set8=null;
        ArrayParser.read_return read1 = null;

        ArrayParser.read_return read4 = null;


        CommonTree EQ2_tree=null;
        CommonTree NEQ3_tree=null;
        CommonTree INDEX5_tree=null;
        CommonTree EQ6_tree=null;
        CommonTree NEQ7_tree=null;
        CommonTree set8_tree=null;

        try {
            // Array.g:50:2: ( read ( EQ | NEQ ) read | INDEX ( EQ | NEQ ) ( INDEX | FRESH ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==SELECT||(LA3_0>=FRESH && LA3_0<=FUNCTION_NAME)) ) {
                alt3=1;
            }
            else if ( (LA3_0==INDEX) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // Array.g:50:4: read ( EQ | NEQ ) read
                    {
                    pushFollow(FOLLOW_read_in_equality136);
                    read1=read();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(read1.getTree(), root_0);
                    // Array.g:50:10: ( EQ | NEQ )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==EQ) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==NEQ) ) {
                        alt1=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // Array.g:50:11: EQ
                            {
                            EQ2=(Token)match(input,EQ,FOLLOW_EQ_in_equality140); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            EQ2_tree = (CommonTree)adaptor.create(EQ2);
                            root_0 = (CommonTree)adaptor.becomeRoot(EQ2_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // Array.g:50:17: NEQ
                            {
                            NEQ3=(Token)match(input,NEQ,FOLLOW_NEQ_in_equality145); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NEQ3_tree = (CommonTree)adaptor.create(NEQ3);
                            root_0 = (CommonTree)adaptor.becomeRoot(NEQ3_tree, root_0);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_read_in_equality149);
                    read4=read();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, read4.getTree());

                    }
                    break;
                case 2 :
                    // Array.g:51:5: INDEX ( EQ | NEQ ) ( INDEX | FRESH )
                    {
                    INDEX5=(Token)match(input,INDEX,FOLLOW_INDEX_in_equality155); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INDEX5_tree = (CommonTree)adaptor.create(INDEX5);
                    root_0 = (CommonTree)adaptor.becomeRoot(INDEX5_tree, root_0);
                    }
                    // Array.g:51:12: ( EQ | NEQ )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==EQ) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==NEQ) ) {
                        alt2=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // Array.g:51:13: EQ
                            {
                            EQ6=(Token)match(input,EQ,FOLLOW_EQ_in_equality159); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            EQ6_tree = (CommonTree)adaptor.create(EQ6);
                            root_0 = (CommonTree)adaptor.becomeRoot(EQ6_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // Array.g:51:19: NEQ
                            {
                            NEQ7=(Token)match(input,NEQ,FOLLOW_NEQ_in_equality164); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NEQ7_tree = (CommonTree)adaptor.create(NEQ7);
                            root_0 = (CommonTree)adaptor.becomeRoot(NEQ7_tree, root_0);
                            }

                            }
                            break;

                    }

                    set8=(Token)input.LT(1);
                    if ( (input.LA(1)>=INDEX && input.LA(1)<=FRESH) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set8));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

            // ANTLR does not generate its normal rule try/catch
            catch(RecognitionException e) {
                throw e;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equality"

    public static class read_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "read"
    // Array.g:54:1: read : ( SELECT LPAR write C ( INDEX | fun | FRESH ) RPAR | ELEMENT | fun | FRESH );
    public final ArrayParser.read_return read() throws RecognitionException {
        ArrayParser.read_return retval = new ArrayParser.read_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SELECT9=null;
        Token LPAR10=null;
        Token C12=null;
        Token INDEX13=null;
        Token FRESH15=null;
        Token RPAR16=null;
        Token ELEMENT17=null;
        Token FRESH19=null;
        ArrayParser.write_return write11 = null;

        ArrayParser.fun_return fun14 = null;

        ArrayParser.fun_return fun18 = null;


        CommonTree SELECT9_tree=null;
        CommonTree LPAR10_tree=null;
        CommonTree C12_tree=null;
        CommonTree INDEX13_tree=null;
        CommonTree FRESH15_tree=null;
        CommonTree RPAR16_tree=null;
        CommonTree ELEMENT17_tree=null;
        CommonTree FRESH19_tree=null;

        try {
            // Array.g:55:2: ( SELECT LPAR write C ( INDEX | fun | FRESH ) RPAR | ELEMENT | fun | FRESH )
            int alt5=4;
            switch ( input.LA(1) ) {
            case SELECT:
                {
                alt5=1;
                }
                break;
            case ELEMENT:
                {
                alt5=2;
                }
                break;
            case FUNCTION_NAME:
                {
                alt5=3;
                }
                break;
            case FRESH:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Array.g:55:4: SELECT LPAR write C ( INDEX | fun | FRESH ) RPAR
                    {
                    SELECT9=(Token)match(input,SELECT,FOLLOW_SELECT_in_read185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SELECT9_tree = (CommonTree)adaptor.create(SELECT9);
                    root_0 = (CommonTree)adaptor.becomeRoot(SELECT9_tree, root_0);
                    }
                    LPAR10=(Token)match(input,LPAR,FOLLOW_LPAR_in_read188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAR10_tree = (CommonTree)adaptor.create(LPAR10);
                    adaptor.addChild(root_0, LPAR10_tree);
                    }
                    pushFollow(FOLLOW_write_in_read190);
                    write11=write();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, write11.getTree());
                    C12=(Token)match(input,C,FOLLOW_C_in_read192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    C12_tree = (CommonTree)adaptor.create(C12);
                    adaptor.addChild(root_0, C12_tree);
                    }
                    // Array.g:55:25: ( INDEX | fun | FRESH )
                    int alt4=3;
                    switch ( input.LA(1) ) {
                    case INDEX:
                        {
                        alt4=1;
                        }
                        break;
                    case FUNCTION_NAME:
                        {
                        alt4=2;
                        }
                        break;
                    case FRESH:
                        {
                        alt4=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }

                    switch (alt4) {
                        case 1 :
                            // Array.g:55:26: INDEX
                            {
                            INDEX13=(Token)match(input,INDEX,FOLLOW_INDEX_in_read195); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            INDEX13_tree = (CommonTree)adaptor.create(INDEX13);
                            adaptor.addChild(root_0, INDEX13_tree);
                            }

                            }
                            break;
                        case 2 :
                            // Array.g:55:34: fun
                            {
                            pushFollow(FOLLOW_fun_in_read199);
                            fun14=fun();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, fun14.getTree());

                            }
                            break;
                        case 3 :
                            // Array.g:55:40: FRESH
                            {
                            FRESH15=(Token)match(input,FRESH,FOLLOW_FRESH_in_read203); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FRESH15_tree = (CommonTree)adaptor.create(FRESH15);
                            adaptor.addChild(root_0, FRESH15_tree);
                            }

                            }
                            break;

                    }

                    RPAR16=(Token)match(input,RPAR,FOLLOW_RPAR_in_read206); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAR16_tree = (CommonTree)adaptor.create(RPAR16);
                    adaptor.addChild(root_0, RPAR16_tree);
                    }

                    }
                    break;
                case 2 :
                    // Array.g:56:4: ELEMENT
                    {
                    ELEMENT17=(Token)match(input,ELEMENT,FOLLOW_ELEMENT_in_read212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ELEMENT17_tree = (CommonTree)adaptor.create(ELEMENT17);
                    root_0 = (CommonTree)adaptor.becomeRoot(ELEMENT17_tree, root_0);
                    }

                    }
                    break;
                case 3 :
                    // Array.g:57:4: fun
                    {
                    pushFollow(FOLLOW_fun_in_read219);
                    fun18=fun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(fun18.getTree(), root_0);

                    }
                    break;
                case 4 :
                    // Array.g:58:4: FRESH
                    {
                    FRESH19=(Token)match(input,FRESH,FOLLOW_FRESH_in_read225); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FRESH19_tree = (CommonTree)adaptor.create(FRESH19);
                    root_0 = (CommonTree)adaptor.becomeRoot(FRESH19_tree, root_0);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

            // ANTLR does not generate its normal rule try/catch
            catch(RecognitionException e) {
                throw e;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "read"

    public static class fun_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fun"
    // Array.g:61:1: fun : FUNCTION_NAME LPAR functionarg ( C functionarg )* RPAR ;
    public final ArrayParser.fun_return fun() throws RecognitionException {
        ArrayParser.fun_return retval = new ArrayParser.fun_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNCTION_NAME20=null;
        Token LPAR21=null;
        Token C23=null;
        Token RPAR25=null;
        ArrayParser.functionarg_return functionarg22 = null;

        ArrayParser.functionarg_return functionarg24 = null;


        CommonTree FUNCTION_NAME20_tree=null;
        CommonTree LPAR21_tree=null;
        CommonTree C23_tree=null;
        CommonTree RPAR25_tree=null;

        try {
            // Array.g:62:2: ( FUNCTION_NAME LPAR functionarg ( C functionarg )* RPAR )
            // Array.g:62:4: FUNCTION_NAME LPAR functionarg ( C functionarg )* RPAR
            {
            FUNCTION_NAME20=(Token)match(input,FUNCTION_NAME,FOLLOW_FUNCTION_NAME_in_fun237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION_NAME20_tree = (CommonTree)adaptor.create(FUNCTION_NAME20);
            root_0 = (CommonTree)adaptor.becomeRoot(FUNCTION_NAME20_tree, root_0);
            }
            LPAR21=(Token)match(input,LPAR,FOLLOW_LPAR_in_fun240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAR21_tree = (CommonTree)adaptor.create(LPAR21);
            adaptor.addChild(root_0, LPAR21_tree);
            }
            pushFollow(FOLLOW_functionarg_in_fun242);
            functionarg22=functionarg();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionarg22.getTree());
            // Array.g:62:36: ( C functionarg )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==C) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Array.g:62:37: C functionarg
            	    {
            	    C23=(Token)match(input,C,FOLLOW_C_in_fun245); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    C23_tree = (CommonTree)adaptor.create(C23);
            	    adaptor.addChild(root_0, C23_tree);
            	    }
            	    pushFollow(FOLLOW_functionarg_in_fun247);
            	    functionarg24=functionarg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionarg24.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            RPAR25=(Token)match(input,RPAR,FOLLOW_RPAR_in_fun251); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAR25_tree = (CommonTree)adaptor.create(RPAR25);
            adaptor.addChild(root_0, RPAR25_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

            // ANTLR does not generate its normal rule try/catch
            catch(RecognitionException e) {
                throw e;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fun"

    public static class functionarg_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionarg"
    // Array.g:65:1: functionarg : ( read | INDEX );
    public final ArrayParser.functionarg_return functionarg() throws RecognitionException {
        ArrayParser.functionarg_return retval = new ArrayParser.functionarg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INDEX27=null;
        ArrayParser.read_return read26 = null;


        CommonTree INDEX27_tree=null;

        try {
            // Array.g:66:2: ( read | INDEX )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==SELECT||(LA7_0>=FRESH && LA7_0<=FUNCTION_NAME)) ) {
                alt7=1;
            }
            else if ( (LA7_0==INDEX) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // Array.g:66:4: read
                    {
                    pushFollow(FOLLOW_read_in_functionarg262);
                    read26=read();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(read26.getTree(), root_0);

                    }
                    break;
                case 2 :
                    // Array.g:67:4: INDEX
                    {
                    INDEX27=(Token)match(input,INDEX,FOLLOW_INDEX_in_functionarg268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INDEX27_tree = (CommonTree)adaptor.create(INDEX27);
                    root_0 = (CommonTree)adaptor.becomeRoot(INDEX27_tree, root_0);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

            // ANTLR does not generate its normal rule try/catch
            catch(RecognitionException e) {
                throw e;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionarg"

    public static class write_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "write"
    // Array.g:70:1: write : ( STORE LPAR write C INDEX C ELEMENT RPAR | ARRAY );
    public final ArrayParser.write_return write() throws RecognitionException {
        ArrayParser.write_return retval = new ArrayParser.write_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STORE28=null;
        Token LPAR29=null;
        Token C31=null;
        Token INDEX32=null;
        Token C33=null;
        Token ELEMENT34=null;
        Token RPAR35=null;
        Token ARRAY36=null;
        ArrayParser.write_return write30 = null;


        CommonTree STORE28_tree=null;
        CommonTree LPAR29_tree=null;
        CommonTree C31_tree=null;
        CommonTree INDEX32_tree=null;
        CommonTree C33_tree=null;
        CommonTree ELEMENT34_tree=null;
        CommonTree RPAR35_tree=null;
        CommonTree ARRAY36_tree=null;

        try {
            // Array.g:71:2: ( STORE LPAR write C INDEX C ELEMENT RPAR | ARRAY )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==STORE) ) {
                alt8=1;
            }
            else if ( (LA8_0==ARRAY) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // Array.g:71:4: STORE LPAR write C INDEX C ELEMENT RPAR
                    {
                    STORE28=(Token)match(input,STORE,FOLLOW_STORE_in_write282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE28_tree = (CommonTree)adaptor.create(STORE28);
                    root_0 = (CommonTree)adaptor.becomeRoot(STORE28_tree, root_0);
                    }
                    LPAR29=(Token)match(input,LPAR,FOLLOW_LPAR_in_write285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAR29_tree = (CommonTree)adaptor.create(LPAR29);
                    adaptor.addChild(root_0, LPAR29_tree);
                    }
                    pushFollow(FOLLOW_write_in_write287);
                    write30=write();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, write30.getTree());
                    C31=(Token)match(input,C,FOLLOW_C_in_write289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    C31_tree = (CommonTree)adaptor.create(C31);
                    adaptor.addChild(root_0, C31_tree);
                    }
                    INDEX32=(Token)match(input,INDEX,FOLLOW_INDEX_in_write291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INDEX32_tree = (CommonTree)adaptor.create(INDEX32);
                    adaptor.addChild(root_0, INDEX32_tree);
                    }
                    C33=(Token)match(input,C,FOLLOW_C_in_write293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    C33_tree = (CommonTree)adaptor.create(C33);
                    adaptor.addChild(root_0, C33_tree);
                    }
                    ELEMENT34=(Token)match(input,ELEMENT,FOLLOW_ELEMENT_in_write295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ELEMENT34_tree = (CommonTree)adaptor.create(ELEMENT34);
                    adaptor.addChild(root_0, ELEMENT34_tree);
                    }
                    RPAR35=(Token)match(input,RPAR,FOLLOW_RPAR_in_write297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAR35_tree = (CommonTree)adaptor.create(RPAR35);
                    adaptor.addChild(root_0, RPAR35_tree);
                    }

                    }
                    break;
                case 2 :
                    // Array.g:72:4: ARRAY
                    {
                    ARRAY36=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_write302); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ARRAY36_tree = (CommonTree)adaptor.create(ARRAY36);
                    root_0 = (CommonTree)adaptor.becomeRoot(ARRAY36_tree, root_0);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

            // ANTLR does not generate its normal rule try/catch
            catch(RecognitionException e) {
                throw e;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "write"

    // Delegated rules


 

    public static final BitSet FOLLOW_read_in_equality136 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_EQ_in_equality140 = new BitSet(new long[]{0x0000000000007010L});
    public static final BitSet FOLLOW_NEQ_in_equality145 = new BitSet(new long[]{0x0000000000007010L});
    public static final BitSet FOLLOW_read_in_equality149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDEX_in_equality155 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_EQ_in_equality159 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_NEQ_in_equality164 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_set_in_equality168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_read185 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LPAR_in_read188 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_write_in_read190 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_C_in_read192 = new BitSet(new long[]{0x0000000000005800L});
    public static final BitSet FOLLOW_INDEX_in_read195 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_fun_in_read199 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FRESH_in_read203 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RPAR_in_read206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENT_in_read212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fun_in_read219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FRESH_in_read225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_NAME_in_fun237 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LPAR_in_fun240 = new BitSet(new long[]{0x0000000000007810L});
    public static final BitSet FOLLOW_functionarg_in_fun242 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_C_in_fun245 = new BitSet(new long[]{0x0000000000007810L});
    public static final BitSet FOLLOW_functionarg_in_fun247 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_RPAR_in_fun251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_functionarg262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDEX_in_functionarg268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_write282 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LPAR_in_write285 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_write_in_write287 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_C_in_write289 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INDEX_in_write291 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_C_in_write293 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ELEMENT_in_write295 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RPAR_in_write297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_write302 = new BitSet(new long[]{0x0000000000000002L});

}