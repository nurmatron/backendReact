/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.TravelEntity;
import java.util.ArrayList;
import java.util.List;
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
@Path("travelentity")
public class TravelEntityFacadeREST extends AbstractFacade<TravelEntity> {

    @PersistenceContext(unitName = "os2024backPU")
    private EntityManager em;

    public TravelEntityFacadeREST() {
        super(TravelEntity.class);
    }

    @GET
    @Path("{origin}/{destination}/{userId}")  //  fetch(`http://localhost:8080/os2024back/webresources/travelentity/${from}/${to}/${localStorage.getItem("userId")}`);
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String findRange(@PathParam("origin") String origin, @PathParam("destination") String destination, @PathParam("userId") String userId) {
        TravelEntity newTE = new TravelEntity(origin, destination, userId);
        create(newTE);
        return newTE.toJson();
    }

    @GET
    @Override
    @Path("getall")   // http://localhost:8080/os2024back/webresources/travelentity/getall
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TravelEntity> findAll() {
        return super.findAll();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, TravelEntity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public TravelEntity find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<TravelEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
