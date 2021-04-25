package org.sphaera.example.protobuf;

import example.enumerations.EnumExample.DayOfTheWeek;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("exampble for enums");

        EnumMessage.Builder builder = EnumMessage.newBuilder();
        builder.setId(42);
        builder.setDayOfTheWeek(DayOfTheWeek.WEDNESDAY);

        EnumMessage message = builder.build();

        System.out.println(message.toString());

    }
}
