package be.vdab.sportmailing.mailing;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.events.ArtikelGemaakt;
import be.vdab.sportmailing.exceptions.KanMailNietZendenException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class DefaultLidMailing implements LidMailing{
    private final JavaMailSender sender;

    public DefaultLidMailing(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void stuurEmail(Sporter sporter, ArtikelGemaakt gemaakt) {
        try {
            var message = sender.createMimeMessage();
            var helper = new SimpleMailMessage();
            helper.setTo(sporter.getEmailadres());
            helper.setSubject("Geregistreerd");
            helper.setText("Er is een nieuw artikel:" + gemaakt.getNaam());
            sender.send(message);
        }
        catch (MailException ex) {
            throw new KanMailNietZendenException(ex);
        }
    }
}
