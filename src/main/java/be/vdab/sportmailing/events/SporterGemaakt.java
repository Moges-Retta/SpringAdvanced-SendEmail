package be.vdab.sportmailing.events;

import be.vdab.sportmailing.domain.Sporter;

public class SporterGemaakt {
    private long id;
    private String emailadres;
    public Sporter naarSporter() {
        return new Sporter(id);
    }

    public long getId() {
        return id;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }
}
