package demo.quanlysinhvien.model;

import demo.quanlysinhvien.service.ClassService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer age;
    @Column
    private String email;
    @Column
    private Integer phoneNumber;
    @Column
    private String address;
    @Column
    private Integer classId;

    private String className;

}
