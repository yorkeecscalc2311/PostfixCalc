//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;


public class Controller
{
	private View window;
	private Model model;
	private GraphController grph_controller;
	
	public static final String CLEAR = "Clear";
	public static final String ENTER = "Enter";
	public static final String PLUS = "+";
	public static final String MULT = "*";
	public static final String DIV = "/";
	public static final String MINUS = "-";
	public static final String FACT = "!";
	public static final String UNDO = "Undo";
	public static final String PI = "\u03C0";
	public static final String PLUSMINUS = "+/-";
	public static final String COS = "COS(";
	public static final String SIN = "SIN(";
	public static final String EXPRESSION = 'x' + "";
	
	
	public Controller(View view)
	{
		model = new Model();
		window = view;
		grph_controller = new GraphController();
		
	}
	
	public void changeToGraph()
	{
		window.setVisible(false);
		grph_controller.initialize(this, model.getPostExpressionList(), model.getInFixExpressionList());
	}
	
	public void open()
	{
		window.setVisible(true);
	}
	
	public void addToEntry(String button)
	{
		model.addToEntry(button);
		window.updateValue(model.updateValue());
		
		if(model.isHistoryEmpty())
			window.updateHistory("");
		else
			window.updateHistory(model.printHistory());
	}
	
	
	public void clear()
	{
		model.reset();
		window.clearDisplay();
	}
	
	public void pi()
	{
		window.updateValue(model.valuePi());
		window.updateHistory(model.historyPi());
	}
	
	public void expression()
	{
		window.updateValue(model.expressionVal());
		window.updateHistory(model.expressionHist());
	}
	
	public void enter()
	{
		window.updateValue(model.enterValue());
		window.updateHistory(model.enterHistory());
	}
	
	public void sum()
	{
		window.updateValue(model.sum());
	}
	
	public void subtract()
	{
		window.updateValue(model.subtract());
	}
	
	public void multiply()
	{
		window.updateValue(model.multiply());
	}
	
	public void divide()
	{
		window.updateValue(model.divide());
	}
	
	public void factorial()
	{
		window.updateValue(model.factorial());
		
	}
	
	public void sin()
	{
		window.updateValue(model.sin());
	}

	public void cos()
	{
		window.updateValue(model.cos());
	}

	public void negate()
	{
		window.updateValue(model.negate());
		window.updateHistory(model.negateHistory());
	}
	
	public void historyOperation(String operator)
	{
		window.updateHistory(model.operandHistory(operator));
	}
	
	public void factHistoryOperation(String operator)
	{
		window.updateHistory(model.factHistory(operator));
	}
	
	public void trigHistoryOperation(String funct)
	{
		window.updateHistory(model.trigHistory(funct));
	}
	
	public void undo()
	{
		window.updateHistory(model.undoHistory());
		window.updateValue(model.undoValue());
		System.out.println(model.expressionsInFix_undo);
	}
	

}
