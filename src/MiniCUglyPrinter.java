import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MiniCUglyPrinter extends MiniCBaseListener {

    public StringBuilder uglyResult = new StringBuilder();
    ParseTreeProperty<String> r4tree = new ParseTreeProperty<>();

    int stack = 0;
    @Override public void exitProgram(MiniCParser.ProgramContext ctx) {
        System.out.println(uglyResult.toString());
    }

    @Override public void exitDecl(MiniCParser.DeclContext ctx) {
        String fun_decl = r4tree.get(ctx.fun_decl());
        r4tree.put(ctx, fun_decl);
        System.out.println(fun_decl);
    }

    @Override public void exitVar_decl(MiniCParser.Var_declContext ctx) {
        for(int i=0; i< stack*4; i++) uglyResult.append(" ");
        TerminalNode V_decl_I = ctx.IDENT();
        uglyResult.append(V_decl_I.getText());
        switch (ctx.getChild(2).getText()) {
            case "=":
                uglyResult.append(" = ");
                TerminalNode lc_LIT = ctx.IDENT();
                uglyResult.append(lc_LIT.getText());
                break;
            case "[":
                uglyResult.append("[");
                TerminalNode lc_LIT2 = ctx.LITERAL();
                uglyResult.append(lc_LIT2.getText() + "]");
                break;
            default:
                break;
        }
        uglyResult.append(";\n");
        r4tree.put(ctx, ctx.type_spec().getText() + " " + ctx.IDENT().getText() + ";\n");
    }

    @Override public void exitType_spec(MiniCParser.Type_specContext ctx) {
        if(ctx.getParent().getRuleIndex() != 4 ){
            uglyResult.append(ctx.getChild(0).getText() + " ");
        }
    }

    @Override public void enterFun_decl(MiniCParser.Fun_declContext ctx) {
        for(int i=0; i< stack*4; i++) uglyResult.append(" ");
        uglyResult.append(ctx.getChild(0).getText()+ " ");
        uglyResult.append(ctx.IDENT().getText());
    }

    @Override public void enterParams(MiniCParser.ParamsContext ctx) { uglyResult.append("("); }

    @Override public void exitParams(MiniCParser.ParamsContext ctx) {
        switch(ctx.getChildCount()){
            case 1:
                uglyResult.append("void");
                break;
            default:
                break;
        }
        uglyResult.append(")");
    }


    @Override public void exitParam(MiniCParser.ParamContext ctx) {
        if(ctx.getParent().getChild(ctx.getParent().getChildCount()-1) == ctx) {
            switch(ctx.getChildCount()){
                case 2:
                    uglyResult.append(ctx.IDENT().getText());
                    break;
                default:
                    uglyResult.append(ctx.IDENT().getText()+ "[]");
                    break;
            }
        }else {
            switch(ctx.getChildCount()){
                case 2:
                    uglyResult.append(ctx.IDENT().getText() + ", ");
                    break;
                default:
                    uglyResult.append(ctx.IDENT().getText()+ "[], ");
                    break;
            }
        }
    }

    @Override public void enterStmt(MiniCParser.StmtContext ctx) {
        if((ctx.getParent().getRuleIndex() != 9 && ctx.getParent().getRuleIndex() != 12)){for(int i=0; i< stack*4; i++) uglyResult.append(" ");}
        if (ctx.getParent() instanceof MiniCParser.If_stmtContext if_parent
                && if_parent.getChildCount() == 7) {

            int idx = 0;
            int i = 0;
            while(if_parent.children.get(i) != ctx){
                i++;
                idx = i;
            }
            if (idx == 6) {
                for(int j=0; j< stack*4; j++) uglyResult.append(" ");
                uglyResult.append("else");
            }
        }
    }

    @Override public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
        uglyResult.append(";\n");
    }
    @Override public void enterWhile_stmt(MiniCParser.While_stmtContext ctx) {
        uglyResult.append("while ");
    }

    @Override public void enterCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
        stack++;
        uglyResult.append(" {\n");
    }

    @Override public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
        stack--;
        for(int i=0; i< stack*4; i++) uglyResult.append(" ");
        uglyResult.append("} \n");
    }

    @Override public void enterLocal_decl(MiniCParser.Local_declContext ctx) {
        for(int i=0; i< stack*4; i++) uglyResult.append(" ");
    }


    @Override public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
        TerminalNode lc_IDENT = ctx.IDENT();
        uglyResult.append(lc_IDENT.getText());
        switch (ctx.getChild(2).getText()) {
            case "=":
                uglyResult.append(" = ");
                TerminalNode lc_LIT = ctx.LITERAL();
                uglyResult.append(lc_LIT.getText());
                break;
            case "[":
                uglyResult.append("[");
                TerminalNode lc_LIT2 = ctx.LITERAL();
                uglyResult.append(lc_LIT2.getText() + "]");
                break;
            default:
                break;
        }
        uglyResult.append(";\n");
    }

    @Override public void enterIf_stmt(MiniCParser.If_stmtContext ctx) {  uglyResult.append("if ");}


    @Override public void enterReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        uglyResult.append("return");
        if(!ctx.getChild(1).getText().equals(";")) uglyResult.append(" ");
    }

    @Override public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        uglyResult.append(";\n");
    }

    @Override
    public void exitExpr(MiniCParser.ExprContext ctx) {
        int count = ctx.getChildCount();
        ParseTree term0 = ctx.getChild(0);

        boolean isTerm0 = (term0 instanceof TerminalNode);
        String s;
        if (ctx.getParent() instanceof MiniCParser.ExprContext || ctx.getParent() instanceof MiniCParser.ArgsContext) {
            return;
        }
        if (isTerm0) {
            TerminalNode tn0 = (TerminalNode) term0;
            int type = tn0.getSymbol().getType();
            String txt0 = tn0.getText();
            switch (type) {
                case MiniCLexer.IDENT -> {
                    if (count == 1) {
                        s = txt0;
                    } else if (count == 3 && "=".equals(ctx.getChild(1).getText())) {
                        s = txt0 + " = " + ctx.getChild(2).getText();
                    } else if (count == 4 && "(".equals(ctx.getChild(1).getText()) && ")".equals(ctx.getChild(3).getText())) {
                        s = txt0 + "(" + ctx.getChild(2).getText() + ")";
                    } else if (count == 4 && "[".equals(ctx.getChild(1).getText()) && "]".equals(ctx.getChild(3).getText())) {
                        s = txt0 + "[" + ctx.getChild(2).getText() + "]";
                    } else if (count == 6
                            && "[".equals(ctx.getChild(1).getText())
                            && "]".equals(ctx.getChild(3).getText())
                            && "=".equals(ctx.getChild(4).getText())) {
                        s = txt0 + "[" + ctx.getChild(2).getText() + "] = " + ctx.getChild(5).getText();
                    } else {
                        s = ctx.getText();
                    }
                }
                case MiniCLexer.LITERAL ->  s = txt0;

                default -> {
                    if (count == 2 && ctx.getChild(1) instanceof MiniCParser.ExprContext) {
                        String op = txt0;
                        s = op + ctx.getChild(1).getText();
                    }
                    else if (count == 3 && "(".equals(txt0) && ")".equals(ctx.getChild(2).getText())) {
                        s = "(" + ctx.getChild(1).getText() + ")";
                    }
                    else {
                        s = ctx.getText();
                    }
                }
            }
        } else {
            if (count == 3
                    && ctx.getChild(1) instanceof org.antlr.v4.runtime.tree.TerminalNode
                    && ctx.getChild(0) instanceof MiniCParser.ExprContext
                    && ctx.getChild(2) instanceof MiniCParser.ExprContext) {
                String op = ctx.getChild(1).getText();
                s = ctx.getChild(0).getText() + " " + op + " " + ctx.getChild(2).getText();
            }
            else if (count == 3 && "(".equals(ctx.getChild(0).getText()) && ")".equals(ctx.getChild(2).getText())) {
                s = "(" + ctx.getChild(1).getText() + ")";
            }
            else {
                s = ctx.getText();
            }
        }
        boolean isThirdChild = false;
        ParseTree parent = ctx.getParent();
        if (parent instanceof ParserRuleContext pr && pr.children != null) {
            for (int i = 0; i < pr.children.size(); i++) {
                if (pr.children.get(i) == ctx) {
                    isThirdChild = (i == 2);
                    break;
                }
            }
        }
        if (isThirdChild) {
            s = "(" + s + ")";
        }

        uglyResult.append(s);
    }

}
