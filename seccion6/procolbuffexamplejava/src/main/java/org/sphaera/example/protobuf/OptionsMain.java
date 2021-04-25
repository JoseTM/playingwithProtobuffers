package org.sphaera.example.protobuf;

import com.example.options.OptionMessageTest;
import com.example.options.OptionMessageTestOrBuilder;

import java.util.Arrays;

public class OptionsMain {
    public static void main(String[] args) {
        System.out.printf("options example");

        OptionMessageTest.Builder builder = OptionMessageTest.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("mysimplename");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4,5,6));
        System.out.println(builder.toString());
    }
}
