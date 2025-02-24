package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@ToString
public abstract class Sequence {
    private long n;
    private List<Fraction> values;

    public Sequence(long n) {
        this.n = n;
        values = new ArrayList<>();
    }
}
