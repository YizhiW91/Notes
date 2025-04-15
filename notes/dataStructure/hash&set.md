# Hash

Common hash implementation for a string: k is some constant
* (first char) + k * (second char) + k^2 * (third char) + ...

## Comparison with arrays

* The biggest disadvantage of hash maps is that for smaller input sizes, they can be slower due to overhead.

* Hash tables can also take up more space. Dynamic arrays are actually fixed-size arrays that resize themselves when they go beyond their capacity. Hash tables are also implemented using a fixed size array - remember that the size is a limit set by the programmer. The problem is, resizing a hash table is much more expensive because every existing key needs to be re-hashed, and also a hash table may use an array that is significantly larger than the number of elements stored, resulting in a huge waste of space. 

## Collisions
If different keys converted to the same integer. it is called a collision in hashmap. Collisions are usually handled by `Chaining`, meaning hashmap stores linked lists inside the hash map's array instead of the elements themselves. The linked list nodes store both the key and the value. If there are collisions, the collided key-value pairs are linked together in a linked list. Then, when trying to access one of these key-value pairs, we traverse through the linked list until the key matches.

The most important thing is that the `number of buckets`(size of your hash table's array) and `modulus` is a prime number. Prime numbers near significant magnitudes that are common to use are:
* 10,007
* 1,000,003
* 1,000,000,007

Common number of buckets are power of 2s.


## Hashmap in C++ and Java
* C++
  * In C++, unordered_map and unordered_set does not support data structure that comes without hash function, for example pair and tuple. (C++20 pair comes with hash function, so it is no longer an issue.)
  * set and map do support pair and tuple as set and map uses operator `<` in the process instead of hash.
* Java
  * Hashset and Hashmap works the same way as unordered_map and unordered_set in C++. To make the entry hashable, one need to override equals() and hashCode() method.

How to make it work in cpp:
```cpp
struct pair_hash {
    size_t operator()(const pair<int, int>& p) const {
        // A simple but effective hash combining technique
        return hash<int>()(p.first) ^ (hash<int>()(p.second) << 1);
    }
};

int main() {
    unordered_set<pair<int, int>, pair_hash> mySet;
    mySet.insert({1, 2});
    mySet.insert({3, 4});

    if (mySet.count({1, 2})) {
        cout << "Found (1, 2)" << endl;
    }
}
```
How to make it work in Java:
```java
Set<Int> set = new HashSet<>();
set.add(convertToHash({1,2}));
System.out.println(set.contains(convertToHash({1,2}))); // true
```

# Set

The difference between a set and hash table is that sets do not map their keys to anything. Sets are more convenient to use when you only care about checking if elements exist. You can add, remove, and check if an element exists in a set all in O(1).


