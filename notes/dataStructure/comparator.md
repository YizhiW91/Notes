# Comparators in C++ and Java

## C++ Comparators

### 1. **Using `std::sort` with a Comparator**

In C++, you can use the `std::sort` function with a custom comparator to define how elements should be ordered.

#### **Rule:**
When comparing `a` and `b`, return `true` if `a` should appear before `b` in the sorted order, otherwise return `false`.

#### **Example: Sorting Integers in Descending Order**

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

bool customComparator(int a, int b) {
    return a > b; // Sort in descending order
}

int main() {
    std::vector<int> vec = {5, 3, 8, 1, 2};
    std::sort(vec.begin(), vec.end(), customComparator);

    for (int num : vec) {
        std::cout << num << " ";
    }
    return 0;
}
```

**Output:**

```
8 5 3 2 1
```

### 2. **Using Lambda Functions as Comparators**

Instead of defining a separate function, you can use a **lambda function**:

```cpp
std::sort(vec.begin(), vec.end(), [](int a, int b) { return a > b; });
```

### 3. **Using `std::set` and `std::map` with Custom Comparators**

```cpp
#include <iostream>
#include <set>

struct CustomCompare {
    bool operator()(int a, int b) const {
        return a > b; // Descending order
    }
};

int main() {
    std::set<int, CustomCompare> mySet = {5, 1, 3, 8};
    for (int num : mySet) {
        std::cout << num << " ";
    }
    return 0;
}
```

## Java Comparators

### 1. **Using `Comparator` Interface**

Java provides the `Comparator<T>` interface to define custom sorting logic.

#### **Rule:**
When comparing `a` and `b`, return a **negative** value if `a` should appear before `b`, **zero** if they are equal, and a **positive** value if `b` should appear before `a`.

#### **Example: Sorting in Descending Order**

```java
import java.util.*;

class DescendingComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a; // Descending order
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 8, 1, 2);
        Collections.sort(list, new DescendingComparator());
        System.out.println(list);
    }
}
```

**Output:**

```
[8, 5, 3, 2, 1]
```

### 2. **Using Lambda Expressions**

In Java 8+, you can use lambdas for comparators:

```java
Collections.sort(list, (a, b) -> b - a);
```

### 3. **Using `TreeSet` and `TreeMap` with Custom Comparators**

```java
TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
```

## Summary

| Feature                   | C++                                            | Java                                        |
| ------------------------- | ---------------------------------------------- | ------------------------------------------- |
| Function-based Comparator | Function pointers, lambdas                     | `Comparator<T>` interface, lambdas          |
| Default Sorting           | `std::sort()` (ascending by default)           | `Collections.sort()` (ascending by default) |
| Custom Sorting            | `std::sort()` with comparator                  | `Collections.sort()` with `Comparator<T>`   |
| Data Structures           | `std::set`, `std::map` with custom comparators | `TreeSet`, `TreeMap` with `Comparator<T>`   |

Both **C++ and Java** provide ways to define **custom sorting logic** via **comparators**. While C++ uses **function pointers, functors, and lambdas**, Java relies on the **`Comparator<T>` interface and lambda expressions**.

