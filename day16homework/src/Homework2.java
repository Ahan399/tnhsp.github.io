public class Homework2 {
    public static void main(String[] args) {
        //通过set 方法给属性赋值
        Vehicle v = new Vehicle();
        v.setSpeed(0);
        v.setSize(5);
        System.out.println("speed:"+v.getSpeed());
        System.out.println("size:"+v.getSize());

        //调用加速方法
        v.speedUp(10);
        System.out.println("speed:"+v.getSpeed());
        //调用减速方法
        v.speedDown(10);
        System.out.println("speed:"+v.getSpeed());
        //通过有参数的构造方法创建对象
       // Vehicle v1 = new Vehicle(120,5);
    }

}
/*
交通工具类
 */
class Vehicle{
    //速度
    private int speed;
    //体积
    private int size;

    public Vehicle() {
    }

    public Vehicle(int speed, int size) {
        this.speed = speed;
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    /*
    移动方法
     */
    public void move(){
        System.out.println("交通工具：公交车，起步行驶");
    }
    /*
    加速方法
     */
    public void speedUp(int addSpeed){
        //this就是当前交通工具对象
        this.setSpeed(this.getSpeed() + addSpeed);
    }
    /*
    减速方法
     */
    public void speedDown(int subSpeed){
        if(speed > 0) {
            int oldSpeed = this.getSpeed();
            this.setSpeed(oldSpeed - subSpeed);
        }
    }
}