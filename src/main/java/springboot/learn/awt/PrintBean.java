package springboot.learn.awt;

import java.util.List;

/**
 * 
 * PrinzBean
 * @description 打印机数据bean
 * @author wangj
 * @date 2018年9月10日 下午2:42:39
 * @version
 */
public class PrintBean {


    /** 日期 **/
    private String date;
    
    /** 案号 **/
    private String ah;
    
    /** 编号 **/
    private String no;
    
    /** 交款人 **/
    private String name;
    
    /** 案由 **/
    private String ay;
   
    /** 案件诉讼费 **/
    private String ajssf;
    
    /** 其他诉讼费 **/
    private String qtssf;
    
    /** 详情 **/
    private List<Xq> xq;
    
    /** 收款人 **/
    private String acceptor;
    
    /** 经办人 **/
    private String operator;

    /** 备注 **/
    private String bz;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAh() {
        return ah;
    }

    public void setAh(String ah) {
        this.ah = ah;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public String getAjssf() {
        return ajssf;
    }

    public void setAjssf(String ajssf) {
        this.ajssf = ajssf;
    }

    public String getQtssf() {
        return qtssf;
    }

    public void setQtssf(String qtssf) {
        this.qtssf = qtssf;
    }

    public List<Xq> getXq() {
        return xq;
    }

    public void setXq(List<Xq> xq) {
        this.xq = xq;
    }

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public PrintBean(String date, String ah, String no, String name, String ay, String ajssf, String qtssf, List<Xq> xq,
        String acceptor, String operator, String bz) {
        super();
        this.date = date;
        this.ah = ah;
        this.no = no;
        this.name = name;
        this.ay = ay;
        this.ajssf = ajssf;
        this.qtssf = qtssf;
        this.xq = xq;
        this.acceptor = acceptor;
        this.operator = operator;
        this.bz = bz;
    }
    
}
