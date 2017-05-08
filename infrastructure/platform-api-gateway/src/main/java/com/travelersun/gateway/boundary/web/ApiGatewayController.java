package com.travelersun.gateway.boundary.web;

import com.travelersun.gateway.application.CustomersServiceClient;
import com.travelersun.gateway.application.OwnerDetails;
import com.travelersun.gateway.application.VisitDetails;
import com.travelersun.gateway.application.VisitsServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Collections.emptyList;

/**
 * @author Maciej Szarlinski
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiGatewayController {

    private final CustomersServiceClient customersServiceClient;

    private final VisitsServiceClient visitsServiceClient;

    @GetMapping(value = "/")
    public String index(Model model){

        return "index";

    }

    @GetMapping(value = "owners/{ownerId}")
    @ResponseBody
    public OwnerDetails getOwnerDetails(final @PathVariable int ownerId) {
        final OwnerDetails owner = customersServiceClient.getOwner(ownerId);
        supplyVisits(owner, visitsServiceClient.getVisitsForPets(owner.getPetIds(), ownerId));
        return owner;
    }

    private void supplyVisits(final OwnerDetails owner, final Map<Integer, List<VisitDetails>> visitsMapping) {
        owner.getPets().forEach(pet ->
            pet.getVisits().addAll(Optional.ofNullable(visitsMapping.get(pet.getId())).orElse(emptyList())));
    }
}
