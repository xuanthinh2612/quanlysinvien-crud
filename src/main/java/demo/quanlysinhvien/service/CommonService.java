package demo.quanlysinhvien.service;

import demo.quanlysinhvien.model.Student;

import java.util.List;

public interface CommonService <T>{
    T save(T t);
    T findById(Integer id);
    void delete(Integer id);
    List<T> findAll();
}
