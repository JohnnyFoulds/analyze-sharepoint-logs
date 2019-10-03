package folderList

import java.lang.management.ManagementFactory

import config.Settings
import org.apache.spark.sql.SparkSession
import utils.SparkUtils
import org.apache.spark.{SparkConf, SparkContext}

object FolderList {
	def main(args: Array[String]): Unit = {

		val spark = SparkSession
			.builder()
			.appName("Spark Worksheet")
			//.config("spark.master", "yarn")
  		.master("yarn")
			.config("spark.hadoop.fs.defaultFS", "hdfs://pshp111zatcwi:9000")
			.config("spark.hadoop.yarn.resourcemanager.address", "pshp111zatcwi:8055")
			//.config("spark.yarn.archive", "hdfs://pshp111zatcwi:9000/spark/spark-libs-2.4.3.jar")
			.getOrCreate()

		//val file = spark.read.csv("C:\\Temp\\IISLogs\\W3SVC1291934293\\u_ex190620.log")
		//file.count()

		/*
			val settings = Settings.FolderList

				// get the spark context
			val sc = SparkUtils.getSparkContext("Analyze IIS Logs")

			val logPath = "hdfs://pshp111zatcwi:9000/u_ex190620.log"

			val logTextData = sc.textFile(logPath)
				.filter(line=> !line.startsWith("#"))

			print(logTextData.count)

			val logData = spark.read
				.option("delimiter", " ")
				.csv(logTextData.toDS)

			logData.count
		 */
	}
}

/*
# Web References
- Introduction to SparkSession - https://dzone.com/articles/introduction-to-spark-session
- Spark SQL, DataFrames and Datasets Guide - https://spark.apache.org/docs/2.3.0/sql-programming-guide.html
- https://github.com/TalentOrigin/spark-course/blob/master/src/main/scala/advanced/spark/SparkUDFExample2.scala
 */