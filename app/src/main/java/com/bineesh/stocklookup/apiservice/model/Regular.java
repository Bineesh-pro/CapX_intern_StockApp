package com.bineesh.stocklookup.apiservice.model;

public class Regular {
    public String timezone;
    public int start;
    public int end;
    public int gmtoffset;

    public String getTimezone() {
        return timezone;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getGmtoffset() {
        return gmtoffset;
    }

    @Override
    public String toString() {
        return "Regular{" +
                "timezone='" + timezone + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", gmtoffset=" + gmtoffset +
                '}';
    }
}
