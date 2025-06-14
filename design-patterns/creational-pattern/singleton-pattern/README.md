# Singleton Design Pattern

The **Singleton Pattern** ensures that a class has **only one instance** and provides a **global access point** to that instance.

In high-scale applications (e.g., config managers, logging systems, connection pools), it is **critical** to ensure:

- Thread safety

- Lazy initialization

- Low overhead

- Resilience to serialization/reflection attacks

## Different ways to create singleton class:

1. Eager Initialization
2. Lazy Initialization
3. Synchronization block
4. Double check locking
5. Bill Pugh 
6. Enum Singleton

## Real-World Use Case

Let’s say you're building a Centralized Configuration Manager in a distributed microservices system. You want only one config instance in each service runtime to avoid redundant I/O, ensure consistent reads, and improve performance.

## Approaches to Singleton in Java

### 1. Eager Initialization

```java
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

```

**Pros:**

- Simple, thread-safe

- No locking

**Cons:**

- Not lazy; instance is created even if unused

--- 

### 2. Lazy Initialization ( Non-thread-safe )

```java
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

```

**Cons:**

- Not thread-safe — multiple instances may be created in concurrent scenarios

---

### 3. Synchronized block Singleton

```java

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}


```

**Pros:** Thread-safe

**Cons:** Performance hit due to full method-level synchronization

---

### 4. Double-Checked Locking 

```java
public class SingletonClass {
    private static volatile SingletonClass instance;

    private SingletonClass() {}

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}


```

**Pros:**

- Thread-safe and performant

- Lazy initialization

**Cons:**

- Requires volatile for correct behavior
- Slow because we are not using cache 

> When we use volatile it directly check from memory skipping the L1 cache

---

### 5. Bill Pugh Singleton 

> Best for most case 

```java
public class SingletonByBillPugh {
    private SingletonByBillPugh() {}

    private static class Holder {
        private static final SingletonByBillPugh INSTANCE = new SingletonByBillPugh();
    }

    public static SingletonByBillPugh getInstance() {
        return Holder.INSTANCE;
    }
}

```

**Pros:**

- Thread-safe
- Lazy initialization without synchronization
- High performance

> Nested classes (such as static inner classes) are not loaded into memory at application startup. They are loaded only when they are first accessed.

> This behavior is key to the **Bill Pugh Singleton Pattern**

---

### 6. Enum Singleton

> Best against serialization/reflection 

```java
public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
       
    }
}

```

**Pros:**

- Thread-safe, serialization-safe, reflection-safe
- Short and effective

**Cons:**

- Not suitable when lazy loading or inheritance is required

> By default all constructors are private in Enum 

> Only one object per **JVM** is created for Enum 