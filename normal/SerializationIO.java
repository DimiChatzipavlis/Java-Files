import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Demonstrates Object Serialization (saving Java objects to files).
 * 
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. Compile: javac SerializationIO.java
 * 3. Run:     java SerializationIO
 * 
 * Concepts covered:
 * 1. Serializable interface
 * 2. ObjectOutputStream (Serialization)
 * 3. ObjectInputStream (Deserialization)
 */
public class SerializationIO {

    // Static nested class: it must implement Serializable to be saved.
    // It is 'static' on purpose: a non-static inner class keeps a hidden reference
    // to the outer SerializationIO object, which is not Serializable.
    static class User implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int age;
        transient String password; // 'transient' fields are NOT saved

        public User(String name, int age, String password) {
            this.name = name;
            this.age = age;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{name='" + name + "', age=" + age + ", password='" + password + "'}";
        }
    }

    public static void main(String[] args) {
        String fileName = "user_data.ser";
        User user = new User("Alice", 30, "Secret123");

        System.out.println("--- Object Serialization Example ---");

        // 1. Serialize (Save object to file)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            System.out.println("1. Serializing object: " + user);
            out.writeObject(user);
            System.out.println("   Object saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Deserialize (Load object from file)
        System.out.println("\n2. Deserializing object from file...");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            User loadedUser = (User) in.readObject();
            System.out.println("   Loaded Object: " + loadedUser);
            System.out.println("   (Note: 'password' is null because it was marked transient)");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
