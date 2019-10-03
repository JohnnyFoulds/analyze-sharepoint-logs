import org.apache.spark.sql.SparkSession

object SampleJob extends App {

	val spark = SparkSession
		.builder()
  	.appName("Sample Job")
  	.master("yarn")
		.config("spark.hadoop.fs.defaultFS", "hdfs://pshp111zatcwi:9000")
		.config("spark.hadoop.yarn.resourcemanager.address", "pshp111zatcwi:8055")
		.config("spark.yarn.archive", "hdfs://pshp111zatcwi:9000/spark/spark-libs-2.4.3.jar")
		.getOrCreate()

	val sc = spark.sparkContext

	val logPath = "hdfs://pshp111zatcwi:9000/u_ex190620.log"

	val logTextData = sc.textFile(logPath)
		.filter(line=> !line.startsWith("#"))

	println(logTextData.count())

	/*
	val logData = spark.read
		.option("delimiter", " ")
		.option("header", "false")
		.csv(logTextData)

	logData.count
*/

		println("test")
}
