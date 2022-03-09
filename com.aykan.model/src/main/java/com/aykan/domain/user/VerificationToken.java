package com.aykan.domain.user;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "VerificationToken")
public class VerificationToken {
    @Transient
    private final int EXPIRY_DATE = 60 * 24;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    public VerificationToken() {
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    public VerificationToken(User user, String token) {
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    private Date calculateExpiryDate(int EXPIRY_DATE) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, EXPIRY_DATE);
        return new Date(calendar.getTime().getTime());
    }

    public int getEXPIRY_DATE() {
        return EXPIRY_DATE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerificationToken)) return false;

        VerificationToken that = (VerificationToken) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
