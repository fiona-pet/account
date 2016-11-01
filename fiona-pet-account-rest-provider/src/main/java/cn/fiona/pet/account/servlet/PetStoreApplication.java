package cn.fiona.pet.account.servlet;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class PetStoreApplication extends Application {
    HashSet<Object> singletons = new HashSet<Object>();

    public PetStoreApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("2.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8828");
        beanConfig.setBasePath("/api/v2");
        beanConfig.setFilterClass("cn.fiona.pet.account.util.ApiAuthorizationFilterImpl");
        beanConfig.setResourcePackage("cn.fiona.pet.account.facade");
        beanConfig.setScan(false);
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();

//        set.add(UserResource.class);
//        set.add(MessageRestService.class);
//        set.add(MessageRestServiceImpl.class);

        set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
