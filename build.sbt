name := """RESTAURANTE"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)

scalaVersion := "2.13.16"

libraryDependencies ++= Seq(
  guice,
  jdbc,
  javaJpa,
  javaForms,
  javaJdbc,
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.14.3",
  "com.h2database" % "h2" % "2.2.224",
  "javax.persistence" % "javax.persistence-api" % "2.2",
  "javax.validation" % "validation-api" % "2.0.1.Final",
  "org.hibernate.validator" % "hibernate-validator" % "6.2.5.Final",
  "org.glassfish" % "javax.el" % "3.0.0",
  "mysql" % "mysql-connector-java" % "8.0.33",
  "org.hibernate" % "hibernate-core" % "5.6.15.Final",
  "org.hibernate" % "hibernate-entitymanager" % "5.6.15.Final"
)
