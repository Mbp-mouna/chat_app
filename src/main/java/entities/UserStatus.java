package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_STATUS")
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "STATUS")
    private String status;


    public UserStatus(Long id, User user, String status) {
        this.id = id;
        this.user = user;
        this.status = status;
    }

    public UserStatus() {

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}