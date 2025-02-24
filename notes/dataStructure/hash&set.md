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


# Set

The difference between a set and hash table is that sets do not map their keys to anything. Sets are more convenient to use when you only care about checking if elements exist. You can add, remove, and check if an element exists in a set all in O(1).