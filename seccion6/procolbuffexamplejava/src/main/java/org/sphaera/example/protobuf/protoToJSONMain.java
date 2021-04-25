package org.sphaera.example.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class protoToJSONMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();


        builder.setId(42)
                .setIsSimple(true)
                .setName("mysimplename");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4,5,6));

        String jsonString = JsonFormat.printer()
                // .includingDefaultValueFields() --option
                .print(builder);
        System.out.println(jsonString);

        Simple.SimpleMessage.Builder builderIn = Simple.SimpleMessage.newBuilder();
        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builderIn);
        Simple.SimpleMessage messageIn = builderIn.build();
        System.out.println(messageIn.toString());

    }
}
