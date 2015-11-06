/**
 * 
 */
package it.unibo.oop.lab05.ex5;

/**
 * @author Danilo Pianini
 *
 */
public final class HashUtils {

    /**
     * DJB2 constants.
     */
    public static final byte DJB2_MAGIC = 33, DJB2_SHIFT = 5, BIT_PER_BYTE = 8;

    /**
     * DJB2 start value.
     */
    public static final int DJB2_START = 5381;
    private static final int MASK_BYTE = 0xff;
    private static final int SHIFT3 = 24;

    /**
	 * 
	 */
    private HashUtils() {
    }

    /**
     * @param bytes
     *            bytes
     * @return DJB2 32bit hash
     */
    public static int djb2int32(final byte... bytes) {
        int hash32 = DJB2_START;
        for (final byte b : bytes) {
            hash32 = hash32 * DJB2_MAGIC ^ b;
        }
        return hash32;
    }

    /**
     * @param bytes
     *            bytes
     * @return DJB2 32bit hash
     */
    public static int djb2int32(final int... bytes) {
        return djb2int32(toByta(bytes));
    }

    /**
     * @param data
     *            int[]
     * @return byte[]
     */
    public static byte[] toByta(final int[] data) {
        if (data == null) {
            return null;
        }
        final byte[] byts = new byte[data.length * 4];
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(toByta(data[i]), 0, byts, i * 4, 4);
        }
        return byts;
    }

    /**
     * @param data
     *            int
     * @return byte[]
     */
    public static byte[] toByta(final int data) {
        return new byte[] { (byte) ((data >> SHIFT3) & MASK_BYTE), (byte) ((data >> 16) & MASK_BYTE),
                (byte) ((data >> 8) & MASK_BYTE), (byte) ((data >> 0) & MASK_BYTE), };
    }

}
