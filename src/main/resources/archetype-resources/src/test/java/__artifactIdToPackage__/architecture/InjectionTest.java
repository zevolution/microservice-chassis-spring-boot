package ${groupId}.${artifactIdToPackageImport}.architecture;

import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.conditions.ArchConditions;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "${groupId}")
public class InjectionTest {

    @ArchTest
    static ArchRule injectAnnotationFieldValidator = ArchRuleDefinition
            .noFields().should(beAnnotatedWithAnInjectionAnnotation())
            .because("field injection is considered harmful; use constructor injection or setter injection instead; see https://stackoverflow.com/q/39890849 for detailed explanations");

    private static ArchCondition<JavaField> beAnnotatedWithAnInjectionAnnotation() {
        ArchCondition<JavaField> annotatedWithSpringAutowired = ArchConditions.beAnnotatedWith("org.springframework.beans.factory.annotation.Autowired");
        ArchCondition<JavaField> annotatedWithJakartaInject = ArchConditions.beAnnotatedWith("javax.inject.Inject");
        return annotatedWithSpringAutowired.or(annotatedWithJakartaInject);
    }

}
