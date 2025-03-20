import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SparseMatricesTest {

    @Test
    void testToMatrix() {
        int[][] input = {
                {0, 0, 3},
                {4, 0, 0},
                {0, 5, 0}
        };
        SparseMatrices sm = new SparseMatrices(input);
        assertArrayEquals(input, sm.toMatrix());
    }

    @Test
    void testTranspose() {
        int[][] input = {
                {0, 0, 3},
                {4, 0, 0},
                {0, 5, 0}
        };
        int[][] expectedTranspose = {
                {0, 4, 0},
                {0, 0, 5},
                {3, 0, 0}
        };
        SparseMatrices sm = new SparseMatrices(input);
        assertArrayEquals(expectedTranspose, sm.transpose());
    }

    @Test
    void testIsSymmetrical() {
        int[][] symmetricMatrix = {
                {1, 2, 3},
                {2, 4, 5},
                {3, 5, 6}
        };
        SparseMatrices smSymmetric = new SparseMatrices(symmetricMatrix);
        assertTrue(smSymmetric.isSymmetrical());

        int[][] nonSymmetricMatrix = {
                {1, 2, 0},
                {2, 4, 5},
                {3, 0, 6}
        };
        SparseMatrices smNonSymmetric = new SparseMatrices(nonSymmetricMatrix);
        assertFalse(smNonSymmetric.isSymmetrical());
    }

    @Test
    void testAdd() {
        int[][] matrix1 = {
                {1, 0, 3},
                {0, 5, 0},
                {7, 0, 0}
        };
        int[][] matrix2 = {
                {0, 2, 0},
                {1, 0, 4},
                {0, 6, 0}
        };
        int[][] expectedSum = {
                {1, 2, 3},
                {1, 5, 4},
                {7, 6, 0}
        };

        SparseMatrices sm = new SparseMatrices(matrix1);
        assertArrayEquals(expectedSum, sm.add(matrix2));
    }

    @Test
    void testMultiply() {
        int[][] matrix1 = {
                {1, 0, 3},
                {0, 5, 0},
                {7, 0, 0}
        };
        int[][] matrix2 = {
                {1, 2},
                {0, 3},
                {4, 5}
        };
        int[][] expectedProduct = {
                {13, 17},
                {0, 15},
                {7, 14}
        };

        SparseMatrices sm = new SparseMatrices(matrix1);
        assertArrayEquals(expectedProduct, sm.multiply(matrix2));
    }

    @Test
    void testAdditionWithInvalidSize() {
        int[][] matrix1 = {
                {1, 0, 3},
                {0, 5, 0}
        };
        int[][] matrix2 = {
                {1, 2},
                {3, 4}
        };

        SparseMatrices sm = new SparseMatrices(matrix1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sm.add(matrix2);
        });

        assertEquals("Enter matrix with same dimensions as main matrix", exception.getMessage());
    }

    @Test
    void testMultiplicationWithInvalidSize() {
        int[][] matrix1 = {
                {1, 0, 3},
                {0, 5, 0}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        SparseMatrices sm = new SparseMatrices(matrix1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sm.multiply(matrix2);
        });

        assertEquals("Matrix multiplication not possible with these dimensions", exception.getMessage());
    }
}