package utils

import java.lang.management.ManagementFactory

import config.Settings
import org.apache.spark.{SparkConf, SparkContext}

object SparkUtils {
	val settings = Settings.SparkConfig

	val isIDE = {
		ManagementFactory.getRuntimeMXBean.getInputArguments.toString.contains("IntelliJ IDEA")
	}

	def getSparkContext(appName: String) : SparkContext = {
		val conf = new SparkConf().setAppName(appName)

		if (settings.master == "yarn-client") {
			System.setProperty("SPARK_YARN_MODE", "true")

			conf.setMaster(settings.master)
			conf.set("spark.hadoop.fs.defaultFS", settings.defaultFS)
			conf.set("spark.hadoop.yarn.resourcemanager.hostname", settings.resourcemanagerHostname)
			conf.set("spark.hadoop.yarn.resourcemanager.address", settings.resourcemanagerAddress)
			conf.set("--deploy-mode", "cluster")
		}
		else if (this.isIDE) {
			System.setProperty("hadoop.home.dir", "c:\\Libraries\\WinUtils")
			conf.setMaster("local[*]")
		}


		return new SparkContext(conf)
	}
}

/*
# Web References
- Running Spark Jobs from Eclipse in YARN Mode - https://www.coding-daddy.xyz/node/7
 */
