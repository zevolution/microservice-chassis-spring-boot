package ${groupId}.${artifactIdToPackageImport}.adapter.transportlayers.restapi;

import ${groupId}.${artifactIdToPackageImport}.internal.interactors.SampleUseCase;
import ${groupId}.${artifactIdToPackageImport}.adapter.transportlayers.mapper.SampleMapper;
import ${groupId}.${artifactIdToPackageImport}.adapter.transportlayers.openapi.api.SampleApi;
import ${groupId}.${artifactIdToPackageImport}.adapter.transportlayers.openapi.model.SampleResponse;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(tags = "Sample")
public class SampleApiImpl implements SampleApi {

    private final SampleUseCase sampleUseCase;

    public SampleApiImpl(SampleUseCase sampleUseCase) {
        this.sampleUseCase = sampleUseCase;
    }

    @Override
    public ResponseEntity<SampleResponse> getSample(Integer id) {
        var sample = sampleUseCase.execute(id);
        var response = SampleMapper.INSTANCE.map(sample);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}