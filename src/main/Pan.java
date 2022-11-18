package main;

import java.util.List;

public class Pan {
   private String issuerName;
    private int panLength;
    private int prefixLength;
    private int innRangeLow;
    private int innRangeHigh;
    List<Integer> pattern;

    Pan(){}
    public Pan(String issuerName, int panLength, int prefixLength, int innRangeLow, int innRangeHigh, List<Integer> pattern) {
        this.issuerName = issuerName;
        this.panLength = panLength;
        this.prefixLength = prefixLength;
        this.innRangeLow = innRangeLow;
        this.innRangeHigh = innRangeHigh;
        this.pattern = pattern;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public int getPanLength() {
        return panLength;
    }

    public void setPanLength(int panLength) {
        this.panLength = panLength;
    }

    public int getPrefixLength() {
        return prefixLength;
    }

    public void setPrefixLength(int prefixLength) {
        this.prefixLength = prefixLength;
    }

    public int getInnRangeLow() {
        return innRangeLow;
    }

    public void setInnRangeLow(int innRangeLow) {
        this.innRangeLow = innRangeLow;
    }

    public int getInnRangeHigh() {
        return innRangeHigh;
    }

    public void setInnRangeHigh(int innRangeHigh) {
        this.innRangeHigh = innRangeHigh;
    }

    public List<Integer> getPattern() {
        return pattern;
    }

    public void setPattern(List<Integer> pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "PanFormat{" +
                "issuerName='" + issuerName + '\'' +
                ", panLength=" + panLength +
                ", prefixLength=" + prefixLength +
                ", innRangeLow=" + innRangeLow +
                ", innRangeHigh=" + innRangeHigh +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}
