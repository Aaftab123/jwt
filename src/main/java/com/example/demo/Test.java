package com.example.demo;

import java.sql.SQLException;

class Base{
    // Static method in base class which will be hidden in subclass 
 public static void display() {
         System.out.println("Static or class method from Base");
 }
 void myMethod()throws SQLException
 {
     System.out.println("Super Class");
 }
 
}
 
 // Subclass
class Derived extends Base {
 // This method hides display() in Base 
 public static void display() {
        System.out.println("Static or class method from Derived");
 }
 
 @Override
 void myMethod() 
 {
     System.out.println("Sub Class");
 }
} 


public class Test implements Cloneable{
	
	

	public static void main(String args[]) {
		
		
		
	
	}

} 

