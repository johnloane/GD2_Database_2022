package com.dkit.gd2.johnloane.JSON;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONExploration
{
    public static void main(String[] args)
    {
//        createJSONObject();
//        createJSONObjectFromMap();
//        createJSONObjectFromJSONString();
//        User stephen = new User("Stephen", 19, "Dundalk");
//        serializeJavaObjectToJSON(stephen);
//        createJSONArray();
//        createJSONArrayFromJSONString();
//        createJSONArrayFromJavaCollection();
//        createJSONArrayFromCSV();
//        createCSVFromJsonArray();
//        createJSONArrayOfJSONObjectsFromCSV();
        createJSONArrayOfJSONObjectsFromCSVWithoutHeader();
    }

    private static void createJSONArrayOfJSONObjectsFromCSVWithoutHeader()
    {
        JSONArray ja = new JSONArray();
        ja.put("name");
        ja.put("age");
        ja.put("town");
        String string = "Dylan, 20, Dundalk\n"+
                "James, 20, Dundalk\n"+
                "Ben, 20, Dundalk\n";
        JSONArray result = CDL.toJSONArray(ja, string);
        System.out.println(result);
    }

    private static void createJSONArrayOfJSONObjectsFromCSV()
    {
        String string = "name, age, town \n"+
                        "Dylan, 20, Dundalk\n"+
                        "James, 20, Dundalk\n"+
                        "Ben, 20, Dundalk\n";
        JSONArray result = CDL.toJSONArray(string);
        System.out.println(result);
    }

    private static void createCSVFromJsonArray()
    {
        JSONArray ja = new JSONArray("[\"Prithvi\", \"Stephen\", \"Hernel\"]");
        System.out.println(ja);
        String csv = CDL.rowToString(ja);
        System.out.println(csv);
    }

    private static void createJSONArrayFromCSV()
    {
        JSONArray ja = CDL.rowToJSONArray(new JSONTokener("Ben, James, Dylan"));
        System.out.println(ja);
    }

    private static void createJSONArrayFromJavaCollection()
    {
        List<String> oopClass = new ArrayList<>();
        oopClass.add("Dylan");
        oopClass.add("Josh");
        oopClass.add("Niall");

        JSONArray ja = new JSONArray(oopClass);
        System.out.println(ja);
    }

    private static void createJSONArrayFromJSONString()
    {
        JSONArray ja = new JSONArray("[true, \"James\", 22]");
        System.out.println(ja);
    }

    private static void createJSONArray()
    {
        JSONArray ja = new JSONArray();
        ja.put(Boolean.TRUE);
        ja.put("Jason");

        JSONObject jo = new JSONObject();
        jo.put("name", "ben");
        jo.put("age", "20");
        jo.put("town", "Dundalk");

        ja.put(jo);
        System.out.println(ja);
    }

    private static void serializeJavaObjectToJSON(User user)
    {
        JSONObject jo = new JSONObject(user);
        System.out.println(jo);
    }


    private static void createJSONObjectFromJSONString()
    {
        JSONObject jo = new JSONObject("{\"name\":\"emily\", \"age\":\"20\", \"town\":\"Dundalk\"}");
        System.out.println(jo);
    }

    private static void createJSONObjectFromMap()
    {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("name", "james");
        testMap.put("age", "22");
        testMap.put("town", "Dundalk");

        JSONObject jo = new JSONObject(testMap);
        System.out.println(jo);
    }

    private static void createJSONObject()
    {
        JSONObject jo = new JSONObject();
        jo.put("name", "niall");
        jo.put("age", 17);
        jo.put("town", "Dundalk");
        System.out.println(jo);
    }
}
