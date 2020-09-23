package be.vdab.sportmailing.messaging;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.events.ArtikelGemaakt;
import be.vdab.sportmailing.events.SporterGemaakt;
import be.vdab.sportmailing.exceptions.KanMailNietZendenException;
import be.vdab.sportmailing.mailing.LidMailing;
import be.vdab.sportmailing.services.SporterService;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Component
public class SporterListner {
    private final SporterService service;
    private final LidMailing mailing;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public SporterListner(SporterService service, LidMailing mailing) {
        this.service = service;
        this.mailing = mailing;
    }

    @RabbitListener(queues = "sportartikels")
    void verwerkBericht(ArtikelGemaakt gemaakt) {
        for (Sporter sporter : service.findAll()) {
            try {
                mailing.stuurEmail(sporter, gemaakt);
            } catch (KanMailNietZendenException ex) {
                logger.error("Kan mail niet sturen", ex);
            }
        }
    }
}
