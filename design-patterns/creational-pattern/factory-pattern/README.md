# Factory Design Pattern 

## Overview 

The Factory Design Pattern is a creational pattern used to encapsulate the instantiation logic of related objects without exposing the creation logic to the client. It provides a way to create objects based on a given input or condition.


##  Use Case

Use the Factory Pattern when:

- The exact type of the object may vary depending on some condition.

- The object creation code is complex or involves multiple steps.

- You want to centralize the object creation logic to improve maintainability.

## Advantages

- Promotes **loose coupling** between client and implementation.

- Simplifies object creation logic.

- Encourages **Single Responsibility Principle** by separating object creation from usage.

## Implementation 

### Real-World Example: Notification Service

Imagine an application that sends different types of notifications: Email, SMS, and Push. The Factory Pattern can help in creating the appropriate notifier object based on the input type.


### Step 1: Create a Common Interface

```java
public interface Notifier {
    void send(String message);
}
```

### Step 2: Implement Concrete Notifier Classes

```java

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

```

```java
public class SmsNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
```

```java
public class PushNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}
```


### Step 3: Create the Notifier Factory


```java
public class NotifierFactory {

    public static Notifier getNotifier(String type) {
        if (type == null) return null;

        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailNotifier();
            case "SMS":
                return new SmsNotifier();
            case "PUSH":
                return new PushNotifier();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

```

### Step 4: Usage 

```java

public class NotificationApp {
    public static void main(String[] args) {
        Notifier notifier = NotifierFactory.getNotifier("email");
        notifier.send("Your OTP is 123456");

        notifier = NotifierFactory.getNotifier("sms");
        notifier.send("Your package has shipped.");
    }
}

```