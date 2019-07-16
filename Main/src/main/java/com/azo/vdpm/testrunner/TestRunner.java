package com.azo.vdpm.testrunner;

import org.slf4j.Logger;

import com.azo.flexFrmwk.controller.Controller;
import com.azo.flexFrmwk.exception.ApplicationException;
import com.azo.flexFrmwk.logger.LogFactory;

public class TestRunner {
	private static final Logger log = LogFactory.getLogger(TestRunner.class);
	
	public static void main(String[] args) {
		
		try {
			String configFilesPath = "config-files/";
			Controller controller = new Controller(args, configFilesPath);
			controller.control();
		}catch(ApplicationException e) {
			e.printStackTrace();
		}

	}

}
