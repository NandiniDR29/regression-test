package com.exigen.ren.rest.claim.model.claimintaketask;

import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class ClaimIntakeTaskStatusModel extends RestError {
    private List<String> messageList;
    private String contextDescription;
    private String status;
    private String successful;
    private String messagesAsString;

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public String getContextDescription() {
        return contextDescription;
    }

    public void setContextDescription(String contextDescription) {
        this.contextDescription = contextDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSuccessful() {
        return successful;
    }

    public void setSuccessful(String successful) {
        this.successful = successful;
    }

    public String getMessagesAsString() {
        return messagesAsString;
    }

    public void setMessagesAsString(String messagesAsString) {
        this.messagesAsString = messagesAsString;
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
        ClaimIntakeTaskStatusModel that = (ClaimIntakeTaskStatusModel) o;
        return Objects.equals(messageList, that.messageList) &&
                Objects.equals(contextDescription, that.contextDescription) &&
                Objects.equals(status, that.status) &&
                Objects.equals(successful, that.successful) &&
                Objects.equals(messagesAsString, that.messagesAsString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), messageList, contextDescription, status, successful, messagesAsString);
    }

}
