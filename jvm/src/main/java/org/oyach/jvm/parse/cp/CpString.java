package org.oyach.jvm.parse.cp;

public class CpString {

    private final int stringIndex;

    public CpString(int stringIndex) {
        this.stringIndex = stringIndex;
    }

    public int getStringIndex() {
        return stringIndex;
    }
}
