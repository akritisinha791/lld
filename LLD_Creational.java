import java.util.*;

// ===================== MAIN DRIVER =====================
public class LLD_Creational_Assignment {

    public static void main(String[] args) {

        // ---------- 1. SINGLETON ----------
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.logInfo("System started");
        logger2.logError("Something failed");

        System.out.println("Same instance: " + (logger1 == logger2));
        System.out.println("Total logs: " + logger1.getLogCount());

        // ---------- 2. FACTORY ----------
        Notification n1 = NotificationFactory.createNotification("EMAIL");
        Notification n2 = NotificationFactory.createNotification("SMS");
        Notification n3 = NotificationFactory.createNotification("WHATSAPP");

        n1.send("Hello Email");
        n2.send("Hello SMS");
        n3.send("Hello WhatsApp");

        // ---------- 3. ABSTRACT FACTORY ----------
        UIFactory lightFactory = UIFactoryProvider.getFactory("LIGHT");
        Button lightBtn = lightFactory.createButton();
        TextBox lightText = lightFactory.createTextBox();

        lightBtn.render();
        lightText.render();

        // ---------- 4. BUILDER ----------
        Pizza pizza = new Pizza.Builder("MEDIUM")
                .addCheese()
                .addMushrooms()
                .build();

        System.out.println(pizza);

        // ---------- 5. PROTOTYPE ----------
        Document doc1 = new Document("Doc1", "Content1", Arrays.asList("tag1", "tag2"));
        Document doc2 = doc1.clone();

        doc2.tags.add("tag3");

        System.out.println("Original: " + doc1.tags);
        System.out.println("Clone: " + doc2.tags);
    }
}

//////////////////////////////////////////////////////////////////
// ===================== 1. SINGLETON ============================
//////////////////////////////////////////////////////////////////

class Logger {

    // TODO 1: Make this variable private static
    private static Logger instance;

    // TODO 2: Add a variable to track log count
    private int logCount = 0;

    // TODO 3: Make constructor private
    private Logger() {}

    public static synchronized Logger getInstance() {
        // TODO 4: Ensure only ONE instance is created
        // TODO 5: Make it thread-safe using synchronized keyword (basic way)
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logInfo(String msg) {
        // TODO 6: Increment log count
        // TODO 7: Print in format -> INFO: message
        logCount++;
        System.out.println("INFO: "+msg);
    }

    public void logError(String msg) {
        // TODO 8: Increment log count
        // TODO 9: Print in format -> ERROR: message
        logCount++;
        System.out.println("ERROR: " +msg);
    }

    public int getLogCount() {
        // TODO 10: return total logs
        return logCount;
    }
}

//////////////////////////////////////////////////////////////////
// ===================== 2. FACTORY ==============================
//////////////////////////////////////////////////////////////////

interface Notification {
    void send(String message);
}

// TODO 11: Implement EmailNotification
class EmailNotification implements Notification {
    public void send(String message) {
        // TODO: print "Sending EMAIL: message"
        System.out.println("Sending EMAIL: " + message);
    }
}

// TODO 12: Implement SMSNotification
class SMSNotification implements Notification {
    public void send(String message) {
        // TODO
        System.out.println("Sending SMS: " + message);
    }
}

// TODO 13: Implement WhatsAppNotification
class WhatsAppNotification implements Notification {
    public void send(String message) {
        // TODO
        System.out.println("Sending WHATSAPP: " + message);
    }
}

class NotificationFactory {

    public static Notification createNotification(String type) {

        // TODO 14:
        // if type = EMAIL -> return EmailNotification
        // if type = SMS -> return SMSNotification
        // if type = WHATSAPP -> return WhatsAppNotification

        // TODO 15: handle invalid input (return null or print message)
        if(type == null){ return null;}
        if(type.equalsIgnoreCase("EMAIL")){
            return new EmailNotification();
        } else if(type.equalsIgnoreCase("SMS")){
            return new SMSNotification();
        } else if(type.equalsIgnoreCase("WHATSAPP")){
            return new WhatsAppNotification();
        } else {
            System.out.println("Invalid notification type: " +type);
            return null;
        }
    }
}

//////////////////////////////////////////////////////////////////
// ===================== 3. ABSTRACT FACTORY =====================
//////////////////////////////////////////////////////////////////

interface Button {
    void render();
}

interface TextBox {
    void render();
}

interface UIFactory {
    Button createButton();
    TextBox createTextBox();
}

// ---------- LIGHT THEME ----------

// TODO 16: Create LightButton
class LightButton implements Button {
    public void render() {
        // TODO: print "Light Button"
    }
}

// TODO 17: Create LightTextBox
class LightTextBox implements TextBox {
    public void render() {
        // TODO
    }
}

// TODO 18: Create LightFactory
class LightFactory implements UIFactory {
    public Button createButton() {
        // TODO
        return null;
    }

    public TextBox createTextBox() {
        // TODO
        return null;
    }
}

// ---------- DARK THEME ----------

// TODO 19: Create DarkButton
class DarkButton implements Button {
    public void render() {
        // TODO
    }
}

// TODO 20: Create DarkTextBox
class DarkTextBox implements TextBox {
    public void render() {
        // TODO
    }
}

// TODO 21: Create DarkFactory
class DarkFactory implements UIFactory {
    public Button createButton() {
        // TODO
        return null;
    }

    public TextBox createTextBox() {
        // TODO
        return null;
    }
}

class UIFactoryProvider {

    public static UIFactory getFactory(String theme) {

        // TODO 22:
        // if LIGHT -> LightFactory
        // if DARK -> DarkFactory

        return null;
    }
}

//////////////////////////////////////////////////////////////////
// ===================== 4. BUILDER ==============================
//////////////////////////////////////////////////////////////////

class Pizza {

    private final String size;
    private final boolean cheese;
    private final boolean mushrooms;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.mushrooms = builder.mushrooms;
    }

    public static class Builder {

        // TODO 23: Add fields
        private String size;
        private boolean cheese;
        private boolean mushrooms;

        // TODO 24: Constructor with mandatory field size
        public Builder(String size) {
            this.size = size;
        }

        // TODO 25: addCheese()
        public Builder addCheese() {
            return this;
        }

        // TODO 26: addMushrooms()
        public Builder addMushrooms() {
            return this;
        }

        public Pizza build() {

            // TODO 27:
            // validate size is not null or empty

            return new Pizza(this);
        }
    }

    public String toString() {
        // TODO 28: print all fields properly
        return "";
    }
}

//////////////////////////////////////////////////////////////////
// ===================== 5. PROTOTYPE ============================
//////////////////////////////////////////////////////////////////

class Document implements Cloneable {

    String title;
    String content;
    List<String> tags;

    public Document(String title, String content, List<String> tags) {

        // TODO 29: assign values
        // IMPORTANT: create new ArrayList for tags
    }

    public Document clone() {

        // TODO 30:
        // create new object
        // deep copy tags list

        return null;
    }
}