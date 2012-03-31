package de.haw.vs.p1.client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import com.compoundtheory.classloader.NetworkClassLoader;

import de.haw.vs.p1.agent.Agent;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NetworkClassLoader classLoader = new NetworkClassLoader();
		URL url = null;
		try {
			url = new URL("file:/C:/Users/haselo_d/Desktop/Server.jar");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		classLoader.addURL(url);
		Class reflectedClass = null;
		try {
			reflectedClass = classLoader.findClass("de.haw.vs.p1.server.Server");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Method main = reflectedClass.getDeclaredMethod("arrive", Agent.class);
			main.invoke(null, new Agent("file:/C:/Users/haselo_d/Desktop/Client.jar"));
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
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
