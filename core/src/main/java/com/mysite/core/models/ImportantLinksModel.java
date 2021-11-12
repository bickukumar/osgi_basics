package com.mysite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.osgi.service.component.annotations.Reference;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ImportantLinksModel {

    @Reference
    ResourceResolver rs;

    @Inject
    private List<LinkModelPojo> links;

    public List<LinkModelPojo> getLinks() {
        return new ArrayList<LinkModelPojo>();
    }

    public void setLinks(List<LinkModelPojo> links) {

        for(LinkModelPojo linkModelPojo : links){
            String url = linkModelPojo.getLink();

            if(url.startsWith("/content")){
                Resource resource = rs.getResource(url);
                if(resource != null){
                    url += ".html";
                } else {
                    url = url;
                }
            }
        }
    }
}













