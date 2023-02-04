package streamApi.spliteratorTest;

import java.util.Date;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        MessageRecord record1 = new MessageRecord(1, date, "Hello");
        MessageRecord record2 = new MessageRecord(2, date, "World");
        MessageRecord record3 = new MessageRecord(3, date, "Java the best");
        MessageRecord record4 = new MessageRecord(4, date, "Cat");
        MessageRecord record5 = new MessageRecord(4, date, "Hello Jonn");
        MessageRecord record6 = new MessageRecord(3, date, "Bae Katty");
        MessageRecord record7 = new MessageRecord(5, date, "I choose Java");
        MessageRecord record8 = new MessageRecord(1, date, "Good Luck");

        MassageForum messages = new MassageForum();

        messages.addMessageRecord(record1);
        messages.addMessageRecord(record2);
        messages.addMessageRecord(record3);
        messages.addMessageRecord(record4);
        messages.addMessageRecord(record5);
        messages.addMessageRecord(record6);
        messages.addMessageRecord(record7);
        messages.addMessageRecord(record8);

        Consumer<MessageRecord> action = a -> System.out.println(a);

//        Spliterator<MessageRecord> split = messages.getSpliterator();
//
//        Spliterator<MessageRecord> newSplit = split.trySplit();
//
//        for (; split.tryAdvance(action);) {
//            System.out.println("split.estimateSize() = " + split.estimateSize());
//        }
//        System.out.println("----------------------------------------------------");
//        for (; newSplit.tryAdvance(action);) {
//            System.out.println("newSplit.estimateSize() = " + newSplit.estimateSize());
//
//        }

        final List<MessageRecord> collect = messages
                .stream()
                .filter(a -> a.getUserId() == 3)
                .collect(Collectors.toList());
//        System.out.println("collect = " + collect);
        collect.forEach(a -> System.out.println(a));

    }
}
