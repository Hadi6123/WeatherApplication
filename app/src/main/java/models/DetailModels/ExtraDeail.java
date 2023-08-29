package models.DetailModels;

public class ExtraDeail extends ExtraUnit {

    private String name;

    @Override
    protected void reset() {
        name = " ";
        setName(name);
    }

    /*
    private String nameDetail;

    public ExtraDeail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public String getNameDetail() {
        return nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    } */
}
