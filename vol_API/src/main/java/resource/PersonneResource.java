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

import entity.Personne;

@Path("Personne")
public class PersonneResource {

	private List<Personne> Personne = new ArrayList<>();

	public PersonneResource() {
		Personne p1 = new Personne(12,10,"youssef","abdelj");
		Personne.add(p1);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPersonne() {
		return Response.ok(Personne).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonne(@PathParam("id") int id) {
		return Response.ok(Personne.stream().filter(
				Personne -> id == Personne.getIdFlight())
				.findAny().orElse(null)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPersonne(Personne p1) {
		Personne.add(p1);
		return Response.ok(Personne).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Personne newPersonne) {
		Personne oldPersonne = Personne.stream().filter(f -> id == f.getIdFlight()).findAny().orElse(null);
		if (oldPersonne == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Personne.remove(id);
		Personne.add(newPersonne);
		return Response.ok(Personne).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		Personne.remove(id);
		return Response.ok(Personne).build();
	}

	@GET
	@Path("_search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@QueryParam("id") Integer id, @QueryParam("nom") String name) {
		if (id != null && name != null) {
			return Response.ok(Personne.stream().filter(p1 -> id == p1.getIdFlight() && name.contains(p1.getNom()))
					.findAny().orElse(null)).build();
		} else if (id != null && name == null) {
			return Response.ok(Personne.stream().filter(p1 -> id == p1.getIdFlight()).findAny().orElse(null)).build();
		} else if (id == null && name != null) {
			return Response.ok(Personne.stream().filter(p1 -> name.contains(p1.getNom())).findAny().orElse(null))
					.build();
		} else {
			return Response.ok(Personne).build();
		}
	}}
