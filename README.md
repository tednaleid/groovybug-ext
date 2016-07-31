# Groovy `@Grab` bug with extension module jar

This project creates a jar file that uses a "groovy extension module" that installs
new method `appendFoo()` on the `String` class.

It also has an `initialize()` method in it that is meant to be called manually by the user.

If this jar is loaded using the `@Grab` annotation, somehow the `initialize()` method has already been called.

To replicate, run:

```
./gradlew install
```

To install the test jar in your `~/.m2` directory.

Then, run the demo file that shows the bug (using groovy 2.4.7):

```
groovy demoBug.groovy
Caught: Assertion failed:

assert "bar ".appendFoo() == "bar null"
              |           |
              bar foo     false

Assertion failed:

assert "bar ".appendFoo() == "bar null"
              |           |
              bar foo     false

	at demoBug.run(demoBug.groovy:11)
```

Without the `@Grab` the exact same code works as you'd expect if you give the jar on the classpath:

```
groovy -classpath ~/.m2/repository/groovybug/groovybug-ext/1.0/groovybug-ext-1.0.jar demoWorking.groovy
initialized
success!
```