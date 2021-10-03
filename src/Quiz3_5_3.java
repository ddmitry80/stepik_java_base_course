import java.util.Locale;

interface TextAnalyzer {
    Label processText(String text);
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

abstract class KeywordAnalyzer implements TextAnalyzer {

    abstract protected String[] getKeywords();

    abstract protected Label getLabel();

    public Label processText(String text) {return Label.OK;};
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    private Label label;

    public SpamAnalyzer(String[] keyWordsList) {
        keywords = keyWordsList.clone();
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {return label;}

    @Override
    public Label processText(String text) {
        label = Label.OK;
        for (String kw: getKeywords() ) {
            if (text.toLowerCase().contains(kw)) {
                label = Label.SPAM;
                break;
            }
        }
        return label;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private  String[] negativeSigns = {":(", "=(", ":|"};
    private Label label;

    @Override
    protected String[] getKeywords() {
        return new String[0];
    }

    @Override
    protected Label getLabel() {
        return null;
    }

    @Override
    public Label processText(String text) {
        label = Label.OK;
        for (String sign: negativeSigns)
            if (text.contains(sign)) {
                label = Label.NEGATIVE_TEXT;
                break;
            }
        return label;
    }
}

class TooLongTextAnalyzer extends KeywordAnalyzer {
    private final int maxLength;
    private Label label;

    public TooLongTextAnalyzer(int maxTextLength) {
        this.maxLength = maxTextLength;
    }

    @Override
    protected String[] getKeywords() {
        return new String[0];
    }

    @Override
    protected Label getLabel() {
        return null;
    }

    @Override
    public Label processText(String text) {
        label = Label.OK;
        if (text.length()>maxLength) {
            label = Label.TOO_LONG;
        };
        return label;
    }
}

class Main {

    public Label checkLabels(TextAnalyzer[] analyzers, String text ) {
        Label label = Label.OK;
        for (TextAnalyzer textAnalyzer: analyzers) {
            label = textAnalyzer.processText(text);
            if (label!=Label.OK)
                break;;
        }
        return label;
    }
}


public class Quiz3_5_3 {


    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        Main testObject = new Main();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }

    }
}