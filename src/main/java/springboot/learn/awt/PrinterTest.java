package springboot.learn.awt;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Arrays;


public class PrinterTest {

    private Ticket ticket;
    
    
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void printer() {
        Book book = new Book();
        PageFormat format = new PageFormat();
        format.setOrientation(PageFormat.PORTRAIT);
        
        //设置打印纸信息
        Paper paper = new Paper();
        paper.setSize(250, 150);
        paper.setImageableArea(50, 50, 250, 250);
        format.setPaper(paper);
        
        book.append(ticket, format);
        
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        try {
            printerJob.setPageable(book);
            printerJob.print();
        } catch (PrinterException e) {
        }
    }
    
    public static void main(String[] args) {
        Xq xq = new Xq("xx费用", "1");
        Xq xq2 = new Xq("xx费用", "2");
        Xq xq3 = new Xq("xx费用", "3");
        PrintBean printBean = new PrintBean("2018-9-10", "民初一号", "No.123456789", "wangj", "xxx", "100", "10", Arrays.asList(xq, xq2, xq3), "收款人1", "操作员1", "备注");
        
        Ticket ticket = new Ticket();
        ticket.setPrintBean(printBean);
        
        PrinterTest printerTest = new PrinterTest();
        printerTest.setTicket(ticket);
        printerTest.printer();
    }
}
