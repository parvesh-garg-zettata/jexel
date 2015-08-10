A resolver is a custom piece of code you can develop to implement variable resolution specific to your application.  Below is a simple example of of a Resolver, primarily supporting the use of date functions.

Your resolver must implement two methods, each of which accept a single String argument.  These two methods are canResolve() and resolve().  As you can see resolve() returns a generic Object so that you can extend this to whatever your project requires.

```
package com.gadberry.utility.expression;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleResolver implements Resolver {

	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	public boolean canResolve(String path) {
		return resolve(path) != null;
	}

	public Object resolve(String path) {
		try {
			return sdf.parse(path);
		} catch (ParseException e) {
		}
		return null;
	}
}

```

This resolver would be utilized in code by calling the setResolver() method on an expression.  For example:

```
Expression exp = new Expression("1 + 2");
exp.setResolver(new SimpleResolver());
String result = exp.evaluate().toString();
```

Alternatively, to use a single resolver on all expressions you could call the static  method setDefaultResolver().  For example:

```
Expression.setDefaultResolver(new SimpleResolver());
String result = Expression.evaluate("1 + 2").toString();
```