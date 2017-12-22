package services;

import com.dimon.domain.Student;
import com.dimon.domain.StudentRepository;
import com.dimon.presentation.AppConfig;
import com.dimon.services.ApplicationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ApplicationServiceImplIntegrationTest {

    @Autowired
    private ApplicationService service;

    @Autowired
    private StudentRepository repository;

    @Test
    public void testCreate100RandomStudents() {
        repository.removeAllStudents();

        service.create100RandomStudents();

        List<Student> students = repository.getAllStudents();
        Assert.assertEquals(students.size(), 100);
    }

    @Test
    public void outputDuplicateStudentsNormalTest() {
        repository.removeAllStudents();
        service.create100RandomStudents();

        List<Student> students = service.outputDuplicateStudents();
        Assert.assertEquals(10, students.size());
    }

    @Test
    public void outputDuplicateStudentsEmptyTest() {
        repository.removeAllStudents();
        service.outputDuplicateStudents();

        List<Student> students = repository.getAllStudents();
        Assert.assertEquals(students.size(), 0);
    }

}
