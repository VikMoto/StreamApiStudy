package innerClasses;

public class Letter {
    private String sender;
    public Letter(String sender) {
        this.sender = sender;
    }
    public String toString() {
        return "Letter [sender=" + sender + "]";
    }
    public class Address {
        private int postCode;
        public Address(int postCode) {
            this.postCode = postCode;
        }

        public String getLetterSender() {
            return  sender;
        }
        public String toString() {
            return "Address [postCode=" + postCode + "]" + Letter.this.toString();
        }
    }
}