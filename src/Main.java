import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import generated.MiniCLexer;
import generated.MiniCParser;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        MiniCLexer lexer = new MiniCLexer(CharStreams.fromFileName("./input.mc"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniCParser parser = new MiniCParser(tokens);

        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        MiniC2IR irPrinter = new MiniC2IR();
        walker.walk(irPrinter, tree);
        FileWriter fw = new FileWriter("./output.ir");
        System.out.println(irPrinter.irResult.toString());
        fw.write(irPrinter.irResult.toString());
        fw.close();
    }
}