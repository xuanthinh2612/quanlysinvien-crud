package demo.quanlysinhvien.repository;

import demo.quanlysinhvien.model.ClassGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository <ClassGroup, Integer> {
}
