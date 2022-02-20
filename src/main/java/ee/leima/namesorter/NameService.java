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

    public String addNewName(String newName) {
        Name name = new Name();
        name.setName(newName);
        nameRepository.save(name);
        return "Nimi andmebaasi lisatud!";
    }

    public List<String> getSortedNames(Character filterLetter, String sortBy) {
        List<String> names = new ArrayList<>();

        if (filterLetter != null) {
            List<Name> filteredByLetter = nameRepository.findNamesByFilterLetter(filterLetter, filterLetter);
            List<NameDto> allNamesDto = nameMapper.toDto(filteredByLetter);
            for (NameDto nameDto : allNamesDto) {
                names.add(nameDto.getName());
            }
        } else {
            List<Name> allNames = nameRepository.findAll();
            List<NameDto> allNamesDto = nameMapper.toDto(allNames);
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
