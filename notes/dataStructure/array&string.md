# Array & String

## Difference in Language

### String
* Java and Python has immutable String, meaning foo = "abc", if one needs to change it to "abd", the whole string needs to be recreated.
* C++ has mutable String.

### Array
* Array has fixed length or dynamic. Most of the language uses dynamic length. The space allocation usually happens at max capacity by doubling the capacity, etc. vector in C++ or ArrayList in Java.


## Operation Complexity

| Ops  | Array/List | String(Immutable) |
|---|---|---|
| Appending to end | *O(1) | O(n) |
| Pop from end | O(1) | O(n)
| Insert, not from end | O(n) | O(n)
| Delete, not from end | O(n) | O(n)
| Modify an element | O(1) | O(n)
| Random Access | O(1) | O(1)
| Check if element exists | O(n) | O(n)