package Phone;

public class Conts extends Mobile
{
    private long numbers;

    public Conts(String name, long numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public long getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

}
