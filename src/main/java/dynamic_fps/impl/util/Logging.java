package dynamic_fps.impl.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dynamic_fps.impl.DynamicFPSMod;

public class Logging {
	private static final Logger logger = LogManager.getLogger(DynamicFPSMod.MOD_ID);

	public static Logger getLogger() {
		return logger;
	}
}
