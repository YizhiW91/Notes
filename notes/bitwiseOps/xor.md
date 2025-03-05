# XOR

## How XOR works

```java
int a = 0b111000
int b = 0b100011
int c = a ^ b // c = 0b011011
```

## Common Use
```java
int a = 1
int b = 2

//commutative rule
a^b == b^a 
//associative rule
a^b^c == b^c^a 
// same number xor = 0
a^a == 0
// number xor 0 = number
a^0 == a
```

## Take first right most 1 from a number
```java
int a = 0b10001000
int rightMostOne = a&(~a+1)
// rightMostOne = 10001000 & (01110111+1=0111000) = 00001000
```