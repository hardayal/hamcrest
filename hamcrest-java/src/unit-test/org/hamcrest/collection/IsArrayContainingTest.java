package org.hamcrest.collection;

import org.hamcrest.AbstractMatcherTest;
import static org.hamcrest.collection.IsArrayContaining.arrayContaining;

public class IsArrayContainingTest extends AbstractMatcherTest {

    public void testMatchesAnArrayThatContainsAnElementMatchingTheGivenMatcher() {
        assertMatches("should match array that contains 'a'",
                arrayContaining("a"), new String[]{"a", "b", "c"});
    }

    public void testDoesNotMatchAnArrayThatDoesntContainAnElementMatchingTheGivenMatcher() {
        assertDoesNotMatch("should not match array that doesn't contain 'a'",
                arrayContaining("a"), new String[]{"b", "c"});
        assertDoesNotMatch("should not match empty array",
                arrayContaining("a"), new String[0]);
    }

    public void testDoesNotMatchNull() {
        assertDoesNotMatch("should not match null",
                arrayContaining("a"), null);
    }

    public void testHasAReadableDescription() {
        assertDescription("an array containing eq(\"a\")", arrayContaining("a"));
    }

    // Remaining code no longer compiles, thanks to generics. I think that's a good thing, but
    // I still need to investigate how this behaves with code that doesn't use generics.
    // I expect ClassCastExceptions will be thrown.
    // -Joe.

//    public void testDoesNotMatchObjectThatIsNotAnArray() {
//        assertDoesNotMatch("should not match empty list",
//                arrayContaining("a"), "not a collection");
//    }

//    public void testMatchesPrimitiveArrayElements() {
//        assertMatches("boolean", arrayContaining(true), new boolean[]{true, false});
//        assertDoesNotMatch("boolean", arrayContaining(false), new boolean[]{false});
//
//        assertMatches("byte", arrayContaining((byte) 1), new byte[]{1, 2, 3});
//        assertDoesNotMatch("byte", arrayContaining((byte) 0), new byte[]{1, 2, 3});
//
//        assertMatches("char", arrayContaining('a'), new char[]{'a', 'b', 'c'});
//        assertDoesNotMatch("char", arrayContaining('z'), new char[]{'a', 'b', 'c'});
//
//        assertMatches("short", arrayContaining((short) 1), new short[]{1, 2, 3});
//        assertDoesNotMatch("short", arrayContaining((short) 0), new short[]{1, 2, 3});
//
//        assertMatches("int", arrayContaining(1), new int[]{1, 2, 3});
//        assertDoesNotMatch("int", arrayContaining(0), new int[]{1, 2, 3});
//
//        assertMatches("long", arrayContaining(1L), new long[]{1, 2, 3});
//        assertDoesNotMatch("long", arrayContaining(0L), new long[]{1, 2, 3});
//
//        assertMatches("float", arrayContaining(1f), new float[]{1f, 2f, 3f});
//        assertDoesNotMatch("float", arrayContaining(0f), new float[]{1f, 2f, 3f});
//
//        assertMatches("double", arrayContaining(1.0), new double[]{1.0, 2.0, 3.0});
//        assertDoesNotMatch("double", arrayContaining(0.0), new double[]{1.0, 2.0, 3.0});
//    }

}
