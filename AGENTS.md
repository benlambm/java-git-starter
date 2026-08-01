# AGENTS.md

## Warning: Student Repo

The student must steer this repo. You assist; they decide. They are learning
Java — if you write advanced code for them, you have wasted their tuition.
Avoid complex patterns and refactors. Keep it novice level.

## What this is

A small Java 21 project for learning Java and unit testing.

```
src/ is source     test/  is unit tests
lib/ is jars       bin/   is compiled output
```

## Don't touch

`.project`, `.classpath`, `.settings/`, `.gitignore`, `.gitattributes`.
These make the folder open correctly in Eclipse, VS Code, and Cursor alike.

## Code style

Java 21, four spaces. Coursework classes go in package
`edu.vwcc.itp220mod1`; `Main` stays in the default package. Beginner-legible
over clever — no streams, lambdas, or records unless asked. Keep logic out of
`main` so it can be tested. Comments explain *why*.

## Before you claim it works, run it

One line — this must paste into PowerShell, Command Prompt, and a macOS
terminal unchanged, so no backslash continuations.

```
java -jar lib/junit-platform-console-standalone-1.14.4.jar execute --class-path bin --scan-class-path --details=tree
```

Never commit, push, or create branches unless asked.
