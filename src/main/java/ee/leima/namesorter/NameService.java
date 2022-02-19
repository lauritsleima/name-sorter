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

    public String addNewName(NameDto newName) {
        Name name = nameMapper.nameDtoToName(newName);
        nameRepository.save(name);
        return "Nimi andmebaasi lisatud!";
    }

    public List<String> getSortedNames(Character filterByLetter, String sortBy) {
        List<String> names = new ArrayList<>();

        if (filterByLetter != null) {
            List<Name> filteredByLetter = nameRepository.findNameByFilterLetter(filterByLetter, filterByLetter);
            List<NameDto> allNamesDto = nameMapper.namesToNamesDto(filteredByLetter);
            for (NameDto nameDto : allNamesDto) {
                names.add(nameDto.getName());
            }
        } else {
            List<Name> allNames = nameRepository.findAll();
            List<NameDto> allNamesDto = nameMapper.namesToNamesDto(allNames);
            for (NameDto nameDto : allNamesDto) {
                names.add(nameDto.getName());
            }
        }

        if (sortBy != null) {
            if (sortBy.toLowerCase(Locale.ROOT).equals("asc")) {
                Collections.sort(names);
            }

            if (sortBy.toLowerCase(Locale.ROOT).equals("desc")) {
                Collections.sort(names, Collections.reverseOrder());
            }
        }

        return names;
    }
}
