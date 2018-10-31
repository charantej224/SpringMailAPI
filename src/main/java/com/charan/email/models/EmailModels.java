
package com.charan.email.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sendTo",
    "ccTo",
    "bccTo",
    "attachments",
    "subject",
    "template",
    "sentDate"
})
public class EmailModels {

    @JsonProperty("sendTo")
    private String sendTo;
    @JsonProperty("ccTo")
    private String ccTo;
    @JsonProperty("bccTo")
    private String bccTo;
    @JsonProperty("attachments")
    private List<Attachment> attachments = null;
    
    @JsonProperty("subject")
    private String subject;
    
    @JsonProperty("subject")
    public String getSubject() {
		return subject;
	}

    @JsonProperty("subject")
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@JsonProperty("template")
    private String template;
    @JsonProperty("sentDate")
    private String sentDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EmailModels() {
    }

    /**
     * 
     * @param template
     * @param sendTo
     * @param sentDate
     * @param ccTo
     * @param attachments
     * @param bccTo
     */
    public EmailModels(String sendTo, String ccTo, String bccTo, List<Attachment> attachments, String template, String sentDate) {
        super();
        this.sendTo = sendTo;
        this.ccTo = ccTo;
        this.bccTo = bccTo;
        this.attachments = attachments;
        this.template = template;
        this.sentDate = sentDate;
    }

    @JsonProperty("sendTo")
    public String getSendTo() {
        return sendTo;
    }

    @JsonProperty("sendTo")
    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    @JsonProperty("ccTo")
    public String getCcTo() {
        return ccTo;
    }

    @JsonProperty("ccTo")
    public void setCcTo(String ccTo) {
        this.ccTo = ccTo;
    }

    @JsonProperty("bccTo")
    public String getBccTo() {
        return bccTo;
    }

    @JsonProperty("bccTo")
    public void setBccTo(String bccTo) {
        this.bccTo = bccTo;
    }

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty("sentDate")
    public String getSentDate() {
        return sentDate;
    }

    @JsonProperty("sentDate")
    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
