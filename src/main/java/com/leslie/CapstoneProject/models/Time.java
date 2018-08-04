package com.leslie.CapstoneProject.models;

public enum Time {

        MORNING ("Morning"),
        AFTERNOON ("Afternoon"),
        EVENING ("Evening"),
        NIGHT ("Night");

        private final String name;

        Time(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

}
