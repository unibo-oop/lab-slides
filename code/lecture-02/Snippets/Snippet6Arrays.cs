using System;

namespace Snippets
{
    public class Snippet6Arrays
    {
        public static void ArraysInstantiations()
        {
            Int32[] aLinearArrayOf10Ints = new Int32[10]; // all initialised to 0
            Int32[] aLinearArrayOf4Ints = new Int32[] {1, 2, 3, 4};
            Int32[] anotherLinearArrayOf4Ints = new [] {1, 2, 3, 4};
            Int32[] yetAnotherLinearArrayOf4Ints = {1, 2, 3, 4};
            Int32[,] aMatrixOf12Ints = new Int32[4,3]; // all initialised to 0
            Int32[,] aMatrixOf6Ints = new Int32[,] {{1, 2, 3}, {4, 5, 6}};
            Int32[,] anotherMatrixOf6Ints = {{1, 2}, {3, 4}, {5, 6}};
            Int32[,,] a3DArrayOf8Ints = new Int32[2,2,2]; // all initialised to 0
            Int32[,,] another3DArrayOf8Ints = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
            String[] aLinearArrayOf10Strings = new string[10]; // all initialised to null
            String[] aLinearArrayOf3Strings = new string[] {"a1", "b2", "c3"};
            String[][] anArrayOf10ArraysOfStrings = new string[10][]; // all sub-arrays are to null
            String[][] anArrayOf3ArraysOf2Strings = new string[][]
            {
                new[] {"a", "b"}, new[] {"c", "d"}, new[] {"e", "f"}
            };
        }

        public static void BubbleSort(Int32[] array)
        {
            for (Int32 i = 0; i < array.Length; i++)
            {
                for (Int32 j = i - 1; j >= 0; j--)
                {
                    if (array[j + 1] < array[j])
                    {
                        Int32 temp = array[j];    // read array item
                        array[j] = array[j + 1];  // read and set array item
                        array[j + 1] = temp;      // set array item
                    }
                }
            }
        }
        
        public static void FillMatrixRandomly(Int32[,] matrix, Random random)
        {
            for (Int32 i = 0; i < matrix.GetLength(0); i++)
            {
                for (Int32 j = 0; i < matrix.GetLength(1); i++)
                {
                    matrix[i, j] = random.Next();
                }
            }
        }
    }
}