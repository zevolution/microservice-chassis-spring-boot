package ${groupId}.${artifactIdToPackageImport}.internal.interactors;

import ${groupId}.${artifactIdToPackageImport}.internal.entities.Sample;
import ${groupId}.${artifactIdToPackageImport}.internal.repositories.SampleRepository;
import org.springframework.stereotype.Service;

@Service
public class SampleUseCase {

    private final SampleRepository sampleRepository;

    public SampleUseCase(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public Sample execute(Integer id) {
        return sampleRepository.getSample(id);
    }

}