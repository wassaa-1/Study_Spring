package dev.bank.bankstatement.core.todo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Setter @Getter
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="id", example="1, 2, 3 ...")
    private Long id;


    @NotBlank
    @ApiModelProperty(value="name", example="밥먹기, 물먹기 ...", required = true)
    private String name;

    public Todo() {
        System.out.println("Todo() called");
    }
}
