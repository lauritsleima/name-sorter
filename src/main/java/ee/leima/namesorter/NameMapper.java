package ee.leima.namesorter;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NameMapper {
    Name nameDtoToName(NameDto nameDto);

    NameDto nameToNameDto(Name name);


    List<NameDto> namesToNamesDto(List<Name> names);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNameFromNameDto(NameDto nameDto, @MappingTarget Name name);
}
