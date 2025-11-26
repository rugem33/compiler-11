package generated;// Generated from C:/Users/rugem/IdeaProjects/compiler-11/out/production/compiler-11/IR.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IRParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, BINARY_OP=6, UNARY_OP=7, BRANCH_OP=8, 
		CBRANCH_OP=9, CALL_OP=10, RETURN_OP=11, VOID=12, INT=13, FUNCTION_START=14, 
		FUNCTION_END=15, IDENT=16, LITERAL=17, DecimalConstant=18, OctalConstant=19, 
		HexadecimalConstant=20, WS=21, NEWLINE=22;
	public static final int
		RULE_program = 0, RULE_function = 1, RULE_instructions = 2, RULE_instruction = 3, 
		RULE_label = 4, RULE_assign_instruction = 5, RULE_branch_instruction = 6, 
		RULE_call_instruction = 7, RULE_return_instruction = 8, RULE_type_spec = 9, 
		RULE_operand = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "function", "instructions", "instruction", "label", "assign_instruction", 
			"branch_instruction", "call_instruction", "return_instruction", "type_spec", 
			"operand"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':'", "'='", "','", null, null, "'jump'", "'cjump'", 
			"'call'", "'return'", "'V'", "'I'", "'function'", "'end function'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "BINARY_OP", "UNARY_OP", "BRANCH_OP", 
			"CBRANCH_OP", "CALL_OP", "RETURN_OP", "VOID", "INT", "FUNCTION_START", 
			"FUNCTION_END", "IDENT", "LITERAL", "DecimalConstant", "OctalConstant", 
			"HexadecimalConstant", "WS", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "IR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IRParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				function();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNCTION_START );
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNCTION_START() { return getToken(IRParser.FUNCTION_START, 0); }
		public TerminalNode IDENT() { return getToken(IRParser.IDENT, 0); }
		public List<Type_specContext> type_spec() {
			return getRuleContexts(Type_specContext.class);
		}
		public Type_specContext type_spec(int i) {
			return getRuleContext(Type_specContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(IRParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(IRParser.NEWLINE, i);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public TerminalNode FUNCTION_END() { return getToken(IRParser.FUNCTION_END, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(FUNCTION_START);
			setState(28);
			match(IDENT);
			setState(29);
			match(T__0);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOID || _la==INT) {
				{
				{
				setState(30);
				type_spec();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(T__1);
			setState(37);
			type_spec();
			setState(38);
			match(NEWLINE);
			setState(39);
			instructions();
			setState(40);
			match(FUNCTION_END);
			setState(41);
			match(NEWLINE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionsContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(IRParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(IRParser.NEWLINE, i);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitInstructions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitInstructions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instructions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68352L) != 0)) {
				{
				{
				setState(43);
				instruction();
				setState(44);
				match(NEWLINE);
				}
				}
				setState(50);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public Assign_instructionContext assign_instruction() {
			return getRuleContext(Assign_instructionContext.class,0);
		}
		public Branch_instructionContext branch_instruction() {
			return getRuleContext(Branch_instructionContext.class,0);
		}
		public Call_instructionContext call_instruction() {
			return getRuleContext(Call_instructionContext.class,0);
		}
		public Return_instructionContext return_instruction() {
			return getRuleContext(Return_instructionContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				assign_instruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				branch_instruction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				call_instruction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				return_instruction();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				label();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(IRParser.IDENT, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IDENT);
			setState(59);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_instructionContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(IRParser.IDENT, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode BINARY_OP() { return getToken(IRParser.BINARY_OP, 0); }
		public TerminalNode UNARY_OP() { return getToken(IRParser.UNARY_OP, 0); }
		public Assign_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterAssign_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitAssign_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitAssign_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_instructionContext assign_instruction() throws RecognitionException {
		Assign_instructionContext _localctx = new Assign_instructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_instruction);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(IDENT);
				setState(62);
				match(T__3);
				setState(63);
				operand();
				setState(64);
				match(BINARY_OP);
				setState(65);
				operand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(IDENT);
				setState(68);
				match(T__3);
				setState(69);
				match(UNARY_OP);
				setState(70);
				operand();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(IDENT);
				setState(72);
				match(T__3);
				setState(73);
				operand();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Branch_instructionContext extends ParserRuleContext {
		public TerminalNode BRANCH_OP() { return getToken(IRParser.BRANCH_OP, 0); }
		public TerminalNode IDENT() { return getToken(IRParser.IDENT, 0); }
		public TerminalNode CBRANCH_OP() { return getToken(IRParser.CBRANCH_OP, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public Branch_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterBranch_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitBranch_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitBranch_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Branch_instructionContext branch_instruction() throws RecognitionException {
		Branch_instructionContext _localctx = new Branch_instructionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_branch_instruction);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRANCH_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(BRANCH_OP);
				setState(77);
				match(IDENT);
				}
				break;
			case CBRANCH_OP:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(CBRANCH_OP);
				setState(79);
				operand();
				setState(80);
				match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Call_instructionContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(IRParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(IRParser.IDENT, i);
		}
		public TerminalNode CALL_OP() { return getToken(IRParser.CALL_OP, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public Call_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterCall_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitCall_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitCall_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_instructionContext call_instruction() throws RecognitionException {
		Call_instructionContext _localctx = new Call_instructionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_call_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(IDENT);
			setState(85);
			match(T__3);
			setState(86);
			match(CALL_OP);
			setState(87);
			match(IDENT);
			setState(88);
			match(T__0);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==LITERAL) {
				{
				setState(89);
				operand();
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(90);
					match(T__4);
					setState(91);
					operand();
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(99);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Return_instructionContext extends ParserRuleContext {
		public TerminalNode RETURN_OP() { return getToken(IRParser.RETURN_OP, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public Return_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterReturn_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitReturn_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitReturn_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_instructionContext return_instruction() throws RecognitionException {
		Return_instructionContext _localctx = new Return_instructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_return_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(RETURN_OP);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==LITERAL) {
				{
				setState(102);
				operand();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(IRParser.VOID, 0); }
		public TerminalNode INT() { return getToken(IRParser.INT, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitType_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitType_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperandContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(IRParser.IDENT, 0); }
		public TerminalNode LITERAL() { return getToken(IRParser.LITERAL, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRListener ) ((IRListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IRVisitor) return ((IRVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==IDENT || _la==LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0016n\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0004\u0000\u0018"+
		"\b\u0000\u000b\u0000\f\u0000\u0019\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002/\b\u0002\n\u0002\f\u0002"+
		"2\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00039\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005K\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006S\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007]\b\u0007\n\u0007\f\u0007`\t\u0007\u0003\u0007b\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0003\bh\b\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0000\u0002\u0001\u0000\f\r\u0001\u0000\u0010\u0011"+
		"o\u0000\u0017\u0001\u0000\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000"+
		"\u00040\u0001\u0000\u0000\u0000\u00068\u0001\u0000\u0000\u0000\b:\u0001"+
		"\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000"+
		"\u000eT\u0001\u0000\u0000\u0000\u0010e\u0001\u0000\u0000\u0000\u0012i"+
		"\u0001\u0000\u0000\u0000\u0014k\u0001\u0000\u0000\u0000\u0016\u0018\u0003"+
		"\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001"+
		"\u0000\u0000\u0000\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		"\u000e\u0000\u0000\u001c\u001d\u0005\u0010\u0000\u0000\u001d!\u0005\u0001"+
		"\u0000\u0000\u001e \u0003\u0012\t\u0000\u001f\u001e\u0001\u0000\u0000"+
		"\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001"+
		"\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000"+
		"$%\u0005\u0002\u0000\u0000%&\u0003\u0012\t\u0000&\'\u0005\u0016\u0000"+
		"\u0000\'(\u0003\u0004\u0002\u0000()\u0005\u000f\u0000\u0000)*\u0005\u0016"+
		"\u0000\u0000*\u0003\u0001\u0000\u0000\u0000+,\u0003\u0006\u0003\u0000"+
		",-\u0005\u0016\u0000\u0000-/\u0001\u0000\u0000\u0000.+\u0001\u0000\u0000"+
		"\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u00001\u0005\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"39\u0003\n\u0005\u000049\u0003\f\u0006\u000059\u0003\u000e\u0007\u0000"+
		"69\u0003\u0010\b\u000079\u0003\b\u0004\u000083\u0001\u0000\u0000\u0000"+
		"84\u0001\u0000\u0000\u000085\u0001\u0000\u0000\u000086\u0001\u0000\u0000"+
		"\u000087\u0001\u0000\u0000\u00009\u0007\u0001\u0000\u0000\u0000:;\u0005"+
		"\u0010\u0000\u0000;<\u0005\u0003\u0000\u0000<\t\u0001\u0000\u0000\u0000"+
		"=>\u0005\u0010\u0000\u0000>?\u0005\u0004\u0000\u0000?@\u0003\u0014\n\u0000"+
		"@A\u0005\u0006\u0000\u0000AB\u0003\u0014\n\u0000BK\u0001\u0000\u0000\u0000"+
		"CD\u0005\u0010\u0000\u0000DE\u0005\u0004\u0000\u0000EF\u0005\u0007\u0000"+
		"\u0000FK\u0003\u0014\n\u0000GH\u0005\u0010\u0000\u0000HI\u0005\u0004\u0000"+
		"\u0000IK\u0003\u0014\n\u0000J=\u0001\u0000\u0000\u0000JC\u0001\u0000\u0000"+
		"\u0000JG\u0001\u0000\u0000\u0000K\u000b\u0001\u0000\u0000\u0000LM\u0005"+
		"\b\u0000\u0000MS\u0005\u0010\u0000\u0000NO\u0005\t\u0000\u0000OP\u0003"+
		"\u0014\n\u0000PQ\u0005\u0010\u0000\u0000QS\u0001\u0000\u0000\u0000RL\u0001"+
		"\u0000\u0000\u0000RN\u0001\u0000\u0000\u0000S\r\u0001\u0000\u0000\u0000"+
		"TU\u0005\u0010\u0000\u0000UV\u0005\u0004\u0000\u0000VW\u0005\n\u0000\u0000"+
		"WX\u0005\u0010\u0000\u0000Xa\u0005\u0001\u0000\u0000Y^\u0003\u0014\n\u0000"+
		"Z[\u0005\u0005\u0000\u0000[]\u0003\u0014\n\u0000\\Z\u0001\u0000\u0000"+
		"\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000aY\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"cd\u0005\u0002\u0000\u0000d\u000f\u0001\u0000\u0000\u0000eg\u0005\u000b"+
		"\u0000\u0000fh\u0003\u0014\n\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000h\u0011\u0001\u0000\u0000\u0000ij\u0007\u0000\u0000\u0000"+
		"j\u0013\u0001\u0000\u0000\u0000kl\u0007\u0001\u0000\u0000l\u0015\u0001"+
		"\u0000\u0000\u0000\t\u0019!08JR^ag";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}