package SatChecker;

// $ANTLR 3.2 debian-7ubuntu3 Array.g 2013-07-01 10:44:11

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe generata automaticamente compilando la grammatica con il tool ANTLR.
 * @author Diego Sempreboni
 */
public class ArrayLexer extends Lexer {
    public static final int INDEX=11;
    public static final int WS=17;
    public static final int NEQ=10;
    public static final int LPAR=6;
    public static final int C=8;
    public static final int ELEMENT=13;
    public static final int RPAR=7;
    public static final int FRESH=12;
    public static final int DIGIT=16;
    public static final int EQ=9;
    public static final int FUNCTION_NAME=14;
    public static final int EOF=-1;
    public static final int SELECT=4;
    public static final int ARRAY=15;
    public static final int STORE=5;

        @Override
        public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            throw new RuntimeException(hdr + ":" + msg);
        }


    // delegates
    // delegators

    public ArrayLexer() {;} 
    public ArrayLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ArrayLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Array.g"; }

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:16:8: ( 'select' )
            // Array.g:16:10: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "STORE"
    public final void mSTORE() throws RecognitionException {
        try {
            int _type = STORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:17:7: ( 'store' )
            // Array.g:17:9: 'store'
            {
            match("store"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STORE"

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:18:6: ( '(' )
            // Array.g:18:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAR"

    // $ANTLR start "RPAR"
    public final void mRPAR() throws RecognitionException {
        try {
            int _type = RPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:19:6: ( ')' )
            // Array.g:19:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAR"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            int _type = C;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:20:3: ( ',' )
            // Array.g:20:5: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "C"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:21:4: ( '=' )
            // Array.g:21:6: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "NEQ"
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:22:5: ( '!=' )
            // Array.g:22:7: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEQ"

    // $ANTLR start "ELEMENT"
    public final void mELEMENT() throws RecognitionException {
        try {
            int _type = ELEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:79:8: ( 'v' ( DIGIT )+ )
            // Array.g:79:9: 'v' ( DIGIT )+
            {
            match('v'); 
            // Array.g:79:12: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Array.g:79:13: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELEMENT"

    // $ANTLR start "INDEX"
    public final void mINDEX() throws RecognitionException {
        try {
            int _type = INDEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:81:6: ( 'i' ( DIGIT )+ )
            // Array.g:81:8: 'i' ( DIGIT )+
            {
            match('i'); 
            // Array.g:81:11: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Array.g:81:12: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INDEX"

    // $ANTLR start "FRESH"
    public final void mFRESH() throws RecognitionException {
        try {
            int _type = FRESH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:83:6: ( 'j' ( DIGIT )+ )
            // Array.g:83:8: 'j' ( DIGIT )+
            {
            match('j'); 
            // Array.g:83:11: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Array.g:83:12: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FRESH"

    // $ANTLR start "ARRAY"
    public final void mARRAY() throws RecognitionException {
        try {
            int _type = ARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:85:6: ( 'A' ( DIGIT )+ )
            // Array.g:85:9: 'A' ( DIGIT )+
            {
            match('A'); 
            // Array.g:85:12: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Array.g:85:13: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARRAY"

    // $ANTLR start "FUNCTION_NAME"
    public final void mFUNCTION_NAME() throws RecognitionException {
        try {
            int _type = FUNCTION_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:87:14: ( 'f' ARRAY | 'a' .. 'e' | 'g' .. 'h' | 'k' .. 'u' | 'w' .. 'z' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 'f':
                {
                alt5=1;
                }
                break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
                {
                alt5=2;
                }
                break;
            case 'g':
            case 'h':
                {
                alt5=3;
                }
                break;
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
                {
                alt5=4;
                }
                break;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Array.g:87:16: 'f' ARRAY
                    {
                    match('f'); 
                    mARRAY(); 

                    }
                    break;
                case 2 :
                    // Array.g:87:27: 'a' .. 'e'
                    {
                    matchRange('a','e'); 

                    }
                    break;
                case 3 :
                    // Array.g:87:38: 'g' .. 'h'
                    {
                    matchRange('g','h'); 

                    }
                    break;
                case 4 :
                    // Array.g:87:49: 'k' .. 'u'
                    {
                    matchRange('k','u'); 

                    }
                    break;
                case 5 :
                    // Array.g:87:60: 'w' .. 'z'
                    {
                    matchRange('w','z'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION_NAME"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // Array.g:89:15: ( '0' .. '9' )
            // Array.g:89:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Array.g:91:3: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // Array.g:91:5: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // Array.g:91:5: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||(LA6_0>='\f' && LA6_0<='\r')||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Array.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // Array.g:1:8: ( SELECT | STORE | LPAR | RPAR | C | EQ | NEQ | ELEMENT | INDEX | FRESH | ARRAY | FUNCTION_NAME | WS )
        int alt7=13;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // Array.g:1:10: SELECT
                {
                mSELECT(); 

                }
                break;
            case 2 :
                // Array.g:1:17: STORE
                {
                mSTORE(); 

                }
                break;
            case 3 :
                // Array.g:1:23: LPAR
                {
                mLPAR(); 

                }
                break;
            case 4 :
                // Array.g:1:28: RPAR
                {
                mRPAR(); 

                }
                break;
            case 5 :
                // Array.g:1:33: C
                {
                mC(); 

                }
                break;
            case 6 :
                // Array.g:1:35: EQ
                {
                mEQ(); 

                }
                break;
            case 7 :
                // Array.g:1:38: NEQ
                {
                mNEQ(); 

                }
                break;
            case 8 :
                // Array.g:1:42: ELEMENT
                {
                mELEMENT(); 

                }
                break;
            case 9 :
                // Array.g:1:50: INDEX
                {
                mINDEX(); 

                }
                break;
            case 10 :
                // Array.g:1:56: FRESH
                {
                mFRESH(); 

                }
                break;
            case 11 :
                // Array.g:1:62: ARRAY
                {
                mARRAY(); 

                }
                break;
            case 12 :
                // Array.g:1:68: FUNCTION_NAME
                {
                mFUNCTION_NAME(); 

                }
                break;
            case 13 :
                // Array.g:1:82: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\13\15\uffff";
    static final String DFA7_eofS =
        "\17\uffff";
    static final String DFA7_minS =
        "\1\11\1\145\15\uffff";
    static final String DFA7_maxS =
        "\1\172\1\164\15\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\1\1"+
        "\2";
    static final String DFA7_specialS =
        "\17\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\14\1\uffff\2\14\22\uffff\1\14\1\6\6\uffff\1\2\1\3\2\uffff"+
            "\1\4\20\uffff\1\5\3\uffff\1\12\37\uffff\10\13\1\10\1\11\10\13"+
            "\1\1\2\13\1\7\4\13",
            "\1\15\16\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SELECT | STORE | LPAR | RPAR | C | EQ | NEQ | ELEMENT | INDEX | FRESH | ARRAY | FUNCTION_NAME | WS );";
        }
    }
 

}