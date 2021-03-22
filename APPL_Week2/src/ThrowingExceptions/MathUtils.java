/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThrowingExceptions;

/**
 *
 * @author DZAKIRA
 */
// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils
{
//-------------------------------------------------------------
// Returns the factorial of the argument given
//-------------------------------------------------------------
public static int factorial(int n)
{
int fac = 1;
for (int i=n; i>0; i--)
fac *= i;
return fac;
}
}
