package me.iwjf.restful.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import	java.util.Date;


import java.math.BigDecimal;

/**
 * 每月员工工资信息
 * @author jiefa
 */

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    private Long id;
    /**
     * 员工ID
     */
    private Long employeeId;

    /**
     * 工资
     */
    private BigDecimal money;

    /**
     * 所属时间
     */
    @JsonFormat(pattern = "yyyy-MM",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date month;
}
