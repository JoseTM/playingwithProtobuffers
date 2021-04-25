package org.sphaera.example.protobuf;


import example.complex.Complex.DummyMessage;
import example.complex.Complex.ComplexMessage;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {
        System.out.println("complex message");


        DummyMessage messageDummy =  createDummyMessage("dummy1", 66);

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(messageDummy);
        builder.addMultipleDummy(createDummyMessage("otro mensaje", 67));
        builder.addMultipleDummy(createDummyMessage("otro mensaje", 68));
        builder.addMultipleDummy(createDummyMessage("otro mensaje", 69));

        builder.addAllMultipleDummy(Arrays.asList(
                createDummyMessage("otro mensaje", 70),
                createDummyMessage("otro mensaje", 71)
        ));

        ComplexMessage complexMessage = builder.build();

        System.out.println(complexMessage.toString());



    }

    private static DummyMessage  createDummyMessage(String name, int id) {
        DummyMessage.Builder builderDummyMessage = DummyMessage.newBuilder();
        return builderDummyMessage.setName(name)
                .setId(id)
                .build();

    }
}
