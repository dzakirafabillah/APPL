package ThrowingExceptions;

// ****************************************************************
// MathUtils.java
// @author DZAKIRA
// Provides static mathematical utility functions.
//
// ****************************************************************

public class MathUtils extends IllegalArgumentException{
//-------------------------------------------------------------
// Returns the factorial of the argument given
//-------------------------------------------------------------
    public static int factorial (int n){
        if(n<0){
            throw new IllegalArgumentException("invalid input (kurang dari 0)");
        }else if (n>16){
            throw new IllegalArgumentException("invalid input (lebih dari 16)");
        }
        else {
            int fac = 1;
            for (int i=n; i>0; i--)
                fac *= i;
            return fac;
        }
    }
}
