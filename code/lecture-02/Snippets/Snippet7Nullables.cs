using System;

namespace Snippets
{
    public class Snippet7Nullables
    {
        public static void SomeExpressionsInvolvingNullables()
        {
            Int32? aNullableInt = null;
            Int32? anotherNullableInt = 1 + aNullableInt; // null
            Int64 aLong = (long) (anotherNullableInt ?? 0); // 0L
            Int64? aNullableLong = (long?) anotherNullableInt; // null
            String aString = anotherNullableInt?.ToString() ?? ""; // ""
        }
    }
}