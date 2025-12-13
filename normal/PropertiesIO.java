import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Demonstrates managing configuration files using java.util.Properties.
 * 
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. Compile: javac PropertiesIO.java
 * 3. Run:     java PropertiesIO
 * 
 * Concepts covered:
 * 1. Properties class (Key-Value pairs)
 * 2. Storing properties to a file
 * 3. Loading properties from a file
 */
public class PropertiesIO {

    public static void main(String[] args) {
        String fileName = "config.properties";
        Properties appProps = new Properties();

        System.out.println("--- Properties File Example ---");

        // 1. Set and Save Properties
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            appProps.setProperty("app.name", "JavaFileManager");
            appProps.setProperty("app.version", "1.0.0");
            appProps.setProperty("window.width", "800");
            appProps.setProperty("window.height", "600");

            System.out.println("1. Saving properties to " + fileName);
            appProps.store(out, "Application Configuration"); // Adds a comment header
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Load Properties
        System.out.println("\n2. Loading properties from file...");
        Properties loadedProps = new Properties();
        try (FileInputStream in = new FileInputStream(fileName)) {
            loadedProps.load(in);
            
            System.out.println("   App Name: " + loadedProps.getProperty("app.name"));
            System.out.println("   Version:  " + loadedProps.getProperty("app.version"));
            System.out.println("   Width:    " + loadedProps.getProperty("window.width"));
            
            // Listing all
            System.out.println("\n   All Properties:");
            loadedProps.forEach((k, v) -> System.out.println("   - " + k + ": " + v));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
