package com.example.waterqualityapp;

import java.util.concurrent.ExecutionException;

public class ContaminantThread extends Thread {

    public String returnedContaminants = "";
    public String tempSubstring = "";

    public void run(){
        //Some url endpoint that you may have
        String myUrl = "https://mytapwater.org/zip/" + MainActivity.zipCode + "/";

        //Instantiate new instance of our class
        HttpGetRequest getRequest = new HttpGetRequest();
        //Perform the doInBackground method, passing in our url
        try {
            MainActivity.numberOfContaminants = 0;
            returnedContaminants = getRequest.execute(myUrl).get();
            returnedContaminants = returnedContaminants.substring(returnedContaminants.indexOf("<tr class=\"pws-row\""), returnedContaminants.indexOf("</table>"));
            while (true) {
                if (returnedContaminants.indexOf("</tr>") == -1) {
                    break;
                }
                returnedContaminants = returnedContaminants.substring(returnedContaminants.indexOf("<tr class=\"pws-row\""));
                tempSubstring = returnedContaminants.substring(0, returnedContaminants.indexOf("</tr>"));
                for (int i = 0; i < 3; i++) {
                    tempSubstring =  tempSubstring.substring(tempSubstring.indexOf("</td>") + 5, tempSubstring.length() - 1);
                }

                tempSubstring = tempSubstring.substring(tempSubstring.indexOf(">") + 1, tempSubstring.indexOf("</"));

                if (Integer.parseInt(tempSubstring) == 0) {
                    break;
                }
                          MainActivity.numberOfContaminants += Integer.parseInt(tempSubstring);
                          returnedContaminants = returnedContaminants.substring(returnedContaminants.indexOf("</tr>") + 5);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MainActivity.waterQualityEvaluator.setNumberOfContaminants(String.valueOf(MainActivity.numberOfContaminants));

    }
}
