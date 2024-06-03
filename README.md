# Data Structures & Algorithms in Java

This project provides custom implementations of fundamental data structures and collections in Java. The goal is to mimic the behavior and structure of the Java Collections Framework, providing a deeper understanding of how these data structures work under the hood.

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Implemented Interfaces](#implemented-interfaces)
- [Implemented Classes](#implemented-classes)
- [How to Use](#how-to-use)
- [Running Tests](#running-tests)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project includes custom implementations of key data structures such as lists, queues, and sets. It also includes various interfaces to define the behavior of these data structures, similar to the Java Collections Framework.

## Project Structure

```
DataStructuresAlgorithms/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── jethroau/
│   │   │   │   │   ├── dsa/
│   │   │   │   │   │   ├── collections/         // Collection interfaces
│   │   │   │   │   │   │   ├── Collection.java
│   │   │   │   │   │   │   ├── List.java
│   │   │   │   │   │   │   ├── Queue.java
│   │   │   │   │   │   │   ├── Set.java
│   │   │   │   │   │   │   ├── Deque.java
│   │   │   │   │   │   │   ├── SortedSet.java
│   │   │   │   │   │   │   ├── NavigableSet.java
│   │   │   │   │   │   │   ├── SortedMap.java
│   │   │   │   │   │   │   ├── NavigableMap.java
│   │   │   │   │   │   │   └── Iterator.java
│   │   │   │   │   │   ├── lists/               // List implementations
│   │   │   │   │   │   │   ├── ArrayList.java
│   │   │   │   │   │   │   └── LinkedList.java
│   │   │   │   │   │   ├── queues/              // Queue implementations
│   │   │   │   │   │   └── util/                // Utility classes (if any)
│   │   ├── resources/                          // Resources such as configuration files
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── jethroau/
│   │   │   │   │   ├── dsa/
│   │   │   │   │   │   ├── collections/         // Collection interfaces tests
│   │   │   │   │   │   │   ├── CollectionTest.java
│   │   │   │   │   │   │   └── ListTest.java
│   │   │   │   │   │   ├── lists/               // List implementations tests
│   │   │   │   │   │   │   ├── ArrayListTest.java
│   │   │   │   │   │   │   └── LinkedListTest.java
│   │   │   │   │   │   ├── queues/              // Queue implementations tests
│   │   │   │   │   │   └── util/                // Utility classes tests
│   ├── └── resources/                           // Test resources
```

## Implemented Interfaces

- Collection
- List
- Queue
- Set
- Deque
- SortedSet
- NavigableSet
- SortedMap
- NavigableMap
- Iterator

## Implemented Classes
- ArrayList
- LinkedList
- Coming soon...

## How to Use

To use the custom data structures, you can create instances of the implemented classes and interact with them using the methods defined in their respective interfaces.

Example:

```
import com.jethroau.dsa.lists.ArrayList;
import com.jethroau.dsa.collections.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        System.out.println(list.get(0)); // Outputs: apple
        System.out.println(list.get(1)); // Outputs: banana
    }
}
```

## Running Tests
To run the tests for the implemented data structures, you can use a testing framework like JUnit. The test classes are located in the src/test/java/com/jethroau/dsa/ directory.

#### Running Tests Using Maven

If you are using Maven, you can run the tests using the following command:

```sh
mvn test
```

## Contributing

Contributions are welcome! If you find a bug or want to add a new feature, feel free to open an issue or submit a pull request.

#### How to Contribute
1. Fork the repository.
2. Create a new branch (git checkout -b feature-branch).
3. Make your changes.
4. Commit your changes (git commit -am 'Add new feature').
5. Push to the branch (git push origin feature-branch).
6. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
