package ee.leima.namesorter;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

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

    public ArrayList<String> getSortedNames(NameRequest request) {
        List<Name> namesEntity = nameRepository.findAll();
        List<NameDto> namesDto = nameMapper.namesToNamesDto(namesEntity);

        ArrayList<String> names = new ArrayList<>();
        for (NameDto nameDto : namesDto) {
            names.add(nameDto.getName());
        }

        if (request.getOrderAscOrDesc().toLowerCase(Locale.ROOT).equals("asc")) {
            Collections.sort(names);
        }

        if (request.getOrderAscOrDesc().toLowerCase(Locale.ROOT).equals("desc")) {
            Collections.reverse(names);
        }

        return names;

    }
}
