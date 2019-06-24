package br.com.aptare.cefit.email.service;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Arrays;
import java.util.List;

public class SenhaService  {



    private JavaMailSenderImpl emailSender;

    private static SenhaService instancia;

    public static SenhaService getInstancia()
    {
        if (instancia == null)
        {
            instancia = new SenhaService();
        }
        return instancia;
    }

    public String gerarSenhaAleatoria() {

        List rules = Arrays.asList(
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1));

        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(8, rules);
        return password;
    }

}
