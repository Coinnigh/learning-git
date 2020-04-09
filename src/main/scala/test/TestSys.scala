package test

object TestSys {

  def main(args: Array[String]): Unit = {
    println(SparkUtils.defaultEnv)
    SparkUtils.say()
  }

}
