/**
 * @projectName springbootTest
 * @package springboot.basic.io
 * @className springboot.basic.io.FileTxtFilter
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.io;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileFilter;

/**
 * FileTxtFilter
 *
 * @description 文件txt
 * @author wangjing
 * @date 2019/8/12 10:19
 * @version v1.0.0
 */
public class FileTxtFilter implements FileFilter {
    @Override public boolean accept(File pathname) {
        return StringUtils.endsWith(pathname.getName(), ".txt");
    }
}
