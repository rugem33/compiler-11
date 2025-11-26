package generated;// Generated from C:/Users/rugem/IdeaProjects/compiler-11/out/production/compiler-11/IR.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IRParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IRVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IRParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(IRParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(IRParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructions(IRParser.InstructionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(IRParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(IRParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#assign_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_instruction(IRParser.Assign_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#branch_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch_instruction(IRParser.Branch_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#call_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_instruction(IRParser.Call_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#return_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_instruction(IRParser.Return_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_spec(IRParser.Type_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(IRParser.OperandContext ctx);
}