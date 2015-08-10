JExel is a Java based expression language. It is a non-compiled scripting language parser that can be useful in many different applications. It can handle most basic mathematical and string expressions with the built in operator set fairly easily.

An ideal usage would be allowing a user base access to a limited set of commands/operators but prevent them from causing any harm.

A basic example of use would be: `Expression.evaluate("1 + 2 / max(3, 4, 5) - 4").toDouble();`.  For additional examples and a list of available commands visit the [operators](Operators.md) page.

You can specify your own symbols/functions and/or remove the included base level operators.

JExel also supports variable resolution through the use of a [resolver](Resolver.md).

We believe in Open Source software, and support it through the distribution of this project under the GPL.  If, however, you are a working on a project that is not compatible with the GPL, including closed source software, then we still want you to be able to use JExel.  In order to facilitate this, we have developed a dual license model.  A proprietary license is available for cases that are incompatible with the GPL, or do not otherwise wish to use it.  Please contact us with any questions regarding the proprietary license and associated costs.