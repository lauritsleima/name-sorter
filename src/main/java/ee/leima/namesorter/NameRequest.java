package ee.leima.namesorter;

import lombok.Data;

@Data
public class NameRequest {
    private String orderAscOrDesc;
    private String filterByLetter;
}
