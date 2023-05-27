package org.acme;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/registration")
public class RegistrationResource {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationResource.class);
    @Inject
    RegistrationService registrationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void register(@Valid @NotNull RegistrationDTO registration) {
        var name = registration.name();
        var surname = registration.surname();
        var email = registration.email();
        var approved = registration.approved();
        LOG.debug("registration for {}", name + " " + surname + " | " + email + " | " + approved);
        registrationService.register(registration.name(), registration.surname(), registration.email(), registration.approved());
    }

    @GET
    @Path("/get_registrations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object getAllRegistrations() {
        LOG.debug("test GET");
        return registrationService.getAll();
    }

    @PUT
    @Path("/update_registrations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateRegistrations(RegistrationEntity registrationEntity) {
        LOG.debug("test PUT");
        registrationService.updateRegistrations(registrationEntity);
    }
}
