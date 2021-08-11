/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.claim.model.common.fnol;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class FNOLResponseMetadataModel extends Model {

    private String componentInstanceName;
    private String producerComponentName;
    private String producerComponentVersion;
    private String connectedToInstanceName;
    private String instanceName;

    public String getComponentInstanceName() {
        return componentInstanceName;
    }

    public void setComponentInstanceName(String componentInstanceName) {
        this.componentInstanceName = componentInstanceName;
    }

    public String getProducerComponentName() {
        return producerComponentName;
    }

    public void setProducerComponentName(String producerComponentName) {
        this.producerComponentName = producerComponentName;
    }

    public String getProducerComponentVersion() {
        return producerComponentVersion;
    }

    public void setProducerComponentVersion(String producerComponentVersion) {
        this.producerComponentVersion = producerComponentVersion;
    }

    public String getConnectedToInstanceName() {
        return connectedToInstanceName;
    }

    public void setConnectedToInstanceName(String connectedToInstanceName) {
        this.connectedToInstanceName = connectedToInstanceName;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }
}
