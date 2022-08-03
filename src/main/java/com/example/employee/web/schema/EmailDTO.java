package com.example.employee.web.schema;

import com.example.employee.domain.Email;

public class EmailDTO {

    private final String emailAddress;

    private final EmailType emailType;

    private EmailDTO(String emailAddress, EmailType emailType) {
        this.emailAddress = emailAddress;
        this.emailType = emailType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static Email to(EmailDTO emailDTO){
        return new Email(emailDTO.getEmailAddress(), emailDTO.getEmailType());
    }

    public static class Builder {

        private String emailAddress;

        private EmailType emailType;

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setEmailType(EmailType emailType) {
            this.emailType = emailType;
            return this;
        }

        public EmailDTO build(){
            return new EmailDTO(this.emailAddress, this.emailType);
        }
    }
}
