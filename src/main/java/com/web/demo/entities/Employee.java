package com.web.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "EMPLOYEE")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPNO")
    private Long id;
    @Column(name = "ENAME")
    private String name;
    @Column(name = "JOB")
    private String job;
    @Column(name = "MGR")
    private int manager;
    @Column(name = "HIREDATE")
    private String hireDate;
    @Column(name = "SAL")
    private Long salary;
    @Column(name = "COMM")
    private String comm;
    @Column(name = "DEPTNO")
    private int deptNo;

}
