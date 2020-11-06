import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvalVisitor extends bpBaseVisitor<Boolean>
{
	Map<String, Boolean> memory = new HashMap<String, Boolean>();
	Scanner sc = new Scanner(System.in);

	@Override
	public Boolean visitAssignStm (bpParser.AssignStmContext ctx)
	{
		String id = ctx.ID().getText();
		Boolean value = visit(ctx.expr());
		memory.put(id, value);
		return value;
	}

	@Override
	public Boolean visitWriteStm(bpParser.WriteStmContext ctx)
	{
		String id = ctx.ID().getText();
		System.out.print (id + ": ");
		Boolean value = memory.get(id);
		if (value)
			System.out.println ("True");
		else
			System.out.println ("False");

		return value;
	}

	@Override
	public Boolean visitReadStm (bpParser.ReadStmContext ctx)
	{
		String id = ctx.ID().getText();
		System.out.print (id + ": ");
		String str = sc.nextLine();
		char c = str.charAt(0);
		Boolean value = (c =='t' || c == 'T') ? true : false;
		memory.put (id, value);

		return value;
	}

	@Override
	public Boolean visitBoolV (bpParser.BoolVContext ctx)
	{
		if (ctx.BV().getText().equals ("true"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Boolean visitId (bpParser.IdContext ctx)
	{
		String id = ctx.ID().getText();
		if (memory.containsKey (id))
			return memory.get(id);
		return true;
	}

	@Override
	public Boolean visitBinOp (bpParser.BinOpContext ctx)
	{
		Boolean left = visit(ctx.expr(0));
		Boolean right = visit (ctx.expr(1));
		if (ctx.op.getType() == bpParser.AND)
			return (left & right);
		return (left | right);
	}

	@Override
	public Boolean visitNegOp (bpParser.NegOpContext ctx)
	{
		Boolean value = visit(ctx.expr());
		return (!value);
	}

	@Override
	public Boolean visitParens (bpParser.ParensContext ctx)
	{
		return visit(ctx.expr());
	}

}
