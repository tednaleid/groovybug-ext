// run with groovy 2.4.7:
// ./gradlew install
// groovy -classpath ~/.m2/repository/groovybug/groovybug-ext/1.0/groovybug-ext-1.0.jar demoWorking.groovy

// this one works fine without `@Grab` the first assert passes as we haven't initialized yet




import com.naleid.groovybug.StringExtensions

assert "bar ".appendFoo() == "bar null"

StringExtensions.initialize()

assert "bar ".appendFoo() == "bar foo"

println "success!"
