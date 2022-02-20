package ee.leima.namesorter;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class NameController {

    @Resource
    private NameService nameService;

    @PostMapping("/add/new")
    @Operation(summary = "Lisab uue nime")
    public String addNewName(@RequestParam NameDto name) {
        return nameService.addNewName(name);
    }

    @GetMapping("/get/sorted/names")
    @Operation(summary = "Võid sisesta tähe tulemuse filtreerimiseks. " +
            "Võid sisestada teise parameetrina asc või desc, et saada nimekirja sorteeritult vastavalt A>Z või Z>A")
    public List<String> getSortedNames(
            @RequestParam(required = false) Character filterLetter,
            @RequestParam(required = false) String sortBy) {
        return nameService.getSortedNames(filterLetter, sortBy);
    }


}
