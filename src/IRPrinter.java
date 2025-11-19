import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

class TmpList {
    enum Tmp {
        t0("t0"),
        t1("t1"),
        t2("t2"),
        t3("t3"),
        t4("t4"),
        t5("t5"),
        t6("t6"),
        t7("t7"),
        t8("t8"),
        t9("t9"),
        t10("t10"),
        t11("t11"),
        t12("t12"),
        t13("t13"),
        t14("t14"),
        t15("t15");

        private final String label;

        Tmp(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private static int tmpNum = -1;

    // 다음 tmp 이름 하나 꺼내기
    public static String getTmp() {
        if (tmpNum + 1 >= Tmp.values().length) {
            throw new IllegalStateException("더 이상 사용할 수 있는 tmp가 없습니다.");
            // 혹은: tmpNum = -1; 처럼 다시 처음으로 돌려도 되고
        }
        tmpNum++;
        return Tmp.values()[tmpNum].getLabel();
    }

    // 하나 되돌리기
    public static void returnTmp() {
        tmpNum--;
        // 아니면 음수로 내려가면 예외 던지게 해도 됨
    }

    public static String getCurrentTmp() {
        return Tmp.values()[tmpNum].getLabel();
    }

    public static String getTmpIndex(int i) {
        return Tmp.values()[i].getLabel();
    }

    public static int getCurrentIndex() {
        return tmpNum;
    }
}

public class IRPrinter extends MiniCBaseListener {
    public StringBuilder irResult = new StringBuilder();
    ParseTreeProperty<String> r4tree = new ParseTreeProperty<>();

    private String toBinaryOp(String opText) {
        switch (opText) {
            case "*":  return "mul";
            case "/":  return "div";
            case "%":  return "mod";
            case "+":  return "add";
            case "-":  return "sub";
            case "==": return "eq";
            case "!=": return "neq";
            case "<=": return "leq";
            case "<":  return "lt";
            case ">=": return "geq";
            case ">":  return "gt";
            case "and": return "and";
            case "or":  return "or";
            default:
                throw new IllegalArgumentException("unknown binary op: " + opText);
        }
    }

    private String toUnaryOp(String opText) {
        switch (opText) {
            case "-": return "neg";
            case "+": return "pos";
            case "--": return "dec";
            case "++": return "inc";
            case "!": return "not";
            default:
                throw new IllegalArgumentException("unknown binary op: " + opText);
        }
    }

    @Override public void enterProgram(MiniCParser.ProgramContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitProgram(MiniCParser.ProgramContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (MiniCParser.DeclContext d : ctx.decl()) {
            sb.append(r4tree.get(d)).append("\n");
        }
        irResult.append(sb.toString());
    }
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
    @Override public void exitDecl(MiniCParser.DeclContext ctx) {
        if (ctx.var_decl() != null) {
            r4tree.put(ctx, r4tree.get(ctx.var_decl()));
        } else if (ctx.fun_decl() != null) {
            r4tree.put(ctx, r4tree.get(ctx.fun_decl()));
        }
    }
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
    @Override public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
        if (ctx.getChildCount() == 3) { return;}
        String ident = ctx.IDENT().getText();
        String opcode = "=";
        String lit = ctx.LITERAL().getText();

        String result = ident + " " + opcode + " " + lit;

        irResult.append(result).append("\n");
        r4tree.put(ctx, ident);
        return;
    }
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

    @Override public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        if (ctx.getChildCount() == 2) {
            irResult.append("return").append("\n");
        }else {
            String returnVal = "return " + r4tree.get(ctx.expr());
            irResult.append(returnVal).append("\n");
        }
    }

    @Override public void exitExpr(MiniCParser.ExprContext ctx) {
        String resultCode;
        // (a) IDENT
        if (ctx.IDENT() != null && ctx.getChildCount() == 1 ) {
            r4tree.put(ctx, ctx.IDENT().getText());
            return;
        }

        // (b) LITERAL
        if (ctx.LITERAL() != null && ctx.getChildCount() == 1) {
            r4tree.put(ctx, ctx.LITERAL().getText());
            return;
        }

        // (c) a + b 같은 expr '+' expr
        if (ctx.getChildCount() == 3 && ctx.expr().size() == 2) {

            String opnd1 = r4tree.get(ctx.expr(0));  // "a"
            String opnd2 = r4tree.get(ctx.expr(1));  // "b"
            String opcode = toBinaryOp(ctx.getChild(1).getText());
            String tmp = TmpList.getTmp();    // "t1" 같은 임시 변수 이름

            // 3주소 코드 한 줄 생성
            resultCode = tmp + " = " + opnd1 + " " + opcode + " "  + opnd2;

            // 출력용 버퍼에 추가
            irResult.append(resultCode).append("\n");

            // 이 expr의 값은 tmp 라고 저장 (위쪽에서 또 쓸 수 있게)
            r4tree.put(ctx, tmp);
            return;
        }

        if (ctx.getChildCount() == 2 && ctx.expr().size() == 1 && ctx.getChild(1).getChildCount() == 1) {
            String opnd1 = r4tree.get(ctx.expr(0));
            String opcode = toUnaryOp(ctx.getChild(0).getText());

            resultCode = opcode + " " + opnd1;

            irResult.append(resultCode).append("\n");
            r4tree.put(ctx, opnd1);
            return;

        } else if (ctx.getChildCount() == 2 && ctx.expr().size() == 1 && ctx.getChild(1).getChildCount() != 1) {
            String open1 = TmpList.getCurrentTmp();
            String opcode = toUnaryOp(ctx.getChild(0).getText());

            resultCode = opcode + " " + open1;
            irResult.append(resultCode).append("\n");
            r4tree.put(ctx, open1);
            return;
        }

        if (ctx.getChildCount() == 3 && ctx.expr().size() == 1 && ctx.getChild(1).getText().equals("=")) {
            String opnd1 = r4tree.get(ctx.expr(0));
            String opcode = "=";
            String tmp = TmpList.getTmp();

            resultCode = tmp + " " + opcode + " " + opnd1;
            irResult.append(resultCode).append("\n");
            r4tree.put(ctx, tmp);
            return;
        }

        if (ctx.args() != null) {
            String ident = ctx.IDENT().getText();
            String tmp = TmpList.getTmp();
            String args = r4tree.get(ctx.args());
            resultCode = tmp + " = call " + ident + "(" + args + ")";
            irResult.append(resultCode).append("\n");
            r4tree.put(ctx, tmp);
        }
    }

    @Override public void exitArgs(MiniCParser.ArgsContext ctx) {
        if (ctx.getChildCount() == 0) {return;} else{
            int argCount = ctx.getChildCount() - (ctx.getChildCount() / 2);
            String args = "";
            for (int i = 0;  i < argCount - 1; i++) {
                args += r4tree.get(ctx.expr(i)) + ", ";
            }
            args += r4tree.get(ctx.expr(argCount - 1));
            r4tree.put(ctx, args);
        }
    }

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