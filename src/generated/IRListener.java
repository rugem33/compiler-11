package generated;// Generated from C:/Users/rugem/IdeaProjects/compiler-11/out/production/compiler-11/IR.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IRParser}.
 */
public interface IRListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IRParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(IRParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(IRParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(IRParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(IRParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(IRParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(IRParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(IRParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(IRParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(IRParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(IRParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#assign_instruction}.
	 * @param ctx the parse tree
	 */
	void enterAssign_instruction(IRParser.Assign_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#assign_instruction}.
	 * @param ctx the parse tree
	 */
	void exitAssign_instruction(IRParser.Assign_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#branch_instruction}.
	 * @param ctx the parse tree
	 */
	void enterBranch_instruction(IRParser.Branch_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#branch_instruction}.
	 * @param ctx the parse tree
	 */
	void exitBranch_instruction(IRParser.Branch_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#call_instruction}.
	 * @param ctx the parse tree
	 */
	void enterCall_instruction(IRParser.Call_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#call_instruction}.
	 * @param ctx the parse tree
	 */
	void exitCall_instruction(IRParser.Call_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#return_instruction}.
	 * @param ctx the parse tree
	 */
	void enterReturn_instruction(IRParser.Return_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#return_instruction}.
	 * @param ctx the parse tree
	 */
	void exitReturn_instruction(IRParser.Return_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#type_spec}.
	 * @param ctx the parse tree
	 */
	void enterType_spec(IRParser.Type_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#type_spec}.
	 * @param ctx the parse tree
	 */
	void exitType_spec(IRParser.Type_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(IRParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(IRParser.OperandContext ctx);
}