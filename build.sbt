ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"
lazy val root = (project in file("."))
  .settings(
    name := "shoppingcartpricecalculator"
  )
// https://mvnrepository.com/artifact/org.scalatest/scalatest
// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % Test
