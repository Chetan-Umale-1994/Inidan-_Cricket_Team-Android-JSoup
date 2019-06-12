package com.example.abc.inidancricketteam;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLPeopleData {

    private Context context;
    private Person [] data;

    public XMLPeopleData(Context context)
    {
        this.context = context;

        //get to stream to xml and parse it
        InputStream stream = this.context.getResources().openRawResource(R.raw.players);
        DocumentBuilder builder = null;
        Document document = null;

        try
        {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
        }

        catch(Exception e)
        {

        }

        //extract nodelists for name, address etc

        NodeList nameList = document.getElementsByTagName("name");
        NodeList dobList = document.getElementsByTagName("dob");
        NodeList placeList = document.getElementsByTagName("place");
        NodeList roleList = document.getElementsByTagName("role");
        NodeList batting_styleList = document.getElementsByTagName("batting_style");
        NodeList bowlingStyleList = document.getElementsByTagName("bowling_style");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList urlList = document.getElementsByTagName("url");


        data = new Person[nameList.getLength()];

        //traverse these node lists to populate data

        for(int i=0;i<nameList.getLength();i++)
        {
            // extract name, address etc.
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String dob = dobList.item(i).getFirstChild().getNodeValue();
            String place = placeList.item(i).getFirstChild().getNodeValue();
            String role = roleList.item(i).getFirstChild().getNodeValue();
            String batting_style = batting_styleList.item(i).getFirstChild().getNodeValue();
            String bowling_style = bowlingStyleList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();



            // make a person object

            Person p = new Person(name, dob,place,role,batting_style,bowling_style,image,url);

            // add it to data
            data[i] = p;

        }


    }


    public Person getPersonData(int i){return data[i];}


    public String [] getNames(){

        String [] names = new String[data.length];
        for(int i = 0;i<data.length;i++){

            names[i] = data[i].getName();

        }
        return names;
    }

    public String [] getRoles(){

        String [] roles = new String[data.length];
        for(int i = 0;i<data.length;i++){

            roles[i] = data[i].getRole();

        }
        return roles;
    }

    public String [] getImages(){

        String [] images = new String[data.length];
        for(int i = 0;i<data.length;i++){

            images[i] = data[i].getImage();

        }
        return images;
    }

    public String [] getUrls(){

        String [] urls = new String[data.length];
        for(int i = 0;i<data.length;i++){

            urls[i] = data[i].getUrl();

        }
        return urls;
    }



    public int getLength(){return data.length;}

}
