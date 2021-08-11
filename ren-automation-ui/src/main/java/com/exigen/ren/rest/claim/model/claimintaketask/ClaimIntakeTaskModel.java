package com.exigen.ren.rest.claim.model.claimintaketask;

import com.exigen.ren.rest.model.RestError;

import java.util.Objects;

public class ClaimIntakeTaskModel extends RestError {
    private String claimId;
    private String taskId;
    private ClaimIntakeTaskStatusModel status;

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public ClaimIntakeTaskStatusModel getStatus() {
        return status;
    }

    public void setStatus(ClaimIntakeTaskStatusModel status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ClaimIntakeTaskModel that = (ClaimIntakeTaskModel) o;
        return Objects.equals(claimId, that.claimId) &&
                Objects.equals(taskId, that.taskId) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), claimId, taskId, status);
    }

}
