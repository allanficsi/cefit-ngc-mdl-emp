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
            mail.setContent("Bem vindo ao Cefit! abaixo a sua nova  senha." + "\n\n" + "Senha: "+ senha);
        }else {
            mail.setSubject("Confirmação De Cadastro");
            mail.setContent("Bem vindo ao Cefit! abaixo segue login e senha." + "\n\n"+"Login: "+ login + "\n" + "Senha: "+ senha);
        }
        mail.setTo(email);

       this.sendSimpleMessage(mail);
    }


    private void sendSimpleMessage(final Email email){

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
