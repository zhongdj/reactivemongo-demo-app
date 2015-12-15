import play.PlayImport.PlayKeys._

import ByteConversions._

name := "reactivemongo-demo-app"

version := "0.11.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.reactivemongo" %% "play2-reactivemongo" % "0.11.0.play24"

routesGenerator := InjectedRoutesGenerator

lazy val root = (project in file(".")).enablePlugins(PlayScala)


resolvers += "typesafe-releases" at "http://repo.typesafe.com/typesafe/maven-releases"

libraryDependencies += "com.typesafe.conductr" %% "play24-conductr-bundle-lib" % "1.0.1"

SandboxKeys.imageVersion in Global := "1.0.14"

BundleKeys.nrOfCpus := 1.0

BundleKeys.memory := 64.MiB

BundleKeys.diskSpace := 10.MB

BundleKeys.roles := Set("web")

BundleKeys.endpoints := Map("my-app" -> Endpoint("http", services = Set(URI("http://:9000"))))

javaOptions in Bundle ++= Seq("-Dhttp.address=$MY_APP_BIND_IP", "-Dhttp.port=$MY_APP_BIND_PORT")