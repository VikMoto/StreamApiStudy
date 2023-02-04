package innerClasses;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringWrapperIterate implements Iterable<Character> {
    private String text;
    public StringWrapperIterate(String text) {
        this.text = text;
    }
    @Override
    public Iterator<Character> iterator() {
        return new StringIterator();
    }
    private class StringIterator implements Iterator<Character> { //realization of Iterator by inner class
        private int start = 0;
        @Override
        public boolean hasNext() {
            return start < text.length();
        }
        @Override
        public Character next() {
            if (hasNext()) {
                return text.charAt(start++);
            }
            throw new NoSuchElementException();
        }
    }
}