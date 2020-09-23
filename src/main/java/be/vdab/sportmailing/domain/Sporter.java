package be.vdab.sportmailing.domain;

import javax.persistence.*;

@Entity
@Table(name="sporters")
public class Sporter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String emailadres;
    protected Sporter(){}

    public Sporter(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getEmailadres() {
        return emailadres;
    }
}
