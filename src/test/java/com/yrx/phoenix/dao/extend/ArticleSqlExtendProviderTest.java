package com.yrx.phoenix.dao.extend;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by r.x on 2019/2/17.
 */
public class ArticleSqlExtendProviderTest {

    @Test
    public void testLimitCondition() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ArticleSqlExtendProvider.class.getDeclaredMethod("limitCondition", Integer.class);
        method.setAccessible(true);
        String actual = (String) method.invoke(new ArticleSqlExtendProvider(), 0);
        String expected = "0, 10";
        Assert.assertEquals(expected, actual);
        actual = (String) method.invoke(new ArticleSqlExtendProvider(), 4);
        expected = "40, 10";
        Assert.assertEquals(expected, actual);
    }
}