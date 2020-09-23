package be.vdab.sportmailing.mailing;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.events.ArtikelGemaakt;

public interface LidMailing {
    void stuurEmail(Sporter sporter, ArtikelGemaakt gemaakt);
}
