package com.codeup.tier1hire.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "interviews")
public class Interviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private long candidateId;

    @Column(nullable = false, unique = true)
    private long hrId;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    public Interviews(long id, long candidateId, long hrId, LocalDateTime appointmentTime) {
        this.id = id;
        this.candidateId = candidateId;
        this.hrId = hrId;
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "Interviews{" +
                "id=" + id +
                ", candidateId=" + candidateId +
                ", hrId=" + hrId +
                ", appointmentTime=" + appointmentTime +
                '}';
    }
}
