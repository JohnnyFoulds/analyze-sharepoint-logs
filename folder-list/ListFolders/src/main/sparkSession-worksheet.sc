import org.apache.spark.sql.SparkSession

/*
val spark = SparkSession
	.builder()
	.appName("Spark Worksheet")
  .master("local")
	.getOrCreate()
*/

val spark = SparkSession
	.builder()
	.appName("Spark Worksheet")
	.master("yarn")
	.config("spark.hadoop.fs.defaultFS", "hdfs://pshp111zatcwi:9000")
	.config("spark.hadoop.yarn.resourcemanager.hostname", "pshp111zatcwi")
	.config("spark.hadoop.yarn.resourcemanager.address", "pshp111zatcwi:8055")
	.getOrCreate()

val file = spark.read.csv("C:\\Temp\\IISLogs\\W3SVC1291934293\\u_ex190620.log")
file.count()


