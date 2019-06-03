package service;

import entity.SavedTravelEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("savedtravelentity")
public class SavedTravelEntityFacadeREST extends AbstractFacade<SavedTravelEntity> {

    @PersistenceContext(unitName = "os2024backPU")
    private EntityManager em;

    public SavedTravelEntityFacadeREST() {
        super(SavedTravelEntity.class);
    }

    @GET // http://localhost:8080/os2024back/webresources/savedtravelentity/
    @Path("{origin}/{destination}/{userId}/{distance}/{duration}/{price}/{transport}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createFromPath(@PathParam("origin") String origin,
            @PathParam("destination") String destination,
            @PathParam("userId") String userId,
            @PathParam("distance") String distance,
            @PathParam("duration") String duration,
            @PathParam("price") String price,
            @PathParam("transport") String transport) {
        SavedTravelEntity STE = new SavedTravelEntity(origin, destination, userId, distance, duration, price, transport);
        create(STE);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(SavedTravelEntity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, SavedTravelEntity entity) {
        super.edit(entity);
    }

    @GET // MUST be GET for react to be able to access it...
    @Path("delete/{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public SavedTravelEntity find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Path("getall")
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SavedTravelEntity> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("getall/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<SavedTravelEntity> getSavedList(@PathParam("userId") String idToCheck){
        List savedList;
        savedList = findAll().stream().filter(x -> x.getUserId().equals(idToCheck)).collect(Collectors.toList());
        return savedList;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SavedTravelEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
