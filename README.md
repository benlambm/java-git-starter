# Java Git Starter

A deliberately small Java project for learning Java and Git.

The same clone opens as a real Java project in **Eclipse**, **VS Code**, or
**Cursor**, on **Windows** or **macOS**, with no conversion step. 
Use whichever code IDE editor you like. 

## What you need

- **Git**
- **JDK 21 or newer** (Temurin / Adoptium is the usual free build). 21 is a
  long-term-support release, so it is the safe pick, but a newer JDK works too.
- One of:
  - Eclipse IDE for Java Developers (2023-12 or newer — earlier releases do
    not know about Java 21)
  - VS Code or Cursor, with the recommended **Extension Pack for Java**

## Get the code

Your IDE can do the clone for you — no ZIP download, and no `git clone` in a
terminal first. Every route below asks for the same clone URL:

```text
https://github.com/benlambm/java-git-starter.git
```

## Open in VS Code or Cursor

1. Start VS Code or Cursor with no folder open.
2. Click **Clone Repository**. It is on the Welcome screen, and also in the
   **Source Control** panel in the left sidebar.
3. Paste the clone URL above and press **Enter**.
4. Pick the folder to clone into, then choose **Open** when it offers to open
   the result.
5. Accept the pop-up recommending the **Extension Pack for Java**.
6. Open `src/Main.java` and click **Run** above the `main` method.

## Open in Eclipse

1. Check that Eclipse's Git support is installed: **Help → About Eclipse IDE
   → Installation Details**, then look for **EGit**. The "Eclipse IDE for
   Java Developers" package already includes it. If it is missing, install it
   from **Help → Eclipse Marketplace…** and search for *EGit*.
2. **File → New → Project…**
3. Expand **Git**, choose **Projects from Git** (newer releases label it
   **Projects from Git (with smart import)**), then **Next**.
4. Choose **Clone URI**, then **Next**.
5. Paste the clone URL above into **URI**. The host and path fields fill in
   by themselves. **Next**.
6. Accept the defaults for the branch selection and the local destination
   folder, then **Finish**.
7. Open `src/Main.java` and choose **Run As → Java Application**.

Eclipse imports the project in place, in the folder it just cloned into,
rather than copying it into the workspace. That is what you want: your Git
commits stay matched to the files you are actually editing.

## Run the tests

The `test/` folder holds 28 tests across seven files. Nothing there has a
`main` method — JUnit finds and runs the methods marked `@Test` for you.

All of them fail on a fresh clone. That is on purpose — see **The six
exercises** below.

- **Eclipse:** right-click the `test` folder, or a single test file →
  **Run As → JUnit Test**
- **VS Code / Cursor:** click the beaker icon in the left sidebar, or the
  arrow in the gutter next to a test method

## The six exercises

`src/edu/vwcc/itp220mod1/` holds six classes. Every class starts with an `Instructions:` comment saying exactly what its
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

One more stub lives outside that folder: `Main.greet` in `src/Main.java`,
checked by `test/MainTest.java`. Its javadoc is the spec — a blank or null
name falls back to `"world"`, so `greet("Ada")` returns `Hello, Ada!`. Start
there if you want the smallest possible first win.

### How to work through them

1. **Run the tests first.** On a fresh clone **all 28 fail**. That is the
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

You are finished when all 28 tests pass. That count includes the three in
`test/MainTest.java` covering `Main.greet` — the same shape of problem as the
six: a method that takes values in, returns a value out, and is tested
directly.

