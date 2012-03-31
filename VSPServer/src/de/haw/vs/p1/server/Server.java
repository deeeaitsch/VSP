package de.haw.vs.p1.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import com.compoundtheory.classloader.NetworkClassLoader;

import de.haw.vs.p1.agent.Agent;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public static void arrive(Agent agent){
		
		NetworkClassLoader classLoader = new NetworkClassLoader();
		
		String[] waypoints = new String[]{
				"file:/C:/Users/haselo_d/Desktop/1stServer.jar",
				"file:/C:/Users/haselo_d/Desktop/2ndServer.jar",
				"file:/C:/Users/haselo_d/Desktop/3rdServer.jar"
		};
		
		try {
			agent.writeIntoWaypoints(waypoints);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		URL url = agent.nextTarget();
		classLoader.addURL(url);
		
		Class reflectedClass = null;
		try {
			reflectedClass = classLoader.findClass("de.haw.vs.p1.server.Server");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Method method = reflectedClass.getDeclaredMethod("arrive", Agent.class);
			method.invoke(null, agent);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
