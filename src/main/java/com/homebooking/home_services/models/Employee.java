    package com.homebooking.home_services.models;

    import java.util.Date;

    import org.hibernate.annotations.CreationTimestamp;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;


    @Entity
    @Table(name = "employees")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "enterprise_id", nullable = false)
        private Enterprise enterprise;

        @OneToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @Column(nullable = false)
        private String role;

        @Column(nullable = false, updatable = false)
        @CreationTimestamp
        private Date createdAt = new Date();
    }
