/**
 * Copyright (c) 2012
 */
package com.travelersun.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.travelersun.utils.annotation.MetaData;
import com.travelersun.utils.json.JsonViews;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Access(AccessType.FIELD)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "javassistLazyInitializer", "revisionEntity", "handler" }, ignoreUnknown = true)
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> extends PersistableEntity<ID> {

    private static final long serialVersionUID = 2476761516236455260L;

    @MetaData(value = "乐观锁版本")
    @Column(name = "version", nullable = false)
    @JsonProperty
    @JsonView(JsonViews.Admin.class)
    private Integer version = 0;

    @Column(name = "create_by",length = 100)
    @JsonProperty
    @JsonView(JsonViews.Admin.class)
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty
    @Column(name = "created_date")
    protected Date createdDate;


    @JsonProperty
    @JsonView(JsonViews.Admin.class)
    @Column(name = "last_modified_by",length = 100)
    private String lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty
    @JsonView(JsonViews.Admin.class)
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    private static final String[] PROPERTY_LIST = new String[] { "id", "version" };

    public String[] retriveCommonProperties() {
        return PROPERTY_LIST;
    }

    @Override
    @Transient
    @JsonProperty
    @JsonView(JsonViews.Admin.class)
    public String getDisplay() {
        return "[" + getId() + "]" + this.getClass().getSimpleName();
    }
}
