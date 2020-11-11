import org.antlr.v4.runtime.*;

public class CalErrorListener extends BaseErrorListener {

    public static final CalErrorListener INSTANCE = new CalErrorListener();

    //initially called REPORT_SYNTAX_ERRORS
    private static boolean NO_ERRORS = true;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e){
        if (!NO_ERRORS) {
            return;
        }
        //if syntaxError is called, then we can change the boolean through this function.
        setError();
    }
    //this function is static, so we can change the NO_ERRORS variable.
    public static void setError(){
        NO_ERRORS = false;
    }
    //get the value of the private variable
    public static boolean getError(){
        return NO_ERRORS;
    }
}
