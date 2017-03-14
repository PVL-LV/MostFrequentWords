package ua.pvl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandGetter {

    private String inPath = null;
    private String outPath = null;
    private int numberOfChar = 0;
    private int numberOfWords = 0;

    List<UserParameters> userCommandList = new ArrayList<>();

    public CommandGetter(List<UserParameters> userCommandList) {
        this.userCommandList = userCommandList;
        populateCommand();
    }

    private void populateCommand() {

        Iterator<UserParameters> userIter = userCommandList.iterator();

        while (userIter.hasNext()) {
            UserParameters userParam = userIter.next();
            String userParamName = userParam.getName();
            String userParamValue = userParam.getValue();

            if(userParamName.equals(ParameterDefiner.INPUT_PATH)) {
                inPath = userParamValue;

            }else {
                if(userParamName.equals(ParameterDefiner.OUTPUT_PATH)) {
                    outPath = userParamValue;

                } else {
                    if (userParamName.equals(ParameterDefiner.MIN_VALUE)) {
                        numberOfChar = Integer.parseInt(userParamValue);

                    }else {
                        if(userParamName.equals(ParameterDefiner.NUM_WORDS)) {
                            numberOfWords = Integer.parseInt(userParamValue);
                        }
                    }
                }
            }
        }
    }

    public String getInPath() {
        return inPath;
    }

    public String getOutPath() {
        return outPath;
    }

    public int getNumberOfChar() {
        return numberOfChar;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }
}

