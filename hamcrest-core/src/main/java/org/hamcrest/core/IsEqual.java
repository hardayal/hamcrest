/*  Copyright (c) 2000-2006 hamcrest.org
 */
package org.hamcrest.core;

import java.lang.reflect.Array;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.MismatchDescription;


/**
 * Is the value equal to another value, as tested by the
 * {@link java.lang.Object#equals} invokedMethod?
 */
public class IsEqual<T> extends BaseMatcher<T> {
    private final Object object;

    public IsEqual(T equalArg) {
        object = equalArg;
    }

    @Override
	public boolean matches(Object arg, MismatchDescription description) {
        return areEqual(arg, object, description);
    }

    public void describeTo(Description description) {
        description.appendValue(object);
    }

    private static boolean areEqual(Object o1, Object o2, MismatchDescription description) {
        if (o1 == null) {
            return o2 == null;
        } else if (isArray(o1)) {
            return isArray(o2) && areArraysEqual(o1, o2);
        } else {
            boolean equal = o1.equals(o2);
            if (!equal) {
            	description.appendText("Not equal using Object#equals(Object)");
            }
            return equal;
        }
    }

    private static boolean areArraysEqual(Object o1, Object o2) {
        return areArrayLengthsEqual(o1, o2)
                && areArrayElementsEqual(o1, o2);
    }

    private static boolean areArrayLengthsEqual(Object o1, Object o2) {
        return Array.getLength(o1) == Array.getLength(o2);
    }

    private static boolean areArrayElementsEqual(Object o1, Object o2) {
        for (int i = 0; i < Array.getLength(o1); i++) {
            if (!areEqual(Array.get(o1, i), Array.get(o2, i), MismatchDescription.NONE)) {
            	return false;
            }
        }
        return true;
    }

    private static boolean isArray(Object o) {
        return o.getClass().isArray();
    }

    /**
     * Is the value equal to another value, as tested by the
     * {@link java.lang.Object#equals} invokedMethod?
     */
    @Factory
    public static <T> Matcher<T> equalTo(T operand) {
        return new IsEqual<T>(operand);
    }
}
