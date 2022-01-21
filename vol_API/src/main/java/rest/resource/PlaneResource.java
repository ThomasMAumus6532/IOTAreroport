package rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import rest.app.RestAPI;
import rest.entity.Plane;
import entity.Personne;
import mqtt.Consumer;
import entity.Flight;

@Path("plane")
public class PlaneResource {

	private List<Plane> planes = RestAPI.getPlanes();
	private List<Flight> flights = RestAPI.getFlights();
	
	public PlaneResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllplanes() {
		return Response.ok(Consumer.list).build();
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getAllpassengers(Plane plane) {
//		return Response.ok(plane.gettabPers()).build();
//	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlane(@PathParam("id") int id) {
		return Response.ok(planes.stream().filter(
				Plane -> id == Plane.getIdPlane())
				.findAny().orElse(null)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPlane(Plane plane) {
		planes.add(plane);
		return Response.ok(planes).build();
	}
	
	@GET
	@Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlanes() {
        return Response.ok(planes).build();
    }
	@POST
	@Path("flight/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFlightAndFlightToPlane(@PathParam("id") int id, Flight flight){
		for(Plane plane : planes) {
			if (plane.getIdPlane() == id)
				plane.addFlight(flight.getIdFlight());
			    flights.add(flight);
		}
		return Response.ok(flights).build();
	}
	
//	@POST
//	@Path("passanger")
//	public Response addPassanger(){
//		
//	}
	
	@POST
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPassenger(@PathParam("id") int id, Personne newPersonne){
		for(Plane plane : planes) {
			if (plane.getIdPlane() == id) {
				plane.addPersonne(newPersonne);
				return Response.ok(plane).build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();	
	}
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Plane newPlane) {
		Plane oldPlane = planes.stream().filter(f -> id == f.getIdPlane()).findAny().orElse(null);
		if (oldPlane == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		planes.remove(id);
		planes.add(newPlane);
		return Response.ok(planes).build();
	}
	
//	@DELETE
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response delete(@PathParam("id") int id) {
//		planes.remove(id);
//		return Response.ok(planes).build();
//	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePassenger(@PathParam("id") int id, Plane plane) {
		for(Personne personne : plane.gettabPers()) {
			if (personne.getIdPers() == id) {
				plane.deletePersonne(personne);
				return Response.ok(plane).build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	/*@GET
	@Path("_search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@QueryParam("id") Integer id, @QueryParam("name") String name) {
		if (id != null && name != null) {
			return Response.ok(planes.stream().filter(Plane -> id == Plane.getIdPlane() && name.contains(Plane.getBrand()))
					.findAny().orElse(null)).build();
		} else if (id != null && name == null) {
			return Response.ok(planes.stream().filter(Plane -> id == Plane.getId()).findAny().orElse(null)).build();
		} else if (id == null && name != null) {
			return Response.ok(planes.stream().filter(Plane -> name.contains(Plane.getName())).findAny().orElse(null))
					.build();
		} else {
			return Response.ok(planes).build();
		}
	}*/

}

