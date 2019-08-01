package springboot.learn.awt;

/**
 * 
 * Xq
 * @description 负担诉讼费其他
 * @author wangj
 * @date 2018年9月10日 下午3:13:50
 * @version 
 */
public class Xq {

    /** 描述 **/
    private String ms;
    
    /** 金额 **/
    private String jr;

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getJr() {
        return jr;
    }

    public void setJr(String jr) {
        this.jr = jr;
    }

    public Xq(String ms, String jr) {
        super();
        this.ms = ms;
        this.jr = jr;
    }
    
}
