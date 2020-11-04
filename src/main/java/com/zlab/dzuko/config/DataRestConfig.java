package com.zlab.dzuko.config;

import com.zlab.dzuko.entity.Ad;
import com.zlab.dzuko.entity.AdCategory;
import com.zlab.dzuko.entity.Country;
import com.zlab.dzuko.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public DataRestConfig(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] theUnSupportedActions = {HttpMethod.POST, HttpMethod.DELETE,  HttpMethod.PUT};


        //disable HTTP methods: PUT, POST and DELETE
        disableHttpMethods(Ad.class, config, theUnSupportedActions);
        disableHttpMethods(AdCategory.class, config, theUnSupportedActions);
        disableHttpMethods(Country.class, config, theUnSupportedActions);
        disableHttpMethods(State.class, config, theUnSupportedActions);

        //call the internal helper methods
        expodedIds(config);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnSupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass )
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions))
                .withAssociationExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions));
    }

    private void expodedIds(RepositoryRestConfiguration config) {

        //expose entity ids
        //get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        //get the entity types for the entities
        for(EntityType entityType : entities){
            entityClasses.add(entityType.getJavaType());
        }

        //expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
