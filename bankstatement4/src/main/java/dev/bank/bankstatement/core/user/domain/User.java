package dev.bank.bankstatement.core.user.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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

    // DTO(Data Transfer Object)를 이너 클래스(inner class) 형태로 작성
    public static class Request {

        @NotBlank
        private String id;

        @NotBlank
        @Length(min = 6, max = 12)
        private String password;

        public void setId(String id) {
            System.out.println("setId() called");
            this.id = id;
        }

        public void setPassword(String password) {
            System.out.println("setPassword() called");
            this.password = password;
        }
    }
}
