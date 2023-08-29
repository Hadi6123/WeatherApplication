package models.DetailModels;

public abstract class ExtraUnit implements Cloneable{

    private String name;

    public ExtraUnit() {
        name = "";
    }


    @Override
    public ExtraUnit clone() throws CloneNotSupportedException {
        ExtraUnit unit = (ExtraUnit) super.clone();
        unit.initialize();
        return unit;
    }

    protected void initialize() {
        this.name = "";
        reset();
    }

    protected abstract void reset();

    public void setName(String name){
        this.name = name;
    }

    public String getDetailName() {
        return name;
    }

}
