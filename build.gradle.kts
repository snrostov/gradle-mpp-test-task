import org.gradle.api.internal.tasks.testing.TestExecuter
import org.gradle.api.internal.tasks.testing.TestExecutionSpec
import org.gradle.api.internal.tasks.testing.TestResultProcessor

group = "jb.samples"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

open class MyTestTask: AbstractTestTask() {
    override fun createTestExecuter() = object: TestExecuter<MyTestSpec> {
        override fun execute(testExecutionSpec: MyTestSpec, testResultProcessor: TestResultProcessor?) {

        }

        override fun stopNow() {

        }
    }

    override fun createTestExecutionSpec() =
            MyTestSpec(this)

    override fun setTestNameIncludePatterns(testNamePattern: MutableList<String>?): AbstractTestTask {
        println(testNamePattern)
        return super.setTestNameIncludePatterns(testNamePattern)
    }
}

data class MyTestSpec(val task: MyTestTask): TestExecutionSpec

task<MyTestTask>("test") {
    binResultsDir = buildDir
    reports.html.destination = buildDir
    reports.junitXml.destination = buildDir
//    reports.enabledReports["html"]!!.destination = buildDir
//    reports.enabledReports["junitXml"]!!.destination = buildDir
}