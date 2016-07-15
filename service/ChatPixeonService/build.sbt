name := "ChatPixeonService"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     
buildInfoPackage := "2.2.6"

play.Project.playJavaSettings


