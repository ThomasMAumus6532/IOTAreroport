package rest.app;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import rest.entity.Plane;
import entity.Flight;

@ApplicationPath("api")
public class RestAPI extends ResourceConfig {
	
	private static List<Plane> planes = new ArrayList<>();
	private static List<Flight> flights = new ArrayList<>();
	
	public RestAPI() {
		packages("rest.resource");
		packages("resource");
		Plane p = new Plane(15,"720","Boeing");
		planes.add(p);
		Flight f = new Flight(10, "Paris", "Monaco");
		flights.add(f);
	}
	
	public static List<Plane> getPlanes(){
		return planes;
	}
	
	public static List<Flight> getFlights(){
		return flights;
	}

}

