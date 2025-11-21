import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
class LabelList {
    enum Labels {
        l0("l0"),
        l1("l1"),
        l2("l2"),
        l3("l3"),
        l4("l4"),
        l5("l5"),
        l6("l6"),
        l7("l7"),
        l8("l8"),
        l9("l9"),
        l10("l10"),
        l11("l11"),
        l12("l12"),
        l13("l13"),
        l14("l14"),
        l15("l15");

        private final String label;

        Labels(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private static int labelsNum = -1;

    // 다음 labels 이름 하나 꺼내기
    public static String getLabels() {
        if (labelsNum + 1 >= Labels.values().length) {
            throw new IllegalStateException("더 이상 사용할 수 있는 labels가 없습니다.");
            // 혹은: labelsNum = -1; 처럼 다시 처음으로 돌려도 되고
        }
        labelsNum++;
        return Labels.values()[labelsNum].getLabel();
    }

    // 하나 되돌리기
    public static void returnLabels() {
        labelsNum--;
        // 아니면 음수로 내려가면 예외 던지게 해도 됨
    }

    public static String getCurrentLabels() {
        return Labels.values()[labelsNum].getLabel();
    }

    public static String getLabelsIndex(int i) {
        return Labels.values()[i].getLabel();
    }

    public static int getCurrentIndex() {
        return labelsNum;
    }
}
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

    private String getVariable (String inputText){
        String var;
        if(inputText.contains(" ")){
            var = inputText.substring(0, inputText.indexOf(" "));
        } else {
            var = inputText;
        }
        return var;
    }

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


    @Override public void exitProgram(MiniCParser.ProgramContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < ctx.decl().size(); j++) {
            sb.append(r4tree.get(ctx.decl(j)));
        }
        irResult.append(sb.toString());
    }

    @Override public void exitDecl(MiniCParser.DeclContext ctx) {
        if (ctx.var_decl() != null) {
            r4tree.put(ctx, r4tree.get(ctx.var_decl()));
        } else if (ctx.fun_decl() != null) {
            r4tree.put(ctx, r4tree.get(ctx.fun_decl()));
        }
    }

    @Override public void exitParams(MiniCParser.ParamsContext ctx) {
        String resultCode = "";
        if ((ctx.param() != null && ctx.param().size() > 0) || (ctx.param() == null && ctx.param().size() == 0)){
            for (int i = 0; i < ctx.param().size() - 1; i++) {
                resultCode += r4tree.get(ctx.param(i)) + " ";
            }
            resultCode += r4tree.get(ctx.param(0));
        } else resultCode = "";

        r4tree.put(ctx, resultCode);
    }

    @Override public void exitParam(MiniCParser.ParamContext ctx) {
        String type = "";
        switch(ctx.type_spec().getText()){
            case "int":
                type = "I";
                break;
            case "void":
                type = "V";
                break;
        }
        r4tree.put(ctx, type);
    }

    @Override public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
        String outType = "";
        String params = r4tree.get(ctx.params());
        if (ctx.type_spec().getText().equals("int")) {outType = "I";}else if (ctx.type_spec().getText().equals("void")) {outType = "V";}
        String printInit = "function " + ctx.IDENT().getText() + " (" +  params + ")" + outType + "\n";
        String printCompStmt = r4tree.get(ctx.compound_stmt());
        String printEnd = "end function\n";
        String resultCode = printInit + printCompStmt + printEnd;
        r4tree.put(ctx, resultCode);
    }



    @Override public void exitStmt(MiniCParser.StmtContext ctx) {
        if(ctx.return_stmt() != null) {
            r4tree.put(ctx, r4tree.get(ctx.return_stmt()) + "\n");
        } else if (ctx.if_stmt() != null) {
            r4tree.put(ctx, r4tree.get(ctx.if_stmt()) + "\n");
        } else if (ctx.compound_stmt() != null) {
            String expr = r4tree.get(ctx.compound_stmt());
            r4tree.put(ctx, expr);
        } else if(ctx.expr_stmt() != null) {
            String expr = r4tree.get(ctx.expr_stmt());
            r4tree.put(ctx, expr);
        } else if(ctx.while_stmt() != null) {
            r4tree.put(ctx, r4tree.get(ctx.while_stmt()) + "\n");
        }
    }

    @Override public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
        String expr = r4tree.get(ctx.expr());

        r4tree.put(ctx, expr);

    }

    @Override public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
        String label0 = LabelList.getLabels();
        String label1 = LabelList.getLabels();
        String printL0 = label0 + ":\n";
        String condExpr = r4tree.get(ctx.expr());
        String printCondExpr = condExpr + ":\n";
        String condVar = getVariable(condExpr);
        String condTmp = TmpList.getTmp();
        String printNotCond = condTmp + " = not " + condVar + "\n";
        String printCjump = "cjump " + condTmp + " " + label1 + "\n";
        String printStmt = r4tree.get(ctx.stmt()) + "\n";
        String printJump = "jump " + label0 + "\n";
        String printL1 = label1 + ":";
        String resultCode = printL0 + printCondExpr + printNotCond + printCjump + printStmt + printJump + printL1;
        r4tree.put(ctx, resultCode);

    }


    @Override public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
        String resultCode = "";
        for (int i = 0; i < ctx.local_decl().size(); i++) {
            resultCode += r4tree.get(ctx.local_decl(i));
        }
        for (int i = 0; i < ctx.stmt().size(); i++) {
            resultCode += r4tree.get(ctx.stmt(i));
        }
        r4tree.put(ctx, resultCode);

    }

    @Override public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
        if (ctx.getChildCount() == 3) { return;}
        String ident = ctx.IDENT().getText();
        String opcode = " = ";
        String lit = ctx.LITERAL().getText();

        String result = ident + opcode + lit + "\n";

        r4tree.put(ctx, result);
    }


    @Override public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
        if (ctx.ELSE() != null) {
            String tmp = TmpList.getTmp();
            String condExpr = r4tree.get(ctx.expr());
            String cond = "not " + getVariable(condExpr) + "\n";
            String printCondExpr = condExpr + "\n";
            String printCond = tmp + " = " + cond;

            String label1 = LabelList.getLabels();
            String label2 = LabelList.getLabels();

            String printCjump = "cjump " + tmp + " " + label1 + "\n";
            String printStmt1 = r4tree.get(ctx.stmt(0)) + "\n";
            String printJump = "jump " + label2 + "\n";
            String lb1 = label1 + ":\n";
            String printStmt2 = r4tree.get(ctx.stmt(1)) + "\n";
            String lb2 = label2 + ":";
            String resultCode = printCondExpr + printCond + printCjump + printStmt1 + printJump + lb1 + printStmt2 + lb2;
            r4tree.put(ctx, resultCode);
        } else {
            String tmp = TmpList.getTmp();
            String condExpr = r4tree.get(ctx.expr());
            String cond = "not " + getVariable(condExpr) + "\n";
            String printCondExpr = condExpr + "\n";
            String printCond = tmp + " = " + cond;

            String label1 = LabelList.getLabels();

            String printCjump = "cjump " + tmp + " " + label1 + "\n";
            String printStmt1 = r4tree.get(ctx.stmt(0)) + "\n";
            String lb1 = label1 + ":\n";
            String resultCode = printCondExpr + printCond + printCjump + printStmt1 + lb1;
            r4tree.put(ctx, resultCode);
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */

    @Override public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        if (ctx.getChildCount() == 2) {
            r4tree.put(ctx, "return");
        }else {
            String srcExpr = r4tree.get(ctx.expr());
            String beforeExpr = srcExpr + "\n";
            String returnVal = "return " + getVariable(srcExpr) + "\n";
            String resultCode = beforeExpr + returnVal + "\n";
            r4tree.put(ctx, resultCode);
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
        // ident = lit
        if (ctx.IDENT() != null && ctx.getChild(0).getChildCount() == 0 && ctx.expr().size() == 1) {
            String ident = ctx.IDENT().getText();
            String srcExpr = r4tree.get(ctx.expr(0));
            String opnd1 = srcExpr;
            resultCode = ident + " = " + opnd1;
            r4tree.put(ctx, resultCode);
            return;
        }
        // ident = expr
        if (ctx.IDENT() != null && ctx.getChild(0).getChildCount() != 0 && ctx.expr().size() == 1) {
            String ident = ctx.IDENT().getText();
            String srcExpr = r4tree.get(ctx.expr(0));
            String beforeExpr = srcExpr + "\n";
            String opnd1 = TmpList.getCurrentTmp();
            resultCode = beforeExpr + ident + " = " + opnd1;
            r4tree.put(ctx, resultCode);
            return;
        }

        // (c) a + b 같은 expr op expr
        if (ctx.getChildCount() == 3 && ctx.expr().size() == 2) {
            String srcExpr1 = r4tree.get(ctx.expr(0));
            String srcExpr2 = r4tree.get(ctx.expr(1));
            String opnd1 = getVariable(srcExpr1);  // "a"
            String opnd2 = getVariable(srcExpr2);  // "b"
            String opcode = toBinaryOp(ctx.getChild(1).getText());
            String tmp = TmpList.getTmp();    // "t1" 같은 임시 변수 이름
            String beforeExpr = "";
            if (srcExpr1.contains(" ")){
                beforeExpr += srcExpr1 + "\n";
            }
            if (srcExpr2.contains(" ")){
                beforeExpr += srcExpr2 + "\n";
            }
            // 3주소 코드 한 줄 생성
            resultCode = beforeExpr + tmp + " = " + opnd1 + " " + opcode + " "  + opnd2;

            // 출력용 버퍼에 추가

            // 이 expr의 값은 tmp 라고 저장 (위쪽에서 또 쓸 수 있게)
            r4tree.put(ctx, resultCode);
            return;
        }
        // ++ -- op IDENT
        if (ctx.getChild(1).getChildCount() == 1 && ctx.getChildCount() == 2 && ctx.expr().size() == 1 ) {
            String srcExpr = r4tree.get(ctx.expr(0));
            String opnd1 = getVariable(srcExpr);
            String tmp = TmpList.getTmp();
            String opcode = toUnaryOp(ctx.getChild(0).getText());
            resultCode = tmp + " = " + opcode + " " + opnd1;
            r4tree.put(ctx, resultCode);
            return;
        }
        // ++ -- op expr
         if (ctx.getChildCount() == 2 && ctx.expr().size() == 1 ) {
            String srcExpr = r4tree.get(ctx.expr(0));
            String opnd1 = getVariable(srcExpr);
            String tmp = TmpList.getTmp();
            String opcode = toUnaryOp(ctx.getChild(0).getText());
            String beforeExpr = srcExpr + "\n";
            resultCode = beforeExpr + tmp + " = " + opcode + " " + opnd1;
            r4tree.put(ctx, resultCode);
            return;
        }
         // ( expr )
         if (ctx.getChildCount() == 3 && ctx.expr().size() == 1 && ctx.getChild(0).getText().contains("(") ) {
             String srcExpr1 = r4tree.get(ctx.expr(0));
             r4tree.put(ctx, srcExpr1);
         }

        // t = lit
        if (ctx.getChildCount() == 3 && ctx.expr().size() == 1 && ctx.getChild(1).getText().equals("=")) {
            String srcExpr =  r4tree.get(ctx.expr(0));
            String opnd1 = getVariable(srcExpr);
            String opcode = "=";
            String tmp = TmpList.getTmp();
            String beforeExpr = srcExpr + "\n";
            resultCode = beforeExpr + tmp + " " + opcode + " " + opnd1;
            r4tree.put(ctx, resultCode);
            return;
        }

        // return args
        if (ctx.args() != null) {
            String ident = ctx.IDENT().getText();
            String tmp = TmpList.getTmp();
            String argsExpr = r4tree.get(ctx.args());
            String args = argsExpr.substring(argsExpr.lastIndexOf("\n") + 1, argsExpr.length());
            String declArgs = argsExpr.substring(0, argsExpr.lastIndexOf("\n") + 1);
            resultCode = declArgs + tmp + " = call " + ident + "(" + args + ")";
            r4tree.put(ctx, resultCode);

        }
    }

    @Override public void exitArgs(MiniCParser.ArgsContext ctx) {
        if (ctx.getChildCount() == 0) {return;} else{
            int argCount = ctx.getChildCount() - (ctx.getChildCount() / 2);
            String args = "";
            String argsExpr = "";
            String srcExpr = "";
            for (int i = 0;  i < argCount - 1; i++) {
                srcExpr = r4tree.get(ctx.expr(i));
                args += srcExpr.substring(0, srcExpr.indexOf(" ")) + ", ";
                argsExpr += srcExpr + "\n";
            }
            srcExpr = r4tree.get(ctx.expr(argCount - 1));
            args += getVariable(srcExpr);
            argsExpr += srcExpr + "\n";

            String resultCode = argsExpr + args;
            r4tree.put(ctx, resultCode);
        }
    }
}