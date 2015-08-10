If you wish to adjust the set of operators used to evaluate expressions you need to create a custom OperatorSet.  This is a very simple task.  Here is an example OperatorSet pulled from the unit test cases:

```
OperatorSet opSet = new OperatorSet();
opSet.addOperator("+", AdditionSymbol.class);
opSet.addOperator("-", SubtractionSymbol.class);
```

You could utilize this set to evaluate an expression with the following code:

```
Expression exp = new Expression("123 - 321 + 123");
exp.setOperatorSet(opSet);
double result = exp.evaluate().toDouble();
```

If instead you wanted to extend the standard operator set you could use:

```
OperatorSet opSet = OperatorSet.getStandardOperatorSet();
opSet.addOperator("^", PowerSymbol.class);
```

See [here](Operators.md) for a list of operators in the standard operator set.

Also available to you is a static method to assist with usability:

```
Expression.setDefaultOperatorSet(opSet);
```

Any and all expressions without an explicitly set operator set would then utilize the newly defined default.  As you could gues, the standard operator set is the default by default.