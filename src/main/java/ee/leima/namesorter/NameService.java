package ee.leima.namesorter;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class NameService {

    @Resource
    private NameRepository nameRepository;

    @Resource
    private NameMapper nameMapper;

    public Result addNewName(NameDto newName) {
        Name name = nameMapper.nameDtoToName(newName);
        nameRepository.save(name);

        Result result = new Result();
        result.setMessage("Success! Name added to database");
        return result;
    }

    public ArrayList<String> getSortedNames() {
        List<Name> namesEntity = nameRepository.findAll();
        List<NameDto> namesDto = nameMapper.namesToNamesDto(namesEntity);

        ArrayList<String> names = new ArrayList<>();
        for (NameDto nameDto : namesDto) {
            names.add(nameDto.getName());
        }
        //Sort alphabetically acending
        names.sort(String::compareToIgnoreCase);

        return names;

    }
}
