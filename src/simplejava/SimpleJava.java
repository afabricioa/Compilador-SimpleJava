package simplejava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tabela.Table;

public class SimpleJava {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Jonatas Laet\\Documents\\NetBeansProjects\\SimpleJava\\src\\simplejava\\exemplo1.jav";
        InputStream input = new FileInputStream(fileName);
        ANTLRInputStream stream = new ANTLRInputStream(input);

        //Lexico
        simpleJavaLexer lexer = new simpleJavaLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        //Sintatico
        simpleJavaParser parser = new simpleJavaParser(tokens);
        ParseTree tree = parser.programa();
//        System.out.println(tree.toStringTree(parser));
        
        //acoes semanticas, atraves de listener
        //Estou passando minha tabela pro listenner
        //AcoesSemanticas listener = new AcoesSemanticas(new Table());
        ParseTreeWalker walker = new ParseTreeWalker();
        //walker.walk(listener, tree);
        //
        //System.out.println("Tabela de Simbolos\n"+parser.tabSimb);
    }
    
}
