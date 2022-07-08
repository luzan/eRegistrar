package edu.miu.cs.cs425.eregistar.Repository;

import edu.miu.cs.cs425.eregistar.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    // This interface definition relies on the public abstract methods
    // inherited from the super interface, CrudRepository<T, ID>
    // We may override any or add more methods here, if needed.
    List<Student> findByFirstNameContainingIgnoreCase(String name);
}
