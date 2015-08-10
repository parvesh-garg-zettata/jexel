A Symbol is a type of Operator that typically appears between two arguments, such as + or `*`.  The Symbols included in the default OperatorSet can be found on the [operators](Operators.md) page.

If you wish, you can create your own Symbols to either extend or replace existing Symbols.  Say you wanted to be able to subtract dates and have the result be the difference in days.  You could create your own SubtractionSymbol class that accepts dates.  You could even extend the current SubtractionSymbol class and inherit the base functionality.

To create your own Symbol you need to do a few things.  First you need to write your own class that extending com.gadberry.utility.expression.Symbol.  Symbol is an abstract class that requires implementation of three methods and one constructor.  These methods are getPriority(), checkArgs() and resolve(), and the constructor must accept a single Expression argument.  The Expression creating the Symbol should be passed into this constructor.  For reference purposes here is the SubtractionSymbol.java from the source code.

```
package com.gadberry.utility.expression.symbol;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Symbol;

public class SubtractionSymbol extends Symbol {

	public SubtractionSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() != 2) {
			throw new InvalidArgumentsException(
					"SubtractionOperator requires two doubles.  Wrong number of arguments provided.");
		}

		if (!args.get(0).isDouble() || !args.get(1).isDouble()) {
			throw new InvalidArgumentsException(
					"SubtractionOperator requires two doubles.  Wrong type of arguments provided.");
		}
	}

	public int getPriority() {
		return 6;
	}

	public Argument resolve() {
		double lhs = getArgument(0).toDouble();
		double rhs = getArgument(1).toDouble();
		return new Argument(new Double(lhs - rhs), getResolver());
	}

}
```

As you can see the methods are fairly straight forward and the class to implement the Symbol is not large.

The checkArgs() method should thrown an InvalidArgumentsException in the case that passed arguments are not valid for the Symbol.  In this case we only have valid arguments if we have exactly two arguments and they are both doubles.

The getPriority() method determines order of operations.  To get an idea of where your Symbol should be have a look at the existing ones in the source code.  Lower priority operators are parsed first but executed last.

The resolve() method is the meat of the Symbol.  It actually does what the Symbol is intended to accomplish, in this case the subtraction of the arguments.

You can see use of the Argument class for both the incoming arguments and the outgoing result.  This is simply a holder class with many helper functions to translate things to doubles or booleans or dates.  You can always get the original object out of an argument with getObject().

To actually use your Symbol you need to register it with an OperatorSet.