/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 一个可以动态加载一个图片做背景的JPanel
 */
package tool;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
/**
 *
 * @author Administrator
 */
public class ImagePanel extends JPanel{
    Image im;
    public ImagePanel(Image im){
        this.im=im;
        int w= Toolkit.getDefaultToolkit().getScreenSize().width;
        int h= Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(w,h);        
    }
    
    //画出背景
    public void paintComponent(Graphics g){
        //清屏
        super.paintComponents(g);
        g.drawImage(im, 0, 0, this.getWidth(),this.getHeight(),this);
    }
}
