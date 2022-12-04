namespace Collections
{
    // A type for any object capable of comparing two instances of T
    // according to some given ordering criterion
    public interface IComparer<in T>
    {
        // Returns 0 if x and y are equal,
        // otherwise a positive integer if x is greater than y
        // or a negative integer if x is lower than y
        int Compare(T x, T y);
    }
}