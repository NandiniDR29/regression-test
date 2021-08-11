/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.bpm.model.tasks;

import com.exigen.istf.data.TestData;
import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TasksResponseModel extends RestError implements Comparable<TasksResponseModel> {

    private String agencyCd;
    private String brandCd;
    private String name;
    private String id;
    //additional fields needed for IPBQA-22587 checks
    private String dueDate;
    private String warningDate;
    private String description;
    private PriorityModel priority;
    //additional fields needed for IPBQA-22587 checks ends
    private AssignmentModel assignment;
    //flag to include additional fields to equals method
    private boolean includeAdditionalFields;
    private boolean excludeIdMatching;

    public TasksResponseModel() {
    }

    public TasksResponseModel(TestData testData, Map<String, String> mapper) {
        super(testData);
        this.agencyCd = testData.getValue("agencyCd");
        this.name = testData.getValue("name");
        this.dueDate = testData.getValue("dueDate");
        this.warningDate = testData.getValue("warningDate");
        this.description = testData.getValue("description");
        if (null != testData.getTestData("priority")) {
            this.priority = new PriorityModel(testData.getTestData("priority"));
        }
        this.id = mapper.get(testData.getValue("taskId"));
    }

    public TasksResponseModel(TestData testData) {
        super(testData);
        this.agencyCd = testData.getValue("agencyCd");
        this.name = testData.getValue("name");
        this.id = testData.getValue("taskId");
        this.description = testData.getValue("description");
        List<TestData> list = testData.getTestDataList("errors");
        if(!list.isEmpty()) {
            List<RestError> listError = new ArrayList<>();
            list.forEach(el -> listError.add(new RestError(el)));
            this.errors = listError;
        }
    }

    public String getAgencyCd() {
        return agencyCd;
    }

    public void setAgencyCd(String agencyCd) {
        this.agencyCd = agencyCd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AssignmentModel getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentModel assignment) {
        this.assignment = assignment;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getWarningDate() {
        return warningDate;
    }

    public void setWarningDate(String warningDate) {
        this.warningDate = warningDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TasksResponseModel includeAdditionalFields() {
        this.includeAdditionalFields = true;
        return this;
    }

    public TasksResponseModel excludeIdMatching() {
        this.excludeIdMatching = true;
        return this;
    }

    public PriorityModel getPriority() {
        return priority;
    }

    public void setPriority(PriorityModel priority) {
        this.priority = priority;
    }

    public String getBrandCd() {
        return brandCd;
    }

    public void setBrandCd(String brandCd) {
        this.brandCd = brandCd;
    }

    /**
     * Assignment does not include to equals because it do not need to check it in Task get/create tests
     * Assignment related checks will be done separately
     * Additional fields dueDate,warningDate and description will be compared in equals
     * after includeAdditionalFields() invocation, what will set includeAdditionalFields to true accordingly.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof RestError)) {
            return false;
        }

        if (getErrorCode() != null) {
            return super.equals(o);
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        TasksResponseModel that = (TasksResponseModel) o;

        if (!excludeIdMatching) {
            if (id != null ? !id.equals(that.id) : that.id != null) {
                return false;
            }
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (includeAdditionalFields) {
            if (dueDate != null ? !compareStringDateValue(this.dueDate, that.dueDate) : that.dueDate != null) {
                return false;
            }
            if (warningDate != null ? !compareStringDateValue(this.warningDate, that.warningDate) : that.warningDate != null) {
                return false;
            }
            if (description != null ? !description.equals(that.description) : that.description != null) {
                return false;
            }
            if (priority != null ? !priority.equals(that.priority) : that.priority != null) {
                return false;
            }
        }
        return agencyCd != null ? agencyCd.equals(that.agencyCd) : that.agencyCd == null;
    }

    @Override
    public int hashCode() {
        int result = agencyCd != null ? agencyCd.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        if (includeAdditionalFields) {
            result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
            result = 31 * result + (warningDate != null ? warningDate.hashCode() : 0);
            result = 31 * result + (description != null ? description.hashCode() : 0);
            result = 31 * result + (priority != null ? priority.hashCode() : 0);
        }
        return result;
    }

    @Override
    public String toString() {
        String toStr = "TasksResponse{" +
                "agencyCd='" + agencyCd + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'';
        if (includeAdditionalFields) {
            toStr = toStr + ", dueDate='" + dueDate + '\'' +
                    ", warningDate='" + warningDate + '\'' +
                    ", priority='" + priority + '\'' +
                    ", description='" + description + '\'';
        }
        toStr += '}';
        return toStr;
    }

    @Override
    public int compareTo(TasksResponseModel o) {
        int compareId = Integer.parseInt(o.getId());
        int currentId = Integer.parseInt(this.id);
        return currentId - compareId;
    }

    private boolean compareStringDateValue(String value1, String value2) {
        String first = value1.substring(0, value1.lastIndexOf(":"));
        String second = value1.substring(0, value2.lastIndexOf(":"));
        return first.equals(second);
    }
}
