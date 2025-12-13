# Java Files Concepts Repository

This repository contains a collection of Java examples demonstrating File I/O operations, ranging from basic legacy techniques to advanced modern APIs. The examples are categorized into two sections: **Normal** and **Advanced**.

## Project Structure

```
Java-Files/
├── normal/
│   ├── BasicFileIO.java      # Legacy java.io examples (File, FileWriter, Scanner)
│   ├── BufferedIO.java       # Efficient reading/writing (BufferedReader, BufferedWriter)
│   ├── SerializationIO.java  # Saving objects to files (ObjectOutputStream)
│   └── PropertiesIO.java     # Managing configuration files (Properties)
├── advanced/
│   ├── ModernFileIO.java     # Modern java.nio.file examples (Path, Files)
│   └── FileTreeWalker.java   # Recursive directory traversal (SimpleFileVisitor)
└── README.md
```

---

## 1. Normal Section (Legacy I/O)

The `normal` directory contains examples using the traditional `java.io` package, which has been part of Java since version 1.0.

### `BasicFileIO.java`
This file demonstrates the fundamental building blocks of file handling.
*   **Key Concepts:** `File`, `FileWriter`, `Scanner`.
*   **What it does:** Creates a file, writes text, and reads it back.

### `BufferedIO.java`
This file demonstrates how to improve I/O performance by reducing disk access.
*   **Key Concepts:** `BufferedReader`, `BufferedWriter`.
*   **What it does:** Writes multiple lines efficiently and reads them back line-by-line.

### `SerializationIO.java`
This file demonstrates how to save entire Java objects to a file and restore them later.
*   **Key Concepts:** `Serializable`, `ObjectOutputStream`, `ObjectInputStream`.
*   **What it does:** Saves a `User` object to a binary file and loads it back.

### `PropertiesIO.java`
This file demonstrates how to handle configuration files (key-value pairs).
*   **Key Concepts:** `java.util.Properties`.
*   **What it does:** Saves application settings to a `.properties` file and reads them.

---

## 2. Advanced Section (Modern NIO.2)

The `advanced` directory focuses on the Non-blocking I/O 2 (NIO.2) API introduced in Java 7 (`java.nio.file`). This is the recommended approach for new Java projects.

### `ModernFileIO.java`
This file showcases the cleaner, more efficient, and exception-safe way to handle files.
*   **Key Concepts:**
    *   `java.nio.file.Path` & `Paths`: A more versatile replacement for the `File` class.
    *   `java.nio.file.Files`: A utility class containing static methods for all common file operations.
    *   `StandardOpenOption`: Enums to specify how files should be opened (CREATE, APPEND, etc.).
*   **What it does:**
    1.  Writes text and lists of strings to `example_nio.txt` in one line of code.
    2.  Reads all lines from the file into a List.
    3.  Copies the file to `example_nio_copy.txt`.
    4.  Checks file attributes (existence, writability).

### `FileTreeWalker.java`
This file demonstrates how to traverse directory structures recursively, which is complex with legacy I/O but simple with NIO.
*   **Key Concepts:**
    *   `Files.walkFileTree()`: The engine that walks the file tree.
    *   `SimpleFileVisitor`: A class you extend to define what to do when visiting a file or directory.
*   **What it does:**
    1.  Starts at the current directory (`.`).
    2.  Recursively visits every file and folder.
    3.  Prints the name of every directory and file found, along with file sizes.

---

## How to Run the Examples

You can run these files using the command line or a terminal in VS Code. The files have been simplified to run directly from their folders without complex package commands.

### Prerequisites
*   Ensure you have the **Java Development Kit (JDK)** installed.
*   Verify by running `java -version` in your terminal.

### Running the Normal Examples

1.  Navigate to the `normal` directory:
    ```powershell
    cd normal
    ```
2.  Compile and Run **BasicFileIO**:
    ```powershell
    javac BasicFileIO.java
    java BasicFileIO
    ```
3.  Compile and Run **BufferedIO**:
    ```powershell
    javac BufferedIO.java
    java BufferedIO
    ```
4.  Compile and Run **SerializationIO**:
    ```powershell
    javac SerializationIO.java
    java SerializationIO
    ```
5.  Compile and Run **PropertiesIO**:
    ```powershell
    javac PropertiesIO.java
    java PropertiesIO
    ```

### Running the Advanced Examples

1.  Navigate to the `advanced` directory:
    ```powershell
    cd advanced
    ```
2.  Compile and Run ModernFileIO:
    ```powershell
    javac ModernFileIO.java
    java ModernFileIO
    ```
3.  Compile and Run FileTreeWalker:
    ```powershell
    javac FileTreeWalker.java
    java FileTreeWalker
    ```

### Inspecting Output
*   **BasicFileIO**: Look for `example_basic.txt` in the `normal` folder.
*   **ModernFileIO**: Look for `example_nio.txt` and `example_nio_copy.txt` in the `advanced` folder.
*   **FileTreeWalker**: Check the terminal output for a list of files in the current directory.