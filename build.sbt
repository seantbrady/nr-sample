name := "nr-sample"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.newrelic.agent.java" % "newrelic-api" % "3.11.0"
)

play.Project.playJavaSettings
