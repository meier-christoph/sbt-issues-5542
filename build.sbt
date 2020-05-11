import Dependencies._

ThisBuild / organization := "org.example"

ThisBuild / javacOptions ++= List("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")

// ThisBuild / useCoursier := false

lazy val nameBase = "sbt-issues-5542"
name := s"$nameBase-root"

lazy val core = projectMatrix
  .in(file("src/core"))
  .settings(
    name := s"$nameBase-core",
    libraryDependencies ++= List(
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.4",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
      // "org.slf4j" % "slf4j-api" % "1.7.30",
      "org.bitbucket.b_c" % "jose4j" % "0.7.0",
      "ch.qos.logback" % "logback-classic" % "1.2.3" % Test
    )
  )
  .jvmPlatform(Versions.scalaAll)

lazy val play23 = projectMatrix
  .in(file("src/play-v2.3.x"))
  .dependsOn(core)
  .settings(
    name := s"$nameBase-play-23",
    libraryDependencies ++= List(
      "javax.inject" % "javax.inject" % "1",
      "com.typesafe.play" %% "play" % Versions.play23,
      "com.typesafe.play" %% "play-ws" % Versions.play23,
      "com.typesafe.play" %% "play-cache" % Versions.play23
    )
  )
  .jvmPlatform(Versions.scalaForPlay23)

lazy val play25 = projectMatrix
  .in(file("src/play-v2.5.x"))
  .dependsOn(core)
  .settings(
    name := s"$nameBase-play-25",
    libraryDependencies ++= List(
      "com.typesafe.play" %% "play" % Versions.play25,
      "com.typesafe.play" %% "play-ws" % Versions.play25,
      "com.typesafe.play" %% "play-cache" % Versions.play25
    )
  )
  .jvmPlatform(Versions.scalaForPlay25)

lazy val play28 = projectMatrix
  .in(file("src/play-v2.8.x"))
  .dependsOn(core)
  .settings(
    name := s"$nameBase-play-28",
    libraryDependencies ++= List(
      "com.typesafe.play" %% "play" % Versions.play28,
      "com.typesafe.play" %% "play-ws" % Versions.play28,
      "com.typesafe.play" %% "play-cache" % Versions.play28,
      "com.typesafe.play" %% "play-guice" % Versions.play28 % Optional
    )
  )
  .jvmPlatform(Versions.scalaForPlay28)
