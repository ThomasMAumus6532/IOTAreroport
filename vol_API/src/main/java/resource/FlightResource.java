package resource;

import java.util.ArrayList;
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

import entity.Flight;
import rest.app.RestAPI;

@Path("flights")
public class FlightResource {

	private List<Flight> flights = RestAPI.getFlights();

	public FlightResource() {}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllflights() {
		return Response.ok(flights).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getflights(@PathParam("id") int id) {
		return Response.ok(flights.stream().filter(
				flights -> id == flights.getIdFlight())
				.findAny().orElse(null)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addflights(Flight f1) {
		flights.add(f1);
		return Response.ok(flights).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Flight newflights) {
		Flight oldflights = flights.stream().filter(f -> id == f.getIdFlight()).findAny().orElse(null);
		if (oldflights == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		flights.remove(id);
		flights.add(newflights);
		return Response.ok(flights).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		flights.remove(id);
		return Response.ok(flights).build();
	}

	@GET
	@Path("_search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@QueryParam("id") Integer id, @QueryParam("nom") String country) {
		if (id != null && country != null) {
			return Response.ok(flights.stream().filter(f1 -> id == f1.getIdFlight() && country.contains(f1.getArrivalCity()))
					.findAny().orElse(null)).build();
		} else if (id != null && country == null) {
			return Response.ok(flights.stream().filter(f1 -> id == f1.getIdFlight()).findAny().orElse(null)).build();
		} else if (id == null && country != null) {
			return Response.ok(flights.stream().filter(f1 -> country.contains(f1.getDepartureCity())).findAny().orElse(null))
					.build();
		} else {
			return Response.ok(flights).build();
		}
	}}
