package advanced;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Demonstrates advanced file system traversal using the Visitor pattern.
 * Concepts covered:
 * 1. Files.walkFileTree
 * 2. SimpleFileVisitor
 * 3. Recursively processing directories
 * 4. Handling file attributes
 */
public class FileTreeWalker {

    public static void main(String[] args) {
        // Start walking from the current directory (or specify another path)
        Path startPath = Paths.get(".");

        System.out.println("Scanning directory tree starting at: " + startPath.toAbsolutePath());

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Directory: " + dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("   File: " + file.getFileName() + " (" + attrs.size() + " bytes)");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Failed to access: " + file + " (" + exc.getMessage() + ")");
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
