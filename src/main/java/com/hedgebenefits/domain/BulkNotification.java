package com.hedgebenefits.domain;

import javax.persistence.*;

@Entity
@Table(name = "bulk_notification")
public class BulkNotification {
    private static BulkNotification bulkNotification = new BulkNotification();
    private BulkNotification(){}

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="message")
    private String notificationMessage;
    @OneToOne
//    @PrimaryKeyJoinColumn
    //@JoinColumn(name = "pdf_message_fk")
    private PdfMessage pdfMessage;


    public String getNotificationMessage(){
        return notificationMessage;
    }

    public static BulkNotification getInstance(String notificationMessage, PdfMessage pdfMessage) {
        bulkNotification.notificationMessage = notificationMessage;
        bulkNotification.pdfMessage = pdfMessage;
        return bulkNotification;
    }

    public PdfMessage getPdfMessage() {
        return pdfMessage;
    }
}
