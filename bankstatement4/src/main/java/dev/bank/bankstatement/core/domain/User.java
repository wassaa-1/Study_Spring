package dev.bank.bankstatement.core.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class User {
    @Id
    private String id;
    private String password;

}
