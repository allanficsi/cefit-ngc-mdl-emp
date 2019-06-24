package br.com.aptare.cefit.email.service;

import br.com.aptare.cefit.email.entity.Email;
import br.com.aptare.fda.crud.service.AptareService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class EmailService extends AptareService<Email> {



    private JavaMailSenderImpl emailSender;

    private static EmailService instancia;

    public static EmailService getInstancia()
    {
        if (instancia == null)
        {
            instancia = new EmailService();
        }
        return instancia;
    }

    public void enviarEmailNotificacao(String email,String login, String senha, Boolean flagRecuperarSenha){

        Email mail = new Email();
        if(flagRecuperarSenha){
            mail.setSubject("Recuperação De Senha");
            mail.setContent("Bem vindo ao Cefit! abaixo segue login e a nova  senha." + "\n\n"+"Login: "+ login + "\n" + "Senha: "+ senha);
        }else {
            mail.setSubject("Confirmação De Cadastro");
            mail.setContent("Bem vindo ao Cefit! abaixo segue login e senha." + "\n\n"+"Login: "+ login + "\n" + "Senha: "+ senha);
        }
        mail.setTo(email);

       this.sendSimpleMessage(mail);
    }


    private void sendSimpleMessage(final Email email){

//        spring.mail.default-encoding=UTF-8
//        spring.mail.host=smtp.gmail.com
//        spring.mail.username=cefitsignac@gmail.com
//                spring.mail.password=allan1992torres
//        spring.mail.port=587
//        spring.mail.protocol=smtp
//        spring.mail.test-connection=false
//        spring.mail.properties.mail.smtp.auth=true
//        spring.mail.properties.mail.smtp.starttls.enable=true


        emailSender = new JavaMailSenderImpl();
        emailSender.setHost("smtp.gmail.com");
        emailSender.setPort(587);

        emailSender.setUsername("cefitsignac@gmail.com");
        emailSender.setPassword("allan1992torres");

        Properties props = emailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");


        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        message.setTo(email.getTo());
        //message.setFrom(email.getFrom());

        emailSender.send(message);
    }

}
