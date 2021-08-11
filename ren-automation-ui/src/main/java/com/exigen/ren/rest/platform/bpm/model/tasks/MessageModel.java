package com.exigen.ren.rest.platform.bpm.model.tasks;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class MessageModel extends Model {
    private String code;
    private String message;
    private String context;
    private String severity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MessageModel that = (MessageModel) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(context, that.context) &&
                Objects.equals(severity, that.severity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, message, context, severity);
    }
}
