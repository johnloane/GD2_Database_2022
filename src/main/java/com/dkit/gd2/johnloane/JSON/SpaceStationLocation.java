package com.dkit.gd2.johnloane.JSON;

import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SpaceStationLocation
{
    public static void main(String[] args)
    {
        final String ISS_NOW_URI = "http://api.open-notify.org/iss-now.json";

        try
        {
            URL url = new URL(ISS_NOW_URI);
            InputStream in = url.openStream();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while((inputStr = streamReader.readLine()) != null)
            {
                responseStrBuilder.append(inputStr);
            }

            JSONObject response = new JSONObject(responseStrBuilder.toString());
            JSONObject position = response.getJSONObject("iss_position");

            System.out.println(response.get("iss_position"));
            System.out.println(position.get("latitude"));
        }
        catch(MalformedURLException me)
        {
            System.out.println("Malformed URL " + me.getMessage());
        }
        catch(UnsupportedEncodingException uee)
        {
            System.out.println("Problem with encoding " + uee.getMessage());
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
    }
}
