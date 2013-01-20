package com.hedgebenefits.domain;


import javax.persistence.*;

@Entity
@Table(name = "pdf_message")
public class PdfMessage {

    private PdfMessage(){}
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "pdf_body")
    private String messageBody;
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private PDFMessageType messageType;

//    @OneToOne
//    private BulkNotification bulkNotification;

    public Long getId() {
        return id;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public PDFMessageType getMessageType() {
        return messageType;
    }

    public PdfMessage getInstance(){
        return PdfMessageBuilder.pdfMessageBuilder().build();
    }
    
//    public BulkNotification getBulkNotification() {
//        return bulkNotification;  //To change body of created methods use File | Settings | File Templates.
//    }
//
//    public void setBulkNotification(BulkNotification bulkNotification) {
//        this.bulkNotification = bulkNotification;
//    }

    public static class PdfMessageBuilder {
        private String messageBody;
        private PDFMessageType messageType;

        public static PdfMessageBuilder pdfMessageBuilder() {
            return new PdfMessageBuilder();  //To change body of created methods use File | Settings | File Templates.
        }

        public PdfMessage build() {
            PdfMessage pdfMessage = new PdfMessage();
            pdfMessage.messageBody = messageBody;
            pdfMessage.messageType = messageType;
            return pdfMessage;  //To change body of created methods use File | Settings | File Templates.
        }

        public PdfMessageBuilder messageBody(String body) {
            messageBody = body;
            return this;  //To change body of created methods use File | Settings | File Templates.
        }

        public PdfMessageBuilder messsageType(PDFMessageType messageType) {
            this.messageType = messageType;
            return this;  //To change body of created methods use File | Settings | File Templates.
        }
    }
}
