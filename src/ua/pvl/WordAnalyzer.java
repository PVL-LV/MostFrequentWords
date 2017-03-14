package ua.pvl;

public class WordAnalyzer {
    private String result;
    private String leng;
    private String numWords;  //new code
    private String [] args = null;
    private String outputPath = null;

    public WordAnalyzer (String inputPath, Integer minV, Integer nWords, String outputPath) {
        setInputFile(inputPath);
        setMaxWordLength(minV);
        setHowManyWords(nWords);
        setOutputPath(outputPath);
    }

    public void setInputFile(String someFile) {
        someFile = "inputPath=" + someFile;
        args [0] = someFile;
    }

    public void setMaxWordLength(Integer length) {
        this.leng = length.toString();
        leng = "minValue=" + leng;
        args [1] = leng;
    }

    //new code

    public void setHowManyWords(Integer nWords) {
        this.numWords = nWords.toString();
        numWords = "numberOfWords=" + numWords;
        args [2] = numWords;
    }
    // end of new code

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
        String outPath = "outputPath" + outputPath;
        args [3] = outPath;  //change 2 to 3
    }

    public void executeWordCounter() {
        NewParser np = new NewParser();
        np.executeParser(args);
    }

    public String getProcessedTextResult() {
        executeWordCounter();
        result = outputPath;

        return result;
    }
}