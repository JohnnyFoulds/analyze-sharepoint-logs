package config

import com.typesafe.config.ConfigFactory

object Settings {
	private val config = ConfigFactory.load()

	object FolderList {
		// get the configuration section
		private  val folderList = config.getConfig("folderList")

		// get the configuration values
		lazy val logPath = folderList.getString("logPath")
	}

	object SparkConfig {
		private  val settings = config.getConfig("spark")

		lazy val master = settings.getString("master")
		lazy val defaultFS = settings.getString("defaultFS")
		lazy val resourcemanagerHostname = settings.getString("resourcemanagerHostname")
		lazy val resourcemanagerAddress = settings.getString("resourcemanagerAddress")
	}
}
