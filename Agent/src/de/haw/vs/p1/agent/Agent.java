package de.haw.vs.p1.agent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class Agent {

	private ArrayList<URL> route;
	private ArrayList<URL> waypoints;
	private URL homeURL;
	
	public Agent(String homeURL) throws MalformedURLException{
		this.route = new ArrayList<URL>();
		this.waypoints = new ArrayList<URL>();
		this.homeURL = new URL(homeURL);
	}
	
	/**
	 * Writes a given URL into the route list,
	 * which contains the way which was already
	 * gone
	 * @param pos
	 * @throws MalformedURLException 
	 */
	private void writeIntoRoute(URL url){
		this.route.add(url);
	}
	
	/**
	 * Returns the next target of the waypoint list
	 * @return next target of the Agent
	 */
	public URL nextTarget(){
		URL nextTarget = this.waypoints.get(this.waypoints.size() - 1);
		this.waypoints.remove(nextTarget);
		
		writeIntoRoute(nextTarget);
		
		return nextTarget;
	}
	
	/**
	 * Writes an array of Strings into the waypoints,
	 * this list have to be finished until the agent 
	 * could went home
	 * @param waypoints
	 * @param current
	 * @throws MalformedURLException
	 */
	public void writeIntoWaypoints(String... waypoints) throws MalformedURLException{
		for(String point: waypoints){
			URL newURL = new URL(point);
			if(!this.route.contains(newURL)){
				this.waypoints.add(newURL);
			}		
		}
		//deleteCurrentHostFromList(current);
	}
	
	/**
	 * Deletes the current position of the agent from the
	 * waypoints list
	 * @param current
	 * @throws MalformedURLException
	 */
	private void deleteCurrentHostFromList(String current) throws MalformedURLException{
		this.waypoints.remove(new URL(current));
	}
	
	public String toString(){	
		Iterator<URL> iter = this.route.iterator();
		StringBuffer retVal = new StringBuffer();
		while(iter.hasNext()){
			retVal.append(iter.next().getHost());
		}
		return retVal.toString();
	}
}
