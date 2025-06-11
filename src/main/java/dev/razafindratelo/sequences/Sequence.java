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

	public Sequence(long n) {
		this.n = n;
	}

	/**
	 * @param k
	 *            : k is range of the square root sequence
	 * @return the k-th value of the square root sequence
	 */
	abstract Fraction kThValue(long k);
}
