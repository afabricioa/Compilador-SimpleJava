// Generated from C:\Users\Jonatas Laet\Documents\NetBeansProjects\SimpleJava\src\simplejava\simpleJava.g4 by ANTLR 4.5.3

    package simplejava;
    import java.util.Map;
    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleJavaParser}.
 */
public interface simpleJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(simpleJavaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(simpleJavaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#decVar}.
	 * @param ctx the parse tree
	 */
	void enterDecVar(simpleJavaParser.DecVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#decVar}.
	 * @param ctx the parse tree
	 */
	void exitDecVar(simpleJavaParser.DecVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#decConst}.
	 * @param ctx the parse tree
	 */
	void enterDecConst(simpleJavaParser.DecConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#decConst}.
	 * @param ctx the parse tree
	 */
	void exitDecConst(simpleJavaParser.DecConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#decFunc}.
	 * @param ctx the parse tree
	 */
	void enterDecFunc(simpleJavaParser.DecFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#decFunc}.
	 * @param ctx the parse tree
	 */
	void exitDecFunc(simpleJavaParser.DecFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#blocoFunc}.
	 * @param ctx the parse tree
	 */
	void enterBlocoFunc(simpleJavaParser.BlocoFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#blocoFunc}.
	 * @param ctx the parse tree
	 */
	void exitBlocoFunc(simpleJavaParser.BlocoFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#stmtf}.
	 * @param ctx the parse tree
	 */
	void enterStmtf(simpleJavaParser.StmtfContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#stmtf}.
	 * @param ctx the parse tree
	 */
	void exitStmtf(simpleJavaParser.StmtfContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterFuncao(simpleJavaParser.FuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitFuncao(simpleJavaParser.FuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#nativas}.
	 * @param ctx the parse tree
	 */
	void enterNativas(simpleJavaParser.NativasContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#nativas}.
	 * @param ctx the parse tree
	 */
	void exitNativas(simpleJavaParser.NativasContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#listaExpr}.
	 * @param ctx the parse tree
	 */
	void enterListaExpr(simpleJavaParser.ListaExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#listaExpr}.
	 * @param ctx the parse tree
	 */
	void exitListaExpr(simpleJavaParser.ListaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(simpleJavaParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(simpleJavaParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#join}.
	 * @param ctx the parse tree
	 */
	void enterJoin(simpleJavaParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#join}.
	 * @param ctx the parse tree
	 */
	void exitJoin(simpleJavaParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqual(simpleJavaParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqual(simpleJavaParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(simpleJavaParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(simpleJavaParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(simpleJavaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(simpleJavaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(simpleJavaParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(simpleJavaParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#xp}.
	 * @param ctx the parse tree
	 */
	void enterXp(simpleJavaParser.XpContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#xp}.
	 * @param ctx the parse tree
	 */
	void exitXp(simpleJavaParser.XpContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#uni}.
	 * @param ctx the parse tree
	 */
	void enterUni(simpleJavaParser.UniContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#uni}.
	 * @param ctx the parse tree
	 */
	void exitUni(simpleJavaParser.UniContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(simpleJavaParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(simpleJavaParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#listaParametros}.
	 * @param ctx the parse tree
	 */
	void enterListaParametros(simpleJavaParser.ListaParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#listaParametros}.
	 * @param ctx the parse tree
	 */
	void exitListaParametros(simpleJavaParser.ListaParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(simpleJavaParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(simpleJavaParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#listaIDs}.
	 * @param ctx the parse tree
	 */
	void enterListaIDs(simpleJavaParser.ListaIDsContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#listaIDs}.
	 * @param ctx the parse tree
	 */
	void exitListaIDs(simpleJavaParser.ListaIDsContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(simpleJavaParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(simpleJavaParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(simpleJavaParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(simpleJavaParser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#blocoMain}.
	 * @param ctx the parse tree
	 */
	void enterBlocoMain(simpleJavaParser.BlocoMainContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#blocoMain}.
	 * @param ctx the parse tree
	 */
	void exitBlocoMain(simpleJavaParser.BlocoMainContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(simpleJavaParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleJavaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(simpleJavaParser.StmtContext ctx);
}