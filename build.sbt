name := "Queta-Sec"

version := "0.1.0-SNAPSHOT"

scalaVersion := "3.2.2"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "4.0.0",
  "com.h2database"  %  "h2"                % "2.1.214",
  "ch.qos.logback"  %  "logback-classic"   % "1.4.5",
  "com.sparkjava"  % "spark-core" % "2.9.4"
)
