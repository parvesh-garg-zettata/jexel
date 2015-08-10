A Function is a type of Operator that is typically followed by a list of arguments, such as substr(abc, 1, 2).  The Functions included in the default OperatorSet can be found on the [operators](Operators.md) page.

If you wish, you can create your own Functions to either extend or replace existing Functions.  Say you wanted to create a function that reversed a string.  You could create your own ReverseFunction class.

To create your own Function you need to do a few things.  First you need to write your own class that extending com.gadberry.utility.expression.Function.  Function is an abstract class that requires implementation of two methods and one constructor.  These methods are checkArgs() and resolve().  Another one that may be helpful to override is getPriority(), and the constructor must accept a single Expression argument. The Expression creating the Function should be passed into this constructor..  For reference purposes here is the MaxFunction.java from the source code.

```
package com.gadberry.utility.expression.function;

import java.util.Iterator;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.Function;
import com.gadberry.utility.expression.InvalidArgumentsException;

public class MaxFunction extends Function {

	public MaxFunction(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() < 2) {
			throw new InvalidArgumentsException(
					"MaxOperator requires a minimum of two doubles.  Wrong number of arguments provided.");
		}

		for (Argument arg : args) {
			if (!arg.isDouble()) {
				throw new InvalidArgumentsException(
						"MaxOperator only accepts doubles.  Wrong type of arguments provided.  Arg: " + arg.toString());
			}
		}
	}

	public Argument resolve() {
		double max = 0;
		Iterator<Argument> iter = getArguments().iterator();
		max = iter.next().toDouble();
		while (iter.hasNext()) {
			Argument arg = iter.next();
			if (max < arg.toDouble()) {
				max = arg.toDouble();
			}
		}
		return new Argument(new Double(max), getResolver());
	}
}
```

As you can see the methods are fairly straight forward and the class to implement the Symbol is not large.

The checkArgs() method should thrown an InvalidArgumentsException in the case that passed arguments are not valid for the Symbol.  In this case we only have valid arguments if we have at least two arguments and all the arguments are doubles.

The getPriority() method determines order of operations.  To get an idea of where your Symbol should be have a look at the existing ones in the source code.  Lower priority operators are parsed first but executed last.

The resolve() method is the meat of the Function.  It actually does what the Function is intended to accomplish, in this case the determining of the maximum argument.

You can see use of the Argument class for both the incoming arguments and the outgoing result.  This is simply a holder class with many helper functions to translate things to doubles or booleans or dates.  You can always get the original object out of an argument with getObject().

To actually use your Function you need to register it with an OperatorSet.