    package com.example.gestioncontrat.model;

    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.Getter;
    import lombok.Setter;

    import java.util.Set;

    @Entity
    @Data
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Column(unique = true)
        private String email;

        private String password;
        private String phone;
        private String address;

        @ManyToOne
        private Role role;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private Set<Contract> contrats;

        public User(String name, String email, String password, String phone, String address, Set<Contract> contrats) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.phone = phone;
            this.address = address;
            this.contrats = contrats;
        }

        public User() {

        }

    }
