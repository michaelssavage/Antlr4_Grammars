import org.antlr.v4.runtime.*;

public class CalErrorListener extends BaseErrorListener {

    public static final CalErrorListener INSTANCE = new CalErrorListener();
    public static boolean REPORT_SYNTAX_ERRORS = true;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e){
        if (!REPORT_SYNTAX_ERRORS) {
            return;
        }
        
        //if syntaxError is called, then we can change the boolean through this function.
        setError();
    }
    //this function is static, so we can change the REPORT_SYNTAX_ERRORS variable.
    public static void setError(){
        REPORT_SYNTAX_ERRORS = false;
    }
}