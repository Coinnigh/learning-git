package test

import java.io.File

import scala.collection.JavaConverters

  trait SparkUtils {

    protected def defaultEnv: Map[String, String]

    def say(): Unit ={
      sys.env.get("SPARK_CONF_DIR")
        .orElse(sys.env.get("SPARK_HOME").map(path => s"$path${File.separator}conf"))
      .map(path => new File(s"$path${File.separator}spark-defaults.conf"))
        .filter(_.isFile)
        .map(_.getAbsolutePath)
      println("hello word trait")
    }

}

object SparkUtils extends SparkUtils {
  override lazy val defaultEnv = sys.env
}
