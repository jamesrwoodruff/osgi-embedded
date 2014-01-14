package com.github.simbo1905.osgi;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public class EmbedMathService {

	public static void main(String[] args) throws Exception {
		FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();
		Map<String, String> config = new HashMap<String, String>();

		// TODO: add some config properties
		Framework framework = frameworkFactory.newFramework(config);

		framework.start();

		BundleContext context = framework.getBundleContext();
		List<Bundle> installedBundles = new LinkedList<Bundle>();

		installedBundles.add(context
.installBundle("MathService-0.0.1", new FileInputStream(
"./target/MathService-0.0.1-SNAPSHOT.jar")));
		installedBundles.add(context
.installBundle("MathServiceClient", new FileInputStream(
"./target/MathServiceClient-0.0.1-SNAPSHOT.jar")));

		for (Bundle bundle : installedBundles) {
			if (bundle.getHeaders().get(Constants.FRAGMENT_HOST) == null)
				bundle.start();
		}

		try {
			System.out.println("awaiting stop");
		    framework.waitForStop(0);
		} finally {
		    System.exit(0);
		}
	}

}
