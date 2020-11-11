import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Cal
{
	public static void main (String[] args) throws Exception{

		Scanner in = new Scanner(System.in);
		String inputFile = null;

		//file name can be given from the args or the scanner.
		if (args.length > 0) {
			inputFile = args[0];
		}
		else{
			//if file name not given in the args.
			System.err.print("Please enter the input file: ");
			inputFile = in.next();
			in.close();
		}
		InputStream is = System.in;
		if (inputFile != null){
			is = new FileInputStream(inputFile);
		}

		//remove default error listeners and add my own from CalErrorListener.
		calLexer lexer = new calLexer (CharStreams.fromStream (is));
		lexer.removeErrorListeners();
		lexer.addErrorListener(CalErrorListener.INSTANCE);

		CommonTokenStream tokens = new CommonTokenStream (lexer);
		calParser parser = new calParser (tokens);

		//again, replace the default error listeners for the parser.
		parser.removeErrorListeners();
		parser.addErrorListener(CalErrorListener.INSTANCE);
		parser.prog ();
		is.close();

		//NO_ERRORS is set to true in CalErrorListener by default.
		if(CalErrorListener.getError())
			System.out.println(inputFile+ " parsed successfully");
		else
			System.out.println(inputFile+ " has not parsed");
	}
}
