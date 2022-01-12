package ${groupId}.${artifactIdToPackageImport}.adapter.transportlayers.mapper;

import ${groupId}.${artifactIdToPackageImport}.internal.entities.Sample;
import ${groupId}.${artifactIdToPackageImport}.adapter.transportlayers.openapi.model.SampleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SampleMapper {

    SampleMapper INSTANCE = Mappers.getMapper(SampleMapper.class);

    SampleResponse map(Sample sample);

}

