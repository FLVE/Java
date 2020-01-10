package me.iwjf.restful.dto;


import lombok.*;

/**
 * 员工
 * @author jiefa
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
}
