package services;

import com.dimon.domain.Student;
import com.dimon.domain.StudentRepository;
import com.dimon.services.ApplicationServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceImplTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    ApplicationServiceImpl app ;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        app = new ApplicationServiceImpl(repository);
    }

    // Проверка на количество вызовов метода репозитории
    @Test
    public void TestOutputDuplicateNameEntities() {
        app.outputDuplicateStudents();
        verify(repository, times(1)).getAllStudents();
    }

    // Проверка на количество вызовов метода создания студента в репозитории
    @Test
    public void testCreate100Students() {
        app.create100RandomStudents();
        verify(repository, times(100)).addStudent(Mockito.any(Student.class));
    }

    // Проверка на корректность возвращаемых дублируемых данных
    @Test
    public void outputDuplicateStudents() {
        List<Student> test = new ArrayList<Student>();
        test.add(new Student(1, "name1", "surname1", "0939330036", "name.student1@gmail.com", 1));
        test.add(new Student(2, "name2", "surname2", "0939330032", "name.student2@gmail.com", 3));
        test.add(new Student(3, "name3", "surname3", "0939330033", "name.student3@gmail.com", 2));
        test.add(new Student(1, "name1", "surname1", "0939330036", "name.student1@gmail.com", 1));
        when(repository.getAllStudents()).thenReturn(test);
        List<Student> testEND = new ArrayList<Student>();
        testEND.add(new Student(1, "name1", "surname1", "0939330036", "name.student1@gmail.com", 1));
        assertEquals(testEND, app.outputDuplicateStudents());
        verify(repository).getAllStudents();
    }

    // Проверка на корректность при отсутствии дублируемых данных
    @Test
    public void outputDuplicateNameStudentsNoSameDate() {
        List<Student> test = new ArrayList<Student>();
        test.add(new Student(1, "name1", "surname1", "0939330036", "name.student1@gmail.com", 1));
        test.add(new Student(2, "name2", "surname2", "0939330032", "name.student2@gmail.com", 3));
        test.add(new Student(3, "name3", "surname3", "0939330033", "name.student3@gmail.com", 2));
        when(repository.getAllStudents()).thenReturn(test);
        List<Student> testEND = new ArrayList<Student>();
        assertEquals(testEND, app.outputDuplicateStudents());
        verify(repository).getAllStudents();
    }

    // Проверка на корректность при отсутствии данных в списке
    @Test
    public void outputDuplicateNameStudentsWithEmptyData() {
        List<Student> test = new ArrayList<Student>();
        when(repository.getAllStudents()).thenReturn(test);
        assertTrue(app.outputDuplicateStudents().size() == 0);
        verify(repository).getAllStudents();
    }
}
