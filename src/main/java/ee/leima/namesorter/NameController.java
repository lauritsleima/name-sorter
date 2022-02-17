package ee.leima.namesorter;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
public class NameController {

    @Resource
    private NameService nameService;

    @PostMapping("/add/new")
    public Result addNewName(@RequestParam NameDto name) {
        return nameService.addNewName(name);
    }

    @GetMapping("/get/sorted/names")
    public ArrayList<String> getSortedNames(@RequestParam NameRequest request) {
        return nameService.getSortedNames(request);
    }


}
