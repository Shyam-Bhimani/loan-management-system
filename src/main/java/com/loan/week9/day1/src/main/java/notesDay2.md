# Spring Core Framework Notes 🚀

## 1. Bean vs Bean Definition
* **Bean Instance:** The actual live Java object allocated in the JVM heap memory, managed fully by the Spring IoC container.
* **Bean Definition:** The abstract configuration metadata (the "blueprint" or "recipe"). Represented by the `BeanDefinition` interface, it tells Spring the bean's class name, scope, factory methods, constructor arguments, and initialization/destruction steps.

## 2. Bean Lifecycle
The exact execution sequence from creation to garbage collection within the container:
1. **Instantiation:** Spring creates the raw Java instance using the class constructor.
2. **Populate Properties (DI):** Spring injects dependencies via fields, setters, or constructor arguments.
3. **Initialization (`@PostConstruct`):** Spring calls custom initialization logic after property configuration.
4. **In Use:** The bean sits in the application context ready to handle business requests.
5. **Destruction (`@PreDestroy`):** Spring executes cleanup methods during context shutdown before garbage collection.

## 3. @PostConstruct
* A Jakarta annotation used on a method to declare custom initialization logic.
* Runs **exactly once**, immediately *after* Spring completes dependency injection but *before* the bean is put into service.
* Best used for establishing initial connections, validation checks, or caching startup states.

## 4. @PreDestroy
* A Jakarta annotation used on a method to declare cleanup tasks.
* Fires during a **graceful shutdown** of the `ApplicationContext` (via `context.close()` or a JVM shutdown hook).
* Used to close database pools, terminate active threads, or release system resources.

## 5. Singleton Scope
* **Default Scope:** The default scope for all Spring beans.
* **Behavior:** Spring creates exactly **one shared instance** per container. Every request or injection for that bean reference returns the exact same object instance.
* **Thread Safety:** Singletons should ideally be stateless, as they are accessed concurrently by multiple threads.

## 6. Prototype Scope
* **Behavior:** Spring creates a **brand-new instance** every single time the bean is requested from the context (`context.getBean()`) or injected into another component.
* **Lifecycle Lifecycle Catch:** Spring does *not* manage the complete lifecycle of a prototype bean. It handles instantiation, configuration, and initialization, but completely drops the reference afterward. **`@PreDestroy` hooks are never called on Prototype beans.**

## 7. Request Scope
* **Web-Aware:** Valid only within a web-aware Spring ApplicationContext.
* **Behavior:** Spring creates a single bean instance for the lifecycle of a single **HTTP request**. The instance is destroyed automatically when the HTTP request completes.

## 8. Session Scope
* **Web-Aware:** Valid only within a web-aware Spring ApplicationContext.
* **Behavior:** Spring creates a single bean instance for the duration of an entire **HTTP Session**. The same instance is shared across multiple HTTP requests originating from the same user session.

## 9. Application Scope
* **Web-Aware:** Valid only within a web-aware Spring ApplicationContext.
* **Behavior:** Scopes a single bean definition to the lifecycle of a `ServletContext`. Unlike a Singleton which is unique per Spring Container, an Application-scoped bean is shared globally across all servlet instances running inside the web application deployment.

## 10. WebSocket Scope
* **Web-Aware:** Valid only within a web-aware Spring ApplicationContext.
* **Behavior:** Scopes a single bean definition to the lifecycle of a **WebSocket session**. It allows you to maintain stateful attributes bound strictly to that specific, long-lived bidirectional communication channel.

## 11. Eager vs Lazy Initialization
* **Eager Initialization (Default):** Beans are created during container startup. It helps catch configuration and wiring errors immediately on startup, but consumes more memory early on.
* **Lazy Initialization (`@Lazy`):** The bean creation is deferred until the exact moment it is explicitly requested or called for the first time. It speeds up application startup times but delays the detection of errors to runtime.

## 12. Prototype inside Singleton (The Prototype Trap)
* **The Problem:** When you inject a `Prototype` bean into a `Singleton` bean, the injection occurs **only once** when the singleton is being instantiated. Consequently, the singleton holds onto that single prototype instance forever, effectively neutralising its prototype behavior.
* **The Solution:**
    1. Use **`@Lookup` method injection** so Spring overrides a method to dynamically pull a fresh instance from the context.
    2. Inject an **`ObjectProvider<MyPrototype>`** or standard **`ApplicationContext`** to programmatically fetch a new instance at runtime.
    3. Apply scoped proxies (`@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)`).