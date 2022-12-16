package UI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtil {

    /**
     *
     * 根据文件路径
     * 获得图片
     */
    public static BufferedImage getImg(String path){

        try {
            BufferedImage img = ImageIO.read(ImageUtil.class.getResource(path));
            return img;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
