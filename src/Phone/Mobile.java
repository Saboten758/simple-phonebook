package Phone;

public abstract class Mobile
{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void list()
    {
        System.out.print(this.name);
    }
}
