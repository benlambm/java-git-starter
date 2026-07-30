# Java Git Starter

A deliberately small Java project for learning Java and Git. The same clone
opens as a Java project in Eclipse, VS Code, or Cursor on Windows or macOS.

## What you need

- Git
- JDK 21
- One of:
  - Eclipse IDE for Java Developers
  - VS Code or Cursor with the recommended Extension Pack for Java

## Open in VS Code or Cursor

1. Open this repository's top-level folder.
2. Accept the recommendation to install the **Extension Pack for Java**.
3. Open `src/Main.java`.
4. Click **Run** above the `main` method.

The Java extension reads the committed Eclipse project configuration, so
`src` is the source folder and compiled `.class` files go into `bin`.

## Open in Eclipse

1. Choose **File → Import**.
2. Choose **General → Existing Projects into Workspace**.
3. Select this repository's top-level folder as the root directory.
4. Make sure `java-git-starter` is checked, then choose **Finish**.
5. Open `src/Main.java` and choose **Run As → Java Application**.

Do not select **Copy projects into workspace**. Eclipse should use the same
files that Git, VS Code, and Cursor use.

## Compile without an IDE

These commands work in macOS Terminal, Windows PowerShell, and the terminals
inside VS Code or Cursor:

```text
javac -d bin src/Main.java
java -cp bin Main
```

## Folder map

```text
java-git-starter/
├── src/          Java source code (commit this)
├── bin/          compiled .class files (generated and ignored)
├── lib/          instructor-provided .jar libraries (commit when allowed)
├── .classpath    shared Eclipse/Java classpath
├── .project      tells Eclipse this is a Java project
└── .vscode/      small shared settings and extension recommendation
```

Git cannot store an empty ignored folder, so `bin` may not appear immediately
after cloning. Eclipse, VS Code, Cursor, or `javac -d bin` creates it when the
project is compiled.

## What Git ignores

- compiled output in `bin`
- `.class` files
- personal IDE workspace state
- `.env` files and secrets
- operating-system clutter and logs

The few committed files under `.vscode` and `.settings`, plus `.project` and
`.classpath`, are shared project configuration—not personal workspace state.
They are what make the project portable between the IDEs.

## If you add a JAR library

Place it in `lib`, then add it to the build path in Eclipse:

**Project → Properties → Java Build Path → Libraries → Classpath → Add JARs**

Commit the JAR (if its license allows redistribution) and the changed
`.classpath` file. VS Code and Cursor use that same classpath. Avoid absolute
paths to files elsewhere on your computer; those break on another student's
computer.
