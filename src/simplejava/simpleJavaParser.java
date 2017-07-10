// Generated from C:\Users\Jonatas Laet\Documents\NetBeansProjects\SimpleJava\src\simplejava\simpleJava.g4 by ANTLR 4.5.3

    package simplejava;
    import java.util.Map;
    import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class simpleJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, ID=40, NUM=41, STRING=42, WS=43, COMMENT=44, LINE_COMMENT=45;
	public static final int
		RULE_programa = 0, RULE_decVar = 1, RULE_decConst = 2, RULE_decFunc = 3, 
		RULE_blocoFunc = 4, RULE_stmtf = 5, RULE_funcao = 6, RULE_nativas = 7, 
		RULE_listaExpr = 8, RULE_bool = 9, RULE_join = 10, RULE_equal = 11, RULE_rel = 12, 
		RULE_expr = 13, RULE_termo = 14, RULE_xp = 15, RULE_uni = 16, RULE_fator = 17, 
		RULE_listaParametros = 18, RULE_parametro = 19, RULE_listaIDs = 20, RULE_tipo = 21, 
		RULE_valor = 22, RULE_blocoMain = 23, RULE_stmt = 24;
	public static final String[] ruleNames = {
		"programa", "decVar", "decConst", "decFunc", "blocoFunc", "stmtf", "funcao", 
		"nativas", "listaExpr", "bool", "join", "equal", "rel", "expr", "termo", 
		"xp", "uni", "fator", "listaParametros", "parametro", "listaIDs", "tipo", 
		"valor", "blocoMain", "stmt"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Prog'", "'{'", "'}'", "';'", "'Static'", "'='", "'('", "')'", 
		"'if'", "'else'", "'while'", "'break'", "'for'", "'to'", "'step'", "'return'", 
		"'print'", "'scan'", "','", "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", 
		"'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'^'", "'!'", "'TRUE'", "'FALSE'", 
		"'Int'", "'Real'", "'String'", "'Bool'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "ID", "NUM", "STRING", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "simpleJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	Map<String,Integer> tabSimb = new HashMap<String,Integer>();

	public simpleJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(simpleJavaParser.ID, 0); }
		public BlocoMainContext blocoMain() {
			return getRuleContext(BlocoMainContext.class,0);
		}
		public List<DecVarContext> decVar() {
			return getRuleContexts(DecVarContext.class);
		}
		public DecVarContext decVar(int i) {
			return getRuleContext(DecVarContext.class,i);
		}
		public List<DecConstContext> decConst() {
			return getRuleContexts(DecConstContext.class);
		}
		public DecConstContext decConst(int i) {
			return getRuleContext(DecConstContext.class,i);
		}
		public List<DecFuncContext> decFunc() {
			return getRuleContexts(DecFuncContext.class);
		}
		public DecFuncContext decFunc(int i) {
			return getRuleContext(DecFuncContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			match(ID);
			setState(52);
			match(T__1);
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(55);
					switch (_input.LA(1)) {
					case T__35:
					case T__36:
					case T__37:
					case T__38:
						{
						setState(53);
						decVar();
						}
						break;
					case T__4:
						{
						setState(54);
						decConst();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(60);
				decFunc();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			blocoMain();
			setState(67);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecVarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ListaIDsContext listaIDs() {
			return getRuleContext(ListaIDsContext.class,0);
		}
		public DecVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterDecVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitDecVar(this);
		}
	}

	public final DecVarContext decVar() throws RecognitionException {
		DecVarContext _localctx = new DecVarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			tipo();
			setState(70);
			listaIDs();
			setState(71);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecConstContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleJavaParser.ID, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public DecConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterDecConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitDecConst(this);
		}
	}

	public final DecConstContext decConst() throws RecognitionException {
		DecConstContext _localctx = new DecConstContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__4);
			setState(74);
			tipo();
			setState(75);
			match(ID);
			setState(76);
			match(T__5);
			setState(77);
			valor();
			setState(78);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecFuncContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleJavaParser.ID, 0); }
		public ListaParametrosContext listaParametros() {
			return getRuleContext(ListaParametrosContext.class,0);
		}
		public BlocoFuncContext blocoFunc() {
			return getRuleContext(BlocoFuncContext.class,0);
		}
		public List<DecVarContext> decVar() {
			return getRuleContexts(DecVarContext.class);
		}
		public DecVarContext decVar(int i) {
			return getRuleContext(DecVarContext.class,i);
		}
		public DecFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterDecFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitDecFunc(this);
		}
	}

	public final DecFuncContext decFunc() throws RecognitionException {
		DecFuncContext _localctx = new DecFuncContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			tipo();
			setState(81);
			match(ID);
			setState(82);
			match(T__6);
			setState(83);
			listaParametros();
			setState(84);
			match(T__7);
			setState(85);
			match(T__1);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(86);
				decVar();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			blocoFunc();
			setState(93);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoFuncContext extends ParserRuleContext {
		public List<StmtfContext> stmtf() {
			return getRuleContexts(StmtfContext.class);
		}
		public StmtfContext stmtf(int i) {
			return getRuleContext(StmtfContext.class,i);
		}
		public BlocoFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterBlocoFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitBlocoFunc(this);
		}
	}

	public final BlocoFuncContext blocoFunc() throws RecognitionException {
		BlocoFuncContext _localctx = new BlocoFuncContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_blocoFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
				{
				{
				setState(95);
				stmtf();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtfContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(simpleJavaParser.ID, 0); }
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public List<StmtfContext> stmtf() {
			return getRuleContexts(StmtfContext.class);
		}
		public StmtfContext stmtf(int i) {
			return getRuleContext(StmtfContext.class,i);
		}
		public NativasContext nativas() {
			return getRuleContext(NativasContext.class,0);
		}
		public FuncaoContext funcao() {
			return getRuleContext(FuncaoContext.class,0);
		}
		public StmtfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterStmtf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitStmtf(this);
		}
	}

	public final StmtfContext stmtf() throws RecognitionException {
		StmtfContext _localctx = new StmtfContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stmtf);
		int _la;
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(ID);
				setState(102);
				match(T__5);
				setState(103);
				bool(0);
				setState(104);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(T__8);
				setState(107);
				match(T__6);
				setState(108);
				bool(0);
				setState(109);
				match(T__7);
				setState(110);
				match(T__1);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(111);
					stmtf();
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(117);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(T__8);
				setState(120);
				match(T__6);
				setState(121);
				bool(0);
				setState(122);
				match(T__7);
				setState(123);
				match(T__1);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(124);
					stmtf();
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(130);
				match(T__2);
				setState(131);
				match(T__9);
				setState(132);
				match(T__1);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(133);
					stmtf();
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(139);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				match(T__10);
				setState(142);
				match(T__6);
				setState(143);
				bool(0);
				setState(144);
				match(T__7);
				setState(145);
				match(T__1);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(146);
					stmtf();
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				match(T__11);
				setState(155);
				match(T__3);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(156);
				match(T__12);
				setState(157);
				match(T__6);
				setState(158);
				match(ID);
				setState(159);
				match(T__5);
				setState(160);
				bool(0);
				setState(161);
				match(T__13);
				setState(162);
				bool(0);
				setState(165);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(163);
					match(T__14);
					setState(164);
					bool(0);
					}
				}

				setState(167);
				match(T__7);
				setState(168);
				match(T__1);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(169);
					stmtf();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				nativas();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(178);
				match(T__15);
				setState(179);
				match(T__6);
				setState(180);
				bool(0);
				setState(181);
				match(T__7);
				setState(182);
				match(T__3);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(184);
				funcao();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(simpleJavaParser.ID, 0); }
		public ListaExprContext listaExpr() {
			return getRuleContext(ListaExprContext.class,0);
		}
		public FuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitFuncao(this);
		}
	}

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(ID);
			setState(188);
			match(T__6);
			setState(189);
			listaExpr();
			setState(190);
			match(T__7);
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(191);
				match(T__3);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NativasContext extends ParserRuleContext {
		public ListaExprContext listaExpr() {
			return getRuleContext(ListaExprContext.class,0);
		}
		public ListaIDsContext listaIDs() {
			return getRuleContext(ListaIDsContext.class,0);
		}
		public NativasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterNativas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitNativas(this);
		}
	}

	public final NativasContext nativas() throws RecognitionException {
		NativasContext _localctx = new NativasContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_nativas);
		try {
			setState(206);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(T__16);
				setState(195);
				match(T__6);
				setState(196);
				listaExpr();
				setState(197);
				match(T__7);
				setState(198);
				match(T__3);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(T__17);
				setState(201);
				match(T__6);
				setState(202);
				listaIDs();
				setState(203);
				match(T__7);
				setState(204);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaExprContext extends ParserRuleContext {
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public ListaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterListaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitListaExpr(this);
		}
	}

	public final ListaExprContext listaExpr() throws RecognitionException {
		ListaExprContext _localctx = new ListaExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listaExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			bool(0);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(209);
				match(T__18);
				setState(210);
				bool(0);
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public JoinContext join() {
			return getRuleContext(JoinContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		return bool(0);
	}

	private BoolContext bool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolContext _localctx = new BoolContext(_ctx, _parentState);
		BoolContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_bool, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(217);
			join(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BoolContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bool);
					setState(219);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(220);
					match(T__19);
					setState(221);
					join(0);
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class JoinContext extends ParserRuleContext {
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public JoinContext join() {
			return getRuleContext(JoinContext.class,0);
		}
		public JoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitJoin(this);
		}
	}

	public final JoinContext join() throws RecognitionException {
		return join(0);
	}

	private JoinContext join(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		JoinContext _localctx = new JoinContext(_ctx, _parentState);
		JoinContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_join, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(228);
			equal(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new JoinContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_join);
					setState(230);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(231);
					match(T__20);
					setState(232);
					equal(0);
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualContext extends ParserRuleContext {
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitEqual(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		return equal(0);
	}

	private EqualContext equal(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualContext _localctx = new EqualContext(_ctx, _parentState);
		EqualContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_equal, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(239);
			rel();
			}
			_ctx.stop = _input.LT(-1);
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(247);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new EqualContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equal);
						setState(241);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(242);
						match(T__21);
						setState(243);
						rel();
						}
						break;
					case 2:
						{
						_localctx = new EqualContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equal);
						setState(244);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(245);
						match(T__22);
						setState(246);
						rel();
						}
						break;
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitRel(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rel);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				expr(0);
				setState(253);
				match(T__23);
				setState(254);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				expr(0);
				setState(257);
				match(T__24);
				setState(258);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				expr(0);
				setState(261);
				match(T__25);
				setState(262);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				expr(0);
				setState(265);
				match(T__26);
				setState(266);
				expr(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(268);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(272);
			termo(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(280);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(275);
						match(T__27);
						setState(276);
						termo(0);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(278);
						match(T__28);
						setState(279);
						termo(0);
						}
						break;
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public XpContext xp() {
			return getRuleContext(XpContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		return termo(0);
	}

	private TermoContext termo(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermoContext _localctx = new TermoContext(_ctx, _parentState);
		TermoContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_termo, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(286);
			xp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(294);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new TermoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_termo);
						setState(288);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(289);
						match(T__29);
						setState(290);
						xp(0);
						}
						break;
					case 2:
						{
						_localctx = new TermoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_termo);
						setState(291);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(292);
						match(T__30);
						setState(293);
						xp(0);
						}
						break;
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class XpContext extends ParserRuleContext {
		public UniContext uni() {
			return getRuleContext(UniContext.class,0);
		}
		public XpContext xp() {
			return getRuleContext(XpContext.class,0);
		}
		public XpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterXp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitXp(this);
		}
	}

	public final XpContext xp() throws RecognitionException {
		return xp(0);
	}

	private XpContext xp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XpContext _localctx = new XpContext(_ctx, _parentState);
		XpContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_xp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(300);
			uni();
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new XpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_xp);
					setState(302);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(303);
					match(T__31);
					setState(304);
					uni();
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UniContext extends ParserRuleContext {
		public UniContext uni() {
			return getRuleContext(UniContext.class,0);
		}
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public UniContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uni; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterUni(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitUni(this);
		}
	}

	public final UniContext uni() throws RecognitionException {
		UniContext _localctx = new UniContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_uni);
		try {
			setState(315);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(T__32);
				setState(311);
				uni();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				match(T__28);
				setState(313);
				uni();
				}
				break;
			case T__6:
			case T__33:
			case T__34:
			case ID:
			case NUM:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				fator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleJavaParser.ID, 0); }
		public TerminalNode NUM() { return getToken(simpleJavaParser.NUM, 0); }
		public TerminalNode STRING() { return getToken(simpleJavaParser.STRING, 0); }
		public FuncaoContext funcao() {
			return getRuleContext(FuncaoContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fator);
		try {
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				match(T__6);
				setState(318);
				bool(0);
				setState(319);
				match(T__7);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				match(NUM);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(323);
				match(T__33);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(324);
				match(T__34);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(325);
				match(STRING);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(326);
				funcao();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public ListaParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterListaParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitListaParametros(this);
		}
	}

	public final ListaParametrosContext listaParametros() throws RecognitionException {
		ListaParametrosContext _localctx = new ListaParametrosContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_listaParametros);
		int _la;
		try {
			setState(338);
			switch (_input.LA(1)) {
			case T__35:
			case T__36:
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				parametro();
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__18) {
					{
					{
					setState(330);
					match(T__18);
					setState(331);
					parametro();
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleJavaParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitParametro(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			tipo();
			setState(341);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaIDsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(simpleJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(simpleJavaParser.ID, i);
		}
		public ListaIDsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaIDs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterListaIDs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitListaIDs(this);
		}
	}

	public final ListaIDsContext listaIDs() throws RecognitionException {
		ListaIDsContext _localctx = new ListaIDsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_listaIDs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(ID);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(344);
				match(T__18);
				setState(345);
				match(ID);
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(simpleJavaParser.NUM, 0); }
		public TerminalNode STRING() { return getToken(simpleJavaParser.STRING, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitValor(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==STRING) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoMainContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlocoMainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoMain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterBlocoMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitBlocoMain(this);
		}
	}

	public final BlocoMainContext blocoMain() throws RecognitionException {
		BlocoMainContext _localctx = new BlocoMainContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_blocoMain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
				{
				{
				setState(355);
				stmt();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(simpleJavaParser.ID, 0); }
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public NativasContext nativas() {
			return getRuleContext(NativasContext.class,0);
		}
		public FuncaoContext funcao() {
			return getRuleContext(FuncaoContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleJavaListener ) ((simpleJavaListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_stmt);
		int _la;
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(ID);
				setState(362);
				match(T__5);
				setState(363);
				bool(0);
				setState(364);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				match(T__8);
				setState(367);
				match(T__6);
				setState(368);
				bool(0);
				setState(369);
				match(T__7);
				setState(370);
				match(T__1);
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(371);
					stmt();
					}
					}
					setState(376);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(377);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(379);
				match(T__8);
				setState(380);
				match(T__6);
				setState(381);
				bool(0);
				setState(382);
				match(T__7);
				setState(383);
				match(T__1);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(384);
					stmt();
					}
					}
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(390);
				match(T__2);
				setState(391);
				match(T__9);
				setState(392);
				match(T__1);
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(393);
					stmt();
					}
					}
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(399);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(401);
				match(T__10);
				setState(402);
				match(T__6);
				setState(403);
				bool(0);
				setState(404);
				match(T__7);
				setState(405);
				match(T__1);
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(406);
					stmt();
					}
					}
					setState(411);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(412);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(414);
				match(T__11);
				setState(415);
				match(T__3);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(416);
				match(T__12);
				setState(417);
				match(T__6);
				setState(418);
				match(ID);
				setState(419);
				match(T__5);
				setState(420);
				bool(0);
				setState(421);
				match(T__13);
				setState(422);
				bool(0);
				setState(425);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(423);
					match(T__14);
					setState(424);
					bool(0);
					}
				}

				setState(427);
				match(T__7);
				setState(428);
				match(T__1);
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
					{
					{
					setState(429);
					stmt();
					}
					}
					setState(434);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(435);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(437);
				nativas();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(438);
				funcao();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return bool_sempred((BoolContext)_localctx, predIndex);
		case 10:
			return join_sempred((JoinContext)_localctx, predIndex);
		case 11:
			return equal_sempred((EqualContext)_localctx, predIndex);
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 14:
			return termo_sempred((TermoContext)_localctx, predIndex);
		case 15:
			return xp_sempred((XpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean bool_sempred(BoolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean join_sempred(JoinContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equal_sempred(EqualContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termo_sempred(TermoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean xp_sempred(XpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u01bc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\7\2@\n\2\f"+
		"\2\16\2C\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5Z\n\5\f\5\16\5]\13\5\3\5\3\5\3\5\3\6\7"+
		"\6c\n\6\f\6\16\6f\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7"+
		"s\n\7\f\7\16\7v\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0080\n\7\f\7"+
		"\16\7\u0083\13\7\3\7\3\7\3\7\3\7\7\7\u0089\n\7\f\7\16\7\u008c\13\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0096\n\7\f\7\16\7\u0099\13\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a8\n\7\3\7\3\7\3\7"+
		"\7\7\u00ad\n\7\f\7\16\7\u00b0\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u00bc\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u00c3\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00d1\n\t\3\n\3\n\3\n\7\n\u00d6\n\n"+
		"\f\n\16\n\u00d9\13\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00e1\n\13\f\13"+
		"\16\13\u00e4\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ec\n\f\f\f\16\f\u00ef"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00fa\n\r\f\r\16\r\u00fd"+
		"\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u0110\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\7\17\u011b\n\17\f\17\16\17\u011e\13\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u0129\n\20\f\20\16\20\u012c\13\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u0134\n\21\f\21\16\21\u0137\13\21\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u013e\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u014a\n\23\3\24\3\24\3\24\7\24\u014f\n\24\f\24\16"+
		"\24\u0152\13\24\3\24\5\24\u0155\n\24\3\25\3\25\3\25\3\26\3\26\3\26\7\26"+
		"\u015d\n\26\f\26\16\26\u0160\13\26\3\27\3\27\3\30\3\30\3\31\7\31\u0167"+
		"\n\31\f\31\16\31\u016a\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\7\32\u0177\n\32\f\32\16\32\u017a\13\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\7\32\u0184\n\32\f\32\16\32\u0187\13\32\3\32\3"+
		"\32\3\32\3\32\7\32\u018d\n\32\f\32\16\32\u0190\13\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\7\32\u019a\n\32\f\32\16\32\u019d\13\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01ac"+
		"\n\32\3\32\3\32\3\32\7\32\u01b1\n\32\f\32\16\32\u01b4\13\32\3\32\3\32"+
		"\3\32\3\32\5\32\u01ba\n\32\3\32\2\b\24\26\30\34\36 \33\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\4\3\2&)\3\2+,\u01de\2\64\3\2"+
		"\2\2\4G\3\2\2\2\6K\3\2\2\2\bR\3\2\2\2\nd\3\2\2\2\f\u00bb\3\2\2\2\16\u00bd"+
		"\3\2\2\2\20\u00d0\3\2\2\2\22\u00d2\3\2\2\2\24\u00da\3\2\2\2\26\u00e5\3"+
		"\2\2\2\30\u00f0\3\2\2\2\32\u010f\3\2\2\2\34\u0111\3\2\2\2\36\u011f\3\2"+
		"\2\2 \u012d\3\2\2\2\"\u013d\3\2\2\2$\u0149\3\2\2\2&\u0154\3\2\2\2(\u0156"+
		"\3\2\2\2*\u0159\3\2\2\2,\u0161\3\2\2\2.\u0163\3\2\2\2\60\u0168\3\2\2\2"+
		"\62\u01b9\3\2\2\2\64\65\7\3\2\2\65\66\7*\2\2\66;\7\4\2\2\67:\5\4\3\28"+
		":\5\6\4\29\67\3\2\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<A\3\2\2"+
		"\2=;\3\2\2\2>@\5\b\5\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2"+
		"\2CA\3\2\2\2DE\5\60\31\2EF\7\5\2\2F\3\3\2\2\2GH\5,\27\2HI\5*\26\2IJ\7"+
		"\6\2\2J\5\3\2\2\2KL\7\7\2\2LM\5,\27\2MN\7*\2\2NO\7\b\2\2OP\5.\30\2PQ\7"+
		"\6\2\2Q\7\3\2\2\2RS\5,\27\2ST\7*\2\2TU\7\t\2\2UV\5&\24\2VW\7\n\2\2W[\7"+
		"\4\2\2XZ\5\4\3\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2]"+
		"[\3\2\2\2^_\5\n\6\2_`\7\5\2\2`\t\3\2\2\2ac\5\f\7\2ba\3\2\2\2cf\3\2\2\2"+
		"db\3\2\2\2de\3\2\2\2e\13\3\2\2\2fd\3\2\2\2gh\7*\2\2hi\7\b\2\2ij\5\24\13"+
		"\2jk\7\6\2\2k\u00bc\3\2\2\2lm\7\13\2\2mn\7\t\2\2no\5\24\13\2op\7\n\2\2"+
		"pt\7\4\2\2qs\5\f\7\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2"+
		"vt\3\2\2\2wx\7\5\2\2x\u00bc\3\2\2\2yz\7\13\2\2z{\7\t\2\2{|\5\24\13\2|"+
		"}\7\n\2\2}\u0081\7\4\2\2~\u0080\5\f\7\2\177~\3\2\2\2\u0080\u0083\3\2\2"+
		"\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0085\7\5\2\2\u0085\u0086\7\f\2\2\u0086\u008a\7\4\2\2\u0087"+
		"\u0089\5\f\7\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008e\7\5\2\2\u008e\u00bc\3\2\2\2\u008f\u0090\7\r\2\2\u0090\u0091\7\t"+
		"\2\2\u0091\u0092\5\24\13\2\u0092\u0093\7\n\2\2\u0093\u0097\7\4\2\2\u0094"+
		"\u0096\5\f\7\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009b\7\5\2\2\u009b\u00bc\3\2\2\2\u009c\u009d\7\16\2\2\u009d\u00bc\7"+
		"\6\2\2\u009e\u009f\7\17\2\2\u009f\u00a0\7\t\2\2\u00a0\u00a1\7*\2\2\u00a1"+
		"\u00a2\7\b\2\2\u00a2\u00a3\5\24\13\2\u00a3\u00a4\7\20\2\2\u00a4\u00a7"+
		"\5\24\13\2\u00a5\u00a6\7\21\2\2\u00a6\u00a8\5\24\13\2\u00a7\u00a5\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\7\n\2\2\u00aa"+
		"\u00ae\7\4\2\2\u00ab\u00ad\5\f\7\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b2\7\5\2\2\u00b2\u00bc\3\2\2\2\u00b3\u00bc\5\20"+
		"\t\2\u00b4\u00b5\7\22\2\2\u00b5\u00b6\7\t\2\2\u00b6\u00b7\5\24\13\2\u00b7"+
		"\u00b8\7\n\2\2\u00b8\u00b9\7\6\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00bc\5\16"+
		"\b\2\u00bbg\3\2\2\2\u00bbl\3\2\2\2\u00bby\3\2\2\2\u00bb\u008f\3\2\2\2"+
		"\u00bb\u009c\3\2\2\2\u00bb\u009e\3\2\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00b4"+
		"\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\r\3\2\2\2\u00bd\u00be\7*\2\2\u00be"+
		"\u00bf\7\t\2\2\u00bf\u00c0\5\22\n\2\u00c0\u00c2\7\n\2\2\u00c1\u00c3\7"+
		"\6\2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\17\3\2\2\2\u00c4"+
		"\u00c5\7\23\2\2\u00c5\u00c6\7\t\2\2\u00c6\u00c7\5\22\n\2\u00c7\u00c8\7"+
		"\n\2\2\u00c8\u00c9\7\6\2\2\u00c9\u00d1\3\2\2\2\u00ca\u00cb\7\24\2\2\u00cb"+
		"\u00cc\7\t\2\2\u00cc\u00cd\5*\26\2\u00cd\u00ce\7\n\2\2\u00ce\u00cf\7\6"+
		"\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00c4\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d1"+
		"\21\3\2\2\2\u00d2\u00d7\5\24\13\2\u00d3\u00d4\7\25\2\2\u00d4\u00d6\5\24"+
		"\13\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\23\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\b\13\1"+
		"\2\u00db\u00dc\5\26\f\2\u00dc\u00e2\3\2\2\2\u00dd\u00de\f\4\2\2\u00de"+
		"\u00df\7\26\2\2\u00df\u00e1\5\26\f\2\u00e0\u00dd\3\2\2\2\u00e1\u00e4\3"+
		"\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\25\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e5\u00e6\b\f\1\2\u00e6\u00e7\5\30\r\2\u00e7\u00ed\3"+
		"\2\2\2\u00e8\u00e9\f\4\2\2\u00e9\u00ea\7\27\2\2\u00ea\u00ec\5\30\r\2\u00eb"+
		"\u00e8\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\27\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\b\r\1\2\u00f1\u00f2"+
		"\5\32\16\2\u00f2\u00fb\3\2\2\2\u00f3\u00f4\f\5\2\2\u00f4\u00f5\7\30\2"+
		"\2\u00f5\u00fa\5\32\16\2\u00f6\u00f7\f\4\2\2\u00f7\u00f8\7\31\2\2\u00f8"+
		"\u00fa\5\32\16\2\u00f9\u00f3\3\2\2\2\u00f9\u00f6\3\2\2\2\u00fa\u00fd\3"+
		"\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\31\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fe\u00ff\5\34\17\2\u00ff\u0100\7\32\2\2\u0100\u0101"+
		"\5\34\17\2\u0101\u0110\3\2\2\2\u0102\u0103\5\34\17\2\u0103\u0104\7\33"+
		"\2\2\u0104\u0105\5\34\17\2\u0105\u0110\3\2\2\2\u0106\u0107\5\34\17\2\u0107"+
		"\u0108\7\34\2\2\u0108\u0109\5\34\17\2\u0109\u0110\3\2\2\2\u010a\u010b"+
		"\5\34\17\2\u010b\u010c\7\35\2\2\u010c\u010d\5\34\17\2\u010d\u0110\3\2"+
		"\2\2\u010e\u0110\5\34\17\2\u010f\u00fe\3\2\2\2\u010f\u0102\3\2\2\2\u010f"+
		"\u0106\3\2\2\2\u010f\u010a\3\2\2\2\u010f\u010e\3\2\2\2\u0110\33\3\2\2"+
		"\2\u0111\u0112\b\17\1\2\u0112\u0113\5\36\20\2\u0113\u011c\3\2\2\2\u0114"+
		"\u0115\f\5\2\2\u0115\u0116\7\36\2\2\u0116\u011b\5\36\20\2\u0117\u0118"+
		"\f\4\2\2\u0118\u0119\7\37\2\2\u0119\u011b\5\36\20\2\u011a\u0114\3\2\2"+
		"\2\u011a\u0117\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011d\35\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\b\20\1\2\u0120"+
		"\u0121\5 \21\2\u0121\u012a\3\2\2\2\u0122\u0123\f\5\2\2\u0123\u0124\7 "+
		"\2\2\u0124\u0129\5 \21\2\u0125\u0126\f\4\2\2\u0126\u0127\7!\2\2\u0127"+
		"\u0129\5 \21\2\u0128\u0122\3\2\2\2\u0128\u0125\3\2\2\2\u0129\u012c\3\2"+
		"\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\37\3\2\2\2\u012c\u012a"+
		"\3\2\2\2\u012d\u012e\b\21\1\2\u012e\u012f\5\"\22\2\u012f\u0135\3\2\2\2"+
		"\u0130\u0131\f\4\2\2\u0131\u0132\7\"\2\2\u0132\u0134\5\"\22\2\u0133\u0130"+
		"\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"!\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7#\2\2\u0139\u013e\5\"\22\2"+
		"\u013a\u013b\7\37\2\2\u013b\u013e\5\"\22\2\u013c\u013e\5$\23\2\u013d\u0138"+
		"\3\2\2\2\u013d\u013a\3\2\2\2\u013d\u013c\3\2\2\2\u013e#\3\2\2\2\u013f"+
		"\u0140\7\t\2\2\u0140\u0141\5\24\13\2\u0141\u0142\7\n\2\2\u0142\u014a\3"+
		"\2\2\2\u0143\u014a\7*\2\2\u0144\u014a\7+\2\2\u0145\u014a\7$\2\2\u0146"+
		"\u014a\7%\2\2\u0147\u014a\7,\2\2\u0148\u014a\5\16\b\2\u0149\u013f\3\2"+
		"\2\2\u0149\u0143\3\2\2\2\u0149\u0144\3\2\2\2\u0149\u0145\3\2\2\2\u0149"+
		"\u0146\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u0148\3\2\2\2\u014a%\3\2\2\2"+
		"\u014b\u0150\5(\25\2\u014c\u014d\7\25\2\2\u014d\u014f\5(\25\2\u014e\u014c"+
		"\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0155\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u014b\3\2"+
		"\2\2\u0154\u0153\3\2\2\2\u0155\'\3\2\2\2\u0156\u0157\5,\27\2\u0157\u0158"+
		"\7*\2\2\u0158)\3\2\2\2\u0159\u015e\7*\2\2\u015a\u015b\7\25\2\2\u015b\u015d"+
		"\7*\2\2\u015c\u015a\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f+\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\t\2\2\2"+
		"\u0162-\3\2\2\2\u0163\u0164\t\3\2\2\u0164/\3\2\2\2\u0165\u0167\5\62\32"+
		"\2\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\61\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016c\7*\2\2\u016c"+
		"\u016d\7\b\2\2\u016d\u016e\5\24\13\2\u016e\u016f\7\6\2\2\u016f\u01ba\3"+
		"\2\2\2\u0170\u0171\7\13\2\2\u0171\u0172\7\t\2\2\u0172\u0173\5\24\13\2"+
		"\u0173\u0174\7\n\2\2\u0174\u0178\7\4\2\2\u0175\u0177\5\62\32\2\u0176\u0175"+
		"\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017c\7\5\2\2\u017c\u01ba\3\2"+
		"\2\2\u017d\u017e\7\13\2\2\u017e\u017f\7\t\2\2\u017f\u0180\5\24\13\2\u0180"+
		"\u0181\7\n\2\2\u0181\u0185\7\4\2\2\u0182\u0184\5\62\32\2\u0183\u0182\3"+
		"\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186"+
		"\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7\5\2\2\u0189\u018a\7\f"+
		"\2\2\u018a\u018e\7\4\2\2\u018b\u018d\5\62\32\2\u018c\u018b\3\2\2\2\u018d"+
		"\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2"+
		"\2\2\u0190\u018e\3\2\2\2\u0191\u0192\7\5\2\2\u0192\u01ba\3\2\2\2\u0193"+
		"\u0194\7\r\2\2\u0194\u0195\7\t\2\2\u0195\u0196\5\24\13\2\u0196\u0197\7"+
		"\n\2\2\u0197\u019b\7\4\2\2\u0198\u019a\5\62\32\2\u0199\u0198\3\2\2\2\u019a"+
		"\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\3\2"+
		"\2\2\u019d\u019b\3\2\2\2\u019e\u019f\7\5\2\2\u019f\u01ba\3\2\2\2\u01a0"+
		"\u01a1\7\16\2\2\u01a1\u01ba\7\6\2\2\u01a2\u01a3\7\17\2\2\u01a3\u01a4\7"+
		"\t\2\2\u01a4\u01a5\7*\2\2\u01a5\u01a6\7\b\2\2\u01a6\u01a7\5\24\13\2\u01a7"+
		"\u01a8\7\20\2\2\u01a8\u01ab\5\24\13\2\u01a9\u01aa\7\21\2\2\u01aa\u01ac"+
		"\5\24\13\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ad\3\2\2\2"+
		"\u01ad\u01ae\7\n\2\2\u01ae\u01b2\7\4\2\2\u01af\u01b1\5\62\32\2\u01b0\u01af"+
		"\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b6\7\5\2\2\u01b6\u01ba\3\2"+
		"\2\2\u01b7\u01ba\5\20\t\2\u01b8\u01ba\5\16\b\2\u01b9\u016b\3\2\2\2\u01b9"+
		"\u0170\3\2\2\2\u01b9\u017d\3\2\2\2\u01b9\u0193\3\2\2\2\u01b9\u01a0\3\2"+
		"\2\2\u01b9\u01a2\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01ba"+
		"\63\3\2\2\2(9;A[dt\u0081\u008a\u0097\u00a7\u00ae\u00bb\u00c2\u00d0\u00d7"+
		"\u00e2\u00ed\u00f9\u00fb\u010f\u011a\u011c\u0128\u012a\u0135\u013d\u0149"+
		"\u0150\u0154\u015e\u0168\u0178\u0185\u018e\u019b\u01ab\u01b2\u01b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}