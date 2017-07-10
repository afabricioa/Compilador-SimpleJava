/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejava;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import simplejava.simpleJavaParser.ListaParametrosContext;
import tabela.Constante;
import tabela.Table;
import tabela.Variavel;

/**
 *
 * @author rmoura
 */
public class AcoesSemanticas extends simpleJavaBaseListener {
    //private Map tabSimb;
    public Table tab;
    //public List<String> msgErroNaLinha = new ArrayList<String>();
    public List<String> mensagemErro = new ArrayList<String>();
    String idFuncAtual;
    public List<String> saida = new ArrayList<String>();
    ArrayList <String> parametrosFuncAtual;
    //Tipos:
    final int Int = 1, Real = 2, String = 3, Bool = 4;
    boolean ativaBreak = false;
    boolean ativaRetorno = false;
    FileWriter codigo;
    PrintWriter gerar;
    StringBuilder sb = new StringBuilder();
    /*
    public AcoesSemanticas(Map tabSimb) {
        this.tabSimb = tabSimb;
    }
    */
    public String msgCompilacao;
    
    public AcoesSemanticas(Table tab, String nomeArq)
    {
        String[] parts = nomeArq.split("\\.");
        String nome = parts[0];
//        System.out.println("nome: " + nome);
        try {
            this.codigo = new FileWriter("/Users/Fabricio/NetBeansProjects/SimpleJava/src/teste/"+nome+".j");
        } catch (IOException ex) {
            Logger.getLogger(AcoesSemanticas.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tab = tab;
    }
    
    
    
    public void enterPrograma(simpleJavaParser.ProgramaContext ctx){
        sb.append(".class public ");
        sb.append(ctx.ID().getText());
        sb.append("\n");
	sb.append(".super java/lang/Object\n\n\n");
	sb.append(".method public static read()I\n");
	sb.append(".limit stack 5   ; up to five items can be pushed\n");
	sb.append(".limit locals 100\n");
	sb.append("ldc 0\n");
	sb.append("istore 50     ; storage for a dummy integer for reading it by input()\n");
	sb.append("ldc 0\n");
	sb.append("istore 49\n");
	sb.append("Label1: \ngetstatic java/lang/System/in Ljava/io/InputStream;");
        sb.append("\ninvokevirtual java/io/InputStream/read()I\n");
        sb.append("istore 51\n");
        sb.append("iload 51\n"); 
        sb.append("ldc 10 ; uso no mac (valor ASCII da tecla ENTER)\n");
        sb.append(";   ldc 13 ; uso no windows (valor ASCII da tecla ENTER)\n");
        sb.append("isub\n");
        sb.append("ifeq Label2\n");
        sb.append("iload 51\n");
        sb.append("ldc 32 ; space\n");
        sb.append("isub\n");
        sb.append("ifeq Label2\n");
        sb.append("iload 51\n");
        sb.append("ldc 43 ; plus sign\n");
        sb.append("isub\nifeq Label1\niload 51\nldc 45 ; minus sign\nisub\nifeq Label3\niload 51\n"
                + "ldc 48\nisub\nldc 10\niload 50\n"
            + "imul\n" + "iadd\n" + "istore 50\n" + "goto Label1\n"	+ "Label3:\n"
            + "ldc 1\n"	+ "istore 49\n"	+ "goto Label1\n" + "Label2:     ; now our dummy integer contains the integer read from the keyboard\n"
            + "ldc 1\n"	+ "iload 49\n" + "isub\n" + "ifeq Label4\n"	+ "iload 50       ; input function ends here\n"
            + "ireturn\n" + "Label4:\n" + "ldc 0\n" + "iload 50\n" + "isub\n" + "ireturn\n"
            + ".end method\n");
	sb.append(".method public static main([Ljava/lang/String;)V\n");
	sb.append("\t.limit stack 100\n");
	sb.append("\t.limit locals 100\n");
    }
    public void exitPrograma(simpleJavaParser.ProgramaContext ctx) { 
        //System.out.println("Programa analisado com sucesso.");
        //        System.out.println("Programa analisado com sucesso.");
//        System.out.println("quantidade de erros: " + mensagemErro.size());
        if(mensagemErro.isEmpty()){
            msgCompilacao = "Programa analisado sem erros semanticos!";
        }else{
            msgCompilacao = "Programa analisado: erros encontrados\n";
        }
        gerar = new PrintWriter(codigo);
        
        sb.append("\treturn\n");
	sb.append(".end method");
        gerar.printf(sb.toString());
        
        try{
            codigo.close();
        }catch(IOException e){
            System.out.println("Erro ao fechar o arquivo!");
        }
    }
    
    @Override public void enterDecVar(simpleJavaParser.DecVarContext ctx) { 
        int tipo = tipoToInt(ctx.tipo().getText());
        
        //Verifica se a variável é repetida globalmente
        if(ctx.parent.getChild(0).getText().equals("Prog")){
            for(TerminalNode tn : ctx.listaIDs().ID())
            {
                //Verifica se a variável é alguma palavra reservada da linguagem
                if (this.tab.ehPalavraDaLinguagem(tn.getText()))
                {
                    System.out.println("Variável " + tn.getText() + " é uma palavra reservada da linguagem.");
                    mensagemErro.add("Variável " + tn.getText() + " é uma palavra reservada da linguagem.");
                }
                //Verifica se a variável foi declarada como constante
                else if(this.tab.isConstante(tn.getText()))
                {
                    System.out.println("Variável " + tn.getText() + " usada na linha " + ctx.start.getLine() + "já foi usada como constante.");
                    mensagemErro.add("Variável " + tn.getText() + " usada na linha " + ctx.start.getLine() + "já foi usada como constante.");
                }
                else if (this.tab.isVariavel(tn.getText()))
                {
                    System.out.println("Variável " + tn.getText() + " repetida na linha " + ctx.start.getLine());
                    mensagemErro.add("Variável " + tn.getText() + " repetida na linha " + ctx.start.getLine());
                }
                else
                {
                    tab.addVar(tn.getText(), tipo);
                }
            }
        }
        else
        {
            for(TerminalNode tn : ctx.listaIDs().ID())
            {
                String nomeDestaVariavel = tn.getText();
                Variavel encontrouVariavel = this.tab.getFuncao(idFuncAtual).getVariavel(nomeDestaVariavel);
                //Verifica se a variável é alguma palavra reservada da linguagem
                if (this.tab.ehPalavraDaLinguagem(tn.getText()))
                {
                    System.out.println("Variável " + nomeDestaVariavel + " é uma palavra reservada da linguagem.");
                    mensagemErro.add("Variável " + tn.getText() + " é uma palavra reservada da linguagem.");
                }
                //Se já existe essa variável
                else if (encontrouVariavel != null)
                {
                    System.out.println("Variável " + nomeDestaVariavel + " repetida na linha " + ctx.start.getLine());
                    mensagemErro.add("Variável " + nomeDestaVariavel + " repetida na linha " + ctx.start.getLine());
                }
                //Se foi declarada como constante
                else if (tab.isConstante(nomeDestaVariavel))
                {
                    System.out.println("Variável " + nomeDestaVariavel + " utilizada na linha " + ctx.start.getLine() + " já foi usada como constante.");
                    mensagemErro.add("Variável " + nomeDestaVariavel + " utilizada na linha " + ctx.start.getLine() + " já foi usada como constante.");
                    
                }
                //Se foi usada como nome de função
                else if (tab.isFuncao(nomeDestaVariavel))
                {
                    System.out.println("Variável " + nomeDestaVariavel + " utilizada na linha " + ctx.start.getLine() + " já foi usada como função.");
                    mensagemErro.add("Variável " + nomeDestaVariavel + " utilizada na linha " + ctx.start.getLine() + " já foi usada como função.");
                }
                else
                {
                    this.tab.getFuncao(idFuncAtual).addVar(nomeDestaVariavel, tipo);
                }
            }
        }   
        super.enterDecVar(ctx);
    }
    
    @Override public void enterDecConst(simpleJavaParser.DecConstContext ctx) { 
        
        int tipo = tipoToInt(ctx.tipo().getText());
        String valor = ctx.valor().getText();
        
        String nomeDestaConstante = ctx.getText();
        //Verifica se a variável é alguma palavra reservada da linguagem
        if (this.tab.ehPalavraDaLinguagem(nomeDestaConstante))
        {
            System.out.println("Constante " + nomeDestaConstante + " é uma palavra reservada da linguagem.");
            mensagemErro.add("Constante " + nomeDestaConstante + " é uma palavra reservada da linguagem.");
        }
        //Se foi declarada como constante
        else if (tab.isConstante(nomeDestaConstante))
        {
            System.out.println("Constante " + nomeDestaConstante + " utilizada na linha " + ctx.start.getLine() + " já foi usada como constante.");
            mensagemErro.add("Constante " + nomeDestaConstante + " utilizada na linha " + ctx.start.getLine() + " já foi usada como constante.");
        }
        //Se já foi declarada como variável
        else if (tab.isVariavel(nomeDestaConstante))
        {
            System.out.println("Constante " + nomeDestaConstante + " utilizada na linha " + ctx.start.getLine() + " já foi usada como variável.");
            mensagemErro.add("Constante " + nomeDestaConstante + " utilizada na linha " + ctx.start.getLine() + " já foi usada como variável.");
        }
        //Se foi usada como nome de função
        else if (tab.isFuncao(nomeDestaConstante))
        {
            System.out.println("Variável " + nomeDestaConstante + " utilizada na linha " + ctx.start.getLine() + " já foi usada como função.");
            mensagemErro.add("Variável " + nomeDestaConstante + " utilizada na linha " + ctx.start.getLine() + " já foi usada como função.");
        }
        else
        {
            tab.addConst(nomeDestaConstante, tipo, valor);
        }          
    }

    @Override public void enterDecFunc(simpleJavaParser.DecFuncContext ctx) { 
        //Quando ele entra na função, ele nomeia
        this.idFuncAtual = ctx.ID().getText();
        
        //Captura o tipo dessa função
        int tipo = tipoToInt(ctx.tipo().getText());
       
        TerminalNode tn = ctx.ID();
        String nomeDestaFuncao = tn.getText();
        
        //Verifica se essa função é alguma palavra reservada da linguagem
        if (this.tab.ehPalavraDaLinguagem(nomeDestaFuncao))
        {
            System.out.println("Funcao " + nomeDestaFuncao + " utilizada na linha " + ctx.start.getLine() + " é uma palavra reservada da linguagem.");
            mensagemErro.add("Funcao " + nomeDestaFuncao + " utilizada na linha " + ctx.start.getLine() + " é uma palavra reservada da linguagem.");
        }
        //Verifica se já foi usada como constante
        else if (this.tab.isConstante(nomeDestaFuncao))
        {
            System.out.println("Funcao " + nomeDestaFuncao + " utilizada na linha " + ctx.start.getLine() + " já foi utilizada como constante.");
            mensagemErro.add("Funcao " + nomeDestaFuncao + " utilizada na linha " + ctx.start.getLine() + " já foi utilizada como constante.");
        }
        //Verifica se já foi usada como variável
        else if (this.tab.isVariavel(nomeDestaFuncao))
        {
            System.out.println("Funcao " + nomeDestaFuncao + " utilizada na linha " + ctx.start.getLine() + " já foi utilizada como variável.");
            mensagemErro.add("Funcao " + nomeDestaFuncao + " utilizada na linha " + ctx.start.getLine() + " já foi utilizada como variável.");
        }
        //Verifica se já foi usada como função
        else if (this.tab.isFuncao(nomeDestaFuncao))
        {
            System.out.println("Funcao " + nomeDestaFuncao + " utilizada na linha " + ctx.start.getLine() + " já foi utilizada como função.");
            mensagemErro.add("Funcao " + nomeDestaFuncao + " utilizada na linha " + ctx.start.getLine() + " já foi utilizada como função.");
        }
        else
        {
            //Se não há então a adicione na tabela
            tab.addFunc(tipoToInt(ctx.tipo().getText()), idFuncAtual);
        }
    }
    
    @Override public void exitDecFunc(simpleJavaParser.DecFuncContext ctx) { 
        //Quando ele sai, ele desnomeia
        this.idFuncAtual = null;
    }
    
    @Override public void enterListaParametros(simpleJavaParser.ListaParametrosContext ctx) 
    {
        //System.out.println("Parametros = " + ctx.getText());
        //Pendente
    }
    
    @Override public void enterParametro(simpleJavaParser.ParametroContext ctx) 
    {        
        TerminalNode tn = ctx.ID();
        String nomeDesteParametro = tn.getText();
        int tipo = tipoToInt(ctx.tipo().getText());
        
        //Verifica se este parâmetro é uma palavra reservada desta linguagem
        if (this.tab.ehPalavraDaLinguagem(nomeDesteParametro))
        {
            System.out.println("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " é uma palavra reservada.");
            mensagemErro.add("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " é uma palavra reservada.");        
        }
        //Verifica se foi utilizado como variável
        else if (this.tab.getFuncao(idFuncAtual).isVariavel(nomeDesteParametro))
        {
            System.out.println("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " já foi usado como variável.");
            mensagemErro.add("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " já foi usado como variável.");
        }
        //Verifica se foi utilizado como parâmetro
        else if (this.tab.getFuncao(idFuncAtual).isParametro(nomeDesteParametro))
        {
            System.out.println("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " já foi usado como parâmetro.");
            mensagemErro.add("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " já foi usado como parâmetro.");
        }
        //Verifica se foi utilizado como funcao
        else if (this.tab.isFuncao(nomeDesteParametro))
        {
            System.out.println("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " já foi usado como função.");
            mensagemErro.add("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " já foi usado como função.");
        }
        //Verifica se foi utilizado como constante
        else if (this.tab.isConstante(nomeDesteParametro))
        {
            System.out.println("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " já foi usado como constante.");
            mensagemErro.add("Parametro " + nomeDesteParametro + " utilizado na linha " + ctx.start.getLine() + " já foi usado como constante.");
        }
        else
        {
            //Se não há então a adicione na tabela
            //tab.addFunc(tipoToInt(ctx.tipo().getText()), idFuncAtual);
            tab.getFuncao(idFuncAtual).addPar(tn.getText(), tipo);            
        }        
    }
    
    @Override public void enterNativas(simpleJavaParser.NativasContext ctx) 
    { 
        int tipoRetorno = 0, i = 0;
        String tipoJasmin;
        
        //System.out.println("print="+ctx.listaExpr().getText());
        if (ctx.getChild(0).getText().equals("print"))
        {
            //tipoRetorno = this.verificarTipoDaExpressao((simpleJavaParser.BoolContext)ctx.listaExpr().getChild(0));
            String palavra="";
            while (ctx.listaExpr().getChild(i) != null)
            {
                palavra = ctx.listaExpr().getChild(i).getText();
                //System.out.println("Palavra: " +palavra);
                ///*
                if (!palavra.equals(","))
                {
                    sb.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
                    tipoRetorno = this.verificarTipoDaExpressao(((simpleJavaParser.BoolContext) ctx.listaExpr().getChild(i)));
                    sb.append("ldc ");
                    sb.append(palavra);
                    sb.append("\n");
                    sb.append("invokevirtual java/io/PrintStream/println(");
                    tipoJasmin = tipoEmJasmin(tipoRetorno);
                    sb.append(tipoJasmin);
                    sb.append(";)V\n");
                    //System.out.println("tipo=" + tipoRetorno);
                }
                //*/
                i++;
                //System.out.println("i=" + i);
            }
        }
        else
        if (ctx.getChild(0).getText().equals("scan"))
        {
            String palavra="";
            i = 0;
            while (ctx.listaIDs().getChild(i) != null)
            {
                
                palavra = ctx.listaIDs().getChild(i).getText();
                if (!palavra.equals(","))
                {
                    //Verifica se é palavra dessa linguagem
                    if (this.tab.ehPalavraDaLinguagem(palavra))
                    {
                        System.out.println("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" é reservada dessa linguagem.");
                        mensagemErro.add("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" é reservada dessa linguagem.");
                    }
                    //Verifica se é constante
                    else if (this.tab.isConstante(palavra))
                    {
                        System.out.println("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" é constante.");
                        mensagemErro.add("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" é constante.");
                    }
                    //Verifica se NÃO foi declarada como variável
                    else if (!this.tab.isVariavel(palavra))
                    {
                        System.out.println("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" não foi declarada.");
                        mensagemErro.add("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" não foi declarada.");
                    }   
                }
                i++;
            }
            
        }
        
        
        super.exitNativas(ctx);
    }
    
    @Override public void exitNativas(simpleJavaParser.NativasContext ctx) 
    { 
        //super.exitPrint(ctx);
        super.exitNativas(ctx);
    }
    
    @Override public void enterBlocoFunc(simpleJavaParser.BlocoFuncContext ctx) 
    {
        //System.out.println("print="+ctx.getText());
    }
    
    @Override public void enterStmtf(simpleJavaParser.StmtfContext ctx) 
    { 
        int tipoPrimeiroMembro = 0;
        int tipoSegundoMembro = 0;
        String nomeVar = "";
        //Verifica em qual regra o stmt deriva
        //Se for: 
        //ou: ID '=' bool ';' [4 filhos]
        //ou: 'if' '(' bool ')' '{' stmt* '}' [7 filhos]
        //ou: 'if' '(' bool ')' '{' stmt* '}' 'else' '{' stmt* '}' [11 filhos]
        //ou: 'while' '(' bool ')' '{' stmt* '}' [7 filhos]
        //ou: 'break' ';'//2
        //ou: 'for' '(' ID '=' bool 'to' bool ('step' bool)? ')' '{' stmtf* '}'//11
        //ou: nativas
        //ou: funcao
        
        //Se deriva na regra ID '=' bool ';'
        if (ctx.getChildCount() == 4) 
        {
            nomeVar = ctx.getChild(0).getText(); //captura o ID
            //por exemplo: a = ; captura o a        
            //Verifica se a variável já foi usada como constante
            if (this.tab.isConstante(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " já foi usada como constante.");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " já foi usada como constante.");
            }
            //Caso não tenha sido, verifica se a variável não já foi usada como nome de função
            else if (this.tab.isFuncao(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " já foi usada como nome de função.");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " já foi usada como nome de função.");
            }
            //Verifica se a variável não já foi declarada globalmente [este stmt é funcao]
            //else if (!this.tab.isVariavel(nomeVar))
            else if (!this.tab.getFuncao(idFuncAtual).isVariavel(nomeVar) && !this.tab.isVariavel(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " não foi declarada");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Se nenhum dos casos anteriores...
            else
            {
                //então captura o tipo dela
                if (this.tab.isVariavel(nomeVar)) tipoPrimeiroMembro = this.tab.getVariavel(nomeVar).tipo;
                else tipoPrimeiroMembro = this.tab.getFuncao(idFuncAtual).getVariavel(nomeVar).tipo;
                tipoSegundoMembro = verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(2));
                
                //System.out.println("TipoPrimeiroMembroF " + tipoPrimeiroMembro);
                //System.out.println("TipoSegundoMembroF " + tipoSegundoMembro);
                //System.out.println("ops");
                //int=1 real=2 string=3 bool=4
                //Verifica se a variável inteira está recebendo uma do tipo que não é inteira ou real
                if (tipoPrimeiroMembro == 1 && tipoSegundoMembro > 2)
                {
                    //System.out.println("TipoPrimeiroMembro " + tipoPrimeiroMembro);
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
                else //Verifica se a variável real está recebendo uma do tipo que não é inteira ou real
                if (tipoPrimeiroMembro == 2 && tipoSegundoMembro > 2)
                {
                    //System.out.println("opa");
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
                else //Verifica se a variável string está recebendo uma do tipo que não é string
                if (tipoPrimeiroMembro == 3 && tipoSegundoMembro != 3)
                {
                    //System.out.println("opa");
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
                else //Verifica se a variável bool está recebendo uma do tipo que não é bool
                if (tipoPrimeiroMembro == 4 && tipoSegundoMembro != 4)
                {
                    //System.out.println("opa");
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
            }
        }
        //ou: 'if' '(' bool ')' '{' stmt* '}' [7 filhos]
        //ou: 'if' '(' bool ')' '{' stmt* '}' 'else' '{' stmt* '}' [11 filhos]
        else if (ctx.getChild(0).getText().equals("if"))// && verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(2)) != Bool)
        {
            verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(2));// != Bool
        }
        //ou: 'while' '(' bool ')' '{' stmt* '}' [7 filhos]
        else if (ctx.getChild(0).getText().equals("while"))// && )
        {
            ativaBreak = true;
            verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(2));
        }
        //ou: 'break' ';'
        else if (ctx.getChildCount() == 2)
        {
            //Verifica se o break está dentro de um laço de repetição
            if (!ativaBreak)
            {
                System.out.println("Comando 'break' utilizado na linha " + ctx.start.getLine() + " não está dentro de um laço de repetição.");
                mensagemErro.add("Comando 'break' utilizado na linha " + ctx.start.getLine() + " não está dentro de um laço de repetição.");
            }
        }
        //ou: 'for' '(' ID '=' bool 'to' bool ('step' bool)? ')' '{' stmtf* '}'//13 
        else if (ctx.getChild(0).getText().equals("for"))
        {
            ativaBreak = true;
            nomeVar = ctx.getChild(2).getText(); //captura o ID
            //Verifica se a variável já foi usada como constante
            if (this.tab.isConstante(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " já foi usada como constante.");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Caso não tenha sido, verifica se a variável não já foi usada como nome de função
            else if (this.tab.isFuncao(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " já foi usada como nome de função.");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Verifica se a variável não já foi declarada 
            else if (!this.tab.isVariavel(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " não foi declarada");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Se nenhum dos casos anteriores...
            else
            {
                //então captura o tipo dela
                tipoPrimeiroMembro = this.tab.getVariavel(nomeVar).tipo;
               
                //Verifica se a variável está recebendo um valor de tipo insuportável, ex: string recebendo bool
                if (tipoPrimeiroMembro != verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(4)))
                {
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
                //se tiver step
                else if (ctx.getChildCount() == 13)
                {
                    if (verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(8)) != Int){
                        System.out.println("Valor incompatível sendo atribuído ao step na linha " + ctx.start.getLine());
                        mensagemErro.add("Valor incompatível sendo atribuído ao step na linha " + ctx.start.getLine());
                    }
                }
            }
        }
        //ou: funcao
        else if (ctx.getChildCount() == 1 && ctx.getChild(0) instanceof simpleJavaParser.FuncaoContext)
        {
            
            String nomeFunc = ((simpleJavaParser.FuncaoContext) ctx.getChild(0)).ID().getText();
            //Verifica se a função foi declarada
            if (!tab.isFuncao(nomeFunc))
            {
                System.out.println("Função não declarada na linha "+ ctx.start.getLine());
                mensagemErro.add("Função não declarada na linha "+ ctx.start.getLine());
            }
            else //Se essa função foi declarada
            {
                tipoPrimeiroMembro = this.tab.getFuncao(nomeFunc).tipoRetorno;
                //System.out.println("nomeFunc: " + nomeFunc);
                //System.out.println("parametro: " + ((simpleJavaParser.FuncaoContext) ctx.getChild(0)).listaExpr().getChildCount());
                String parametros[]=(((simpleJavaParser.FuncaoContext) ctx.getChild(0)).listaExpr().getText()).split(",");
                int i = 0;
                //System.out.println("qtdParametros: " + parametros.length);
                
                //Verifica a quantidade de parâmetros da chamada com a quantidade da função declarada
                if (parametros.length != tab.getFuncao(nomeFunc).qtdParametros())
                {
                    System.out.println("Quantidade incompatível de parâmetros na linha "+ ctx.start.getLine());
                    mensagemErro.add("Quantidade de parâmetros incompatível na linha "+ ctx.start.getLine());
                }
                else //Se a quantidade de parâmetros está compatível
                {
                    //Se não, se tem parâmetros na declaração e na chamada
                    if (parametros.length > 0)
                    {
                        //System.out.println("ops");
                        //System.out.println("p="+ (simpleJavaParser.ParametroContext) ctx.ID());
                        ///*/Percorre os parâmetros na chamada
                        for (i=0; i < parametros.length; i++)
                        {
                            //Captura nome do parâmetro
                            String nomeParametroCall = parametros[i];
                            int tipoParametroCall = this.retornaTipoDaString(nomeParametroCall);
                            //Verifica se esse parâmetro NÃO foi declarado como variável
                            if (!tab.isVariavel(nomeParametroCall) && tipoParametroCall == -1)
                            {
                                System.out.println("Parâmetro " + nomeParametroCall + " usado na linha " + ctx.start.getLine() + " não foi declarado");
                                mensagemErro.add("Parâmetro " + nomeParametroCall + " usado na linha " + ctx.start.getLine() + " não foi declarado");

                            }
                            else if (this.retornaTipoDaString(nomeParametroCall) != -1)
                            {
                                if (tab.getFuncao(nomeFunc).getTipoParametro(tipoParametroCall, i) == -1){
                                    System.out.println("Parametro " + nomeParametroCall + " incompatível na linha " + ctx.start.getLine());
                                    mensagemErro.add("Parametro " + nomeParametroCall + " incompatível na linha " + ctx.start.getLine());
                                }
                            }
                            else //Se foi...
                            {
                                tipoParametroCall = tab.getVariavel(nomeParametroCall).tipo;
                                if (tab.getFuncao(nomeFunc).getTipoParametro(tipoParametroCall, i) == -1){
                                    System.out.println("Parametro " + nomeParametroCall + " incompatível na linha " + ctx.start.getLine());
                                    mensagemErro.add("Parametro " + nomeParametroCall + " incompatível na linha " + ctx.start.getLine());
                                }
                            }
                        }
                        //*/
                    }
                }
            }
        }
        //ou: 'return' '(' bool ')' ';'
        else if (ctx.getChild(0).getText().equals("return"))
        {
            //Verificar se o return NÃO está sendo declarado dentro de uma função
            if (this.tab.getFuncao(idFuncAtual) == null)
            {
                System.out.println("O return usado na linha "+ ctx.start.getLine()+" não está dentro de uma função. ");
                mensagemErro.add("O return usado na linha "+ ctx.start.getLine()+" não está dentro de uma função. ");
            }
            else 
            {                
                //então captura o tipo dela
                int tipoRetornoDaFuncao = this.verificarTipoDaExpressao((simpleJavaParser.BoolContext)ctx.getChild(2));
                int tipoDaFuncao = this.tab.getFuncao(idFuncAtual).tipoRetorno;
                
                //System.out.println("ops");
                //int=1 real=2 string=3 bool=4
                //Verifica se a variável inteira está recebendo uma do tipo que não é inteira ou real
                if (tipoDaFuncao == 1 && tipoRetornoDaFuncao > 2 || tipoDaFuncao == 2 && tipoRetornoDaFuncao > 2)
                {
                    System.out.println("O return usado na linha "+ ctx.start.getLine()+" não é compatível com sua função. ");
                    mensagemErro.add("O return usado na linha "+ ctx.start.getLine()+" não é compatível com sua função. ");
                }
                else //Verifica se a variável string está recebendo uma do tipo que não é string
                if (tipoDaFuncao == 3 && tipoRetornoDaFuncao != 3 || tipoDaFuncao == 4 && tipoRetornoDaFuncao != 2)
                {
                    System.out.println("O return usado na linha "+ ctx.start.getLine()+" não é compatível com sua função. ");
                    mensagemErro.add("O return usado na linha "+ ctx.start.getLine()+" não é compatível com sua função. ");
                }
            }
        }
        //ou: nativas
        else if (ctx.getChildCount() == 1)
        {            
            /*
            int tipoRetorno = 0, i = 0;
            if (ctx.nativas().getChild(0).getText().equals("print"))
            {
                tipoRetorno = this.verificarTipoDaExpressao((simpleJavaParser.BoolContext)ctx.nativas().listaExpr().getChild(0));
                String palavra="";
                while (ctx.nativas().listaExpr().getChild(i) != null)
                {
                    palavra = ctx.nativas().listaExpr().getChild(i).getText();
                    ///*
                    if (!palavra.equals(","))
                    {
                        tipoRetorno = this.verificarTipoDaExpressao(((simpleJavaParser.BoolContext) ctx.nativas().listaExpr().getChild(i)));
                    }
                    i++;
                }
            }
            else
            if (ctx.getChild(0).getText().equals("scan"))
            {
                String palavra="";
                i = 0;
                while (ctx.nativas().listaIDs().getChild(i) != null)
                {

                    palavra = ctx.nativas().listaIDs().getChild(i).getText();
                    if (!palavra.equals(","))
                    {
                        //Verifica se é palavra dessa linguagem
                        if (this.tab.ehPalavraDaLinguagem(palavra))
                        {
                            System.out.println("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" é reservada dessa linguagem.");
                            //mensagemErro.add("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" é reservada dessa linguagem.");
                        }
                        //Verifica se é constante
                        else if (this.tab.isConstante(palavra))
                        {
                            System.out.println("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" é constante.");
                            //mensagemErro.add("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" é constante.");
                        }
                        //Verifica se NÃO foi declarada como variável
                        else if (!this.tab.isVariavel(palavra))
                        {
                            System.out.println("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" não foi declarada.");
                            //mensagemErro.add("Palavra " + palavra + " utilizada na linha " +ctx.start.getLine()+" não foi declarada.");
                        }   
                    }
                    i++;
                }

            }
            */
        }
    }
    
    @Override public void enterListaExpr(simpleJavaParser.ListaExprContext ctx) 
    { 
        //System.out.println("print="+ctx);
    }
    
    @Override public void enterBool(simpleJavaParser.BoolContext ctx) 
    { 
        //System.out.println("enterBool="+ctx.getText());
    }
    
    @Override public void enterExpr(simpleJavaParser.ExprContext ctx) 
    { 
        //System.out.println("expr="+ctx.getText());
    }
    
    @Override public void enterFator(simpleJavaParser.FatorContext ctx) 
    {
        //System.out.println("fator="+ctx.getText());
        //System.out.println("fator.tipo="+ctx.ID());
    }

    @Override public void enterTipo(simpleJavaParser.TipoContext ctx) 
    { 
        //System.out.println("tipo="+ctx.getText());
        //Tipo inválido nesta linguagem
        if (!ctx.getText().equals("Int")&&!ctx.getText().equals("Real")&&!ctx.getText().equals("String")&&!ctx.getText().equals("Bool"))
        {
            System.out.println("Tipo inválido nesta linguagem declarado na linha " + ctx.start.getLine());
        }
    }
    
    @Override public void enterBlocoMain(simpleJavaParser.BlocoMainContext ctx) 
    { 
        //System.out.println("blocoMain="+ctx.stmt());
    }
    
    @Override public void enterStmt(simpleJavaParser.StmtContext ctx) 
    {               
        int tipoPrimeiroMembro = 0;
        int tipoSegundoMembro = 0;
        String nomeVar = "";
        //Verifica em qual regra o stmt deriva
        //Se for: 
        //ou: ID '=' bool ';' [4 filhos]
        //ou: 'if' '(' bool ')' '{' stmt* '}' [7 filhos]
        //ou: 'if' '(' bool ')' '{' stmt* '}' 'else' '{' stmt* '}' [11 filhos]
        //ou: 'while' '(' bool ')' '{' stmt* '}' [7 filhos]
        //ou: 'break' ';'//2
        //ou: 'for' '(' ID '=' bool 'to' bool ('step' bool)? ')' '{' stmtf* '}'//11
        //ou: nativas
        //ou: funcao
        //System.out.println("getCount: " + ctx.getChildCount());
        //System.out.println("getCount: " + ctx.getText());
        //Se deriva na regra ID '=' bool ';'
        if (ctx.getChildCount() == 4) 
        {
            nomeVar = ctx.getChild(0).getText(); //captura o ID
            //por exemplo: a = ; captura o a        
            //Verifica se a variável já foi usada como constante
            if (this.tab.isConstante(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " já foi usada como constante.");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Caso não tenha sido, verifica se a variável não já foi usada como nome de função
            else if (this.tab.isFuncao(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " já foi usada como nome de função.");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Verifica se a variável não já foi declarada globalmente [este stmt é global]
            else if (!this.tab.isVariavel(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " não foi declarada");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Se nenhum dos casos anteriores...
            else
            {
                //então captura o tipo dela
                tipoPrimeiroMembro = this.tab.getVariavel(nomeVar).tipo;
                tipoSegundoMembro = verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(2));
                
                //System.out.println("TipoPrimeiroMembro " + tipoPrimeiroMembro);
                //System.out.println("TipoSegundoMembro " + tipoSegundoMembro);
                //System.out.println("ops");
                //int=1 real=2 string=3 bool=4
                //Verifica se a variável inteira está recebendo uma do tipo que não é inteira ou real
                if (tipoPrimeiroMembro == 1 && tipoSegundoMembro > 2)
                {
                    //System.out.println("opa");
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
                else //Verifica se a variável real está recebendo uma do tipo que não é inteira ou real
                if (tipoPrimeiroMembro == 2 && tipoSegundoMembro > 2)
                {
                    //System.out.println("opa");
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
                else //Verifica se a variável string está recebendo uma do tipo que não é string
                if (tipoPrimeiroMembro == 3 && tipoSegundoMembro != 3)
                {
                    //System.out.println("opa");
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
                else //Verifica se a variável bool está recebendo uma do tipo que não é bool
                if (tipoPrimeiroMembro == 4 && tipoSegundoMembro != 4)
                {
                    //System.out.println("opa");
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
            }
        }
        //ou: 'if' '(' bool ')' '{' stmt* '}' [7 filhos]
        //ou: 'if' '(' bool ')' '{' stmt* '}' 'else' '{' stmt* '}' [11 filhos]
        else if (ctx.getChild(0).getText().equals("if"))// && verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(2)) != Bool)
        {
            verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(2));// != Bool
        }
        //ou: 'while' '(' bool ')' '{' stmt* '}' [7 filhos]
        else if (ctx.getChild(0).getText().equals("while"))// && )
        {
            ativaBreak = true;
            verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(2));
        }
        //ou: 'break' ';'
        else if (ctx.getChildCount() == 2)
        {
            //Verifica se o break está dentro de um laço de repetição
            if (!ativaBreak)
            {
                System.out.println("Comando 'break' utilizado na linha " + ctx.start.getLine() + " não está dentro de um laço de repetição.");
                mensagemErro.add("Comando 'break' utilizado na linha " + ctx.start.getLine() + " não está dentro de um laço de repetição.");
            }
        }
        //ou: 'for' '(' ID '=' bool 'to' bool ('step' bool)? ')' '{' stmtf* '}'//11  
        else if (ctx.getChild(0).getText().equals("for"))
        {
            ativaBreak = true;
            //System.out.println("ctx.getChildCount():"+ctx.getChildCount());
            nomeVar = ctx.getChild(2).getText(); //captura o ID
            //Verifica se a variável já foi usada como constante
            if (this.tab.isConstante(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " já foi usada como constante.");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Caso não tenha sido, verifica se a variável não já foi usada como nome de função
            else if (this.tab.isFuncao(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " já foi usada como nome de função.");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Verifica se a variável não já foi declarada 
            else if (!this.tab.isVariavel(nomeVar))
            {
                System.out.println("Variável " + nomeVar + " usada na linha " + ctx.start.getLine() + " não foi declarada");
                mensagemErro.add("Variável " + nomeVar + " usada na linha  " + ctx.start.getLine() + " não foi declarada");
            }
            //Se nenhum dos casos anteriores...
            else
            {
                //System.out.println("gg: " + ctx.getChildCount());
                //então captura o tipo dela
                tipoPrimeiroMembro = this.tab.getVariavel(nomeVar).tipo;
               
                //Verifica se a variável está recebendo um valor de tipo insuportável, ex: string recebendo bool
                if (tipoPrimeiroMembro != verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(4)))
                {
                    System.out.println("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                    mensagemErro.add("Valor incompatível sendo atribuído na linha " + ctx.start.getLine());
                }
                //se tiver step
                else if (ctx.getChild(7).getText().equals("step"))//(ctx.getChild(8).equals("step"))
                {
                    //System.out.println("v=" + ctx.getChild(7).getText());
                    if (verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(8)) != Int){
                        System.out.println("Valor incompatível sendo atribuído ao step na linha " + ctx.start.getLine());
                        mensagemErro.add("Valor incompatível sendo atribuído ao step na linha " + ctx.start.getLine());
                    }
                }
            }
        }
        //ou: funcao
        else if (ctx.getChildCount() == 1 && ctx.getChild(0) instanceof simpleJavaParser.FuncaoContext)
        {
            
            String nomeFunc = ((simpleJavaParser.FuncaoContext) ctx.getChild(0)).ID().getText();
            //Verifica se a função foi declarada
            if (!tab.isFuncao(nomeFunc))
            {
                System.out.println("Função não declarada na linha "+ ctx.start.getLine());
                mensagemErro.add("Função não declarada na linha "+ ctx.start.getLine());
            }
            else //Se essa função foi declarada
            {
                tipoPrimeiroMembro = this.tab.getFuncao(nomeFunc).tipoRetorno;
                //System.out.println("nomeFunc: " + nomeFunc);
                //System.out.println("parametro: " + ((simpleJavaParser.FuncaoContext) ctx.getChild(0)).listaExpr().getChildCount());
                String parametros[]=(((simpleJavaParser.FuncaoContext) ctx.getChild(0)).listaExpr().getText()).split(",");
                int i = 0;
                //System.out.println("qtdParametros: " + parametros.length);
                
                //Verifica a quantidade de parâmetros da chamada com a quantidade da função declarada
                if (parametros.length != tab.getFuncao(nomeFunc).qtdParametros())
                {
                    System.out.println("Quantidade incompatível de parâmetros na linha "+ ctx.start.getLine());
                    mensagemErro.add("Quantidade de parâmetros incompatível na linha "+ ctx.start.getLine());
                }
                else //Se a quantidade de parâmetros está compatível
                {
                    //Se não, se tem parâmetros na declaração e na chamada
                    if (parametros.length > 0)
                    {
                        //System.out.println("ops");
                        //System.out.println("p="+ (simpleJavaParser.ParametroContext) ctx.ID());
                        ///*/Percorre os parâmetros na chamada
                        for (i=0; i < parametros.length; i++)
                        {
                            //Captura nome do parâmetro
                            String nomeParametroCall = parametros[i];
                            int tipoParametroCall = this.retornaTipoDaString(nomeParametroCall);
                            //Verifica se esse parâmetro NÃO foi declarado como variável
                            if (!tab.isVariavel(nomeParametroCall) && tipoParametroCall == -1)
                            {
                                System.out.println("Parâmetro " + nomeParametroCall + " usado na linha " + ctx.start.getLine() + " não foi declarado");
                                mensagemErro.add("Parâmetro " + nomeParametroCall + " usado na linha " + ctx.start.getLine() + " não foi declarado");

                            }
                            else if (this.retornaTipoDaString(nomeParametroCall) != -1)
                            {
                                if (tab.getFuncao(nomeFunc).getTipoParametro(tipoParametroCall, i) == -1){
                                    System.out.println("Parametro " + nomeParametroCall + " incompatível na linha " + ctx.start.getLine());
                                    mensagemErro.add("Parametro " + nomeParametroCall + " incompatível na linha " + ctx.start.getLine());
                                }
                            }
                            else //Se foi...
                            {
                                tipoParametroCall = tab.getVariavel(nomeParametroCall).tipo;
                                if (tab.getFuncao(nomeFunc).getTipoParametro(tipoParametroCall, i) == -1){
                                    System.out.println("Parametro " + nomeParametroCall + " incompatível na linha " + ctx.start.getLine());
                                    mensagemErro.add("Parametro " + nomeParametroCall + " incompatível na linha " + ctx.start.getLine());
                                }
                            }
                        }
                        //*/
                    }
                }
            }
        }
        //ou: nativas
        else
        {
            super.enterStmt(ctx);
        }
    }
    
    public int verificarTipoDaExpressao(simpleJavaParser.BoolContext ctx){
        //Se a regra bool deriva em join
        if (ctx.getChildCount() == 1)
        {
            //System.out.println("ops");
            return verificarTipoJoin((simpleJavaParser.JoinContext) ctx.getChild(0));
        }
        else
        {
            //Verifica o tipo de cada um dos outros membros da regra bool
            int tipoBool = verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(0));
            int tipoJoin = verificarTipoJoin((simpleJavaParser.JoinContext) ctx.getChild(0));
            
            //Se as duas derem '1', ou seja, verdadeiro, então blz
            if (tipoBool == tipoJoin)
            {
                return Bool;
            }
            else
            {
                System.out.println("Tipos incompatíveis sendo usados na expressão || na linha " + ctx.start.getLine());
                mensagemErro.add("Tipos incompatíveis sendo usados na expressão || na linha " + ctx.start.getLine());
            }
        }
        return 0;
    }
    public int verificarTipoJoin(simpleJavaParser.JoinContext ctx){
        //Se a regra join deriva em equals
        if(ctx.getChildCount() == 1)
        {
            //System.out.println("ops");
            return verificarTipoEqual((simpleJavaParser.EqualContext) ctx.getChild(0));
        }
        else
        {
            int tipoJoin = verificarTipoJoin((simpleJavaParser.JoinContext) ctx.getChild(0));;
            int tipoEqual = verificarTipoEqual((simpleJavaParser.EqualContext) ctx.getChild(2));
            
            //Se as duas derem '1', ou seja, verdadeiro, então blz
            if (tipoJoin == tipoEqual)
            {
                return Bool;
            }
            else
            {
                System.out.println("Tipos incompatíveis sendo usados na expressão && na linha " + ctx.start.getLine());
                mensagemErro.add("Tipos incompatíveis sendo usados na expressão && na linha " + ctx.start.getLine());
            }
        }
        return 0;
    }
    
    public int verificarTipoEqual(simpleJavaParser.EqualContext ctx)
    {
        //Se a regra equal deriva em rel
        if (ctx.getChildCount() == 1)
        {
            //System.out.println("ops");
            return verificarTipoRel((simpleJavaParser.RelContext) ctx.getChild(0));
        }
        else
        {
            int tipoEqual = verificarTipoEqual((simpleJavaParser.EqualContext) ctx.getChild(0));
            int tipoRel = verificarTipoRel ((simpleJavaParser.RelContext) ctx.getChild(2));
            
            //Verifica operador
            String operador = "nulo";
            if (ctx.getChild(1).toString().equals("=="))
                operador = "==";
            else operador = "!=";
            
            if (tipoEqual == tipoRel)
            {
                return Bool;
            }
            else
            {
                System.out.println("Tipos incompatíveis sendo usados na expressão "+operador+" na linha " + ctx.start.getLine());
                mensagemErro.add("Tipos incompatíveis sendo usados na expressão "+operador+" na linha " + ctx.start.getLine());
            }
        }
        return 0;
    }
    
    public int verificarTipoRel (simpleJavaParser.RelContext ctx)
    {
        //Se a regra rel deriva SOMENTE em expr
        if (ctx.getChildCount() == 1)
        {
            //System.out.println("ops");
            return verificarTipoExpr((simpleJavaParser.ExprContext) ctx.getChild(0));
        }
        else
        {
            int tipoExpr1 = verificarTipoExpr ((simpleJavaParser.ExprContext) ctx.getChild(0));
            int tipoExpr2 = verificarTipoExpr ((simpleJavaParser.ExprContext) ctx.getChild(2));
            
            //Verifica operador
            String operador = "";
            if (ctx.getChild(1).toString().equals(">"))
                operador = ">";
            else if (ctx.getChild(1).toString().equals("<"))
                operador = "<";
            else if (ctx.getChild(1).toString().equals("<="))
                operador = "<=";
            else if (ctx.getChild(1).toString().equals(">="))
                operador = ">=";
            
            if (tipoExpr1 == Real && tipoExpr2 == Real || tipoExpr1 == Int && tipoExpr2 == Real || tipoExpr1 == Real && tipoExpr2 == Int || tipoExpr1 == Int && tipoExpr2 == Int)
            {
                return Bool;
            }
            else
            {
                System.out.println("Tipos incompatíveis sendo usados na expressão "+operador+" na linha " + ctx.start.getLine());
                mensagemErro.add("Tipos incompatíveis sendo usados na expressão "+operador+" na linha " + ctx.start.getLine());
            }
        }
        return 0;
    }
    
    public int verificarTipoExpr (simpleJavaParser.ExprContext ctx)
    {
        //Se a regra expr deriva em termo
        if(ctx.getChildCount() == 1)
        {
            //System.out.println("ops");
            return verificarTipoTermo((simpleJavaParser.TermoContext) ctx.getChild(0));
        }
        else
        {
            int tipoExpr = verificarTipoExpr ((simpleJavaParser.ExprContext) ctx.getChild(0));
            String tExpr = ctx.getChild(0).getText();
            int tipoTermo = verificarTipoTermo ((simpleJavaParser.TermoContext) ctx.getChild(2));
            String tTermo = ctx.getChild(2).getText();
            
            //Verifica operador
            String operador = "nulo";
            if (ctx.getChild(1).toString().equals("-"))
                operador = "-";
            else operador = "+";
            
            //System.out.println("tExpr: " + tExpr +"; tTermo: " + tTermo);
            
            if (tipoExpr == Real && tipoTermo == Real || tipoExpr == Real && tipoTermo == Int || tipoExpr == Int && tipoTermo == Real)
            {
                return Real;
            }
            else if (tipoExpr == Int && tipoTermo == Int)
            {
                return Int;
            }
            else
            {
                System.out.println("Tipos incompatíveis sendo usados na expressão "+operador+" na linha " + ctx.start.getLine());
                mensagemErro.add("Tipos incompatíveis sendo usados na expressão "+operador+" na linha " + ctx.start.getLine());
            }
        }
        return 0;
    }
    
    public int verificarTipoTermo (simpleJavaParser.TermoContext ctx)
    {
        //Se a regra expr deriva em termo
        if(ctx.getChildCount() == 1)
        {
            //System.out.println("ops");
            return verificarTipoXp((simpleJavaParser.XpContext) ctx.getChild(0));
        }
        else
        {
            int tipoTermo = verificarTipoTermo ((simpleJavaParser.TermoContext) ctx.getChild(0));;
            int tipoXp = verificarTipoXp ((simpleJavaParser.XpContext) ctx.getChild(2));
            //System.out.println("tipoTermo: " + tipoTermo);
            //System.out.println("tipoXp: " + tipoXp);
            //Verifica operador
            String operador = "nulo";
            if (ctx.getChild(1).toString().equals("/"))operador = "/";
            else operador = "*";
            
            if ((tipoTermo == Real && tipoXp == Real) || (tipoTermo == Int && tipoXp == Real) || (tipoTermo == Real && tipoXp == Int))
            {
                return Real;
            }
            else if (tipoTermo == Int && tipoXp == Int)
            {
                return Int;
            }
            else
            {
                System.out.println("Tipos incompatíveis sendo usados na expressão "+operador+" na linha " + ctx.start.getLine());
                mensagemErro.add("Tipos incompatíveis sendo usados na expressão "+operador+" na linha " + ctx.start.getLine());
            }
        }
        return 0;
    }
    
    public int verificarTipoXp (simpleJavaParser.XpContext ctx)
    {
        //Se a regra termo deriva em xp
        if(ctx.getChildCount() == 1)
        {
            //System.out.println("ops");
            return verificarTipoUni((simpleJavaParser.UniContext) ctx.getChild(0));
        }
        else
        {
            int tipoXp = verificarTipoXp ((simpleJavaParser.XpContext) ctx.getChild(0));
            int tipoUni = verificarTipoUni ((simpleJavaParser.UniContext) ctx.getChild(2));
            
            if ((tipoXp == Int && tipoUni == Int))//||(tipoXp == Real && tipoUni == Int)||(tipoXp == Int && tipoUni == Real)||(tipoXp == Real && tipoUni == Real))
            {
                return Int;
            }
            else if ((tipoXp == Real && tipoUni == Int)||(tipoXp == Int && tipoUni == Real)||(tipoXp == Real && tipoUni == Real))
            {
                return Real;
            }
            else
            {
                System.out.println("Tipos incompatíveis sendo usados na potenciação na linha " + ctx.start.getLine());
                mensagemErro.add("Tipos incompatíveis sendo usados na potenciação na linha " + ctx.start.getLine());
            }
        }
        return 0;
    }
    
    public int verificarTipoUni (simpleJavaParser.UniContext ctx)
    {
        //Se a regra xp deriva em fator
        if(ctx.getChildCount() == 1)
        {
            //System.out.println("ops");
            return verificarTipoFator((simpleJavaParser.FatorContext) ctx.getChild(0));
        }
        else
        {
            String unario = ctx.getChild(0).toString();
            int tipoUni = verificarTipoFator ((simpleJavaParser.FatorContext) ctx.getChild(1));
            //if (unario == "!" && tipoUni != Bool)
            if (unario.equals("!") && tipoUni != Bool)
            {
                System.out.println("Operador de negação usado com tipo incompatível na linha " + ctx.start.getLine());
                mensagemErro.add("Operador de negação usado com tipo incompatível na linha " + ctx.start.getLine());
            }
            else if (unario.equals("-") && (tipoUni != Real && tipoUni != Int))
            {
                System.out.println("Operador de subtração usado com tipo incompatível na linha " + ctx.start.getLine());
                mensagemErro.add("Operador de negatividade usado com tipo incompatível na linha " + ctx.start.getLine());
            }
        }
        return 0;
    }
    
    public int verificarTipoFator (simpleJavaParser.FatorContext ctx)
    {
        //System.out.println("ops");
        //Se a regra fator deriva em uma expressão entre parênteses ( bool ) "três elementos"
        if(ctx.getChildCount() == 3)
        {
            //System.out.println("ops");
            return verificarTipoDaExpressao((simpleJavaParser.BoolContext) ctx.getChild(1));
        }
        else
        {
            
            String tipoDoFator = ctx.getChild(0).toString();
            //System.out.println("tipoDoFator: " + tipoDoFator);

            //Se não, se o fator derivar no retorno de uma função, então simplesmente retorna o tipo dessa função
            if (ctx.getChild(0) instanceof simpleJavaParser.FuncaoContext)
            {
                //System.out.println("opaaa");
                String nomeFunc = ((simpleJavaParser.FuncaoContext) ctx.getChild(0)).ID().getText();
                if (tab.isFuncao(nomeFunc))
                {
                    return tab.getFuncao(nomeFunc).tipoRetorno;
                }
                else
                {
                    System.out.println("Função utilizada na linha " + ctx.start.getLine() + " não foi declarada.");
                    mensagemErro.add("Função utilizada na linha " + ctx.start.getLine() + " não foi declarada.");
                }
            }
            else //Se não é literal (se é variável)
            if (this.retornaTipoDaString(tipoDoFator) == -1){
                if (tab.isVariavel(tipoDoFator))
                {
                    return tab.getVariavel(tipoDoFator).tipo;
                    //System.out.println("Variável "+tipoDoFator+" usada na linha " + ctx.start.getLine() + " não foi declarada.");
                    //mensagemErro.add("Variável usada na linha " + ctx.start.getLine() + " não foi declarada.");
                }
                //Se não, se é variável de função
                else if (idFuncAtual != null && tab.getFuncao(idFuncAtual).isVariavel(tipoDoFator))
                {
                    return tab.getFuncao(idFuncAtual).getVariavel(tipoDoFator).tipo;
                    //System.out.println("Variável "+tipoDoFator+" usada na linha " + ctx.start.getLine() + " não foi declarada.");
                    //mensagemErro.add("Variável usada na linha " + ctx.start.getLine() + " não foi declarada.");
                }
                else
                {
                    System.out.println("Variável "+tipoDoFator+" usada na linha " + ctx.start.getLine() + " não foi declarada.");
                    mensagemErro.add("Variável " +tipoDoFator+ " usada na linha " + ctx.start.getLine() + " não foi declarada.");
                }
                
            }
            //Se não...
            else return this.retornaTipoDaString(tipoDoFator);
        }
        return 0;
    }
    
    public int retornaTipoDaString(String t)
    {
        //Se for TRUE ou FALSE é porque é Bool
        if (t.equals("TRUE") || t.equals("FALSE"))
        {
            //System.out.println("tipoDoFator: Bool");
            return Bool;
        }
        //Se não, se iniciar com aspas e terminar com aspas, então é STRING
        else if (t.startsWith("\"") && t.endsWith("\""))
        {
            //System.out.println("tipoDoFator: String");
            return String;
        }
        //Se não, se tiver ponto, então é Real
        else if (t.contains("."))
        {
            //System.out.println("tipoDoFator: Real");
            return Real;
        }
        else if (ehInteiro(t))
        {
            //System.out.println("VarGlobal: ");// + tab.getVariavel(tipoDoFator).toString());
            return Int;
        }
        //else if ()
        return -1;
    }
    
    @Override public void exitStmtf(simpleJavaParser.StmtfContext ctx) 
    { 
        //System.out.println("ctx.getText(): " + ctx.getText());
        if (ctx.getChild(0).getText().equals("for")){
            //System.out.println("ctx.getText(): " + ctx.getChild(0).getText());     
            this.ativaBreak = false;
        }
        else if (ctx.getChild(0).getText().equals("while")){
            //System.out.println("ctx.getText(): " + ctx.getChild(0).getText());     
            this.ativaBreak = false;
        }
    }
    
    @Override public void exitStmt(simpleJavaParser.StmtContext ctx) 
    { 
        //System.out.println("ctx.getText(): " + ctx.getText());
        if (ctx.getChild(0).getText().equals("for")){
            //System.out.println("ctx.getText(): " + ctx.getChild(0).getText());     
            this.ativaBreak = false;
        }
        else if (ctx.getChild(0).getText().equals("while")){
            //System.out.println("ctx.getText(): " + ctx.getChild(0).getText());     
            this.ativaBreak = false;
        } 
    }
    @Override public void enterFuncao(simpleJavaParser.FuncaoContext ctx) 
    { 
        //System.out.println("tipoDaFunc: "+ ctx.getText());
    }
    
    @Override public void exitFuncao(simpleJavaParser.FuncaoContext ctx) 
    { 
        //System.out.println("tipoRetornoDaFunc: "+ ctx.getText());
    }
    //"mapTipo" = "tipoToInt"
    public int tipoToInt(String t){
        if(t.equals("Int"))
            return Int;
        if(t.equals("Real"))
            return Real;
        if(t.equals("String"))
            return String;
        if(t.equals("Bool"))
            return Bool;
        return 0;
    }
    
    public static boolean ehInteiro(String palavra)
    {
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher mat = pat.matcher(palavra);
        return mat.matches();
    }
    
    private String tipoEmJasmin(int type){
        switch(type){
            case 1: return "I";
            case 2: return "F";
            case 3: return "Ljava/lang/String;";
            case 4: return "I"; 
	}
            return "";
    }
    
    private void declaraVariavelEmJasmin(String tipo, int endereco){
	switch(tipo){
            case "Int":
		//salvar.printf("\t\tldc " + 0 + "\n");
		//salvar.printf("\t\tistore " + endereco + "\n");
		break;
            case "Real":
		//salvar.printf("\t\tldc " + 0 + "\n");
//		salvar.printf("\t\tfstore " + endereco + "\n");
		break;
            case "Bool":
//		salvar.printf("\t\tldc " + "\"FALSO\"" + "\n");
//		salvar.printf("\t\tastore " + endereco + "\n");
		break;
            case "String":
//		salvar.printf("\t\tldc " + "\"\"" + "\n");
//		salvar.printf("\t\tastore " + endereco + "\n");
		break;
	}
    }
    
    private void ldc(int tipo, String valor){
	switch(tipo){
            case 1:
//		salvar.printf("\t\tldc " + valor + "\n");
		break;
            case 2:
//		salvar.printf("\t\tldc " + valor + "\n");
		break;
            case 3:
//		salvar.printf("\t\tldc " + valor + "\n");
		break;
            case 4:
//		salvar.printf("\t\tldc " + valor + "\n");
		break;
	}
    }
}