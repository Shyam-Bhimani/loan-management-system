# Core Spring Framework Configuration — Reference Notes

This guide covers core inversion of control (IoC) and dependency injection configuration strategies within the **Spring Framework**.

---

## 1. @Configuration
An annotation placed on a Java class to declare it as a **source of bean definitions**.
* It marks the class as a bootstrap engine for the IoC container.
* Behind the scenes, Spring processes this class using CGLIB to proxy methods, ensuring that singleton execution contracts are honored across cross-bean calls.

## 2. @Bean
A method-level annotation used within `@Configuration` classes to explicitly declare a bean managed by the container.
* **Granular Control:** You instantiate the object manually inside the method using the `new` keyword, customize it, and return it.
* **Third-Party Integration:** It is the primary way to register classes from external or third-party libraries (like Jackson, DataSource, or Apache Commons) into your application context since you cannot add `@Component` to their compiled source code.

## 3. @Component
A class-level annotation indicating that the annotated class is a auto-scannable candidate for application context registration.
* **Stereotype Annotation:** It acts as the generic meta-annotation parent for specialized architectural roles: `@Service`, `@Repository`, and `@Controller`.
* **Container-Managed:** Spring controls instantiation using standard reflection, expecting a accessible constructor.

## 4. @ComponentScan
An annotation attached to a `@Configuration` class to define the structural boundary where Spring should look for `@Component` stereotyper classes.
* **Package Anchors:** You can supply explicit package names (`basePackages = "com.app"`) or safe anchor classes (`basePackageClasses = CoreMarker.class`).
* **Implicit Behavior:** If no packages are declared, Spring defaults to scanning from the exact package of the declaring class downward into all sub-packages.

## 5. Component Scanning
The scanning process where the container parses classpath bytecode during context bootstrap looking for component stereotypes.
* **Blueprint Generation:** When a candidate class matches the scanning criteria, Spring registers a new metadata `BeanDefinition` instance for it.
* **Automation:** It eliminates manual java configuration steps, creating a highly modular and pluggable structural pattern.

## 6. Bean Naming
The convention logic Spring relies on to assign unique identifier strings to beans in the registry.
* **Component Default:** For classes found via automated scanning, Spring converts the short class name to **camelCase** (e.g., `LoanService` becomes `loanService`). If the first two characters are uppercase (`LLDService`), the name remains unchanged.
* **@Bean Method Default:** For factory methods, the bean name matches the **exact method name** unless overridden explicitly via property parameters like `@Bean("customName")`.

## 7. @Primary
An annotation indicating that a specific bean should be given **automatic precedence** when multiple matching candidate beans exist for a single-valued dependency target.
* **Tie-Breaker:** It establishes a clear fallback strategy without requiring configuration structural adjustments at injection sites.
* **Contextual Limitation:** If multiple conflicting beans are marked with `@Primary` for the same interface target type, Spring fails with an ambiguous resolution exception.

## 8. @Qualifier
An annotation used to provide **explicit bean name filtering** at the exact point of dependency injection.
* **Target Isolation:** Used alongside `@Autowired` or constructor parameters to pass the unique name string of the exact instance you need (e.g., `@Qualifier("secureStorage")`).
* **Precedence:** `@Qualifier` is highly specific and overrides any structural defaults specified globally via `@Primary`.

## 9. @Import
An annotation used to cleanly partition configuration classes by pulling secondary metadata configurations into a primary configuration anchor.
* **Modularization:** It prevents a single monolithic configuration class by letting you link separate domains: `@Import({SecurityConfig.class, DatabaseConfig.class})`.
* **Registration Power:** Can be used to import functional implementations of `ImportSelector` or `ImportBeanDefinitionRegistrar` to conditionally generate dynamic definitions based on system states.

## 10. Full vs Lite Configuration Modes
The state modes Spring applies to a configuration source based on how it is defined.
* **Full Mode:** Triggered when a class is annotated with `@Configuration`. Spring uses CGLIB interceptor proxies on the class methods. If one `@Bean` method calls another `@Bean` method, the call is intercepted to safely return the existing singleton instance from the container cache.
* **Lite Mode:** Triggered when `@Bean` methods are placed inside an ordinary class (like a `@Component` or plain class). No proxying occurs. Inter-method calls behave as standard plain old Java method invocations, creating **duplicate object instances** and breaking singleton contracts.

## 11. proxyBeanMethods
A boolean property modifier on `@Configuration(proxyBeanMethods = false)` introduced to eliminate startup overhead.
* **Performance Gain:** Setting this to `false` forces the configuration class into **Lite mode**, disabling CGLIB proxy generation. This improves startup performance and lowers memory usage.
* **Usage Rule:** Use this safely when your configuration's `@Bean` methods are completely independent and never directly call each other to fulfill internal dependencies.

## 12. @Bean vs @Component
While both declare Spring-managed objects, they serve entirely different engineering needs:

| Characteristic | `@Component` | `@Bean` |
| :--- | :--- | :--- |
| **Target Level** | Class-level annotation. | Method-level annotation. |
| **Instantiation** | Automated by Spring via reflection. | Manual control inside the method body via code logic. |
| **Source Access** | Requires direct access to edit the class source code. | Can wrap any class, making it perfect for external third-party libraries. |
| **Configuration** | Implicitly found during classpath structural scans. | Explicitly declared inside a `@Configuration` framework class. |
