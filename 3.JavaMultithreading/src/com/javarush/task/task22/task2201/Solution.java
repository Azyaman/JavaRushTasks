package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {

        try {
            int s1 = string.indexOf("\t");
            int s2 = string.lastIndexOf("\t");
            String str = string.substring(s1 + 1, s2);
            return str;
        }
        catch (Exception e) {
            if (threadName.equals(FIRST_THREAD_NAME)) {
                StringForFirstThreadTooShortException e1 = new StringForFirstThreadTooShortException();
                e1.initCause(e);
                throw e1;
            }
            else if (threadName.equals(SECOND_THREAD_NAME)) {
                StringForSecondThreadTooShortException e2 = new StringForSecondThreadTooShortException();
                e2.initCause(e);
                throw e2;
            }
            else {
                RuntimeException e3 = new RuntimeException();
                e3.initCause(e);
                throw e3;
            }
        }
    }
}
