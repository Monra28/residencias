name := """RESTAURANTE"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.16"

libraryDependencies += guice
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.14.3"
libraryDependencies += "com.h2database" % "h2" % "2.2.224"
libraryDependencies += "io.ebean" % "ebean" % "13.11.0"
libraryDependencies += "io.ebean" % "ebean-querybean" % "13.11.0"
libraryDependencies += "io.ebean" % "ebean-ddl-generator" % "13.11.0"
libraryDependencies += "javax.persistence" % "javax.persistence-api" % "2.2"
libraryDependencies += "javax.validation" % "validation-api" % "2.0.1.Final"
libraryDependencies += "org.hibernate.validator" % "hibernate-validator" % "6.2.5.Final"
libraryDependencies += "org.glassfish" % "javax.el" % "3.0.0"
