# Java Git Starter

A deliberately small Java project for learning Java and Git.

The same clone opens as a real Java project in **Eclipse**, **VS Code**, or
**Cursor**, on **Windows** or **macOS**, with no conversion step and no
per-student setup. Use whichever editor you like. Your classmates and your
instructor can open your work in a different one and it still builds.

## What you need

- Git
- **JDK 25** (Temurin / Adoptium is the usual free build)
- One of:
  - Eclipse IDE for Java Developers (2025-09 or newer — earlier releases do
    not know about Java 25)
  - VS Code or Cursor, with the recommended **Extension Pack for Java**

Check your JDK from a terminal:

```text
java -version
```

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

Copying into the workspace would give Eclipse its own private duplicate of
the files, and your Git commits would stop matching what you are editing.

## Run the tests

`test/MainTest.java` contains three small tests. Nothing here has a `main`
method — JUnit finds and runs the methods marked `@Test` for you.

- **Eclipse:** right-click `MainTest.java` → **Run As → JUnit Test**
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

## Compile without an IDE

macOS / Linux:

```text
javac -d bin --release 25 -cp lib/junit-platform-console-standalone-1.14.4.jar $(find src test -name "*.java")
java -cp bin Main
```

Windows PowerShell:

```text
javac -d bin --release 25 -cp lib/junit-platform-console-standalone-1.14.4.jar (Get-ChildItem -Recurse src,test -Filter *.java).FullName
java -cp bin Main
```

## Folder map

```text
java-git-starter/
├── src/           your Java source code            (committed)
├── test/          your JUnit tests                 (committed)
├── lib/           .jar libraries                   (committed)
├── bin/           compiled .class files            (IGNORED — generated)
├── .classpath     shared source folders, JDK, and libraries
├── .project       marks this folder as a Java project
├── .settings/     shared compiler level (Java 25)
├── .vscode/       shared editor settings, run config, test task
├── .gitattributes line-ending normalization
├── .editorconfig  shared indentation and whitespace rules
└── .gitignore     what Git leaves alone
```

## Why one folder works in both IDEs

This is worth understanding, because it looks like it should not work.

VS Code and Cursor do not have their own Java compiler. The Extension Pack
for Java runs the **Eclipse JDT Language Server** — literally the same engine
inside Eclipse — in the background. So when you commit `.project` and
`.classpath`, both IDEs read the exact same two files and reach the exact
same conclusions about where your source lives, which JDK to use, and which
JARs are on the build path.

Three files do the whole job:

| File | Says |
| --- | --- |
| `.project` | "This folder is a Java project named java-git-starter." |
| `.classpath` | "Source is in `src` and `test`, output goes to `bin`, compile against JavaSE-25, and put `lib/junit-…jar` on the build path." |
| `.settings/org.eclipse.jdt.core.prefs` | "Compile at Java 25 language level." |

The counter-intuitive part: most `.gitignore` templates you find online tell
you to ignore `.project` and `.classpath` as "IDE files." Ignoring them is
exactly what breaks portability. They are not personal settings — they are
the project definition, the same way a `pom.xml` would be. Personal state
(`.metadata/`, `.idea/`, window layouts, your local run history) stays
ignored. See the comments inside `.gitignore`.

## What Git ignores, and why

| Ignored | Reason |
| --- | --- |
| `bin/`, `*.class` | Generated from source. Committing them causes merge conflicts in files no human ever edits. |
| `.metadata/`, `.idea/`, most of `.vscode/` | Personal workspace state — differs per person, per machine. |
| `.env`, `*.key`, `*.pem` | Secrets. Once a secret is committed, deleting it later does not remove it from history. |
| `.DS_Store`, `Thumbs.db` | Operating-system clutter. |

`bin/` will not exist right after you clone — Git cannot store an empty
ignored folder. Eclipse, VS Code, Cursor, or `javac -d bin` creates it on the
first build.

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

## Renaming the project

If you want a different name in the Eclipse project list, change the `<name>`
element in `.project` before you import. Renaming only the folder is not
enough — Eclipse reads the name from that file.
