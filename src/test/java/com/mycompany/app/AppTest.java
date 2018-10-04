package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testApp()
    {
        assertTrue( true );
    }
    
    
   
    // test1-test2 are for correct results
    public void test1(){
        ArrayList<Integer> arrA = new ArrayList<>(Arrays.asList(3, 6, 2, 9 ));
        ArrayList<Integer> arrB = new ArrayList<>(Arrays.asList(1, 7, 8, 4));
        int a = 5;
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Ayse","Fatma","Hulya","Leyla")); 
        ArrayList<String> result = new ArrayList<>(Arrays.asList("AyseFatmaHulyaLeyla0",
                                                                    "AyseFatmaHulyaLeyla13",
                                                                     "AyseFatmaHulyaLeyla26",
                                                                        "AyseFatmaHulyaLeyla39" ));
        
        ArrayList<String> resultH = new App().concatElements(arrA, arrB, strList, a);
        assertEquals(result,resultH);
    }

    public void test2(){
        ArrayList<Integer> arrA = new ArrayList<>(Arrays.asList(1, 1, 1, 1 ));
        ArrayList<Integer> arrB = new ArrayList<>(Arrays.asList(3, 0, 9, 5));
        int a = 2;
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Izmir","Denizli","Ankara","Istanbul"));
        
        ArrayList<String> result = new ArrayList<>(Arrays.asList("IzmirDenizliAnkaraIstanbul0",
                                                                  "IzmirDenizliAnkaraIstanbul10",
                                                                  "IzmirDenizliAnkaraIstanbul20",
                                                                  "IzmirDenizliAnkaraIstanbul30"));
        ArrayList<String> resultH = new App().concatElements(arrA, arrB, strList, a);
        assertEquals(result,resultH);
    }
    

   
   //test3-4 are for arrays that are not same size 
    public void test3(){
        ArrayList<Integer> arrA = new ArrayList<>(Arrays.asList(3, 6, 2, 9));
        ArrayList<Integer> arrB = new ArrayList<>(Arrays.asList(1, 5, 0));
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Izmir","Denizli","Ankara","Istanbul"));
        ArrayList<String> result = null;
        int a = 5;
        ArrayList<String> resultH = new App().concatElements(arrA, arrB, strList, a);
        assertEquals(result,resultH);
    }
    
    
    public void test4(){
        ArrayList<Integer> arrA = new ArrayList<>(Arrays.asList(5,3,4));
        ArrayList<Integer> arrB = new ArrayList<>(Arrays.asList(3,6,2,9));
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Izmir","Denizli","Ankara","Istanbul"));
        ArrayList<String> result = null;
        int a = 2;
        ArrayList<String> resultH = new App().concatElements(arrA, arrB, strList, a);
        assertEquals(result,resultH);
    }
    
    //test5 is to test if this method works when stringlist is shorter than integerlists
    public void test5(){
        ArrayList<Integer> arrA = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> arrB = new ArrayList<>(Arrays.asList(3,6,2,9));
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("List","Stack","Queue"));
        ArrayList<String> result = new ArrayList<>(Arrays.asList("ListStackQueue0",
                                                                "ListStackQueue4",
                                                                "ListStackQueue8"));
        int a = 4;
        ArrayList<String> resultH = new App().concatElements(arrA, arrB, strList, a);
        assertEquals(result,resultH);
    }

    //test6-7-8 are null tests
    public void test6(){
        ArrayList<Integer> arrA = null;
        ArrayList<Integer> arrB = new ArrayList<>(Arrays.asList(6,8,2));
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Tuna","Eren","Firuze"));
        ArrayList<String> result = null;
        int a = 2;
        ArrayList<String> resultH = new App().concatElements(arrA, arrB, strList, a);
        assertEquals(result,resultH);
    }

    public void test7(){
        ArrayList<Integer> arrA = new ArrayList<>(Arrays.asList(3,2,3,9));
        ArrayList<Integer> arrB = null;
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Bardak","Tabak","Tencere"));
        ArrayList<String> result = null;
        int a = 0;
        ArrayList<String> resultH = new App().concatElements(arrA, arrB, strList, a);
        assertEquals(result,resultH);
    }

    public void test8(){
        ArrayList<Integer> arrA = new ArrayList<>(Arrays.asList(7,6,5,4));
        ArrayList<Integer> arrB = new ArrayList<>(Arrays.asList(8,5,4,2));
        ArrayList<String> strList = null;
        ArrayList<String> result = null;
        int a = 1;
        ArrayList<String> resultH = new App().concatElements(arrA, arrB, strList, a);
        assertEquals(result,resultH);
    }

}