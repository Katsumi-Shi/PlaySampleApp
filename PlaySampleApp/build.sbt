name := """play-java8-sample"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
	.enablePlugins(PlayEbean)   

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.38",
  javaJdbc,
  javaWs,
  jdbc,
  evolutions,
)

libraryDependencies += javaForms

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.192"
libraryDependencies += "org.projectlombok" % "lombok" % "1.16.10"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
libraryDependencies += "org.playframework.anorm" %% "anorm" % "2.6.4"


// LESS compile setting
includeFilter in (Assets, LessKeys.less) := "*.less"
excludeFilter in (Assets, LessKeys.less) := "_*.less"
