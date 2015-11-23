package it.unibo.oop.lab09.workers2;

/**
 * 
 * An interfaced defining a sum for a matrix.
 * 
 * @author mviroli
 * @author mcasadei
 *
 */
public interface ISumMatrix {

	/**
	 * @param matrix
	 *            an arbitrary-sized matrix
	 * @return the sum of its elements
	 */
	double sum(double[][] matrix);

}
