package validator;

public class TriangleValidator {
    public boolean isTriangle(double a, double b, double c) throws Exception {
        if(a<=0 || b<=0 || c<=0) {
            throw new Exception("There are invalid sides");
        }
        return (a<b+c) && (b<a+c) && (c<a+b);
    }
}
