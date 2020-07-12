import org.apache.spark.sql.SparkSession

object SampleJob extends App {

	val spark = SparkSession
		.builder()
  	.appName("Sample Job")
  	.master("yarn")
		.config("spark.hadoop.fs.defaultFS", "hdfs://pshp111:9000")
		.config("spark.hadoop.yarn.resourcemanager.address", "pshp111:8055")
		.config("spark.yarn.archive", "hdfs://pshp111:9000/spark/spark-libs-2.4.3.jar")
		.getOrCreate()

	val sc = spark.sparkContext

	val nums = Array(1,2,3,5,6)
	val rdd = sc.parallelize(nums)

	import spark.implicits._
	val df = rdd.toDF("num")

	df.show()

	/*
	val logPath = "hdfs://pshp111:9000/u_ex190620.log"

	val logTextData = sc.textFile(logPath)
		.filter(line=> !line.startsWith("#"))

	println(logTextData.count())\

	 */

	/*
	val logData = spark.read
		.option("delimiter", " ")
		.option("header", "false")
		.csv(logTextData)

	logData.count
*/

		println("test")
}
