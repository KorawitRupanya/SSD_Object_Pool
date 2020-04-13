import java.util.ArrayList;
import java.util.List;

public class BulletPool {
    private static BulletPool instance;
    private List<Bullet> bullet_list;
    private int size = 50;

    private BulletPool(){
        bullet_list = new ArrayList<>();

        for(int i=0; i<size; i++){
            bullet_list.add(new Bullet(0, 0, 0, 0));
        }
    }


    public static BulletPool getInstance(){
        if(instance == null) instance = new BulletPool();

        return instance;
    }

    public Bullet addBulletPool(int x, int y, int dX, int dY){
        if(bullet_list.isEmpty()){
            for(int i=0; i< size ; i++){
                bullet_list.add(new Bullet(0, 0, 0, 0));
            }
        }

        bullet_list.get(0).setX(x);
        bullet_list.get(0).setY(y);
        bullet_list.get(0).setDx(dX);
        bullet_list.get(0).setDy(dY);
        Bullet temp = bullet_list.get(0);
        bullet_list.remove(0);
        return temp;
    }

    public void releaseBullet(Bullet bullet){
        bullet_list.add(bullet);
    }
}
