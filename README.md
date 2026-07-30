# Java Git Starter

A deliberately small Java project for learning Java and Git.

The same clone opens as a real Java project in **Eclipse**, **VS Code**, or
**Cursor**, on **Windows** or **macOS**, with no conversion step. 
Use whichever code IDE editor you like. 

## What you need

- Git
- **JDK 25** (Temurin / Adoptium is the usual free build)
- One of:
  - Eclipse IDE for Java Developers (2025-09 or newer — earlier releases do
    not know about Java 25)
  - VS Code or Cursor, with the recommended **Extension Pack for Java**

## Open in VS Code or Cursor

1. Open this repository's top-level folder (the folder that contains this
   README), not a parent folder and not a subfolder.
2. Accept the pop-up recommending the **Extension Pack for Java**.
3. Open `src/Main.java`.
4. Click **Run** above the `main` method.

## Open in Eclipse

1. **File → Import…**
2. **General → Existing Projects into Workspace**, then **Next**.
3. Set **Select root directory** to this repository's top-level folder.
4. Confirm `java-git-starter` is checked. Leave **Copy projects into
   workspace** UNCHECKED.
5. **Finish**, then open `src/Main.java` and choose **Run As → Java
   Application**.

Why step 4 says unchecked: copying into the workspace would give Eclipse its
own private duplicate of the files, and your Git commits would stop matching
what you are editing.

## Run the tests

The `test/` folder holds 28 tests across seven files. Nothing there has a
`main` method — JUnit finds and runs the methods marked `@Test` for you.

Most of them fail on a fresh clone. That is on purpose — see **The six
exercises** below.

- **Eclipse:** right-click the `test` folder, or a single test file →
  **Run As → JUnit Test**
- **VS Code / Cursor:** click the beaker icon in the left sidebar, or the
  arrow in the gutter next to a test method
- **Terminal:** `Terminal → Run Test Task`, or run it by hand:

```text
java -jar lib/junit-platform-console-standalone-1.14.4.jar execute --class-path bin --scan-class-path --details=tree
```

That last command is byte-for-byte identical in macOS Terminal, Windows
PowerShell, and Windows Command Prompt. It reads the compiled classes your
IDE already put in `bin`, so compile first (opening the project in either IDE
does this automatically).

## The six exercises

`src/edu/vwcc/itp220mod1/` holds six classes. Each one has a method that is a
**stub** — it returns `""`, `false`, or `0.0` so the file still compiles, but
it does no real work yet. Filling those in is the assignment.

Every class starts with an `Instructions:` comment saying exactly what its
method must do. The matching file in `test/edu/vwcc/itp220mod1/` checks it.

| Class | What its method does |
| --- | --- |
| `FizzBuzz` | "Fizz", "Buzz", "FizzBuzz", or the number |
| `MovieTicketCalculator` | Ticket price from age, show hour, weekend |
| `HitDetection` | Is a click inside a rectangle? |
| `HealthBarDisplay` | Build a bar like `[######----] 60%` |
| `PasswordRuleChecker` | Does a password satisfy every rule? |
| `CaesarCipher` | Shift letters through the alphabet |

That order is roughly easiest to hardest, but you can work in any order.

### How to work through them

1. **Run the tests first.** On a fresh clone **25 of the 28 fail**. That is the
   correct starting point, not something you broke. Each failing test is one
   to-do item.
2. **Pick one class.** Read its `Instructions:` comment, then open its test
   file and read the exact values the tests expect. The tests are the precise
   version of the instructions.
3. **Write the method body.**
4. **Re-run just that one test class** — right-click it → **Run As → JUnit
   Test** in Eclipse, or click the gutter arrow in VS Code / Cursor. Repeat
   until it is green.
5. **Move to the next class.** Nothing here depends on anything else, so a
   class you have not started cannot break one you finished.

When a test fails, read the message before changing anything. JUnit tells you
what it wanted and what it got:

```text
expected: <Fizz> but was: <>
```

That one says your method returned an empty String where `"Fizz"` belonged.

You are finished when all 28 tests pass. The three tests in
`test/MainTest.java` already pass on a fresh clone — `Main.greet` is written
for you, as a worked example of the same shape of problem: a method that takes
values in, returns a value out, and is tested directly.

## Adding another JAR library

1. Put the `.jar` in `lib/`.
2. Eclipse: **Project → Properties → Java Build Path → Libraries →
   Classpath → Add JARs…** (pick it from inside this project).
   VS Code / Cursor: it is picked up automatically from `lib/`, but you must
   still add it in Eclipse so the shared `.classpath` records it.
3. Commit **both** the JAR and the changed `.classpath`.

Use the project-relative path (`lib/thing.jar`), never an absolute path like
`C:\Users\you\Downloads\thing.jar`. Absolute paths break on every other
computer.

