package com.piotrek.transactions;

import com.piotrek.transactions.services.CohortService;
import com.piotrek.transactions.services.CoordinatorService;
import com.piotrek.transactions.services.HelloWorldService;
import com.piotrek.transactions.util.Role;
import com.piotrek.transactions.util.SystemProperties;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Defines REST services.
 *
 * @author Piotrek
 */
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        String role = SystemProperties.getProperty("role", true);
        Set<Class<?>> set = new HashSet<>();
        set.add(HelloWorldService.class);
        if(role != null) {
            if(Role.COHORT.compare(role))
                set.add(CohortService.class);
            else if(Role.COORDINATOR.compare(role))
                set.add(CoordinatorService.class);
        }

        return set;
    }
}
