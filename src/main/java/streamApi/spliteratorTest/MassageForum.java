package streamApi.spliteratorTest;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * way to store messages
 *
 * start -> MessageRecord MessageRecord MessageRecord MessageRecord -> end
 * */
public class MassageForum {
    private StringBuffer sb = new StringBuffer(); //accumulate strings

    public void addMessageRecord(MessageRecord record) {
        sb.append(record); //add in StringBuffer 100 chars (9 - Id, 10, - date, 79 - text)
    }

    public Stream<MessageRecord> stream() {
        Spliterator<MessageRecord> split = getSpliterator();
        return StreamSupport.stream(split,false);
    }

    public Spliterator<MessageRecord> getSpliterator() {
        class  InnerSpliterator implements Spliterator<MessageRecord> {
            private int start;
            private int end;

            public InnerSpliterator(int start, int end) {
                super();
                this.start = start;
                this.end = end;
            }

            @Override
            public boolean tryAdvance(Consumer<? super MessageRecord> action) {
                if (start >= end) {
                    return false;
                }
                int s = MessageRecord.SIZE;
    /**
     * start -> MessageRecord MessageRecord MessageRecord MessageRecord -> end
     * */
                MessageRecord messageRecord = MessageRecord.fromString(sb.substring(start * s,
                        (start + 1) * s));
                action.accept(messageRecord);
                sb.replace(start * s, (start + 1) * s, messageRecord.toString());
                start += 1;
                return true;
            }

            @Override
            public Spliterator<MessageRecord> trySplit() {

                if (end - start < 2) { //check - would enough messages to split
                    return null;
                }
                int middle = (end + start) / 2;
                Spliterator<MessageRecord> newSplit = new InnerSpliterator(start, middle);
                start = middle;
                return newSplit;
            }

            @Override
            public long estimateSize() {
                return end - start;
            }

            @Override
            public int characteristics() {
                return Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.NONNULL;
            }
        }

        return new InnerSpliterator(0, sb.length()/100);
    }
}
