# SymbolTable

Run of file: "Test.java" output:

Time linkedSymbolTable: 186.686sec
Number of a's: 14668
size of linkedSymbolTable: 28225
Time arraySymbolTable: 140.481sec
Number of a's: 14668
size of arraySymbolTable: 28225
Time hashmap: 7.233sec
size of hashMap: 28225
Number of a's: 14668
Time rbTree: 0.104sec
Number of a's: 14668
size of rbTree: 28225

Comments on the results:
The shakespear text has 28225 words in total and the number of a's are 14668 which i use to see if the alghoritm for putting elements into the list produces the same result. The data they produce looks correct. The time varies since the linkedlist and the array has O(n) running time and are therefore the slowest ones. Whereas the hashmap and the rbTree has O(log2(n)) and O(log3(n)).

Running time:
The linkedlist has O(n)
The arrayList has O(n)
The hashmap has O(log2(n))
The rbTree has O(log3(n))
