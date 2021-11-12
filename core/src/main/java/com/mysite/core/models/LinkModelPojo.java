package com.mysite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkModelPojo {
    @ValueMapValue
    private String title;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String option;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getOption() {
        return option;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
