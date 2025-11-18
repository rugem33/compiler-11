import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

enum tmpList {
    t0("t0"),
    t1("t1"),
    t2("t2"),
    t3("t3"),
    t4("t4"),
    t5("t5"),
    t6("t6"),
    t7("t7"),
    t8("t8"),
    t9("t9")
    ;
    int tmpNum = -1;

    private final String label;

    tmpList(String label) {
        this.label = label;
    }

    public String getTmp() {
        tmpNum++;
        return tmpList.values()[tmpNum].label;
    }

    public void returnTmp(){
        tmpNum--;
    }
}

public class IRPrinter extends MiniCBaseListener {
    public StringBuilder irResult = new StringBuilder();
    ParseTreeProperty<String> r4tree = new ParseTreeProperty<>();

    @Override public void enterProgram(MiniCParser.ProgramContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitProgram(MiniCParser.ProgramContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDecl(MiniCParser.DeclContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDecl(MiniCParser.DeclContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVar_decl(MiniCParser.Var_declContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVar_decl(MiniCParser.Var_declContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterType_spec(MiniCParser.Type_specContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitType_spec(MiniCParser.Type_specContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFun_decl(MiniCParser.Fun_declContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFun_decl(MiniCParser.Fun_declContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParams(MiniCParser.ParamsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParams(MiniCParser.ParamsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParam(MiniCParser.ParamContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam(MiniCParser.ParamContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStmt(MiniCParser.StmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStmt(MiniCParser.StmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr_stmt(MiniCParser.Expr_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWhile_stmt(MiniCParser.While_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCompound_stmt(MiniCParser.Compound_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLocal_decl(MiniCParser.Local_declContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLocal_decl(MiniCParser.Local_declContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIf_stmt(MiniCParser.If_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIf_stmt(MiniCParser.If_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterReturn_stmt(MiniCParser.Return_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr(MiniCParser.ExprContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr(MiniCParser.ExprContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArgs(MiniCParser.ArgsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArgs(MiniCParser.ArgsContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) { }
}