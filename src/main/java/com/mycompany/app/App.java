package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

//arraylerin en buyuklerini alip toplayip gelen intlerle carp
public class App 
{
    //bu arraylerle islem yap strlistle modunu al 
    public static ArrayList<String> concatElements(ArrayList<Integer> arrA, ArrayList<Integer> arrB, ArrayList<String> strList, int a) {
        
        if(arrA == null) return null;
        if(arrB == null) return null;
        if(strList == null) return null;

        if(arrA.size() != arrB.size()) return null;
        

        
        if(a>=arrA.size())
            a = a%arrA.size();
            
        int sonuc = arrA.get(a)+arrB.get(a);
     
        String allElements = "";
        for(int i=0; i<strList.size(); i++){
            allElements=allElements+strList.get(i);      
        }

        ArrayList<String> str = new ArrayList<>();
        for(int i=0; i<strList.size(); i++){
            String strElement = allElements+(sonuc*i);
            str.add(strElement);
        } 
        return str;

    }


    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> {
            res.redirect("/compute",301);
            return "";
        });

        post("/compute", (req, res) -> {
        
        //input1
        String input1 = req.queryParams("input1");
        java.util.Scanner sc1 = new java.util.Scanner(input1);
        sc1.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
        while (sc1.hasNext()){
        	int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
        }
		System.out.println(inputList);

        //second input2
        String input2 = req.queryParams("input2");
        java.util.Scanner sc2 = new java.util.Scanner(input2);
        sc2.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
        while (sc2.hasNext()){
        	int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
        }
        System.out.println(inputList2);
        
        //input3    
        String input3 = req.queryParams("input3");
        java.util.Scanner sc3 = new java.util.Scanner(input3);
        sc3.useDelimiter("[;\r\n]+");
        java.util.ArrayList<String> inputList3 = new java.util.ArrayList<>();
        while (sc3.hasNext()){
        	String value = sc3.next().replaceAll("\\s","");
            inputList3.add(value);
        }
		System.out.println(inputList3);
		
		//input 4
		String input4 = req.queryParams("input4");
        java.util.Scanner sc4 = new java.util.Scanner(input4);
        int inputList4 = Integer.parseInt(sc4.next());
		System.out.println(inputList4);

        ArrayList<String> result = new ArrayList<>();
		result = App.concatElements(inputList, inputList2 , inputList3 , inputList4 );
		
    	
		


        Map map = new HashMap();
        map.put("result", result);
        return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }  
}