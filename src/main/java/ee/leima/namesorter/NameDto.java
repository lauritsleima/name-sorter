package ee.leima.namesorter;

import lombok.Data;

import java.io.Serializable;

@Data
public class NameDto implements Serializable {
    private final String name;
}
