package com.zlab.dzuko.config;

import com.zlab.dzuko.entity.Ad;
import com.zlab.dzuko.entity.AdCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.HttpMethods;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] theUnSupportedActions = {HttpMethod.POST, HttpMethod.DELETE,  HttpMethod.PUT};

        //disable HTTP methods for ad: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Ad.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions))
                .withAssociationExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions));

        //disable HTTP methods for ad category: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(AdCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions))
                .withAssociationExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions));
    }
}
