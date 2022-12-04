using System;

namespace Snippets
{
    public class DocumentationExample
    {
        class ReturnType { }
        class Type1 { }
        class Type2 { }

        /// <summary>
        /// A method for doing something.
        /// </summary>
        /// Detailed information here on how an instance of <see cref="ReturnType"/> is created
        /// from the provided values of <see cref="Type1"/> and <see cref="Type2"/>.
        /// <param name="arg1">A non-null instance of type <see cref="Type1"/></param>
        /// <param name="arg2">A possibly null instance of type <see cref="Type2"/></param>
        /// <returns>A novel instance of <see cref="ReturnType"/></returns>
        /// <exception cref="NullReferenceException">If <paramref name="arg1"/>
        /// is null</exception>
        static ReturnType SomeMethod(Type1 arg1, Type2 arg2)
        {
            // ...
            throw new NotImplementedException();
        }
    }
}