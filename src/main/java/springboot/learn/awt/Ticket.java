package springboot.learn.awt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;


public class Ticket implements Printable {

    /** 绘制数据bean**/
    PrintBean printBean;
    
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D graphics2d = (Graphics2D) graphics;
        //设置打印颜色
        graphics2d.setColor(Color.BLACK);
        //打印起点坐标
        double x = pageFormat.getImageableX();
        double y = pageFormat.getImageableY();
        //下一行, 正文
        Font font = new Font("宋体", Font.BOLD, 4);
        graphics2d.setFont(font);
        float height = font.getSize2D();
        float line = height*2;
        height = font.getSize2D();
        line += 2;
        
        //绘制数据
        String date = printBean.getDate();
        String [] dates = date.split("-");
        /**绘制数据第一行 年、月、日、案号、No**/
        //年
        graphics2d.drawString(dates[0]+"年", (float)x+20, (float)y+line);
        //月
        graphics2d.drawString(dates[1]+"月", (float)x+40, (float)y+line);
        //日
        graphics2d.drawString(dates[2]+"日", (float)x+50, (float)y+line);
        //案号
        graphics2d.drawString("案号:"+this.printBean.getAh(), (float)x+60, (float)y+line);
        //No
        graphics2d.drawString("编号:"+this.printBean.getNo(), (float)x+100, (float)y+line);
        line += 10;
        /**绘制数据第二行 交款人**/
        graphics2d.drawString("交款人:"+this.printBean.getName(), (float)x+30, (float)y+line);
        line += 10;
        /** 绘制案由 **/
        graphics2d.drawString("案由:"+this.printBean.getAy(), (float)x+30, (float)y+line);
        line += 10;
        /** 绘制案件诉讼费用 **/
        graphics2d.drawString("案件诉讼费用:"+this.printBean.getAjssf(), (float)x+50, (float)y+line);
        line += 10;
        /** 绘制其他诉讼费 **/
        graphics2d.drawString("其他诉讼费用:"+this.printBean.getQtssf(), (float)x+50, (float)y+line);
        line += 10;
        for (Xq xq : this.printBean.getXq()) {
            //绘制描述
            graphics2d.drawString("其他:"+xq.getMs(), (float)x+40, (float)y+line);
            //绘制金额
            graphics2d.drawString("金额:"+xq.getJr(), (float)x+70, (float)y+line);
            line += height;
        }  
        
        /** 绘制收款人 **/
        graphics2d.drawString("收款人:"+this.printBean.getAcceptor(), (float)x+30, (float)y+line);
        
        /** 绘制经办人 **/
        graphics2d.drawString("经办人:"+this.printBean.getAcceptor(), (float)x+80, (float)y+line);
        line += height;
        if(pageIndex == 0) {
            return PAGE_EXISTS;
        }else {
            return NO_SUCH_PAGE;
        }
        
    }

    public PrintBean getPrintBean() {
        return printBean;
    }

    public void setPrintBean(PrintBean printBean) {
        this.printBean = printBean;
    }
    
}
