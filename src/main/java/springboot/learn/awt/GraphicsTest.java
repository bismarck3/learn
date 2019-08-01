package springboot.learn.awt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

import javax.swing.JFrame;

import com.alibaba.druid.util.StringUtils;


public class GraphicsTest extends JFrame{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private PrintBean printBean;
    
    public GraphicsTest() {
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void paint(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        //设置打印颜色
        graphics2d.setColor(Color.BLACK);
        //打印起点坐标
        double x = 0;
        double y = 0;
        //设置标题字体
        Font font = new Font("宋体", Font.BOLD, 30);
        graphics2d.setFont(font);
        //获取字体高度
        float height = font.getSize2D()+30;
        //绘制标题
        graphics2d.drawString("发票绘制测试", (float)x+300, (float)y+height);
        
        //下一行, 正文
        float line = height*2;
        graphics2d.setFont(new Font("宋体",Font.PLAIN, 25));
        height = font.getSize2D();
        line += 2;
        
        //绘制数据
        String date = printBean.getDate();
        String [] dates = date.split("-");
        /**绘制数据第一行 年、月、日、案号、No**/
        //年
        graphics2d.drawString(dates[0], (float)x+20, (float)y+line);
        //月
        graphics2d.drawString(dates[1], (float)x+100, (float)y+line);
        //日
        graphics2d.drawString(dates[2], (float)x+150, (float)y+line);
        //案号
        graphics2d.drawString(this.printBean.getAh(), (float)x+300, (float)y+line);
        //No
        graphics2d.drawString(this.printBean.getNo(), (float)x+500, (float)y+line);
        line += 30;
        /**绘制数据第二行 交款人**/
        graphics2d.drawString(this.printBean.getName(), (float)x+30, (float)y+line);
        line += 30;
        /** 绘制案由 **/
        graphics2d.drawString(this.printBean.getAy(), (float)x+30, (float)y+line);
        line += 30;
        /** 绘制案件诉讼费用 **/
        graphics2d.drawString(this.printBean.getAjssf(), (float)x+80, (float)y+line);
        line += 30;
        /** 绘制其他诉讼费 **/
        graphics2d.drawString(this.printBean.getQtssf(), (float)x+80, (float)y+line);
        line += 30;
        for (Xq xq : this.printBean.getXq()) {
            //绘制描述
            graphics2d.drawString(xq.getMs(), (float)x+40, (float)y+line);
            if(StringUtils.isEmpty(xq.getJr())) {
                continue;
            }
            //绘制金额
            graphics2d.drawString(xq.getJr(), (float)x+160, (float)y+line);
            line += height;
        }  
        
        /** 绘制收款人 **/
        graphics2d.drawString(this.printBean.getAcceptor(), (float)x+100, (float)y+line);
        
        /** 绘制经办人 **/
        graphics2d.drawString(this.printBean.getOperator(), (float)x+300, (float)y+line);
        line += height;
    }
    
    
    public PrintBean getPrintBean() {
        return printBean;
    }

    public void setPrintBean(PrintBean printBean) {
        this.printBean = printBean;
    }

    public static void main(String[] args) {
//        Ticket ticket = new Ticket();
        GraphicsTest graphicsTest = new GraphicsTest();
        Xq xq = new Xq("xx费用", "1");
        PrintBean printBean = new PrintBean("2018-9-10", "民初一号", "No123456789", "wangj", "xxx", "100", "10", null, "收款人1", "操作员1", "备注");
        printBean.setXq(Arrays.asList(xq));
        graphicsTest.setPrintBean(printBean);
        graphicsTest.setVisible(true);
    }
}
