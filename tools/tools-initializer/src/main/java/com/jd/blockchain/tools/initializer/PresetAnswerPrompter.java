package com.jd.blockchain.tools.initializer;

import java.util.Properties;

public class PresetAnswerPrompter extends ConsolePrompter {

    private Properties answers = new Properties();

    private String defaultAnswer;

    public PresetAnswerPrompter(String defaultAnswer) {
        this.defaultAnswer = defaultAnswer;
    }

    public void setAnswer(String tag, String answer) {
        answers.setProperty(tag, answer);
    }

    public void setDefaultAnswer(String defaultAnswer) {
        this.defaultAnswer = defaultAnswer;
    }

    @Override
    public String confirm(String tag, String format, Object... args) {
        System.out.print(String.format(format, args));
        String answer = answers.getProperty(tag, defaultAnswer);
        System.out.println(String.format("\r\n   [Default answer:%s]", answer));
        return answer;
    }
}
