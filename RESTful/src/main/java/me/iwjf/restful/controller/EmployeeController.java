package me.iwjf.restful.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import	java.util.List;

import me.iwjf.restful.dto.Employee;
import me.iwjf.restful.dto.Salary;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 员工资源控制器
 * 设计restful接口步骤
 * 1.确定资源
 * 2.请求方式
 * 3.确定返回结果（类型，头信息，状态码）
 */
/**
 * @Controller
 * @ResponseBody
 *
 * */
@RestController
@RequestMapping("employees")
public class EmployeeController {

    /**
     * 获得所有员工
     * 设计restful接口步骤
     * 1.确定资源   /employees
     * 2.请求方式   get
     * 3.确定返回结果（类型，头信息，状态码）
     * @return
     */
    //@RequestMapping(value = "/employees",method = RequestMethod.GET)
    //@GetMapping("employees")
    @GetMapping
    //@ResponseBody
    public List<Employee> list(){
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1L,"admin"));
        list.add(new Employee(2L,"user"));
        return list;
    }

    /**
     * 获得某个员工的信息
     * 设计restful接口步骤
     * 1.确定资源   /employees/{name}   路径占位符
     * 2.请求方式   get
     * 3.确定返回结果（类型，头信息，状态码）
     *
     * 如果@PathVariable注解没有设置value，默认去路径上找寻相同名字的参数
     *
     * @return
     */
    //@GetMapping("employees/{id}")
    @GetMapping
    //@ResponseBody
    public Employee getById(@PathVariable Long id){
        return new Employee(id,"admin");
    }

    /**
     * 删除某个员工的信息
     * 设计restful接口步骤
     * 1.确定资源   /employees/{name}   路径占位符
     * 2.请求方式   delete
     * 3.确定返回结果（类型，头信息，状态码）
     *
     * 如果@PathVariable注解没有设置value，默认去路径上找寻相同名字的参数
     *
     * @return
     */
    //@DeleteMapping("employees/{id}")
    @DeleteMapping("{id}")
    //@ResponseBody
    public void deleteById(@PathVariable Long id, HttpServletResponse response){
        System.out.println("删除员工号为"+id+"的员工");
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    /**
     * 获取某个员工某个月的工资信息
     * 设计restful接口步骤
     * 1.确定资源   /employees/{name}/salaries/{month}   路径占位符
     * 2.请求方式   get
     * 3.确定返回结果（类型，头信息，状态码）
     *
     * @return
     */
    //@GetMapping("employees/{employeeId}/salaries/{month}")
    @GetMapping("{employeeId}/salaries/{month}")
    //@ResponseBody
    public Salary getSalaryByEmployee(@PathVariable Long employeeId,
                                      @PathVariable @DateTimeFormat(pattern = "yyyy-MM") Date month){

        return new Salary(1L,employeeId, BigDecimal.TEN,month);
    }

    /**
     * 给某个员工添加一条薪资记录
     * 设计restful接口步骤
     * 1.确定资源   /employees/{name}/salaries/{month}   路径占位符
     * 2.请求方式   post
     * 3.确定返回结果（类型，头信息，状态码）
     *
     * @return
     */
    //@PostMapping("employees/{employeeId}/salaries")
    @PostMapping("{employeeId}/salaries")
    //@ResponseBody
    public Salary save(Salary salary){
        return salary;
    }


}
