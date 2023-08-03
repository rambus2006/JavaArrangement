package _19PerformTest._01Inheritance;

public class TV {
    private int size;
    public TV(int size){ this.size = size;}
    protected int getSize(){return size;}
}
class ColorTV extends TV{
    private int resolution;
    public ColorTV(int size,int color){
        super(size);
        this.resolution = resolution;
    }
    protected int getResolution(){return resolution; }
    public void printProperty(){
        System.out.println(getSize() + "인치" + resolution + "컬러");
    }
    @Override
    protected int getSize() {
        return super.getSize();
    }

}
class TVMain{
    public static void main(String []args){
        ColorTV mytv = new ColorTV(32,1024);
        mytv.printProperty();
    }
}

