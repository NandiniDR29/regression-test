/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.bpm.model.processinstance;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProcessInstanceInfoReply")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessInstanceInfoReplyModel extends Model {

    private String actProcessInstanceId;
    private String processBusinessContextId;
    private String processStarted;

    public ProcessInstanceInfoReplyModel() {
    }

    public String getActProcessInstanceId() {
        return actProcessInstanceId;
    }

    public void setActProcessInstanceId(String actProcessInstanceId) {
        this.actProcessInstanceId = actProcessInstanceId;
    }

    public String getProcessBusinessContextId() {
        return processBusinessContextId;
    }

    public void setProcessBusinessContextId(String processBusinessContextId) {
        this.processBusinessContextId = processBusinessContextId;
    }

    public String getProcessStarted() {
        return processStarted;
    }

    public void setProcessStarted(String processStarted) {
        this.processStarted = processStarted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProcessInstanceInfoReplyModel that = (ProcessInstanceInfoReplyModel) o;

        if (actProcessInstanceId != null ? !actProcessInstanceId.equals(that.actProcessInstanceId) : that.actProcessInstanceId != null) {
            return false;
        }
        if (processBusinessContextId != null ? !processBusinessContextId.equals(that.processBusinessContextId) : that.processBusinessContextId != null) {
            return false;
        }
        return processStarted != null ? processStarted.equals(that.processStarted) : that.processStarted == null;
    }

    @Override
    public int hashCode() {
        int result = actProcessInstanceId != null ? actProcessInstanceId.hashCode() : 0;
        result = 31 * result + (processBusinessContextId != null ? processBusinessContextId.hashCode() : 0);
        result = 31 * result + (processStarted != null ? processStarted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProcessInstanceInfoReply{" +
                "actProcessInstanceId='" + actProcessInstanceId + '\'' +
                ", processBusinessContextId='" + processBusinessContextId + '\'' +
                ", processStarted='" + processStarted + '\'' +
                '}';
    }
}
