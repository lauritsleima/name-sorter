package ee.leima.namesorter;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NameMapper {
    Name toEntity(NameDto nameDto);

    NameDto toDto(Name name);

    List<NameDto> toDto(List<Name> names);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNameFromNameDto(NameDto nameDto, @MappingTarget Name name);
}
