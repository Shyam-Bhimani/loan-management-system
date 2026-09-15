# Spring Framework Core Concepts

## 1. What Problem Does Spring Solve?
Before the Spring Framework existed, building enterprise Java applications relied heavily on Enterprise JavaBeans (EJB). EJBs were notoriously heavy, bloated, and tightly tied to application servers. Developers had to write vast amounts of boilerplate code just to manage database connections, transactions, and object creation.

Because components had to manually look up or instantiate their dependencies, systems became tightly coupled. This made the codebase rigid, hard to maintain, and incredibly difficult to unit test without booting up an entire server. Spring solves these problems by handling the infrastructure plumbing. It provides a lightweight container that automates object management, eliminates boilerplate, and enforces architectural decoupling, allowing developers to focus purely on business logic.

---

## 2. What is IoC (Inversion of Control)?
In traditional programming, your application code controls the flow of execution and manually instantiates dependent objects (e.g., using the `new` keyword). **Inversion of Control (IoC)** flips this responsibility.

Instead of your code creating and managing the lifecycle of objects, you delegate that control to an external framework—in this case, Spring. The framework becomes the driver, orchestrating when objects are created, how they are configured, and when they are destroyed. Your code changes from active manager to passive participant, waiting to be invoked by the framework.

---

## 3. What is DI (Dependency Injection)?
**Dependency Injection (DI)** is the practical design pattern used to achieve Inversion of Control. If a class requires another helper class to do its job, that helper class is a "dependency."

Instead of allowing the class to create its own dependency, the framework "injects" (supplies) the required object from the outside. The target class simply exposes a way to accept the dependency (like a constructor or a setter), and Spring pushes the required instance into it at runtime.

---

## 4. IoC vs DI
While often used interchangeably, they represent two different levels of abstraction:
*   **IoC is the concept:** It is a broad design principle stating that control should be inverted. It doesn't specify *how* to invert it; it just states the goal.
*   **DI is the implementation:** It is the specific pattern Spring uses to realize IoC.

Think of IoC as the *strategy* (delegating control) and DI as the *tactic* (passing dependencies into constructors or methods).

---

## 5. What is a Bean?
In Spring, a **Bean** is simply any Java object that is instantiated, configured, assembled, and managed by the Spring IoC container.

Not every Java object in your application is a bean—only the ones you explicitly flag for Spring to manage. Beans form the structural components of your application layer (like services, controllers, and repositories) and are usually managed as singletons by default.

---

## 6. What is ApplicationContext?
The **ApplicationContext** is the brain of the Spring framework. It is the advanced IoC container interface responsible for managing the entire lifecycle of your beans.

It reads your configuration metadata (annotations like `@Component` or Java configuration classes), instantiates the beans in the correct order based on their relationships, hooks them together, and holds them in a centralized registry. Beyond managing beans, it handles advanced enterprise tasks like event publication, internationalization, and AOP integration.

---

## 7. Constructor vs Setter vs Field Injection

| Injection Type | Mechanism | Best Used For | Pros & Cons |
| :--- | :--- | :--- | :--- |
| **Constructor Injection** | Dependencies are passed through the class constructor during instantiation. | Mandatory, immutable dependencies. | **Pros:** Enforces completeness, allows `final` fields.<br>**Cons:** Can look verbose with many dependencies. |
| **Setter Injection** | The object is created first, then dependencies are passed via standard setter methods. | Optional or modifiable dependencies. | **Pros:** Flexible, allows re-injection later.<br>**Cons:** Object can exist in a partially initialized, invalid state. |
| **Field Injection** | Dependencies are injected directly into private fields using reflection (via `@Autowired`). | Quick prototyping or legacy code. | **Pros:** Very clean look with minimal code.<br>**Cons:** Hides dependencies, violates encapsulation, breaks easy unit testing. |

---

## 8. Why Constructor Injection?
Spring strongly recommends **Constructor Injection** as the industry standard because:
1.  **Immutability:** It lets you declare dependency fields as `final`. Once the object is created, its dependencies cannot be accidentally changed or corrupted.
2.  **Guaranteed Initialization:** You cannot instantiate the class without providing the required dependencies. This completely eliminates the risk of encountering a `NullPointerException` at runtime due to a missing component.
3.  **Testability:** It makes unit testing incredibly easy. You don't need Spring or reflection tricks to test the class; you can simply pass mock objects directly into the constructor using standard Java code.

---

## 9. @Component vs @Service vs @Repository
All three annotations tell Spring to register the class as a managed Bean, but they carry distinct semantic meanings:
*   **`@Component`:** The general-purpose, foundational stereotype annotation. Use it for utility classes or generic components that don't fit into a specific architectural layer.
*   **`@Service`:** A specialized form of `@Component` meant for the **business logic layer**. It indicates that the class contains the core workflows and domain calculations of your application.
*   **`@Repository`:** A specialized form of `@Component` meant for the **data access layer (DAO)**. Beyond creating a bean, it tells Spring to automatically translate low-level SQL or database exceptions into Spring's readable `DataAccessException` hierarchy.

---

## 10. Spring Object Creation Flow
When you start a Spring Boot application, the container follows a precise sequence to bring your objects to life:
1.  **Scanning:** Spring scans the designated packages looking for classes marked with stereotype annotations (like `@Component`, `@Service`, or `@Repository`).
2.  **Metadata Parsing:** It builds "Bean Definitions"—internal blueprints mapping out the classes, their scopes, and what dependencies they require.
3.  **Instantiation:** Spring looks at the dependency graph and starts instantiates the objects using their constructors, creating the foundational beans first.
4.  **Dependency Injection:** Once the raw instances are created, Spring populates their fields and calls setters to inject downstream dependencies.
5.  **Initialization:** Spring executes initialization callbacks (like `@PostConstruct` or `InitializingBean` methods) to run any setup logic.
6.  **Ready for Use:** The fully formed, wired bean is stored in the `ApplicationContext` cache, ready to be handed to the application when requested.
