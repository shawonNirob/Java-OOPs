package Remotask;

import java.util.*;

public class EmailQueue {

    private final List<Email> emails = new ArrayList<>();

    public void insert(Email email) {
        emails.add(email);
    }

    public Email delete(String id) {
        for (int i = 0; i < emails.size(); i++) {
            if (emails.get(i).getId().equals(id)) {
                emails.remove(i);
                return emails.get(i);
            }
        }
        return null;
    }

    public Email search(String subject) {
        for (Email email : emails) {
            if (email.getSubject().equals(subject)) {
                return email;
            }
        }
        return null;
    }

    public Email getNewestEmail() {
        if (emails.isEmpty()) {
            return null;
        }
        return emails.get(emails.size() - 1);
    }

    public static void main(String[] args) {
        EmailQueue emailQueue = new EmailQueue();
        emailQueue.insert(new Email("1", "New email 1", "This is the first email."));
        emailQueue.insert(new Email("2", "New email 2", "This is the second email."));
        emailQueue.insert(new Email("3", "New email 3", "This is the third email."));

        System.out.println("The newest email is: " + emailQueue.getNewestEmail().toString());

        System.out.println("Deleting email with ID 2...");
        emailQueue.delete("2");

        System.out.println("The newest email is now: " + emailQueue.getNewestEmail().toString());

        System.out.println("Searching for email with subject 'New email 3'...");
        Email email = emailQueue.search("New email 3");
        if (email != null) {
            System.out.println("Found email: " + email.toString());
        } else {
            System.out.println("Email not found.");
        }
    }
}

class Email {

    private String id;
    private String subject;
    private String body;

    public Email(String id, String subject, String body) {
        this.id = id;
        this.subject = subject;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
