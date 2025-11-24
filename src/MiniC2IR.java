import generated.*;
import org.antlr.v4.runtime.tree.*;

public class MiniC2IR extends MiniCBaseListener {
    public StringBuilder irResult = new StringBuilder();
    ParseTreeProperty<String> r4tree = new ParseTreeProperty<>();
    MiniCTmpList TmpList = new MiniCTmpList();
    MiniCLabelList LabelList = new MiniCLabelList();

    private String getVariable (String inputText){
        String var;
        if(inputText.contains(" ")){
            int beginIndex = inputText.lastIndexOf("\n",inputText.lastIndexOf(" "));
            if(inputText.contains("\n") && beginIndex != -1 ){
                String tmpStr = inputText.substring(beginIndex + 1, inputText.length());
                var = tmpStr.substring(0, tmpStr.indexOf(" "));
            } else {
                var = inputText.substring(0, inputText.indexOf(" "));
            }
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
        String printEnd = "end function\n\n";
        String resultCode = printInit + printCompStmt + printEnd;
        r4tree.put(ctx, resultCode);
    }



    @Override public void exitStmt(MiniCParser.StmtContext ctx) {
        if(ctx.return_stmt() != null) {
            r4tree.put(ctx, r4tree.get(ctx.return_stmt()));
        } else if (ctx.if_stmt() != null) {
            r4tree.put(ctx, r4tree.get(ctx.if_stmt()));
        } else if (ctx.compound_stmt() != null) {
            String expr = r4tree.get(ctx.compound_stmt());
            r4tree.put(ctx, expr);
        } else if(ctx.expr_stmt() != null) {
            String expr = r4tree.get(ctx.expr_stmt());
            r4tree.put(ctx, expr);
        } else if(ctx.while_stmt() != null) {
            r4tree.put(ctx, r4tree.get(ctx.while_stmt()));
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
        String printCondExpr = condExpr;
        String condVar = getVariable(condExpr);
        String condTmp = TmpList.getTmp();
        String printNotCond = condTmp + " = not " + condVar + "\n";
        String printCjump = "cjump " + condTmp + " " + label1 + "\n";
        String printStmt = r4tree.get(ctx.stmt());
        String printJump = "jump " + label0 + "\n";
        String printL1 = label1 + ":\n";
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
            String printCondExpr = condExpr;
            String printCond = tmp + " = " + cond;

            String label1 = LabelList.getLabels();
            String label2 = LabelList.getLabels();

            String printCjump = "cjump " + tmp + " " + label1 + "\n";
            String printStmt1 = r4tree.get(ctx.stmt(0));
            if(printStmt1.lastIndexOf("\n") != printStmt1.length()-1){
                printStmt1 += "\n";
            }
            String printJump = "jump " + label2 + "\n";
            String lb1 = label1 + ":\n";
            String printStmt2 = r4tree.get(ctx.stmt(1));
            String lb2 = label2 + ":\n";
            String resultCode = printCondExpr + printCond + printCjump + printStmt1 + printJump + lb1 + printStmt2 + lb2;
            r4tree.put(ctx, resultCode);
        } else {
            String tmp = TmpList.getTmp();
            String condExpr = r4tree.get(ctx.expr());
            String cond = "not " + getVariable(condExpr) + "\n";
            String printCondExpr = condExpr;
            String printCond = tmp + " = " + cond;

            String label1 = LabelList.getLabels();

            String printCjump = "cjump " + tmp + " " + label1 + "\n";
            String printStmt1 = r4tree.get(ctx.stmt(0));
            if(printStmt1.lastIndexOf("\n") != printStmt1.length()-1){
                printStmt1 += "\n";
            }
            String lb1 = label1 + ":\n";
            String resultCode = printCondExpr + printCond + printCjump + printStmt1 + lb1;
            r4tree.put(ctx, resultCode);
        }
    }

    @Override public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        if (ctx.getChildCount() == 2) {
            r4tree.put(ctx, "return" + "\n");
        }else {
            String srcExpr = r4tree.get(ctx.expr());
            // check return expr
            if(ctx.expr().getChildCount() != 1){
                // return expr
                String beforeExpr = srcExpr;
                String returnVal = "return " + getVariable(srcExpr);
                String resultCode = beforeExpr + returnVal;
                r4tree.put(ctx, resultCode + "\n");
            }else{
                // return ident or lit
                String returnVal = "return " + getVariable(srcExpr);
                if(returnVal.lastIndexOf("\n") != returnVal.length()-1){
                    returnVal += "\n";
                }
                String resultCode = returnVal;
                r4tree.put(ctx, resultCode);
            }
        }
    }

    @Override public void exitExpr(MiniCParser.ExprContext ctx) {
        String resultCode;
        // IDENT
        if (ctx.IDENT() != null && ctx.getChildCount() == 1 ) {
            r4tree.put(ctx, ctx.IDENT().getText());
            return;
        }

        // LITERAL
        if (ctx.LITERAL() != null && ctx.getChildCount() == 1) {
            r4tree.put(ctx, ctx.LITERAL().getText());
            return;
        }
        // ident = lit
        if (ctx.IDENT() != null && ctx.getChild(2).getChildCount() == 1 && ctx.expr().size() == 1) {
            String ident = ctx.IDENT().getText();
            String srcExpr = r4tree.get(ctx.expr(0));
            String opnd1 = srcExpr;
            resultCode = ident + " = " + opnd1;
            r4tree.put(ctx, resultCode + "\n");
            return;
        }
        // ident = expr
        if (ctx.IDENT() != null && ctx.getChild(2).getChildCount() > 1 && ctx.expr().size() == 1) {
            String ident = ctx.IDENT().getText();
            String srcExpr = r4tree.get(ctx.expr(0));
            String beforeExpr = srcExpr;
            String opnd1 = TmpList.getCurrentTmp();
            resultCode = beforeExpr + ident + " = " + opnd1;
            r4tree.put(ctx, resultCode + "\n");
            return;
        }

        // expr op expr
        if (ctx.getChildCount() == 3 && ctx.expr().size() == 2) {
            String srcExpr1 = r4tree.get(ctx.expr(0));
            String srcExpr2 = r4tree.get(ctx.expr(1));
            String opnd1 = getVariable(srcExpr1);  // "a"
            String opnd2 = getVariable(srcExpr2);  // "b"
            String opcode = toBinaryOp(ctx.getChild(1).getText());
            String tmp = TmpList.getTmp();    // "t1" 같은 임시 변수 이름
            String beforeExpr = "";
            if (srcExpr1.contains(" ")){
                beforeExpr += srcExpr1;
            }
            if (srcExpr2.contains(" ")){
                beforeExpr += srcExpr2;
            }

            resultCode = beforeExpr + tmp + " = " + opnd1 + " " + opcode + " "  + opnd2;

            r4tree.put(ctx, resultCode + "\n");
            return;
        }
        // ++ -- op IDENT
        if (ctx.getChild(1).getChildCount() == 1 && ctx.getChildCount() == 2 && ctx.expr().size() == 1 ) {
            String srcExpr = r4tree.get(ctx.expr(0));
            String opnd1 = getVariable(srcExpr);
            String tmp = TmpList.getTmp();
            String opcode = toUnaryOp(ctx.getChild(0).getText());
            resultCode = tmp + " = " + opcode + " " + opnd1;
            r4tree.put(ctx, resultCode + "\n");
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
            r4tree.put(ctx, resultCode + "\n");
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
            r4tree.put(ctx, resultCode + "\n");
            return;
        }

        // call func
        if (ctx.args() != null) {
            boolean checkOnlyIdent = true;
            for (int i = 0; i < ctx.args().getChildCount(); i++) {
                if(ctx.args().getChild(i).getChildCount() != 1) {
                    checkOnlyIdent = false;
                }
            }
            if (checkOnlyIdent) {
                // call func (ident)
                String ident = ctx.IDENT().getText();
                String tmp = TmpList.getTmp();
                String argsExpr = r4tree.get(ctx.args());
                String args = argsExpr.substring(0, argsExpr.length());
                resultCode = tmp + " = call " + ident + "(" + args + ")";
                r4tree.put(ctx, resultCode + "\n");
                return;
            } else {
                // call func (expr)
                String ident = ctx.IDENT().getText();
                String tmp = TmpList.getTmp();
                String argsExpr = r4tree.get(ctx.args());
                String args = argsExpr.substring(0, argsExpr.indexOf(" "));
                String declArgs = argsExpr.substring(0, argsExpr.lastIndexOf("\n"));
                resultCode = declArgs + tmp + " = call " + ident + "(" + args + ")";
                r4tree.put(ctx, resultCode + "\n");
                return;
            }
        }
    }

    @Override public void exitArgs(MiniCParser.ArgsContext ctx) {
        if (ctx.getChildCount() == 0) {
            return;
        } else if (ctx.expr().size() == 1 && ctx.getChild(0).getChildCount() == 1) {
            r4tree.put(ctx, r4tree.get(ctx.expr(0)));
            return;
        } else {
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

                String resultCode = argsExpr;
                r4tree.put(ctx, resultCode);
        }
    }
}