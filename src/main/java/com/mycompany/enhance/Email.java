import com.sun.mail.smtp.SMTPMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;  

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;


public class Email extends JFrame{

Container c;
JLabel labname;
static JTextField from_mail;
JTextField to_mail;
JButton btnsubmit;
JTextArea txtquery;



    public Email()
    {
        c = getContentPane();
        Color d = new Color(0,106,103);
        c.setLayout(new FlowLayout());
        labname = new JLabel("  Email  ");
        labname.setForeground(d);
        from_mail = new JTextField(18);
        setPlaceholder(from_mail, "Enter your Email");

        to_mail = new JTextField(18);
        setPlaceholder(to_mail, "Enter Recipient Email");

        btnsubmit = new JButton("Submit");
        txtquery = new JTextArea(9, 20);
        setPlaceholder2(txtquery, "Content....");

        Font f = new Font("Arial", Font.BOLD, 20);

        labname.setFont(f);
        from_mail.setFont(f);
        to_mail.setFont(f);
        btnsubmit.setFont(f);
        txtquery.setFont(f);

        c.add(labname);
        c.add(from_mail);
        c.add(to_mail);
        c.add(txtquery);
        c.add(btnsubmit);

        btnsubmit.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
            btnsubmitActionPerformer(evt);
            
            }
        });
    }

        private void btnsubmitActionPerformer(java.awt.event.ActionEvent evt)
        {
            String from = this.from_mail.getText();
            String to = this.to_mail.getText();
            String enquiry = this.txtquery.getText();
//            String username = "siddhancomtjhacs@gmail.";
//            String password = "uueisbjucdglxxto";
            if(to.length()==0 || from.length()==0 || enquiry.length()==0)
            {
                JOptionPane.showMessageDialog(this, "Provide complete deatils");
            }
            else{
                Properties props = new Properties();
                props.put("mail.smtp.host","smtp.gmail.com");
                props.put("mail.smtp.port","587");
                props.put("mail.smtp.auth","true");
                props.put("mail.smtp.starttls.enable", "true");

//                Session session = Session.getInstance(props, new Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });

                   Session session = Session.getDefaultInstance(props, new Authenticator(){
                   @Override
                   protected PasswordAuthentication getPasswordAuthentication(){
                       return new PasswordAuthentication("siddhantjhacs@gmail.com","rhes yhof vtds tfrs");
                   }
                           });
                

                try{

                    //composing mail

                    SMTPMessage sendMessage = new SMTPMessage(session);

                    sendMessage.setFrom(new InternetAddress("siddhantjhacs@gmail.com"));
                    sendMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    sendMessage.setText(enquiry);

                    //sending mail

                    Transport.send(sendMessage);
                    JOptionPane.showMessageDialog(this,"Mail Sent");
                }catch(HeadlessException | MessagingException e){
                   System.out.println("issues here "+e);
                }
            }

        }



            //    //this is responsible to send email
            //    public static void sendEmail(String enquiry, String name2, String phone ){

            //     //variable for gmail
            //     String host = "smtp.gmail.com";

            //     //get the system properties
            //     Properties properties = System.getProperties();
            //     System.out.println("PROPERTIES "+properties);
            //    //checkagain

            //    //setting important informationi to properties object

            //    //host set
            //    properties.put("mail.smtp.host", host);
            //    properties.put("mail.smtp.port", "465");
            //    properties.put("mail.smtp.ssl.enable", "true");
            //    properties.put("mail.smtp.auth","true");
                

            //    //step1: to get into session object
            //    Session session = Session.getInstance(properties, new Authenticator(){
            //     @Override
            //     protected PasswordAuthentication getPasswordAuthentication(){
            //         return new PasswordAuthentication(txtname.getText(), "utrdlatkirygrsiw");
            //     }
            // });

            // session.setDebug(true);

            // //Step2: compose the message[text,multi media]

            // MimeMessage m = new MimeMessage(session);
            // try{

            //     //from email
            //     m.setFrom(name);

            //     //adding recipient to message
            //     m.addRecipient(Message.RecipientType.TO, new InternetAddress(phone));

            //     //adding text to message
            //     m.setText(enquiry);

            //     //send mail

            //     //Step3; send message with Transport class

            //     Transport.send(m);
            //     System.out.println("Send successfully");
            // }catch (Exception e){
            
            //     e.printStackTrace();
            // }

            // }
        
        
    

    


        private void setPlaceholder(JTextField component, String placeholder) {
        component.setText(placeholder);
        component.setForeground(Color.GRAY);

        component.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (component.getText().equals(placeholder)) {
                    component.setText("");
                    component.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (component.getText().isEmpty()) {
                    component.setText(placeholder);
                    component.setForeground(Color.GRAY);
                }
            }
        });
    }
    

        private void setPlaceholder2(JTextArea component, String placeholder) {
        component.setText(placeholder);
        component.setForeground(Color.GRAY);

        component.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (component.getText().equals(placeholder)) {
                    component.setText("");
                    component.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (component.getText().isEmpty()) {
                    component.setText(placeholder);
                    component.setForeground(Color.GRAY);
                }
            }
        });

    
    }

    

    

        
};



// public  class Email
// {
//     public static void main(String[] args) {
//         App a = new App();
//         a.setVisible(true);
//         a.setSize(600,650);
//         a.setTitle("Course Enquiry");
//         a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         a.setLocationRelativeTo(null);
//     }
// }
