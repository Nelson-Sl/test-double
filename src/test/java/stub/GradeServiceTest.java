package stub;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GradeServiceTest {
    /* 需求描述：
    编写GradeService类的单元测试，单元测试calculateAverageGrades方法
    原理：由于calculateAverageGrades中使用了GradeSystem中的数据，因此在Mock测试的时候，需要重新继承GradeSystem类为
    其定一个值以确认结果。
    * */
    class MockGradeSystem extends GradeSystem {
        public List<Double> gradesFor(long studentId) {
            return Arrays.asList(80.0, 90.0, 100.0);
        }
    }

    private MockGradeSystem newGrade = new MockGradeSystem();

    @Test
    public void shouldReturn90WhenCalculateStudentAverageGradeAndGradeIs80And90And100() {
        GradeService gradeService = new GradeService(newGrade);
        double result = gradeService.calculateAverageGrades(1);
        Assertions.assertEquals(90.0, result);
    }
}
