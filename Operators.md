Alternatively there are instructions available on how to use a custom OperatorSet.

### Mathematical ###
| **Symbol** | **Operator** | **Type** | **Example** | **Priority** |
|:-----------|:-------------|:---------|:------------|:-------------|
| +          | Addition     | Symbol   | 4 + 2       | 6            |
| -          | Subtraction  | Symbol   | 1 - 2       | 7            |
| `*`        | Multiplication | Symbol   | 3 `*` 2     | 10           |
| /          | Division     | Symbol   | 6 / 2       | 10           |
| %          | Modulo       | Symbol   | 5 % 2       | 10           |
| max        | Maximum      | Function | max( 4, 5, 6 ) | 20           |
| min        | Minimum      | Function | min( 4, 5, 6 ) | 20           |
| floor      | Floor        | Function | floor( 2.9 ) | 20           |
| ceil       | Ceiling      | Function | ceil( 2.1 ) | 20           |
| neg        | Negative     | Function | neg( 2 )    | 20           |
| abs        | Absolute Value | Function | abs( 4 )    | 20           |
| cos        | Cosine       | Function | cos( 90 )   | 20           |
| sin        | Sine         | Function | sin( 180 )  | 20           |
| tan        | Tangent      | Function | tan( 45 )   | 20           |
| acos       | ArcCosine    | Function | acos( 1 )   | 20           |
| asin       | ArcSine      | Function | asin( 0 )   | 20           |
| atan       | ArcTangent   | Function | atan( 1 )   | 20           |
| deg        | RadiansToDegrees | Function | deg( 1 )    | 20           |
| rad        | DegreesToRadians | Function | rad( 1 )    | 20           |

### Comparison ###

| **Symbol** | **Operator** | **Type** | **Example** | **Priority** |
|:-----------|:-------------|:---------|:------------|:-------------|
| ==         | Equal        | Symbol   | 1 == 1      | 5            |
| <          | LessThan     | Symbol   | 1 < 2       | 5            |
| <=         | LessThanOrEqual | Symbol   | 1 <= 1      | 5            |
| >          | GreaterThan  | Symbol   | 2 > 1       | 5            |
| >=         | GreaterThanOrEqual | Symbol   | 1 >= 1      | 5            |

### String ###

| **Symbol** | **Operator** | **Type** | **Example** | **Priority** |
|:-----------|:-------------|:---------|:------------|:-------------|
| substr     | Substring    | Function | substr( abcdef, 2, 4 ) | 20           |

### Boolean ###

| **Symbol** | **Operator** | **Type** | **Example** | **Priority** |
|:-----------|:-------------|:---------|:------------|:-------------|
| AND        | And          | Symbol   | true AND false | 4            |
| OR         | Or           | Symbol   | false OR true | 3            |
| NOT        | Not          | Symbol   | NOT false   | 20           |

### Date ###

| **Symbol** | **Operator** | **Type** | **Example** | **Priority** |
|:-----------|:-------------|:---------|:------------|:-------------|
| dateDifference | Date Difference | Function | dateDifference( date1, date2, Y ) | 20           |