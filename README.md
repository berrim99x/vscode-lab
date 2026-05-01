# VSCode Lab - Development Labs

<div align="center">

![GitHub repo size](https://img.shields.io/github/repo-size/AbdelhakimBerrim/vscode-lab)
![GitHub last commit](https://img.shields.io/github/last-commit/AbdelhakimBerrim/vscode-lab)
![GitHub stars](https://img.shields.io/github/stars/AbdelhakimBerrim/vscode-lab?style=social)

</div>

---

## 👨‍💻 Student Information

| Field | Details |
|-------|---------|
| **Full Name** | Abdelhakim Berrim |
| **GitHub** | [@berrim99x](https://github.com/berrim99x) |
| **Original Repo** | [mbeggas/vscode-lab](https://github.com/mbeggas/vscode-lab) |

---

## 📋 Table of Contents

- [Lab 01 - Python Development](#-lab-01-python-development)
- [Lab 02 - Building Java Applications Using Gradle](#-lab-02-building-java-applications-using-gradle)
- [Lab 03 - Refactoring Java Code](#-lab-03-refactoring-java-code)
- [Project Structure](#-project-structure)
- [Commits Summary](#-commits-summary)

---

## 🐍 Lab 01: Python Development

### Objectives
- Set up a Python project and write functions
- Debug and fix buggy code using tests
- Handle edge cases with exceptions

### Parts Completed

#### ✅ Part 1 — Greet Function
Implemented a `greet()` function that returns a personalized greeting, with full test coverage using `pytest`.

```python
def greet(name):
    return f"Hello, {name}!"
```

#### ✅ Part 2 — Debugging Buggy Functions

**Factorial Fix:** Removed the incorrect `+ 1` from the recursive call.

```python
# Before (buggy)
return n * factorial(n - 1) + 1

# After (fixed)
return n * factorial(n - 1)
```

**Prime Fix:** Corrected the loop range using square root optimization.

```python
# Before (buggy)
for i in range(2, 2*n):

# After (fixed)
for i in range(2, int(n**0.5) + 1):
```

#### ✅ Part 3 — Sum Positive Numbers
Implemented `sum_positive()` that raises a `ValueError` when negative numbers are present, with edge case tests.

```python
def sum_positive(numbers):
    if any(n < 0 for n in numbers):
        raise ValueError("List contains negative numbers!")
    return sum(numbers)
```

### How to Run
```bash
cd lab01-python
pip install pytest
pytest
```

### Test Results
```
6 passed ✅
```

---

## ☕ Lab 02: Building Java Applications Using Gradle

### Objectives
- Understand Gradle basics and project structure
- Configure dependencies and build automation
- Compile, test, and package a Java application as JAR

### Steps Completed

#### ✅ Step 1 — Project Initialization
```bash
gradle init --type java-application
```

#### ✅ Step 2 — Project Structure
```
lab02-gradle/
├── build.gradle
├── settings.gradle
├── gradlew.bat
└── src/
    ├── main/java/
    │   ├── App.java
    │   └── Calculator.java
    └── test/java/
        └── CalculatorTest.java
```

#### ✅ Step 3 — Dependencies (build.gradle)
```groovy
dependencies {
    implementation 'org.apache.commons:commons-lang3:3.12.0'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher:1.10.0'
}
```

#### ✅ Step 4 — Calculator Class
Implemented `add`, `multiply`, `subtract`, `divide`, and `reverseString` using `StringUtils` from `commons-lang3`.

#### ✅ Step 5 — JUnit 5 Tests
Wrote tests for all methods including division by zero exception and string reversal.

#### ✅ Step 6 — JAR Packaging
Packaged the application as an executable JAR file.

### How to Run
```bash
cd lab02-gradle

# Build and run
.\gradlew.bat build
.\gradlew.bat run

# Run all tests
.\gradlew.bat test

# Run a specific test
.\gradlew.bat test --tests "CalculatorTest.testSubtraction"

# Package as JAR
.\gradlew.bat jar
java -jar build/libs/lab02-gradle.jar
```

### Test Results
```
6 tests completed ✅
```

### Expected Output
```
Sum: 15
Product: 50
```

---

## 🔧 Lab 03: Refactoring Java Code

### Objectives
- Apply **Rename** refactoring to improve code readability
- Apply **Extract Method** refactoring to reduce code complexity
- Validate that refactoring does not change behavior using tests

### Steps Completed

#### ✅ Step 1 — Project Setup
Created a new Gradle Java project for refactoring exercises.

#### ✅ Step 2 — Code Before Refactoring
Added the original unclean code for `Calculator` and `OrderProcessor`.

#### ✅ Step 3 — Tests Before Refactoring
Wrote tests to ensure behavior is preserved after refactoring.

#### ✅ Step 4 — Rename Refactoring (Calculator.java)

| Before | After |
|--------|-------|
| `calc()` | `calculateResult()` |
| `prtRes()` | `printResult()` |
| `x` | `sum` |
| `y` | `product` |

```java
// Before
public double calc(double a, double b) {
    double x = a + b;
    double y = a * b;
    return x / y;
}

// After
public double calculateResult(double a, double b) {
    double sum = a + b;
    double product = a * b;
    return sum / product;
}
```

#### ✅ Step 5 — Extract Method Refactoring (OrderProcessor.java)

Extracted two methods from `printOrderSummary()`:
- `calculateTotalPrice(Order order)` — handles price calculation and discount
- `printItems(Order order)` — handles printing item details

```java
// After refactoring
public void printOrderSummary(Order order) {
    double totalPrice = calculateTotalPrice(order);
    System.out.println("Order Summary:");
    System.out.println("Customer: " + order.getCustomer().getName());
    printItems(order);
    System.out.printf("Total Price: $%.2f%n", totalPrice);
}
```

#### ✅ Step 6 — Tests After Refactoring
Reran all tests to confirm behavior was not changed.

### How to Run
```bash
cd lab03-refactoring
.\gradlew.bat test
```

### Test Results
```
4 tests completed ✅
```

---

## 📁 Project Structure

```
vscode-lab/
├── README.md
├── lab01-python/
│   ├── main.py
│   ├── test_main.py
│   ├── factorial.py
│   ├── test_factorial.py
│   ├── prime.py
│   ├── test_prime.py
│   ├── sum_positive.py
│   └── test_sum_positive.py
├── lab02-gradle/
│   ├── build.gradle
│   ├── gradlew.bat
│   └── src/
│       ├── main/java/
│       │   ├── App.java
│       │   └── Calculator.java
│       └── test/java/
│           └── CalculatorTest.java
└── lab03-refactoring/
    ├── build.gradle
    ├── gradlew.bat
    └── src/
        ├── main/java/
        │   ├── Calculator.java
        │   ├── Order.java
        │   ├── Customer.java
        │   ├── Item.java
        │   └── OrderProcessor.java
        └── test/java/
            ├── CalculatorTest.java
            └── OrderProcessorTest.java
```

---

## 📝 Commits Summary

| Commit | Description |
|--------|-------------|
| `Lab01 Part1` | greet function with passing tests |
| `Lab01 Part2` | fix factorial and prime bugs with tests |
| `Lab01 Part3` | sum_positive function with edge case tests |
| `Lab02` | init Gradle java-application project with dependencies |
| `Lab02` | add Calculator class and update App main method |
| `Lab02` | add CalculatorTest with addition and multiplication tests |
| `Lab02` | fix build.gradle JUnit platform configuration |
| `Lab02 Step6` | package application as JAR with manifest configuration |
| `Lab02 TODO` | add subtract, divide, reverseString with StringUtils and tests |
| `Lab03` | init Gradle project for refactoring lab |
| `Lab03` | add Calculator and OrderProcessor code before refactoring |
| `Lab03` | add tests for Calculator and OrderProcessor before refactoring |
| `Lab03` | refactor Calculator (rename) and OrderProcessor (extract method) |
| `Lab03` | update tests after rename refactoring |
| `docs` | add complete README with all labs documentation |

---

<div align="center">

Made with ❤️ by **Abdelhakim Berrim**

</div>
