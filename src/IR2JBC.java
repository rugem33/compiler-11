import generated.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

public class IR2JBC extends IRBaseListener {
    public StringBuilder irResult = new StringBuilder();
    ParseTreeProperty<String> r4tree = new ParseTreeProperty<>();

    private String checkBinaryOp(String opText) {
        switch (opText) {
            case "mul":  return "imul";
            case "div":  return "idiv";
            case "mod":  return "imod";
            case "add":  return "iadd";
            case "sub":  return "isub";
            case "eq": return "if_icmpeq";
            case "neq": return "if_icmpne";
            case "leq": return "if_icmple";
            case "lt":  return "if_icmplt";
            case "geq": return "if_icmpge";
            case "gt":  return "if_icmpgt";
            case "and": return "iand";
            case "or":  return "ior";
            default:
                throw new IllegalArgumentException("unknown binary op: " + opText);
        }
    }

    private String checkUnaryOp(String opText) {
        switch (opText) {
            case "neg": return "ineg";
            case "pos": return "";
            case "dec": return "iinc";
            case "inc": return "iinc";
            case "not": return "ixor";
            default:
                throw new IllegalArgumentException("unknown binary op: " + opText);
        }
    }

    @Override public void enterProgram(IRParser.ProgramContext ctx) {

    }

    @Override public void exitProgram(IRParser.ProgramContext ctx) {
        String init = ".class public Main\n.super java/lang/Object\n\n.method public <init>()V\n\taload_0\n\tinvokenonvirtual java/lang/Object/<init>()V\n\treturn\n.end method\n\n";
        String resultCode = "";
        for(int i = 0; i < ctx.function().size(); i++){
             resultCode += r4tree.get(ctx.function(i));
        }
        init += resultCode;
    }

    @Override public void exitFunction(IRParser.FunctionContext ctx) {
        String init = "\t.limit stack 32\n\t.limit locals 32\n\n";
    }

    @Override public void exitInstructions(IRParser.InstructionsContext ctx) { }

    @Override public void exitInstruction(IRParser.InstructionContext ctx) { }

    @Override public void exitLabel(IRParser.LabelContext ctx) { }

    @Override public void exitAssign_instruction(IRParser.Assign_instructionContext ctx) {
        if (ctx.getChildCount() == 3) {
            String lit = "\ticonst_" + ctx.operand(1).getText() + "\n";
            String ident = "\tistore_" + TmpCount.getTmp()+ "\n";
            r4tree.put(ctx, lit + ident);
        } else if (ctx.getChildCount() == 4) {
            
        }
    }

    @Override public void exitBranch_instruction(IRParser.Branch_instructionContext ctx) { }

    @Override public void exitCall_instruction(IRParser.Call_instructionContext ctx) { }

    @Override public void exitReturn_instruction(IRParser.Return_instructionContext ctx) { }

    @Override public void exitType_spec(IRParser.Type_specContext ctx) { }

    @Override public void exitOperand(IRParser.OperandContext ctx) { }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }

    @Override public void visitErrorNode(ErrorNode node) { }
}
