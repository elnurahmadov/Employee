package com.aykan.domain.user;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class PasswordResetToekn {
    @Transient
    private final int EXPIRY_DATE = 60 * 24;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String token;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(foreignKeyDefinition = "user_fk"))
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    public PasswordResetToekn() {
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    private PasswordResetToekn(String token, User user) {
        this.user = user;
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    private Date calculateExpiryDate(int expiry_date) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(o instanceof PasswordResetToekn)) return false;

        PasswordResetToekn that = (PasswordResetToekn) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
