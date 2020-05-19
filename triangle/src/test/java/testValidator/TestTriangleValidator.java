package testValidator;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import validator.TriangleValidator;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

public class TestTriangleValidator {
    @Test
    public void testIsTriangleTrue() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        Assert.assertTrue(validator.isTriangle(3,4,5));
    }

    @Test
    public void testIsTriangleTrueMessage() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        Assert.assertTrue(validator.isTriangle(4,4,5), "Given sides don't form triangle");
    }

    @Test
    public void testIsTriangleFalse() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        Assert.assertFalse(validator.isTriangle(3,3,6));
    }

    @Test
    public void testIsTriangleFalseMessage() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        Assert.assertFalse(validator.isTriangle(3,3,6));
    }

    @Test(expectedExceptions = Exception.class)
    public void testException() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        boolean res = validator.isTriangle(-1, 3, 5);
    }

    @Test(timeOut = 10000)
    public void timeTest() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        boolean res = validator.isTriangle(6, 8, 10);
    }

    @Test
    public void testIsTriangleEquals() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        Assert.assertEquals(validator.isTriangle(3,1.5,9.7), false);
    }

    @Test
    public void testIsTriangleEqualsMessage() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        Assert.assertEquals(validator.isTriangle(3,3,6), false, "Actual and expected values match");
    }

    @Test
    public void testIsTriangleNotEquals() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        Assert.assertNotEquals(validator.isTriangle(8.5,6.7,5.3), false);
    }

    @Test
    public void testIsTriangleNotEqualsMessage() throws Exception {
        TriangleValidator validator = new TriangleValidator();
        Assert.assertNotEquals(validator.isTriangle(1,3,6), true, "Actual and expected values don't match");
    }
}
