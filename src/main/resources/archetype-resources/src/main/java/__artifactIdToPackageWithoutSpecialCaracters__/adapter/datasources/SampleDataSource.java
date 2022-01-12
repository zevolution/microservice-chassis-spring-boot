package ${groupId}.${artifactIdToPackageImport}.adapter.datasources;

import ${groupId}.${artifactIdToPackageImport}.internal.entities.Sample;
import ${groupId}.${artifactIdToPackageImport}.bootstrap.exceptions.NotFoundException;
import ${groupId}.${artifactIdToPackageImport}.internal.repositories.SampleRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

@Component
public class SampleDataSource implements SampleRepository {

    private static final Set<Integer> validValues = new HashSet<>(asList(1, 2));

    @Override
    public Sample getSample(Integer id) {
        if (!validValues.contains(id)) {
            throw new NotFoundException("Sample not found");
        }

        if (id.equals(1)) {
            return new Sample(1, "First Example");
        }
        return new Sample(2, "Second Example");
    }

}
