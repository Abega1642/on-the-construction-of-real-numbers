package dev.razafindratelo.utils;

import lombok.Getter;
import lombok.ToString;

/**
 *  NOTE : This EuclideanDivision class is not used yet but will be in future
 */
@Getter
@ToString
public class EuclideanDivision {
    private final long quotient;
    private final long reminder;

    public EuclideanDivision(long a, long b) {
    	this.quotient = b == 0 ? 0 : a / b - (a % b < 0 ? Long.signum(b) : 0);
    	this.reminder = b == 0 ? a : a % b + (a % b < 0 ? Math.abs(b) : 0);
	}
}
