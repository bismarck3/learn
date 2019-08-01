package springboot.learn.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainTest {

    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
          
        String name = "Runoob";
        Integer result = null;
        
        try {
           nashorn.eval("print('" + name + "')");
           result = (Integer) nashorn.eval("10 + 2");
           System.out.println(result.toString());
           nashorn.eval(" function a (){return 1+ 2} print(a())");
        }catch(ScriptException e){
           System.out.println("执行脚本错误: "+ e.getMessage());
        }
        
        
    }
}
