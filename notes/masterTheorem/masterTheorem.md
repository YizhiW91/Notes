# Master Theorem (analysis of algorithms complexity)

## Fomula
```math
{T(n)=a\;T\left({\frac {n}{b}}\right)+f(n),}
```

* T(N) is the size of the parent calculation.
* a is the number of times the child calculation needed in each recursion.
* T(N/b) is the size of the child calculation for each recursion.
* b is how many subsets are divided into from the parent calculation in recursion.
* f(n) is the extra calculation of the recursion.

## Condition

```math
\text{when} f(n) = O(n^c)\\

\text{if}  \log_{b}a < c, \text{then}  T(n) ~ O(n^c)\\
\text{if}  \log_{b}a > c, \text{then}  T(n) ~ O(n^{\log_{b}a})\\
\text{if}  \log_{b}a = c, \text{then}  T(n) ~ O(nlogN)


```