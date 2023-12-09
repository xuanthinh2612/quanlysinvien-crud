package demo.quanlysinhvien.service;

import demo.quanlysinhvien.model.ClassGroup;
import demo.quanlysinhvien.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;

    @Override
    public ClassGroup save(ClassGroup classGroup) {
        return classRepository.save(classGroup);
    }
    @Override
    public void delete(Integer classGroupId) {
        classRepository.deleteById(classGroupId);
    }
    @Override
    public List<ClassGroup> findAll() {
        return classRepository.findAll();
    }
    @Override
    public ClassGroup findById(Integer classGroupId) {
        return classRepository.findById(classGroupId).orElse(null);
    }

}
