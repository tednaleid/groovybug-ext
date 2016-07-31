@Grab('groovybug:groovybug-ext:1.0')
// run with groovy 2.4.7:
// ./gradlew install
// groovy demoBug.groovy

// the first assert fails with @Grab
// somehow StringExtensions.initialize() has already been called so this is already "bar foo"
// even though we don't see the println from inside the initialize

import com.naleid.groovybug.StringExtensions

assert "bar ".appendFoo() == "bar null"

StringExtensions.initialize()

assert "bar ".appendFoo() == "bar foo"

println "success!"
