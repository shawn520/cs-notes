package design.abstractfactory.shape;

/**
 * @author Shawn
 * @date 2019/7/2
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Circle");
    }
}
