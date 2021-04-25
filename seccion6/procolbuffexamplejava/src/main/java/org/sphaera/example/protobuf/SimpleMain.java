package org.sphaera.example.protobuf;


import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("hello world");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();


        builder.setId(42)
                .setIsSimple(true)
                .setName("mysimplename");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4,5,6));

        System.out.println(builder.toString());

        SimpleMessage message = builder.build();
        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }catch (IOException e) {
            System.out.println(e.toString());
        }

        System.out.println(message.getSampleListCount());
        try {
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messagedReaded = SimpleMessage.parseFrom(fileInputStream);
            fileInputStream.close();
            System.out.println("-- leido -- ");
            System.out.println(messagedReaded.toString());
        }catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
